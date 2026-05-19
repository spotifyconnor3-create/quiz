package com.crudbasico.app.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crudbasico.app.model.Club;

public interface ClubRepository extends JpaRepository<Club, Long> {

}