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
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Armario;
/**
 *
 * @author biank
 */
public class ArmarioDAO {
    public void create(Armario a){
        
        Connection c = Conexao.getConnection();
        PreparedStatement stmt = null;
        try{
            stmt = c.prepareStatement("INSERT INTO armario (num_chave,num_armario,status) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, a.getNum_armario());
            stmt.setInt(2, a.getNum_chave());
            stmt.setInt(3, 0); // Padrão vai ser 0 = 'DISPONÍVEL'
    
            stmt.executeUpdate();
            
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            int idGerado = rs.getInt(1);
            
            a.setCod_armario(idGerado);
           
            JOptionPane.showMessageDialog(null, "Armário cadastrado com sucesso!");
        }
        catch(SQLException ex){
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE,null,ex);
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar armário!");
        }
        
        finally{
            Conexao.closeConnection(c, stmt);
        }
    }
}
