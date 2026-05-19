package com.crudbasico.app.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crudbasico.app.model.Entrenador;

public interface EntrenadorRepository extends JpaRepository<Entrenador, Long> {

}