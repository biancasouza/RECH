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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Comunidade;
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
          //  stmt = c.prepareStatement("INSERT INTO pessoa (cpf,telefone,nome, data_nasc,rg,email) VALUES (?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            stmt = c.prepareStatement("INSERT INTO pessoa (cpf,telefone,nome, data_nasc,rg,email) VALUES (?,?,?,?,?,?)");
            stmt.setInt(1, p.getCpf());
            stmt.setInt(2, p.getTelefone());
            stmt.setString(3, p.getNome());
            stmt.setDate(4, (Date) p.getData_nasc()); 
            stmt.setInt(5, p.getRg());
            stmt.setString(6, p.getEmail());
            stmt.executeUpdate();
        }
        catch(SQLException ex){
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE,null,ex);
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar pessoa!");
        }
        
        finally{
            Conexao.closeConnection(c, stmt);
        }
       
    }
      public void update(Pessoa p) {
        Connection c = Conexao.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = c.prepareStatement("UPDATE pessoa SET nome = ?, rg = ?, data_nasc = ?, email = ?, telefone = ? WHERE cpf = ?");

            stmt.setInt(6, p.getCpf());
            stmt.setInt(5, p.getTelefone());
            stmt.setString(1, p.getNome());
            stmt.setDate(3, (Date) p.getData_nasc()); 
            stmt.setInt(2, p.getRg());
            stmt.setString(4, p.getEmail());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao atualizar registro!");
        } finally {
            Conexao.closeConnection(c, stmt);
        }

    }

    public List<Pessoa> read() {
        Connection c = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Pessoa> pessoas = new ArrayList<>();
        try {
            stmt = c.prepareStatement("SELECT * FROM pessoa WHERE cpf <> NULL");
            rs = stmt.executeQuery();
            while (rs.next()) {
                
                Pessoa p = new Pessoa();

                p.setNome(rs.getString("nome"));
                p.setEmail(rs.getString("email"));
                p.setTelefone(rs.getInt("telefone"));
                
                pessoas.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.closeConnection(c, stmt);
        }
        return pessoas;
    }

    public void delete(Pessoa p) {
        Connection c = Conexao.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = c.prepareStatement("DELETE FROM pessoa where cpf = ?");
            stmt.setInt(1, p.getCpf());
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

