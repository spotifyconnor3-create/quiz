package com.crudbasico.app.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    // ONE TO ONE
    @OneToOne(cascade = CascadeType.ALL)
    private Entrenador entrenador;

    // ONE TO MANY
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_club")
    private List<Jugadores> jugadores;

    // MANY TO ONE
    @ManyToOne(cascade = CascadeType.ALL)
    private Asociaciones asociaciones;

    // MANY TO MANY
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Competiciones> competiciones;

    public Club() {
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

    public List<Jugadores> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugadores> jugadores) {
        this.jugadores = jugadores;
    }

    public Asociaciones getAsociaciones() {
        return asociaciones;
    }

    public void setAsociaciones(Asociaciones asociaciones) {
        this.asociaciones = asociaciones;
    }

    public List<Competiciones> getCompeticiones() {
        return competiciones;
    }

    public void setCompeticiones(List<Competiciones> competiciones) {
        this.competiciones = competiciones;
    }
}