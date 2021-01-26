/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import java.sql.*;
import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 *
 * @author Utilizador
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        id_empregado_textfield = new javax.swing.JTextField();
        password_textfield = new javax.swing.JPasswordField();
        entrar_botao = new javax.swing.JButton();
        voltar_botao = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Id_empregado");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Password");

        password_textfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                password_textfieldActionPerformed(evt);
            }
        });

        entrar_botao.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        entrar_botao.setText("Entrar");
        entrar_botao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entrar_botaoActionPerformed(evt);
            }
        });

        voltar_botao.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        voltar_botao.setText("Voltar");
        voltar_botao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltar_botaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(entrar_botao, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                        .addComponent(voltar_botao, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(password_textfield)
                    .addComponent(id_empregado_textfield))
                .addContainerGap(88, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(id_empregado_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(password_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(entrar_botao, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(voltar_botao, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void password_textfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_password_textfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_password_textfieldActionPerformed

    private void entrar_botaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entrar_botaoActionPerformed
        try {
            Connection con = ConnectionProvider.Connector();
            int id_bar=0;
            String categoria="";
            String id="";
            int id_empregado=0;
            String pass="";
            char[] password=password_textfield.getPassword();
            for (int i = 0; i < password.length; i++) {
                pass+=password[i];  
            } 
           id = id_empregado_textfield.getText();
           id_empregado=Integer.parseInt(id);
           
          String query ="SELECT id_empregado, password from empregado WHERE id_empregado= ? and password =?";
          PreparedStatement pst= con.prepareStatement(query);
          pst.setInt(1,id_empregado);
          pst.setString(2,pass);
          ResultSet rs=pst.executeQuery();
          if(rs.next()==true){
          pst.close();
          rs.close();
          
          String query1 ="SELECT categoria, id_bar  from empregado WHERE id_empregado= ? and password =?";
          PreparedStatement pst1= con.prepareStatement(query1);
          pst1.setInt(1,id_empregado);
          pst1.setString(2,pass);
          ResultSet rs1=pst1.executeQuery();
                 while(rs1.next()){
                  categoria =rs1.getString("categoria");
                  id_bar=rs1.getInt("Id_bar");
                   }        
           pst1.close();
           rs1.close();
              
              
          setVisible (false);
          new area_empregado(id_empregado,id_bar,categoria).setVisible(true);
          
          }else{
                JOptionPane.showMessageDialog(null, "Credenciais erradas!!");
              
          }
     
            
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_entrar_botaoActionPerformed

    private void voltar_botaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltar_botaoActionPerformed
       setVisible(false);
       new Inicio().setVisible(true);
    }//GEN-LAST:event_voltar_botaoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton entrar_botao;
    private javax.swing.JTextField id_empregado_textfield;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField password_textfield;
    private javax.swing.JButton voltar_botao;
    // End of variables declaration//GEN-END:variables
}
