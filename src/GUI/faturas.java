/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Utilizador
 */
public class faturas extends javax.swing.JFrame {
 double lucro =0;
 String lucroS="";
 int id_bar=0;
    public faturas() {
        initComponents();
    }
    public faturas(int a ) {
        initComponents();
        id_bar=a;
        mostrar_fatura_info_tudo(id_bar);
        try{
        Connection con = ConnectionProvider.Connector();              
        String query1 ="select sum(preco) as preco  from fatura where id_bar=?";
        PreparedStatement pst1= con.prepareStatement(query1);
        pst1.setInt(1,id_bar);
        ResultSet rs1=pst1.executeQuery();
                   while(rs1.next()){
                lucro=rs1.getDouble("preco");
                   } 
                   lucroS=Double.toString(lucro);
                   lucro_total_label.setText(lucroS+"€");
        }catch(Exception e){
           JOptionPane.showMessageDialog(null, e);
    }
    }
    
    public ArrayList <fatura> fatura_info_tudo(int id_bar) {//armazenar info da tabela bar
         ArrayList <fatura> fatura_info_tudo = new ArrayList<>();
         try{
        Connection con = ConnectionProvider.Connector();
        String query ="SELECT * FROM fatura Where id_bar=?";
       PreparedStatement pst= con.prepareStatement(query);
        pst.setInt(1,id_bar);
        ResultSet rs=pst.executeQuery();
        
        fatura f;
        while(rs.next()){
            f=new fatura(rs.getInt("id_fatura"),rs.getDouble("preco"),rs.getString("data"));
            fatura_info_tudo.add(f);
        }
        
        
         }catch(Exception e){
             JOptionPane.showMessageDialog(null, e);
         }
         return fatura_info_tudo;
    }
     public void mostrar_fatura_info_tudo(int id_bar){//distribuir info da tabela mesa na jtable
        ArrayList<fatura> lista =fatura_info_tudo(id_bar);
        DefaultTableModel model =(DefaultTableModel)fatura_tabela.getModel();
        Object[]  row= new Object [3];
        for (int i = 0; i < lista.size(); i++) {
            row[0]=lista.get(i).getId_fatura();
            row[1]=lista.get(i).getPreco();
            row[2]=lista.get(i).getData();
    
            model.addRow(row);
            
        }
        }
     
     public ArrayList <fatura> fatura_info(int id_bar) {//armazenar info da tabela bar
         ArrayList <fatura> fatura_info = new ArrayList<>();
         try{
        Connection con = ConnectionProvider.Connector();
        String query ="SELECT * FROM fatura Where id_bar=? and data=?";
       PreparedStatement pst= con.prepareStatement(query);
        pst.setInt(1,id_bar);
        pst.setString(2,jTextField1.getText());
        ResultSet rs=pst.executeQuery();
        
        fatura f;
        while(rs.next()){
            f=new fatura(rs.getInt("id_fatura"),rs.getDouble("preco"),rs.getString("data"));
            fatura_info.add(f);
        }
        
        
         }catch(Exception e){
             JOptionPane.showMessageDialog(null, e);
         }
         return fatura_info;
    }
        public void mostrar_fatura_info(int id_bar){//distribuir info da tabela mesa na jtable
        ArrayList<fatura> lista =fatura_info(id_bar);
        DefaultTableModel model =(DefaultTableModel)fatura_tabela.getModel();
        Object[]  row= new Object [3];
        for (int i = 0; i < lista.size(); i++) {
            row[0]=lista.get(i).getId_fatura();
            row[1]=lista.get(i).getPreco();
            row[2]=lista.get(i).getData();
    
            model.addRow(row);
            
        }
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
        jScrollPane1 = new javax.swing.JScrollPane();
        fatura_tabela = new javax.swing.JTable();
        ver_faturas_butao = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        lucro_total_label = new javax.swing.JLabel();
        botao_sair = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Data:");

        jLabel2.setText("(ano-mes-data)ex:2020/12/27");

        fatura_tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id_fatura", "lucro", "data"
            }
        ));
        jScrollPane1.setViewportView(fatura_tabela);

        ver_faturas_butao.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ver_faturas_butao.setText("Ver Faturas");
        ver_faturas_butao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ver_faturas_butaoActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Lucro total:");

        lucro_total_label.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        botao_sair.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        botao_sair.setText("Sair");
        botao_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_sairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lucro_total_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(ver_faturas_butao, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botao_sair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lucro_total_label, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ver_faturas_butao, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botao_sair, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ver_faturas_butaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ver_faturas_butaoActionPerformed
       try{
          
           String data = jTextField1.getText();
        if(data.equalsIgnoreCase("")){
            
               DefaultTableModel dm1 = (DefaultTableModel)fatura_tabela.getModel();
                  while(dm1.getRowCount() > 0)
                        {
                            dm1.removeRow(0);
                        }
                       mostrar_fatura_info_tudo(id_bar);
        Connection con = ConnectionProvider.Connector();              
        String query1 ="select sum(preco) as preco from fatura where id_bar=?";
        PreparedStatement pst1= con.prepareStatement(query1);
        pst1.setInt(1,id_bar);
        ResultSet rs1=pst1.executeQuery();
                   while(rs1.next()){
                lucro=rs1.getDouble("preco");
                   } 
                   lucroS=Double.toString(lucro);
                   lucro_total_label.setText(lucroS+"€");
                   con.close();
                   pst1.close();
                 
            
            
        }else{
            
             DefaultTableModel dm2 = (DefaultTableModel)fatura_tabela.getModel();
                  while(dm2.getRowCount() > 0)
                        {
                            dm2.removeRow(0);
                        }
                       mostrar_fatura_info(id_bar);
         Connection con2 = ConnectionProvider.Connector();              
        String query2 ="select sum(preco) as preco from fatura where id_bar=? and data=?";
        PreparedStatement pst2= con2.prepareStatement(query2);
        pst2.setInt(1,id_bar);
        pst2.setString(2,data);
        ResultSet rs2=pst2.executeQuery();
                   while(rs2.next()){
                lucro=rs2.getDouble("preco");
                   } 
                   lucroS=Double.toString(lucro);
                   lucro_total_label.setText(lucroS+"€");
        }
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, e);
           
       }    
    }//GEN-LAST:event_ver_faturas_butaoActionPerformed

    private void botao_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_sairActionPerformed
       setVisible(false);
    }//GEN-LAST:event_botao_sairActionPerformed

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
            java.util.logging.Logger.getLogger(faturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(faturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(faturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(faturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new faturas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botao_sair;
    private javax.swing.JTable fatura_tabela;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lucro_total_label;
    private javax.swing.JButton ver_faturas_butao;
    // End of variables declaration//GEN-END:variables
}
