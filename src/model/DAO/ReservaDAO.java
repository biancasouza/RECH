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
import model.bean.Ambiente;
import model.bean.Comunidade;
import model.bean.Pessoa;
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
            JOptionPane.showMessageDialog(null, "Ambiente não disponível para esta data");
        }
        
        finally{
            Conexao.closeConnection(c, stmt);
        }
    }
       public void update(Reserva r) {
        Connection c = Conexao.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = c.prepareStatement("UPDATE reserva SET data_evento = ?, hora_evento = ?, numero = ? WHERE cod_reserva = ?");

            stmt.setDate(1, (Date) r.getData_evento());
            stmt.setTime(2, r.getHora());
            stmt.setInt(3, r.getNumero());
           
            stmt.setInt(4, r.getCod_reserva());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao atualizar registro!");
        } finally {
            Conexao.closeConnection(c, stmt);
        }

    }

    public List<Reserva> read() {
        Connection c = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Reserva> retorno= new ArrayList<>();
      
        try {
            stmt = c.prepareStatement("SELECT * FROM pessoa,reserva,ambiente WHERE pessoa.cpf = reserva.cpf AND ambiente.numero = reserva.numero");
            rs = stmt.executeQuery();
            while (rs.next()) {
                
                Reserva r = new Reserva();
                //Pessoa p = new Pessoa();
                //Ambiente a = new Ambiente();

                r.setCod_reserva(rs.getInt("cod_reserva"));
                r.setData_evento(rs.getDate("data_evento"));
                //r.setNumero(rs.getInt("numero"));
                //p.setNome(rs.getString("nome"));
                //a.setSetor(rs.getString("setor"));
                //a.setStatus(rs.getInt("status"));
                
                retorno.add(r);
                //retorno.add(p);
               //retorno.add(a);
              
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.closeConnection(c, stmt);
        }
        return retorno;
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
