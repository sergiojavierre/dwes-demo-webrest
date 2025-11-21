package com.cpifppiramide.webrest.dao;

import com.cpifppiramide.webrest.dao.directores.DAODirectores;
import com.cpifppiramide.webrest.dao.directores.DAODirectoresMySQL;
import com.cpifppiramide.webrest.dao.peliculas.DAOPeliculas;
import com.cpifppiramide.webrest.dao.peliculas.DAOPeliculasMySQL;

public class DAOFactory {

    private static DAOFactory daoFactory;

    private DAOPeliculas daoPeliculas;
    private DAODirectores daoDirectores;

    private DAOFactory(){}

    public static DAOFactory getInstance() {
        if(daoFactory == null) daoFactory = new DAOFactory();
        return daoFactory;
    }

    public DAOPeliculas getDaoPeliculas() {
        if(daoPeliculas == null) daoPeliculas = new DAOPeliculasMySQL();
        return daoPeliculas;
    }

    public DAODirectores getDaoDirectores(){
        if(daoDirectores == null) daoDirectores = new DAODirectoresMySQL();
        return daoDirectores;
    }
}
