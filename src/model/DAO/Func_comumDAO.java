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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Comunidade;
import model.bean.Func_comum;

/**
 *
 * @author biank
 */
public class Func_comumDAO {
    public void create(Func_comum com){
        
        Connection c = Conexao.getConnection();
        PreparedStatement stmt = null;
        try{
            stmt = c.prepareStatement("INSERT INTO func_comum (tipo, cod_func) VALUES (?,?)");
            stmt.setString(1, com.getTipo());
            stmt.setInt(2,com.getCod_func());
           
            stmt.executeUpdate();
            
           
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
        }
        catch(SQLException ex){
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE,null,ex);
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar!");
        }
        
        finally{
            Conexao.closeConnection(c, stmt);
        }
    }
    public void update(Func_comum func_c) {
        Connection c = Conexao.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = c.prepareStatement("UPDATE func_comum SET tipo = ? WHERE cod_func = ?");

            stmt.setString(1, func_c.getTipo());
            stmt.setInt(2, func_c.getCod_func());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao atualizar registro!");
        } finally {
            Conexao.closeConnection(c, stmt);
        }

    }

    public List<Func_comum> read() {
        Connection c = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Func_comum> func_com = new ArrayList<>();
        try {
            stmt = c.prepareStatement("SELECT * FROM func_comum WHERE cod_func <> NULL");
            rs = stmt.executeQuery();
            while (rs.next()) {
                
                Func_comum func_comum = new Func_comum();

                func_comum.setTipo(rs.getString("tipo"));
                
                func_com.add(func_comum);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.closeConnection(c, stmt);
        }
        return func_com;
    }

    public void delete(Func_comum func_com) {
        Connection c = Conexao.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = c.prepareStatement("DELETE FROM func_comum where cod_func = ?");
            stmt.setInt(1, func_com.getCod_func());
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
