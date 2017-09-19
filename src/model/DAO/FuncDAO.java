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
import model.bean.Funcionario;

/**
 *
 * @author biank
 */
public class FuncDAO {
   public boolean create(Funcionario f){
        
        Connection c = Conexao.getConnection();
        PreparedStatement stmt = null;
        try{
            stmt = c.prepareStatement("INSERT INTO funcionario (matricula, cargo, setor,cpf) VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, f.getMatricula());
            stmt.setString(2, f.getCargo());
            stmt.setString(3, f.getSetor());
            stmt.setInt(4, f.getCpf());
            stmt.executeUpdate();
            
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            int idGerado = rs.getInt(1);
            f.setCod_func(idGerado);
            
        }
        catch(SQLException ex){
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE,null,ex);
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar pessoa!");
        }
        
        finally{
            Conexao.closeConnection(c, stmt);
        }
       return true;
    }
   public void update(Funcionario f) {
        Connection c = Conexao.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = c.prepareStatement("UPDATE comunidade SET setor = ?, cargo = ? WHERE matricula = ?");

            stmt.setString(1, f.getSetor());
            stmt.setString(2, f.getMatricula());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao atualizar registro!");
        } finally {
            Conexao.closeConnection(c, stmt);
        }

    }

    public List<Funcionario> read() {
        Connection c = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Funcionario> func = new ArrayList<>();
        try {
            stmt = c.prepareStatement("SELECT * FROM funcionario WHERE matricula <> NULL");
            rs = stmt.executeQuery();
            while (rs.next()) {
                
                Funcionario f = new Funcionario();

                f.setCargo(rs.getString("cargo"));
                f.setSetor(rs.getString("setor"));
                f.setMatricula(rs.getString("matricula"));
                
                func.add(f);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.closeConnection(c, stmt);
        }
        return func;
    }

    public void delete(Funcionario f) {
        Connection c = Conexao.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = c.prepareStatement("DELETE FROM funcionario where matricula = ?");
            stmt.setString(1, f.getMatricula());
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
