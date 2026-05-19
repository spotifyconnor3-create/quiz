package com.crudbasico.app.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crudbasico.app.model.Asociaciones;

public interface AsociacionesRepository extends JpaRepository<Asociaciones, Long> {

}