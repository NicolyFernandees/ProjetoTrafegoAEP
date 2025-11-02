package com.unicesumar.trafegosimulator.repository;

import com.unicesumar.trafegosimulator.model.Viaduto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViadutoRepository extends JpaRepository<Viaduto, Long> {
}