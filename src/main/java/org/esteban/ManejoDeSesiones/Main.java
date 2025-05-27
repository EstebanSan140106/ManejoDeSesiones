package org.esteban.ManejoDeSesiones;

import org.esteban.ManejoDeSesiones.util.Conexion;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Connection con = null;
        try {
            con  = Conexion.getConnection();
            if (con != null) {
                System.out.println("Conexión a la base de datos exitosa");
            }
        } catch (SQLException e) {
            System.err.println("Error al conectar con la base de datos");
        } finally {
             if (con == null) {
                 try {
                     con.close();
                     System.out.println("Conexión cerrada");
                 } catch (SQLException e) {
                     System.err.println("Error al cerrar la conexion a la base de datos");
                 }
             }
        }
    }
}
