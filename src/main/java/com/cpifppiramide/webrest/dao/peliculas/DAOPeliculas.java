package com.cpifppiramide.webrest.dao.peliculas;

import com.cpifppiramide.webrest.entidades.Director;
import com.cpifppiramide.webrest.entidades.Genero;
import com.cpifppiramide.webrest.entidades.Pelicula;

import java.util.List;

public interface DAOPeliculas {

    public List<Pelicula> lista(String titulo, Integer año, Director director, Genero genero);

}
