package com.cpifppiramide.webrest.dao.generos;

import com.cpifppiramide.webrest.context.DBConnection;
import com.cpifppiramide.webrest.entidades.Genero;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOGenerosMySQL implements DAOGeneros{
    @Override
    public List<Genero> lista() {
        List<Genero> generos = new ArrayList<>();
        String query = "select * from generos";
        try {
            PreparedStatement statement = DBConnection.getInstance().prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                Genero genero = new Genero(rs.getString("nombre"));
                generos.add(genero);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return generos;
    }
}
