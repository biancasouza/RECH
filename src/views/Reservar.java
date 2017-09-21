/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import config.Conexao;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.DAO.ReservaDAO;
import model.bean.Ambiente;
import model.bean.Reserva;


/**
 *
 * @author biank
 */
public class Reservar extends javax.swing.JFrame {

    /**
     * Creates new form Reservar
     */
    public Reservar() throws SQLException {
        initComponents();
        listarambiente();
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Rech = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        ambiente = new javax.swing.JComboBox<>();
        data = new javax.swing.JTextField();
        hora = new javax.swing.JTextField();
        cpf = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("RECH - Reservar Ambientes");
        setIconImage(Toolkit.getDefaultToolkit().getImage("C://Users/biank/Documents/NetBeansProjects/Rech/src/rech/img/li2.png"
            + ""));

    Rech.setBackground(new java.awt.Color(255, 255, 255));
    Rech.setToolTipText("");
    Rech.setName("RECH"); // NOI18N

    jLabel11.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
    jLabel11.setText("RESERVAR");

    jPanel4.setBackground(new java.awt.Color(97, 180, 83));
    jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

    jLabel16.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
    jLabel16.setText("Data:");

    jLabel19.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
    jLabel19.setText("CPF (Para os demais):");

    jLabel20.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
    jLabel20.setText("Hora: ");

    jLabel14.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
    jLabel14.setText("Ambiente: ");

    ambiente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione"}));

    javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
    jPanel4.setLayout(jPanel4Layout);
    jPanel4Layout.setHorizontalGroup(
        jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel4Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel19)
                .addComponent(jLabel16)
                .addComponent(jLabel20)
                .addComponent(jLabel14))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(hora, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                .addComponent(data, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                .addComponent(cpf)
                .addComponent(ambiente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGap(0, 0, Short.MAX_VALUE))
    );
    jPanel4Layout.setVerticalGroup(
        jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel4Layout.createSequentialGroup()
            .addGap(23, 23, 23)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel19)
                .addComponent(cpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(9, 9, 9)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel16)
                .addComponent(data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(jLabel20)
                .addComponent(hora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(16, 16, 16)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(ambiente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel14))
            .addGap(0, 69, Short.MAX_VALUE))
    );

    jLabel12.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
    jLabel12.setForeground(new java.awt.Color(255, 51, 51));
    jLabel12.setText("--------------------------------------");

    jLabel13.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
    jLabel13.setForeground(new java.awt.Color(255, 51, 51));
    jLabel13.setText("---------------------------------------");

    jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/sair_318-10026.png"))); // NOI18N

    jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/sair.png"))); // NOI18N
    jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jLabel10MouseClicked(evt);
        }
    });

    javax.swing.GroupLayout RechLayout = new javax.swing.GroupLayout(Rech);
    Rech.setLayout(RechLayout);
    RechLayout.setHorizontalGroup(
        RechLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(RechLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(RechLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RechLayout.createSequentialGroup()
                    .addComponent(jLabel12)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                    .addComponent(jLabel11)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel13))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RechLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(RechLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(RechLayout.createSequentialGroup()
                            .addComponent(jLabel10)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel9))
                        .addGroup(RechLayout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(jLabel3)))
                    .addGap(12, 12, 12)))
            .addContainerGap())
    );
    RechLayout.setVerticalGroup(
        RechLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RechLayout.createSequentialGroup()
            .addGap(30, 30, 30)
            .addGroup(RechLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel11)
                .addComponent(jLabel12)
                .addComponent(jLabel13))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(23, 23, 23)
            .addGroup(RechLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel3)
            .addGap(71, 71, 71))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addComponent(Rech, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(Rech, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents
     public void listarambiente() throws SQLException{
        Connection c = Conexao.getConnection();
        PreparedStatement stmt = null;
        stmt = c.prepareStatement("SELECT setor FROM ambiente WHERE status = 0");
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){  
            ambiente.addItem(rs.getString(1));
            
        } 
        ambiente.updateUI();
    }
    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        Reserva r = new Reserva();
        ReservaDAO dao = new ReservaDAO();
        
        try {
            r.setData_evento(converteData(data.getText()));
        } catch (ParseException ex) {
            Logger.getLogger(Reservar.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            r.setHora(converteHora(hora.getText()));
        } catch (ParseException ex) {
            Logger.getLogger(Reservar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        PreparedStatement stmt2 = null;
        ResultSet rs = null;
        ResultSet rs2 = null;
        try {
           
            stmt = con.prepareStatement("SELECT * FROM pessoa WHERE pessoa.cpf = ? ");
         
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("CPF não encontrado!");
        }
        try {
            stmt.setString(1, cpf.getText());
            rs = stmt.executeQuery();
        
            if (rs.next()) {
                int cpf_num = rs.getInt("cpf");
                r.setCpf(cpf_num);
            }
          
         } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);

            }
         try {
           
            stmt2 = con.prepareStatement("SELECT * FROM ambiente WHERE ambiente.setor = ? ");
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro!");
        }
        try {
        
            stmt2.setString(1, (String) ambiente.getSelectedItem());
            rs2= stmt2.executeQuery();
          
            if (rs2.next()) {
                int sala_num = rs2.getInt("numero");
                r.setNumero(sala_num);
            }
         } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, ex);
            }
           
        dao.create(r);
        data.setText("");
        hora.setText("");
        cpf.setText("");
        ambiente.setSelectedItem("Selecione");
        
        
                
    }//GEN-LAST:event_jLabel10MouseClicked
    public Date converteData (String data) throws ParseException{
        SimpleDateFormat formateData = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date date;
        date = formateData.parse(data);
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        return  sqlDate;
    }
    public Time converteHora (String hora) throws ParseException{
        SimpleDateFormat formateData = new SimpleDateFormat("HH:mm:ss");
        java.util.Date hr;
        hr = formateData.parse(hora);
        Time sqlTime= new java.sql.Time(hr.getTime());
        return  sqlTime;
    }
    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Reservar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Reservar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Reservar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Reservar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    new Reservar().setVisible(true);
//                } catch (SQLException ex) {
//                    Logger.getLogger(Reservar.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Rech;
    private javax.swing.JComboBox<String> ambiente;
    private javax.swing.JTextField cpf;
    private javax.swing.JTextField data;
    private javax.swing.JTextField hora;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel4;
    // End of variables declaration//GEN-END:variables

    
}
