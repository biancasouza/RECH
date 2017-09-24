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
import model.bean.Aluno;
import model.bean.Armario;
import model.bean.Emp_armario;
import model.bean.ListarEmpArmario;
import model.bean.ListarReservas;
import model.bean.Pessoa;


/**
 *
 * @author biank
 */
public class ListarEmpArmarioDAO {
    public List<ListarEmpArmario> read() {
        
            Connection c = Conexao.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            List<ListarEmpArmario> retorno= new ArrayList<>();
            
            try {
            stmt = c.prepareStatement("SELECT * FROM pessoa,aluno,armario,emp_armario WHERE pessoa.cpf = aluno.cpf AND aluno.matricula = emp_armario.matricula AND armario.cod_armario = emp_armario.cod_armario");
            rs = stmt.executeQuery();
            while (rs.next()) {
                
                
                Emp_armario e= new Emp_armario();
                Pessoa p = new Pessoa();
                Armario a = new Armario();
                Aluno al = new Aluno();
                
                e.setCod_emprestimo(rs.getInt("cod_emprestimo"));
                e.setEntrega(rs.getDate("entrega"));
                e.setDevolucao(rs.getDate("devolucao"));
                p.setNome(rs.getString("nome"));
                al.setMatricula(rs.getInt("matricula"));
                a.setNum_armario(rs.getInt("num_armario"));
                a.setNum_chave(rs.getInt("num_chave"));
                a.setStatus(rs.getInt("status"));
                
                ListarEmpArmario lista = new ListarEmpArmario(p,al,a,e);
                retorno.add(lista);
               
            }
        } catch (SQLException ex) {
            Logger.getLogger(ListarReservas.class.getName()).log(Level.SEVERE, null, ex);
        }
            finally {
            Conexao.closeConnection(c, stmt);
        }
        return retorno;
    }
}
