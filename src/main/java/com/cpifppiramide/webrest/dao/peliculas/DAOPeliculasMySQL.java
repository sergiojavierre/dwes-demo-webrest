package com.cpifppiramide.webrest.dao.peliculas;

import com.cpifppiramide.webrest.context.DBConnection;
import com.cpifppiramide.webrest.entidades.Director;
import com.cpifppiramide.webrest.entidades.Genero;
import com.cpifppiramide.webrest.entidades.Pelicula;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOPeliculasMySQL implements DAOPeliculas{
    @Override
    public List<Pelicula> lista(String titulo, Integer año, Director director, Genero genero) {
        List<Pelicula> peliculas = new ArrayList<>();
        //construcción dinámica del WHERE con la primera condición trivial para fijar ya el WHERE
        StringBuilder query = new StringBuilder("select  * from peliculas where 1=1");
        //la lista será con Object ya que tengo Strings e Integer
        List<Object> params = new ArrayList<>();
        //reviso los parámetros que recibo
        if (titulo != null && !titulo.isEmpty()) {
            query.append(" and titulo like ?");
            params.add("%" + titulo + "%");
        }
        if (año != null) {
            query.append(" and año = ?");
            params.add(año);
        }
        if (director != null && director.getNombre() != null) {
            query.append(" and director = ?");
            params.add(director.getNombre());
        }
        if (genero != null && genero.getNombre() != null) {
            query.append(" and genero = ?");
            params.add(genero.getNombre());
        }
        try {
            PreparedStatement statement = DBConnection.getInstance().prepareStatement(query.toString());
            //rellenar parámetros en orden
            for (int i = 0; i < params.size(); i++) {
                statement.setObject(i + 1, params.get(i));
            }
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Pelicula pelicula = new Pelicula();
                //uso del patrón builder
                pelicula
                        .titulo(rs.getString("titulo"))
                        .año(rs.getInt("año"))
                        .director(new Director(rs.getString("director")))
                        .genero(new Genero(rs.getString("genero")))
                ;
                peliculas.add(pelicula);
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return peliculas;
    }
}
