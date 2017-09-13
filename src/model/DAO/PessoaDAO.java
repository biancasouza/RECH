/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import config.Conexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Pessoa;

/**
 *
 * @author biank
 */
public class PessoaDAO {
    public void create(Pessoa p){
        
        Connection c = Conexao.getConnection();
        PreparedStatement stmt = null;
        try{
            stmt = c.prepareStatement("INSERT INTO pessoa (cpf,telefone,nome, data_nasc,rg,email) VALUES (?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, p.getCpf());
            stmt.setInt(2, p.getTelefone());
            stmt.setString(3, p.getNome());
            stmt.setDate(4, (Date) p.getData_nasc()); 
            stmt.setInt(5, p.getRg());
            stmt.setString(6, p.getEmail());
            stmt.executeUpdate();
            
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            int idGerado = rs.getInt(1);
            
            
        }
        catch(SQLException ex){
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE,null,ex);
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar pessoa!");
        }
        
        finally{
            Conexao.closeConnection(c, stmt);
        }
       
    }
    
     
}

