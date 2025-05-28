package org.esteban.ManejoDeSesiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.DatabaseMetaData;

public class Main {

    // CONFIGURACIÓN
//CONEXION A LA BASE DE DATOS
    private static final String DB_URL = "jdbc:mysql://localhost:3306/restaurante";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "";

    public static void main(String[] args) {
        System.out.println("Intentando conectar a la base de datos en: " + DB_URL);

        // Usamos try-with-resources para que la conexión se cierre sola
        try (Connection conexion = DriverManager.getConnection(DB_URL, USUARIO, CONTRASENA)) {
            // Si la línea anterior no lanza una excepción, la conexión fue exitosa
            System.out.println("¡Conexión Exitosa a la base de datos!");
        } catch (SQLException e) {
            System.err.println("Error al conectar a la base de datos:");
            // Imprime información detallada sobre el error de SQL
            e.printStackTrace();
        }
    }
}