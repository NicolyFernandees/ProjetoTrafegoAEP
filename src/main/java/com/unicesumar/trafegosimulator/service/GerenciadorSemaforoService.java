package com.unicesumar.trafegosimulator.service;

import com.unicesumar.trafegosimulator.model.RegistroControle;
import com.unicesumar.trafegosimulator.model.Semaforo;
import com.unicesumar.trafegosimulator.repository.RegistroControleRepository;
import com.unicesumar.trafegosimulator.repository.SemaforoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GerenciadorSemaforoService {

    private final SemaforoRepository semaforoRepository;
    private final RegistroControleRepository registroRepository;

    @Autowired
    public GerenciadorSemaforoService(SemaforoRepository semaforoRepository,
                                      RegistroControleRepository registroRepository) {
        this.semaforoRepository = semaforoRepository;
        this.registroRepository = registroRepository;
    }

    @Transactional
    public RegistroControle processarFluxo(Long idSemaforo, int contagemVeiculos) {

        System.out.println("Processando fluxo para semáforo " + idSemaforo +
                " com contagem de " + contagemVeiculos + " veículos.");

        Semaforo semaforo = semaforoRepository.findById(idSemaforo)
                .orElseThrow(() -> new RuntimeException("Semáforo " + idSemaforo + " não encontrado!"));

        int tempoAplicado = semaforo.getTempoAberturaPadraoSeg();

        if (contagemVeiculos > 60) {
            System.out.println("Fluxo intenso detectado! Aumentando tempo em 30s.");
            tempoAplicado += 30;
        } else if (contagemVeiculos < 10) { // Vazio
            System.out.println("Fluxo baixo. Reduzindo tempo em 15s.");
            tempoAplicado = Math.max(30, tempoAplicado - 15);
        } else {
            System.out.println("Fluxo normal. Mantendo tempo padrão de " + tempoAplicado + "s.");
        }

        RegistroControle novoRegistro = new RegistroControle();
        novoRegistro.setSemaforo(semaforo);
        novoRegistro.setContagemVeiculos(contagemVeiculos);
        novoRegistro.setTempoAberturaAplicadoSeg(tempoAplicado);

        RegistroControle registroSalvo = registroRepository.save(novoRegistro);

        System.out.println("Novo registro de controle salvo no banco com ID: " + registroSalvo.getIdRegistro());
        return registroSalvo;
    }
}