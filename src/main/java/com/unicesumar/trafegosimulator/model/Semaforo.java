package com.unicesumar.trafegosimulator.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "semaforo")
public class Semaforo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSemaforo;

    @ManyToOne
    @JoinColumn(name = "id_viaduto", nullable = false)
    private Viaduto viaduto;

    private int tempoAberturaPadraoSeg;
    private int tempoFechamentoPadraoSeg;

    @OneToMany(mappedBy = "semaforo")
    private List<RegistroControle> registros;

    public Semaforo() {
    }

    public Long getIdSemaforo() {
        return idSemaforo;
    }

    public void setIdSemaforo(Long idSemaforo) {
        this.idSemaforo = idSemaforo;
    }

    public Viaduto getViaduto() {
        return viaduto;
    }

    public void setViaduto(Viaduto viaduto) {
        this.viaduto = viaduto;
    }

    public int getTempoAberturaPadraoSeg() {
        return tempoAberturaPadraoSeg;
    }

    public void setTempoAberturaPadraoSeg(int tempoAberturaPadraoSeg) {
        this.tempoAberturaPadraoSeg = tempoAberturaPadraoSeg;
    }

    public int getTempoFechamentoPadraoSeg() {
        return tempoFechamentoPadraoSeg;
    }

    public void setTempoFechamentoPadraoSeg(int tempoFechamentoPadraoSeg) {
        this.tempoFechamentoPadraoSeg = tempoFechamentoPadraoSeg;
    }

    public List<RegistroControle> getRegistros() {
        return registros;
    }

    public void setRegistros(List<RegistroControle> registros) {
        this.registros = registros;
    }
}