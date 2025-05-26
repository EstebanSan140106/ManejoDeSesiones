package org.esteban.ManejoDeSesiones.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    //Inicializo 3 variables locales

    private static String URL ="jdbc:mysql://localhost:3306/compra_venta?serverTimeZone=UTC";

    //nombre del usuario de la bd

    private static String username = "root";

    //contraseña del usuario de la bd

    private static String password = "";

    //implementamos un metodo para realiza la conexion

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, username, password);
    }


}
