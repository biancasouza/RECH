/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import config.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Ambiente;

/**
 *
 * @author biank
 */
public class AmbienteDAO {
    public void create(Ambiente a){
        
        Connection c = Conexao.getConnection();
        PreparedStatement stmt = null;
        try{
            stmt = c.prepareStatement("INSERT INTO ambiente (numero,bloco,setor, status) VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, a.getNumero());
            stmt.setString(2, a.getBloco());
            stmt.setString(3, a.getSetor());
            stmt.setInt(4, 0); // Padrão vai ser 0 = 'DISPONÍVEL'
    
            stmt.executeUpdate();
            
           
            JOptionPane.showMessageDialog(null, "Ambiente cadastrado com sucesso!");
        }
        catch(SQLException ex){
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE,null,ex);
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar ambiente!");
        }
        
        finally{
            Conexao.closeConnection(c, stmt);
        }
    }
}
