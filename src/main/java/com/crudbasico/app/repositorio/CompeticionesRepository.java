package com.crudbasico.app.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crudbasico.app.model.Competiciones;

public interface CompeticionesRepository extends JpaRepository<Competiciones, Long> {

}