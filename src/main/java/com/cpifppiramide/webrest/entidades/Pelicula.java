package com.cpifppiramide.webrest.entidades;

public class Pelicula {
    private String titulo;
    private Integer año;
    private Director director;
    private Genero genero;

    //vacío porque voy a utilizar builder
    public Pelicula(){}

    //setters con patrón builder
    public Pelicula titulo(String titulo){
        this.titulo = titulo;
        return this;
    }
    public Pelicula año(Integer año){
        this.año = año;
        return this;
    }
    public Pelicula director(Director director){
        this.director = director;
        return this;
    }
    public Pelicula genero(Genero genero){
        this.genero = genero;
        return this;
    }

    public String getTitulo() {
        return titulo;
    }

    public Integer getAño() {
        return año;
    }

    public Director getDirector() {
        return director;
    }

    public Genero getGenero() {
        return genero;
    }
}
