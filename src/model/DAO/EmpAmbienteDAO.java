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
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Emp_ambiente;
import model.bean.Funcionario;

/**
 *
 * @author biank
 */
public class EmpAmbienteDAO {


   public boolean create(Emp_ambiente e){
        
        Connection c = Conexao.getConnection();
        PreparedStatement stmt = null;
        try{
            stmt = c.prepareStatement("INSERT INTO emp_ambiente (data, matricula, cod_func_com, numero) VALUES (?,?,?,?)");
            stmt.setDate(1, (Date) e.getData());
            if (e.getMatricula() == null){
            stmt.setNull(2, Types.INTEGER);}
            else{
            stmt.setInt(2, e.getMatricula());}
           
             if (e.getCod_func_com() == null){
            stmt.setNull(3, Types.INTEGER);}
            else{
            stmt.setInt(3, e.getCod_func_com());}
            stmt.setInt(4, e.getNumero());
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Empréstimo feito com sucesso!");
            
        }
        catch(SQLException ex){
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE,null,ex);
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar ambiente!");
        }
        
        finally{
            Conexao.closeConnection(c, stmt);
        }
       return true;
    }
   public void update(Emp_ambiente e) {
        Connection c = Conexao.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = c.prepareStatement("UPDATE comunidade SET data = ?, matricula= ?, cod_func_com = ?, numero = ? WHERE cod_emp_amb = ?");

            stmt.setDate(1, (Date) e.getData());
            stmt.setInt(2, e.getMatricula());
            stmt.setInt(3, e.getCod_func_com());
            stmt.setInt(4, e.getNumero());
            stmt.setInt(5, e.getCod_emp_amb());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao atualizar registro!");
        } finally {
            Conexao.closeConnection(c, stmt);
        }

    }

    public List<Emp_ambiente> read() {
        Connection c = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Emp_ambiente> emp_amb = new ArrayList<>();
        try {
            stmt = c.prepareStatement("SELECT * FROM emp_ambiente WHERE cod_emp_amb <> NULL");
            rs = stmt.executeQuery();
            while (rs.next()) {
                
                Emp_ambiente e = new Emp_ambiente();

                e.setData(rs.getDate("data"));
                e.setMatricula(rs.getInt("matricula"));
                e.setNumero(rs.getInt("numero"));
                e.setCod_func_com(rs.getInt("cod_func_com"));
                
                emp_amb.add(e);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.closeConnection(c, stmt);
        }
        return emp_amb;
    }

    public void delete(Emp_ambiente e) {
        Connection c = Conexao.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = c.prepareStatement("DELETE FROM emp_ambiente where cod_emp_amb = ?");
            stmt.setInt(1, e.getCod_func_com());
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


