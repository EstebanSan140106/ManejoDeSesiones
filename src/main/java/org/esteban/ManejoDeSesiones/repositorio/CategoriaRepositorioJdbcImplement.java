package org.esteban.ManejoDeSesiones.repositorio;

import org.esteban.ManejoDeSesiones.models.Categoría;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaRepositorioJdbcImplement implements Repositorio<Categoría> {

    //creamos una variable donde vamos a guardar la conexion
    private Connection conexion;

    public CategoriaRepositorioJdbcImplement(Connection conexion) {

        this.conexion = conexion;
    }

    @Override
    public List<Categoría> listar() throws SQLException {
        List<Categoría> categorias = new ArrayList<>();
        try (Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM categoría")) {
            while (rs.next()) {
                Categoría c = getCategoría(rs);
                categorias.add(c);

            }
        }
        return categorias;
    }


    @Override
    public Categoría porId(Long id) throws SQLException {
        //Creo un obj tipo categoria nulo
        Categoría categoría = null;
        try (PreparedStatement stmt = conexion.prepareStatement("SELECT * FROM categoria where id = ?")) {
            stmt.setLong(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                categoría = getCategoría(rs);
            }
        }
        return categoría;
    }

    @Override
    public void guardar(Categoría categoría) throws SQLException {
        //Declaro una variable de tipo string Sql
        String sql;
        if (categoría.getIdCategoria() != null && categoría.getIdCategoria() > 0) {
            sql = "update categoría set nombre=? desocripcion=? where idCategoria=?";
        } else {
            sql = "insert into categoría (nombnre,descrpcion,condicion) values (?,?,1)";
        }
    }

    @Override
    public void eliminar(Long id) throws SQLException {

    }


    private Categoría getCategoría(ResultSet rs) throws SQLException {
        Categoría c = new Categoría();
        c.setNombre(rs.getString("nombre"));
        c.setDescripcion(rs.getString("descripcion"));
        c.setCondicion(rs.getInt("condicion"));
        c.setIdCategoria(rs.getLong("idCategoria"));
        return c;
    }
}
