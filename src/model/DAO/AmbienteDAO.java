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
import java.util.ArrayList;
import java.util.List;
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
    
      public void update(Ambiente a) {
        Connection c = Conexao.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = c.prepareStatement("UPDATE ambiente SET bloco = ?, setor = ?, status = ? WHERE numero = ?");

            stmt.setString(1, a.getBloco());
            stmt.setString(2, a.getSetor());
            stmt.setInt(3, a.getStatus());
            stmt.setInt(4, a.getNumero());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao atualizar registro!");
        } finally {
            Conexao.closeConnection(c, stmt);
        }

    }

    public List<Ambiente> read() {
        Connection c = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Ambiente> ambientes = new ArrayList<>();
        try {
            stmt = c.prepareStatement("SELECT * FROM ambiente WHERE numero <> NULL");
            rs = stmt.executeQuery();
            while (rs.next()) {
                
                Ambiente a = new Ambiente();

                a.setNumero(rs.getInt("numero"));
                a.setSetor(rs.getString("setor"));
                a.setBloco(rs.getString("bloco"));
                a.setStatus(rs.getInt("status"));

                ambientes.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.closeConnection(c, stmt);
        }
        return ambientes;
    }

    public void delete(Ambiente a) {
        Connection c = Conexao.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = c.prepareStatement("DELETE FROM ambiente where numero = ?");
            stmt.setInt(1, a.getNumero());
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
