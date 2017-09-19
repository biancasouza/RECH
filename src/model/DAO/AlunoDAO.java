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
import model.bean.Aluno;

/**
 *
 * @author biank
 */
public class AlunoDAO {

    public void create(Aluno a) {

        Connection c = Conexao.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = c.prepareStatement("INSERT INTO aluno (matricula,curso,semestre, turno,cpf) VALUES (?,?,?,?,?)");
            stmt.setInt(1, a.getMatricula());
            stmt.setString(2, a.getCurso());
            stmt.setInt(3, a.getSemestre());
            stmt.setString(4, a.getTurno());
            stmt.setInt(5, a.getCpf());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Aluno (a) cadastrado com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar aluno (a)!");
        } finally {
            Conexao.closeConnection(c, stmt);
        }
    }

    public void update(Aluno a) {
        Connection c = Conexao.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = c.prepareStatement("UPDATE aluno SET turno = ?, semestre = ?, curso = ?, cpf = ? WHERE matricula = ?");

            stmt.setString(1, a.getCurso());
            stmt.setInt(2, a.getSemestre());
            stmt.setString(3, a.getTurno());
            stmt.setInt(4, a.getCpf());
            stmt.setInt(5, a.getMatricula());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao atualizar registro!");
        } finally {
            Conexao.closeConnection(c, stmt);
        }

    }

    public List<Aluno> read() {
        Connection c = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Aluno> alunos = new ArrayList<>();
        try {
            stmt = c.prepareStatement("SELECT * FROM alunos WHERE matricula <> NULL");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Aluno a = new Aluno();

                a.setMatricula(rs.getInt("matricula"));
                a.setCurso(rs.getString("curso"));
                a.setSemestre(rs.getInt("semestre"));
                a.setTurno(rs.getString("turno"));
                a.setCpf(rs.getInt("cpf"));

                alunos.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.closeConnection(c, stmt);
        }
        return alunos;
    }

    public void delete(Aluno a) {
        Connection c = Conexao.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = c.prepareStatement("DELETE FROM  aluno where matricula = ?");
            stmt.setInt(1, a.getMatricula());
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
