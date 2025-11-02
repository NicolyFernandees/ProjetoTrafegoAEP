package com.unicesumar.trafegosimulator.controller;

import com.unicesumar.trafegosimulator.model.Semaforo;
import com.unicesumar.trafegosimulator.model.Viaduto;
import com.unicesumar.trafegosimulator.repository.SemaforoRepository;
import com.unicesumar.trafegosimulator.repository.ViadutoRepository;
import com.unicesumar.trafegosimulator.service.GerenciadorSemaforoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component 
public class SimuladorController implements CommandLineRunner { 
    
    private final ViadutoRepository viadutoRepository;
    private final SemaforoRepository semaforoRepository;
    private final GerenciadorSemaforoService gerenciadorService;

    @Autowired
    public SimuladorController(ViadutoRepository viadutoRepository,
                               SemaforoRepository semaforoRepository,
                               GerenciadorSemaforoService gerenciadorService) {
        this.viadutoRepository = viadutoRepository;
        this.semaforoRepository = semaforoRepository;
        this.gerenciadorService = gerenciadorService;
    }
    @Override
    public void run(String... args) throws Exception {

        if (viadutoRepository.count() == 0) {
            System.out.println("Banco vazio. Inserindo dados iniciais (DML)...");

            Viaduto v1 = new Viaduto();
            v1.setNome("Viaduto A - Centro");
            viadutoRepository.save(v1);

            Viaduto v2 = new Viaduto();
            v2.setNome("Viaduto B - Saída Norte");
            viadutoRepository.save(v2);

            Viaduto v3 = new Viaduto();
            v3.setNome("Viaduto C - Acesso Industrial");
            viadutoRepository.save(v3);

            Semaforo s1 = new Semaforo();
            s1.setViaduto(v1);
            s1.setTempoAberturaPadraoSeg(60);
            s1.setTempoFechamentoPadraoSeg(45);
            semaforoRepository.save(s1);

            Semaforo s2 = new Semaforo();
            s2.setViaduto(v2);
            s2.setTempoAberturaPadraoSeg(60);
            s2.setTempoFechamentoPadraoSeg(45);
            semaforoRepository.save(s2);

            Semaforo s3 = new Semaforo();
            s3.setViaduto(v3);
            s3.setTempoAberturaPadraoSeg(60);
            s3.setTempoFechamentoPadraoSeg(45);
            semaforoRepository.save(s3);

            System.out.println("Dados iniciais inseridos com sucesso!");
        } else {
            System.out.println("Banco já populado. Pulando inserção de dados.");
        }

        System.out.println("\n---- Iniciando simulação de trafégo nos viadutos de Paiçandu ----");

        gerenciadorService.processarFluxo(1L, 75); // 150 veículos

        gerenciadorService.processarFluxo(2L, 8); // 15 veículos

        gerenciadorService.processarFluxo(3L, 40); // 60 veículos

        System.out.println("---- Simulação de trafégo finalizada ----");
        System.out.println("---- Verifique no MySQL Workbench na tabela 'registro_controle' para ver os resultados ----");
    }
}