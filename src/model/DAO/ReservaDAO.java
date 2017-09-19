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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Comunidade;
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
       public void update(Comunidade com) {
        Connection c = Conexao.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = c.prepareStatement("UPDATE comunidade SET endereco = ? WHERE cod_comunidade = ?");

            stmt.setString(1, com.getEndereco());
            stmt.setInt(2, com.getCod_comunidade());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao atualizar registro!");
        } finally {
            Conexao.closeConnection(c, stmt);
        }

    }

    public List<Comunidade> read() {
        Connection c = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Comunidade> comunidades = new ArrayList<>();
        try {
            stmt = c.prepareStatement("SELECT * FROM comunidade WHERE numero <> NULL");
            rs = stmt.executeQuery();
            while (rs.next()) {
                
                Comunidade com = new Comunidade();

                com.setEndereco(rs.getString("endereco"));
                
                comunidades.add(com);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.closeConnection(c, stmt);
        }
        return comunidades;
    }

    public void delete(Comunidade com) {
        Connection c = Conexao.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = c.prepareStatement("DELETE FROM comunidade where cod_armario = ?");
            stmt.setInt(1, com.getCod_comunidade());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro excluido!");
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao excluir registro!");
        } finally {
            Conexao.closeConnection(c, stmt);
        }
    }

}
