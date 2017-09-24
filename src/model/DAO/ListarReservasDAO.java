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
import model.bean.Ambiente;
import model.bean.ListarReservas;
import model.bean.Pessoa;
import model.bean.Reserva;

/**
 *
 * @author biank
 */
public class ListarReservasDAO {
     public List<ListarReservas> read() {
        
            Connection c = Conexao.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            List<ListarReservas> retorno= new ArrayList<>();
            
            try {
            stmt = c.prepareStatement("SELECT * FROM pessoa,reserva,ambiente WHERE pessoa.cpf = reserva.cpf AND ambiente.numero = reserva.numero");
            rs = stmt.executeQuery();
            while (rs.next()) {
                
                
                Reserva r = new Reserva();
                Pessoa p = new Pessoa();
                Ambiente a = new Ambiente();
                
                r.setCod_reserva(rs.getInt("cod_reserva"));
                r.setData_evento(rs.getDate("data_evento"));
                p.setNome(rs.getString("nome"));
                a.setNumero(rs.getInt("numero"));
                a.setSetor(rs.getString("setor"));
                a.setStatus(rs.getInt("status"));
                ListarReservas lista = new ListarReservas(r,p,a);
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
