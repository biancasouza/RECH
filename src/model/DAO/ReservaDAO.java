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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Reserva;

/**
 *
 * @author biank
 */
public class ReservaDAO {
    public void create(Reserva r){
        
        Connection c = Conexao.getConnection();
        PreparedStatement stmt = null;
        try{
            stmt = c.prepareStatement("INSERT INTO reserva (data_evento,hora_evento,cpf, numero) VALUES (?,?,?,?)");
          
            stmt.setDate(1, (Date) r.getData_evento());
            stmt.setTime(2, r.getHora());
            stmt.setInt(3, r.getCpf());
            stmt.setInt(4, r.getNumero()); 
      
            stmt.executeUpdate();
            
           
            JOptionPane.showMessageDialog(null, "Reservado com sucesso!");
        }
        catch(SQLException ex){
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE,null,ex);
            JOptionPane.showMessageDialog(null, "Erro!");
        }
        
        finally{
            Conexao.closeConnection(c, stmt);
        }
    }

}
