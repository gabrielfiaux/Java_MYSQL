/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.UsuarioDTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author gfiau
 */
public class UsuarioDAO {
    
    public Connection conn;
    
    public ResultSet autenticacaoUsuario(UsuarioDTO objusuarioDTO){
    conn = new ConexaoDAO().conectaBD();
    
        try {
            String sql = "select * from usuario  where nome = ? and senha = ? ";
            // peg
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, objusuarioDTO.getNome_usuario());
            pstm.setString(2, objusuarioDTO.getSenha_usuario());
            
            ResultSet rs = pstm.executeQuery();
            return rs;
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null,"UsuarioDAO:  "+ erro);
        }
        return null;
    
    }
    
}
