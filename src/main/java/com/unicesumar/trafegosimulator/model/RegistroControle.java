package com.unicesumar.trafegosimulator.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "registro-controle")
public class RegistroControle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRegistro;

    @ManyToOne
    @JoinColumn(name = "id_semaforo", nullable = false)
    private Semaforo semaforo;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime dataHoraRegistro = LocalDateTime.now();

    private int contagemVeiculos;
    private int tempoAberturaAplicadoSeg;

    public RegistroControle() {
    }

    public Long getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(Long idRegistro) {
        this.idRegistro = idRegistro;
    }

    public Semaforo getSemaforo() {
        return semaforo;
    }

    public void setSemaforo(Semaforo semaforo) {
        this.semaforo = semaforo;
    }

    public LocalDateTime getDataHoraRegistro() {
        return dataHoraRegistro;
    }

    public void setDataHoraRegistro(LocalDateTime dataHoraRegistro) {
        this.dataHoraRegistro = dataHoraRegistro;
    }

    public int getContagemVeiculos() {
        return contagemVeiculos;
    }

    public void setContagemVeiculos(int contagemVeiculos) {
        this.contagemVeiculos = contagemVeiculos;
    }

    public int getTempoAberturaAplicadoSeg() {
        return tempoAberturaAplicadoSeg;
    }

    public void setTempoAberturaAplicadoSeg(int tempoAberturaAplicadoSeg) {
        this.tempoAberturaAplicadoSeg = tempoAberturaAplicadoSeg;
    }
}