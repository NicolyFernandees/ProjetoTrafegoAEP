package com.unicesumar.trafegosimulator.repository;

import com.unicesumar.trafegosimulator.model.RegistroControle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroControleRepository extends JpaRepository<RegistroControle, Long> {
}