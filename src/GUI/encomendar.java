/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Utilizador
 */
public class encomendar extends javax.swing.JFrame {

   int id_bar=0;
   int id_produto_inserir=0;
    public encomendar() {
        initComponents();
    }

        public encomendar(int a) {
        initComponents();
        id_bar=a;
        mostrar_stock_enc( id_bar);
        fill_Combo();
        mostrar_produto_agrupado();
        mostrar_encomena_basico(id_bar);
    }
        public ArrayList <encomenda_basico> encomenda_basico_info(int id_bar) {
         ArrayList <encomenda_basico> encomenda_basico_info = new ArrayList<>();
         try{
        Connection con = ConnectionProvider.Connector();
        String query ="SELECT id_produto, data,qtd from info_stock where id_bar=? ";
        PreparedStatement pst= con.prepareStatement(query);
        pst.setInt(1,id_bar);
        ResultSet rs=pst.executeQuery();
         
        
        encomenda_basico e;
        while(rs.next()){
            e=new encomenda_basico(rs.getInt("id_produto"),rs.getString("data"),rs.getInt("qtd"));
           encomenda_basico_info.add(e);
        }
         }catch(Exception e){
             JOptionPane.showMessageDialog(null, e);
         }
         return encomenda_basico_info;
    }
     
        
          public void mostrar_encomena_basico(int id_bar){//distribuir info da tabela mesa na jtable
        ArrayList<encomenda_basico> lista =encomenda_basico_info(id_bar);
        DefaultTableModel model =(DefaultTableModel)encomenda_table.getModel();
        Object[]  row= new Object [3];
        for (int i = 0; i < lista.size(); i++) {
            row[0]=lista.get(i).getId();
            row[1]=lista.get(i).getQtd();
            row[2]=lista.get(i).getData();
            model.addRow(row);
            
        }
            }
        
        
        
         public ArrayList <produto_agrupado> produto_agrupado_info() {//armazenar info da tabela bar
         ArrayList <produto_agrupado> produto_agrupado_info = new ArrayList<>();
         try{
        Connection con = ConnectionProvider.Connector();
        String query ="SELECT produto.nome,id_produto_agregado,qtd from produto inner join converte  on  produto.id_produto=converte.id_produto_agregado";
         Statement st= con.createStatement();
        ResultSet rs=st.executeQuery(query);
        
        produto_agrupado p;
        while(rs.next()){
            p=new produto_agrupado(rs.getString("nome"),rs.getInt("id_produto_agregado"),rs.getInt("qtd"));
           produto_agrupado_info.add(p);
        }
        
        
         }catch(Exception e){
             JOptionPane.showMessageDialog(null, e);
         }
         return produto_agrupado_info;
    }
        
            public void mostrar_produto_agrupado(){//distribuir info da tabela mesa na jtable
        ArrayList<produto_agrupado> lista =produto_agrupado_info();
        DefaultTableModel model =(DefaultTableModel)agrupado_tabela.getModel();
        Object[]  row= new Object [3];
        for (int i = 0; i < lista.size(); i++) {
            row[0]=lista.get(i).getId();
            row[1]=lista.get(i).getNome();
            row[2]=lista.get(i).getQtd();
            model.addRow(row);
            
        }
            }
        
        
        
        
        
          public ArrayList <stock_enc> stock_enc_info(int id_bar) {//armazenar info da tabela bar
         ArrayList <stock_enc> stock_enc_info = new ArrayList<>();
         try{
        Connection con = ConnectionProvider.Connector();
        String query ="SELECT produto.nome,stock.id_produto,stock.qtd FROM stock inner join produto on produto.id_produto=stock.id_produto WHERE id_bar=?";
        PreparedStatement pst= con.prepareStatement(query);
        pst.setInt(1,id_bar);
        ResultSet rs=pst.executeQuery();
        
        stock_enc s;
        while(rs.next()){
            s=new stock_enc(rs.getString("nome"),rs.getInt("id_produto"),rs.getInt("qtd"));
            stock_enc_info.add(s);
        }
        
        
         }catch(Exception e){
             JOptionPane.showMessageDialog(null, e);
         }
         return stock_enc_info;
    }
        public void mostrar_stock_enc(int id_bar){//distribuir info da tabela mesa na jtable
        ArrayList<stock_enc> lista =stock_enc_info(id_bar);
        DefaultTableModel model =(DefaultTableModel)tabela_stock.getModel();
        Object[]  row= new Object [3];
        for (int i = 0; i < lista.size(); i++) {
            row[0]=lista.get(i).getNome();
            row[1]=lista.get(i).getId_produto();
            row[2]=lista.get(i).getQtd();
            model.addRow(row);
            
        }
        }
            public void fill_Combo(){
        try{
            Connection con = ConnectionProvider.Connector();
            String query ="SELECT id_produto_agregado FROM converte ";
        Statement st= con.createStatement();
        ResultSet rs=st.executeQuery(query);
                  while(rs.next()){
                    String s =String.valueOf(rs.getInt("id_produto_agregado"));
                    produto_comboBox.addItem(s);
        }
        }catch(Exception e){
             JOptionPane.showMessageDialog(null, e);
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

        jLabel3 = new javax.swing.JLabel();
        produto_comboBox = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        quantidade_comboBox = new javax.swing.JComboBox<>();
        botao_adicionar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_stock = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        agrupado_tabela = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        encomenda_table = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Id_produto para encomenda:");

        produto_comboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                produto_comboBoxActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Quantidade:");

        quantidade_comboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

        botao_adicionar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        botao_adicionar.setText("Adicionar");
        botao_adicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_adicionarActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("Acabar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("encomenda");

        jLabel1.setText("Produtos do Bar:");

        tabela_stock.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "nome", "id_produto", "quantidade"
            }
        ));
        jScrollPane1.setViewportView(tabela_stock);

        jLabel5.setText("Produtos para encomendar");

        agrupado_tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "nome", "contem x unidades"
            }
        ));
        jScrollPane2.setViewportView(agrupado_tabela);

        encomenda_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "quantidade", "data"
            }
        ));
        jScrollPane3.setViewportView(encomenda_table);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(produto_comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(quantidade_comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botao_adicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(379, 379, 379))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(produto_comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(quantidade_comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(121, 121, 121)
                        .addComponent(botao_adicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addContainerGap(111, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void produto_comboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_produto_comboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_produto_comboBoxActionPerformed

    private void botao_adicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_adicionarActionPerformed

        try{
            Connection con = ConnectionProvider.Connector();

            String id_produto_temp = produto_comboBox.getSelectedItem().toString();
            String qtd_temp = quantidade_comboBox.getSelectedItem().toString();
            int id_produto=Integer.parseInt(id_produto_temp);
            int qtd=Integer.parseInt(qtd_temp);
            int qtd_individual=0;
            int qtd_total=0;
           String query ="select qtd from converte where id_produto_agregado=?";
           PreparedStatement pst= con.prepareStatement(query);
           pst.setInt(1,id_produto);
           ResultSet rs=pst.executeQuery();
        
        
        
         qtd_individual=rs.getInt("qtd");
    
         qtd_total= qtd_individual * qtd;
         pst.close();
         rs.close();
         
         
         
           String query1 ="select id_produto_individual from converte where id_produto_agregado=?";
           PreparedStatement pst1= con.prepareStatement(query1);
           pst1.setInt(1,id_produto);
           ResultSet rs1=pst1.executeQuery();
            
             id_produto_inserir=rs1.getInt("id_produto_individual");
        
            
            pst1.close();
            rs1.close();
          
              String update ="UPDATE stock set qtd = qtd + ?  where  id_bar= ? and id_produto=? ";
                  PreparedStatement pst8= con.prepareStatement(update);
                  pst8.setInt(1,qtd_total);
                  pst8.setInt(2,id_bar);
                  pst8.setInt(3,id_produto_inserir);
                  pst8.executeUpdate();
                     pst8.close();
                     
                  String insert ="insert into info_stock (id_bar,id_produto,data,tempo,qtd) values(?, ?, date('now'),time('now'),?)";
                  PreparedStatement pst2= con.prepareStatement(insert);
                  pst2.setInt(1,id_bar);
                  pst2.setInt(2,id_produto);
                  pst2.setInt(3,qtd);
                  pst2.executeUpdate();
                  pst2.close();
                  
                  
                     DefaultTableModel dm1 = (DefaultTableModel)tabela_stock.getModel();
                  while(dm1.getRowCount() > 0)
                        {
                            dm1.removeRow(0);
                        }
                 mostrar_stock_enc( id_bar);
                 
                 DefaultTableModel dm2 = (DefaultTableModel)agrupado_tabela.getModel();
                  while(dm2.getRowCount() > 0)
                        {
                            dm2.removeRow(0);
                        }
                 mostrar_produto_agrupado();
                 
                 DefaultTableModel dm3 = (DefaultTableModel)encomenda_table.getModel();
                  while(dm3.getRowCount() > 0)
                        {
                            dm3.removeRow(0);
                        }
                  mostrar_encomena_basico(id_bar);
                 
          
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            
        }
    }//GEN-LAST:event_botao_adicionarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(encomendar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(encomendar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(encomendar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(encomendar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new encomendar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable agrupado_tabela;
    private javax.swing.JButton botao_adicionar;
    private javax.swing.JTable encomenda_table;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JComboBox<String> produto_comboBox;
    private javax.swing.JComboBox<String> quantidade_comboBox;
    private javax.swing.JTable tabela_stock;
    // End of variables declaration//GEN-END:variables
}
