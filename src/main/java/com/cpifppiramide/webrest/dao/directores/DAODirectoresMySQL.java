package com.cpifppiramide.webrest.dao.directores;

import com.cpifppiramide.webrest.context.DBConnection;
import com.cpifppiramide.webrest.entidades.Director;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAODirectoresMySQL implements DAODirectores{
    @Override
    public List<Director> lista() {
        List<Director> directores = new ArrayList<>();
        String query = "select * from directores";
        try {
            PreparedStatement statement = DBConnection.getInstance().prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                Director director = new Director(rs.getString("nombre"));
                directores.add(director);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return directores;
    }
}
