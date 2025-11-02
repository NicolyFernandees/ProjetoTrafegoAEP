package com.unicesumar.trafegosimulator.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "viaduto")
public class Viaduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idViaduto;

    @Column(nullable = false, length = 100)
    private String nome;

    private String localizacaoGeografica;

    @OneToMany(mappedBy = "viaduto")
    private List<Semaforo> semaforos;

    public Viaduto() {
    }

    // --- GETTERS E SETTERS ---
    public Long getIdViaduto() {
        return idViaduto;
    }

    public void setIdViaduto(Long idViaduto) {
        this.idViaduto = idViaduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocalizacaoGeografica() {
        return localizacaoGeografica;
    }

    public void setLocalizacaoGeografica(String localizacaoGeografica) {
        this.localizacaoGeografica = localizacaoGeografica;
    }

    public List<Semaforo> getSemaforos() {
        return semaforos;
    }

    public void setSemaforos(List<Semaforo> semaforos) {
        this.semaforos = semaforos;
    }
}