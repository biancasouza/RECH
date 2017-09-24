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
import model.bean.Ambiente;
import model.bean.Emp_ambiente;
import model.bean.Func_comum;
import model.bean.ListarEmp_Amb;
import model.bean.ListarReservas;
import model.bean.Pessoa;
import model.bean.Reserva;

/**
 *
 * @author biank
 */
public class ListarEmpAmbienteDAO {
    public List<ListarEmp_Amb> read() {
        
            Connection c = Conexao.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            List<ListarEmp_Amb> retorno= new ArrayList<>();
            
            try {
            stmt = c.prepareStatement("SELECT * FROM emp_ambiente, aluno, func_comum,ambiente WHERE aluno.matricula = emp_ambiente.matricula OR func_comum.cod_func_com = emp_ambiente.cod_func_com AND ambiente.numero = emp_ambiente.numero");
            rs = stmt.executeQuery();
            while (rs.next()) {
                
                Emp_ambiente e = new Emp_ambiente();
                Aluno al = new Aluno();
                Ambiente a = new Ambiente();
                Func_comum f = new Func_comum();
                
                e.setCod_emp_amb(rs.getInt("cod_emp_amb"));
                e.setData(rs.getDate("data"));
                a.setSetor(rs.getString("setor"));
                a.setStatus(rs.getInt("status"));
                al.setMatricula(rs.getInt("matricula"));
                f.setCod_func_com(rs.getInt("cod_func_com"));
                ListarEmp_Amb lista = new ListarEmp_Amb(e,al,a,f);
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
