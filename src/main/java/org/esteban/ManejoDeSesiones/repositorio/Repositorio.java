package org.esteban.ManejoDeSesiones.repositorio;

import java.sql.SQLException;
import java.util.List;

/*
La variable <T> es un parametro genereico que permite que la interfaz sea utilizada, como se desee o cualquier objeto(entidad) que se desee manejar
 */
public interface Repositorio  <T> {
    //Metodo Listar que recibe un parametro genererico
    List<T> listar() throws SQLException;

    T porId(Long id) throws SQLException;

    void guardar(T t) throws SQLException;

    void eliminar(Long id) throws SQLException;
}
