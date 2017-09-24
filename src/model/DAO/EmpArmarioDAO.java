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
import model.bean.Emp_armario;
import model.bean.Func_comum;

/**
 *
 * @author biank
 */
public class EmpArmarioDAO {
    public void create(Emp_armario emparmario){
        
        Connection c = Conexao.getConnection();
        PreparedStatement stmt = null;
        PreparedStatement stmt2 = null;
        try{
            stmt = c.prepareStatement("INSERT INTO emp_armario (cod_emprestimo, entrega, devolucao, matricula, cod_armario) VALUES (?,?,?,?,?)");
            stmt = c.prepareStatement("UPDATE armario SET status = ?");
           
            stmt.setInt(1, emparmario.getCod_emprestimo());
            stmt.setDate(2, (Date) emparmario.getEntrega());
            stmt.setDate(3, (Date) emparmario.getDevolucao());
            stmt.setInt(4, emparmario.getMatricula());
            stmt.setInt(5, emparmario.getCod_armario());
            stmt2.setInt(1, 1);
            stmt.executeUpdate();
            stmt2.executeUpdate();
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
    public void update(Emp_armario emparmario) {
        Connection c = Conexao.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = c.prepareStatement("UPDATE emp_armario SET entrega = ?, devolucao = ?, matricula = ? WHERE cod_emprestimo = ?");

            stmt.setDate(1, (Date) emparmario.getEntrega());
            stmt.setDate(2, (Date) emparmario.getDevolucao());
            stmt.setInt(3, emparmario.getMatricula());
            stmt.setInt(4, emparmario.getCod_emprestimo());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao atualizar registro!");
        } finally {
            Conexao.closeConnection(c, stmt);
        }
    }

    public List<Emp_armario> read() {
        Connection c = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Emp_armario> emprestimo_arm = new ArrayList<>();
        try {
            stmt = c.prepareStatement("SELECT * FROM emp_armario WHERE cod_emprestimo <> NULL");
            rs = stmt.executeQuery();
            while (rs.next()) {
                
                Emp_armario emparmario = new Emp_armario();

                emparmario.setEntrega(rs.getDate("entrega"));
                emparmario.setDevolucao(rs.getDate("devolucao"));
                emparmario.setMatricula(rs.getInt("matricula"));
                
                emprestimo_arm.add(emparmario);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.closeConnection(c, stmt);
        }
        return emprestimo_arm;
    }

    public void delete(Emp_armario emp_armario) {
        Connection c = Conexao.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = c.prepareStatement("DELETE FROM emp_armario where cod_emprestimo = ?");
            stmt.setInt(1, emp_armario.getCod_emprestimo());
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
