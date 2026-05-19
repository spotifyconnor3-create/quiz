package com.crudbasico.app.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crudbasico.app.model.Jugadores;

public interface JugadoresRepository extends JpaRepository<Jugadores, Long> {

}