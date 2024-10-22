/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.FuncionarioDTO;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class FuncionarioDAO {

    Connection conn;
    PreparedStatement pstm;

    public void cadastrarFuncionario(FuncionarioDTO funcionarioDTO) {
        String sql = "INSERT INTO funcionario(nome , endereco) values (?,?)";

        //curioso
        conn = new ConexaoDAO().conectaBD();

        try {
            
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, funcionarioDTO.getNome());
            pstm.setString(2, funcionarioDTO.getEndereco());
            
            pstm.execute();
            pstm.close();

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "FuncionarioDAO" + erro);
        }

    }
}
