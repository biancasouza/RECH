/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import config.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Aluno;


/**
 *
 * @author biank
 */
public class AlunoDAO {
    public void create(Aluno a){
        
        Connection c = Conexao.getConnection();
        PreparedStatement stmt = null;
        try{
            stmt = c.prepareStatement("INSERT INTO aluno (matricula,curso,semestre, turno) VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, a.getMatricula());
            stmt.setString(2, a.getCurso());
            stmt.setInt(3, a.getSemestre());
            stmt.setString(4, a.getTurno()); 
    
            stmt.executeUpdate();
            
           
            JOptionPane.showMessageDialog(null, "Aluno (a) cadastrado com sucesso!");
        }
        catch(SQLException ex){
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE,null,ex);
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar aluno (a)!");
        }
        
        finally{
            Conexao.closeConnection(c, stmt);
        }
    }
}
