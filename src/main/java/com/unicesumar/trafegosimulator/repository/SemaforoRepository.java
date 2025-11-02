package com.unicesumar.trafegosimulator.repository;

import com.unicesumar.trafegosimulator.model.Semaforo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SemaforoRepository extends JpaRepository<Semaforo, Long> {
}