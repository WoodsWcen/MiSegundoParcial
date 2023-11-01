package com.emergentes.conexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD_BIBLIOTECA {

    static String url = "jdbc:mysql://localhost:3306/bd_biblioteca";
    static String usuario = "root";
    static String clave = "admin";

    protected Connection conect = null;

    public ConexionBD_BIBLIOTECA() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conect = DriverManager.getConnection(url, usuario, clave);
        } catch (ClassNotFoundException ex) {
            System.out.println("Error en el driver: " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Error de conexión: " + ex.getMessage());
        }
    }

    public Connection conectar() {
        return conect;
    }

    public void desconectar() {
        try {
            conect.close();
        } catch (SQLException ex) {
            System.out.println("Error al desconectar: " + ex.getMessage());
        }
    }
}
