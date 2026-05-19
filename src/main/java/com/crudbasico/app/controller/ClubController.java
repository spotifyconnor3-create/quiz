package com.crudbasico.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.crudbasico.app.model.Club;
import com.crudbasico.app.model.Competiciones;
import com.crudbasico.app.model.Entrenador;
import com.crudbasico.app.model.Jugadores;

import com.crudbasico.app.repositorio.ClubRepository;
import com.crudbasico.app.repositorio.CompeticionesRepository;
import com.crudbasico.app.repositorio.EntrenadorRepository;
import com.crudbasico.app.repositorio.JugadoresRepository;

@Controller
public class ClubController {

    @Autowired
    private ClubRepository clubRepository;

    @Autowired
    private EntrenadorRepository entrenadorRepository;

    @Autowired
    private JugadoresRepository jugadoresRepository;

    @Autowired
    private CompeticionesRepository competicionesRepository;

    // INDEX

    @GetMapping("/")
    public String inicio(Model model) {

        model.addAttribute("entrenadores", entrenadorRepository.findAll());
        model.addAttribute("competiciones", competicionesRepository.findAll());

        return "index";
    }

    // CREAR CLUB

    @PostMapping("/guardarClub")
    public String guardarClub(
            @RequestParam String nombre,
            @RequestParam Long entrenadorId,
            @RequestParam Long competicionId,
            Model model) {

        Club club = new Club();

        club.setNombre(nombre);

        Entrenador entrenador = entrenadorRepository
                .findById(entrenadorId)
                .orElse(null);

        club.setEntrenador(entrenador);

        Competiciones competicion = competicionesRepository
                .findById(competicionId)
                .orElse(null);

        List<Competiciones> listaComp = new ArrayList<>();

        listaComp.add(competicion);

        club.setCompeticiones(listaComp);

        clubRepository.save(club);

        model.addAttribute("listaClubes", clubRepository.findAll());

        return "listar";
    }

    // LISTAR CLUBES

    @GetMapping("/listar")
    public String listar(Model model) {

        model.addAttribute("listaClubes", clubRepository.findAll());

        return "listar";
    }

    // CREAR ENTRENADOR

    @PostMapping("/guardarEntrenador")
    public String guardarEntrenador(
            @RequestParam String nombre,
            @RequestParam String apellido,
            @RequestParam int edad,
            @RequestParam String nacionalidad,
            Model model) {

        Entrenador entrenador = new Entrenador();

        entrenador.setNombre(nombre);
        entrenador.setApellido(apellido);
        entrenador.setEdad(edad);
        entrenador.setNacionalidad(nacionalidad);

        entrenadorRepository.save(entrenador);

        model.addAttribute("entrenadores", entrenadorRepository.findAll());
        model.addAttribute("competiciones", competicionesRepository.findAll());

        return "index";
    }

    // CREAR COMPETICION

    @PostMapping("/guardarCompeticion")
    public String guardarCompeticion(
            @RequestParam String nombre,
            @RequestParam int premio,
            Model model) {

        Competiciones competicion = new Competiciones();

        competicion.setNombre(nombre);
        competicion.setMontoPremio(premio);

        competicionesRepository.save(competicion);

        model.addAttribute("entrenadores", entrenadorRepository.findAll());
        model.addAttribute("competiciones", competicionesRepository.findAll());

        return "index";
    }

    // AGREGAR JUGADOR

    @PostMapping("/agregarJugador")
    public String agregarJugador(

            @RequestParam Long idClub,
            @RequestParam String nombre,
            @RequestParam String apellido,
            @RequestParam int numero,
            @RequestParam String posicion,
            Model model) {

        Club club = clubRepository.findById(idClub).orElse(null);

        Jugadores jugador = new Jugadores();

        jugador.setNombre(nombre);
        jugador.setApellido(apellido);
        jugador.setNumero(numero);
        jugador.setPosicion(posicion);

        jugador.setClub(club);

        jugadoresRepository.save(jugador);

        List<Jugadores> lista = club.getJugadores();

        if (lista == null) {
            lista = new ArrayList<>();
        }

        lista.add(jugador);

        club.setJugadores(lista);

        clubRepository.save(club);

        model.addAttribute("listaClubes", clubRepository.findAll());

        return "listar";
    }

    // ELIMINAR CLUB

    @GetMapping("/eliminarClub/{id}")
    public String eliminarClub(
            @PathVariable Long id,
            Model model) {

        clubRepository.deleteById(id);

        model.addAttribute("listaClubes", clubRepository.findAll());

        return "listar";
    }
}