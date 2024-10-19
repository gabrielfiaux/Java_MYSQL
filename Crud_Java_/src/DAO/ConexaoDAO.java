package DAO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConexaoDAO {
 //comentario
    public Connection conectaBD() {
        Connection conn = null;

        //se houver um erro em um pc diferente pode estar aqui
        // pois o user está como localhost
        //banco de dados está como banco teste.
        try {
            String url = "jdbc:mysql://localhost:3306/bancoteste?user=root&password=";
            conn = DriverManager.getConnection(url);

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ConexaoDAO" + erro.getMessage());
        }
        return conn;
    }

}
