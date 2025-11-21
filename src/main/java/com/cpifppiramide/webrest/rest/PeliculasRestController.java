package com.cpifppiramide.webrest.rest;

import com.cpifppiramide.webrest.dao.DAOFactory;
import com.cpifppiramide.webrest.entidades.Pelicula;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PeliculasRestController {

    @GetMapping("/api/peliculas")
    public List<Pelicula> lista(@RequestBody(required = false) Pelicula filtro){
        if(filtro == null) filtro = new Pelicula();
        return DAOFactory.getInstance().getDaoPeliculas().lista(filtro.getTitulo(), filtro.getAño(), filtro.getDirector(), filtro.getGenero());
    }

    @PostMapping("/api/peliculas")
    public Pelicula inserta(@RequestBody Pelicula pelicula){
        DAOFactory.getInstance().getDaoPeliculas().inserta(pelicula);
        return pelicula;
    }
}
