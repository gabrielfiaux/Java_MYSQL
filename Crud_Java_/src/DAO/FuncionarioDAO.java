/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.FuncionarioDTO;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class FuncionarioDAO {

    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<FuncionarioDTO> lista = new ArrayList<>();

    public void cadastrarFuncionario(FuncionarioDTO funcionarioDTO) {
        String sql = "INSERT INTO funcionario(nome , endereco) values (?,?)";

        //curioso
        conn = new ConexaoDAO().conectaBD();

        try {

            pstm = conn.prepareStatement(sql);
            pstm.setString(1, funcionarioDTO.getNome());
            pstm.setString(2, funcionarioDTO.getEndereco());

            pstm.execute();
            JOptionPane.showMessageDialog(null, "Funcionario Cadastrado com Sucesso.");
            pstm.close();

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "FuncionarioDAO Cadastrar: " + erro);

        }

    }

    public ArrayList<FuncionarioDTO> pesquisarFuncionario() {
        String sql = "select * from funcionario";
         conn = new ConexaoDAO().conectaBD();
        try {
            
            /*var pstm recebe a localização do banco de dados 
             var rs recebe os valores da instrução sql String sql = "select * from funcionario";
             enquanto tiver valores dentro do rs passa para a proxima linha
            set esses valores dentro da bean dto,  para depois exibir na view.
             */
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                FuncionarioDTO funcionarioDTO = new FuncionarioDTO();
                funcionarioDTO.setId(rs.getInt("id"));
                funcionarioDTO.setNome(rs.getString("nome"));
                funcionarioDTO.setEndereco(rs.getString("endereco"));
                lista.add(funcionarioDTO);
            }

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "FuncionarioDAO Pesquisar: " + erro);
        }

        return lista;
    }

}
