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
import model.bean.Func_user;

public class Func_userDAO {
    public boolean checkLogin(String login, String senha) {

        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        boolean check = false;

        try {

            stmt = con.prepareStatement("SELECT * FROM func_user WHERE login = ? and senha = ?");
            stmt.setString(1, login);
            stmt.setString(2, senha);

            rs = stmt.executeQuery();

            if (rs.next()) {

                
                check = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(Func_userDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.closeConnection(con, stmt, rs);
        }

        return check;

    }
    public void create(Func_user f){
        
        Connection c = Conexao.getConnection();
        PreparedStatement stmt = null;
        try{
            stmt = c.prepareStatement("INSERT INTO func_user (login,senha,cod_func) VALUES (?,?,?)");
            stmt.setString(1, f.getLogin());
            stmt.setString(2,f.getSenha());
            stmt.setInt(3, f.getCod_func());
           
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
    public void update(Func_user func_user) {
        Connection c = Conexao.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = c.prepareStatement("UPDATE func_user SET login = ?, senha = ? WHERE cod_func_user = ?");

            stmt.setString(1, func_user.getLogin());
            stmt.setString(2, func_user.getSenha());
            stmt.setInt(3, func_user.getCod_user_func());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao atualizar registro!");
        } finally {
            Conexao.closeConnection(c, stmt);
        }
    }
    
//Não vai ser necessario criar 
//    public List<Func_user> read() {
//        Connection c = Conexao.getConnection();
//        PreparedStatement stmt = null;
//        ResultSet rs = null;
//        List<Func_user> func_users = new ArrayList<>();
//        try {
//            stmt = c.prepareStatement("SELECT * FROM func_user WHERE cod_func <> NULL");
//            rs = stmt.executeQuery();
//            while (rs.next()) {
//                
//                Func_user user = new Func_user();
//
//                user.setLogin(rs.getString("login"));
//                user.setSenha(rs.getString("senha"));
//                
//                func_users.add(user);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            Conexao.closeConnection(c, stmt);
//        }
//        return func_users;
//    }

    public void delete(Func_user func_user) {
        Connection c = Conexao.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = c.prepareStatement("DELETE FROM func_user where cod_func_user = ?");
            stmt.setInt(1, func_user.getCod_user_func());
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
