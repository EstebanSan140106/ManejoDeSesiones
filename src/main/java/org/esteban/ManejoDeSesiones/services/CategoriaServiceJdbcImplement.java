package org.esteban.ManejoDeSesiones.services;

import org.esteban.ManejoDeSesiones.models.Categoría;
import org.esteban.ManejoDeSesiones.repositorio.CategoriaRepositorioJdbcImplement;
import org.esteban.ManejoDeSesiones.util.Conexion;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class CategoriaServiceJdbcImplement implements CategoriaService {

    //creamos ina variable de tipo CategoriaRepositorioJdbcImplement
    //creamos una variabñe de tipo conexion
    private CategoriaRepositorioJdbcImplement repositorioJdbc;

    public CategoriaServiceJdbcImplement(Connection con) {
        this.repositorioJdbc = new CategoriaRepositorioJdbcImplement(con);

    }


    @Override
    public List<Categoría> listar() {
        try {
return repositorioJdbc.listar();
        } catch (SQLException throwables) {
throw new ServiceJdbcException(throwables.getMessage(), throwables.getCause());

        }
    }

    @Override
    public Optional<Categoría> porId(Long id) {
    try {
        return Optional.ofNullable(repositorioJdbc.porId(id));
    } catch(SQLException throwables) {
        throw new ServiceJdbcException(throwables.getMessage(), throwables.getCause());
    }
    }
}