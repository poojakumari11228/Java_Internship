/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobileinventory;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author POOJA KUMARI
 */
public class mobInventoryFrame extends javax.swing.JFrame {

    /**
     * Creates new form mobInventoryFrame
     */
    public Connection con;
    public Statement st;
    public ResultSet rs;
    String searchData;
    JFrame srf ;  
    //Function for searching 
     void search(String searchData){ //    SEARCH FOR data by serial no
               

                      
 try{
         rs = st.executeQuery("SELECT * FROM MOBILEINVENTORY WHERE MODEL = upper('"+searchData+"') OR MODEL = lower('"+searchData+"') ");
   if(searchData.equalsIgnoreCase("GALAXY S9")){
       JOptionPane.showMessageDialog(null,"FOUND");
    GalaxyS9 s9 = new GalaxyS9();
   srf = new JFrame();
   srf.setLocationRelativeTo ( null );
   srf.setBounds(0,0,1468,873);
   srf.add(s9);
    srf.setVisible(true);
    
   }else if(searchData.equalsIgnoreCase("GALAXY ON7 PRIME")){
      JOptionPane.showMessageDialog(null,"FOUND");
        On7Prime on7 = new On7Prime();
      srf = new JFrame();
   srf.setLocationRelativeTo ( null );
   srf.setBounds(0,0,1468,873);
   srf.add(on7);
    srf.setVisible(true);
   }else if(searchData.equalsIgnoreCase("GALAXY NOTE 8")){
      JOptionPane.showMessageDialog(null,"FOUND");
         GalaxyNote8 note8 = new GalaxyNote8();
      srf = new JFrame();
   srf.setLocationRelativeTo ( null );
   srf.setBounds(0,0,1468,873);
   srf.add(note8);
    srf.setVisible(true);
   }else if(searchData.equalsIgnoreCase("GALAXY S6 Edge+")){
       JOptionPane.showMessageDialog(null,"FOUND");
      GalaxyS6Edge EdgeP = new GalaxyS6Edge();
     srf = new JFrame();
   srf.setLocationRelativeTo ( null );
   srf.setBounds(0,0,1468,873);
   srf.add(EdgeP);
    srf.setVisible(true);
   }else if(searchData.equalsIgnoreCase("iPhone X")){
       
JOptionPane.showMessageDialog(null,"FOUND");
   iPhoneX ix = new iPhoneX();
     srf = new JFrame();
   srf.setLocationRelativeTo ( null );
   srf.setBounds(0,0,1468,873);
   srf.add(ix);
    srf.setVisible(true);
   }else if(searchData.equalsIgnoreCase("iPhone 8 Plus")){
       JOptionPane.showMessageDialog(null,"FOUND");
 iPhone8P i8p = new iPhone8P();
      i8p.setName("iPhone 8 Plus");
      HomeTabbedPane.add(i8p);
   }else if(searchData.equalsIgnoreCase("iPhone SE")){
       JOptionPane.showMessageDialog(null,"FOUND");
   iPhoneSE ise = new iPhoneSE();
      srf = new JFrame();
   srf.setLocationRelativeTo ( null );
   srf.setBounds(0,0,1468,873);
   srf.add(ise);
    srf.setVisible(true);
   }else if(searchData.equalsIgnoreCase("iPhone 6s Plus")){
       JOptionPane.showMessageDialog(null,"FOUND");
iPhone6S i6s = new iPhone6S();
     srf = new JFrame();
   srf.setLocationRelativeTo ( null );
   srf.setBounds(0,0,1468,873);
   srf.add(i6s);
    srf.setVisible(true);
   }else if(searchData.equalsIgnoreCase("Honor 10")){
       JOptionPane.showMessageDialog(null,"FOUND");
 honor10 h10 = new honor10();
    srf = new JFrame();
   srf.setLocationRelativeTo ( null );
   srf.setBounds(0,0,1468,873);
   srf.add(h10);
    srf.setVisible(true);  }
   else if(searchData.equalsIgnoreCase("Honor 8")){
       JOptionPane.showMessageDialog(null,"FOUND");
 honor8 h8 = new honor8();
    srf = new JFrame();
   srf.setLocationRelativeTo ( null );
   srf.setBounds(0,0,1468,873);
   srf.add(h8);
    srf.setVisible(true); 
   }else if(searchData.equalsIgnoreCase("Google Nexus 6P")){
       JOptionPane.showMessageDialog(null,"FOUND");
GoogleNexus6P gn6p = new GoogleNexus6P();
      srf = new JFrame();
   srf.setLocationRelativeTo ( null );
   srf.setBounds(0,0,1468,873);
   srf.add(gn6p);
    srf.setVisible(true);  
   }else if(searchData.equalsIgnoreCase("P9")){
       JOptionPane.showMessageDialog(null,"FOUND");
 huaweiP9 p9  = new huaweiP9();
    srf = new JFrame();
   srf.setLocationRelativeTo ( null );
   srf.setBounds(0,0,1468,873);
   srf.add(p9);
    srf.setVisible(true);
   JOptionPane.showMessageDialog(null,"NOT FOUND");}
      
}catch(Exception e){
       JOptionPane.showMessageDialog(null,  e);
        }
     }
    
    public mobInventoryFrame() {
        initComponents();
            //connection to database
              try{
            
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","Computershop","null");
             if(con!=null){
            System.out.println("connection success ");
            }
        st = con.createStatement();
        }catch(Exception e){
        e.printStackTrace();   
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

        HomeTabbedPane = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        samsungBtn = new javax.swing.JButton();
        iPhoneBtn = new javax.swing.JButton();
        huaweiBtn = new javax.swing.JButton();
        nokiaBtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        SearchTextField = new javax.swing.JTextField();
        SearchBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1389, 757));

        jPanel1.setBackground(new java.awt.Color(183, 115, 247));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        samsungBtn.setBackground(new java.awt.Color(183, 115, 247));
        samsungBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mobileinventory/SmSuNg.png"))); // NOI18N
        samsungBtn.setAutoscrolls(true);
        samsungBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        samsungBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                samsungBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                samsungBtnMouseExited(evt);
            }
        });
        samsungBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                samsungBtnActionPerformed(evt);
            }
        });
        jPanel1.add(samsungBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 410, 360));

        iPhoneBtn.setBackground(new java.awt.Color(183, 115, 247));
        iPhoneBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mobileinventory/ios.png"))); // NOI18N
        iPhoneBtn.setAutoscrolls(true);
        iPhoneBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        iPhoneBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                iPhoneBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                iPhoneBtnMouseExited(evt);
            }
        });
        iPhoneBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iPhoneBtnActionPerformed(evt);
            }
        });
        jPanel1.add(iPhoneBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, 430, 360));

        huaweiBtn.setBackground(new java.awt.Color(183, 115, 247));
        huaweiBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mobileinventory/-huawei.png"))); // NOI18N
        huaweiBtn.setAutoscrolls(true);
        huaweiBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        huaweiBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                huaweiBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                huaweiBtnMouseExited(evt);
            }
        });
        huaweiBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                huaweiBtnActionPerformed(evt);
            }
        });
        jPanel1.add(huaweiBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 860, 360));

        nokiaBtn.setBackground(new java.awt.Color(183, 115, 247));
        nokiaBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mobileinventory/ios.png"))); // NOI18N
        nokiaBtn.setAutoscrolls(true);
        nokiaBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        nokiaBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nokiaBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                nokiaBtnMouseExited(evt);
            }
        });
        nokiaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nokiaBtnActionPerformed(evt);
            }
        });
        jPanel1.add(nokiaBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 410, 280, 300));

        HomeTabbedPane.addTab("HOME", jPanel1);

        jPanel2.setBackground(new java.awt.Color(183, 115, 247));

        SearchTextField.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        SearchTextField.setForeground(new java.awt.Color(204, 0, 204));
        SearchTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchTextFieldActionPerformed(evt);
            }
        });

        SearchBtn.setBackground(new java.awt.Color(225, 190, 231));
        SearchBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mobileinventory/searchnew.png"))); // NOI18N
        SearchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(SearchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 679, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(SearchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(212, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SearchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(593, Short.MAX_VALUE))
        );

        HomeTabbedPane.addTab("SEARCH", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(HomeTabbedPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(HomeTabbedPane)
        );

        setSize(new java.awt.Dimension(1095, 836));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void samsungBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_samsungBtnActionPerformed
        // TODO add your handling code here:
       
        this.setVisible(false);
        samsung sm = new samsung();
        sm.setVisible(true);
    }//GEN-LAST:event_samsungBtnActionPerformed

    private void samsungBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_samsungBtnMouseEntered
 samsungBtn.setBackground(new Color(225,190,231));        // TODO add your handling code here:
    }//GEN-LAST:event_samsungBtnMouseEntered

    private void samsungBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_samsungBtnMouseExited
samsungBtn.setBackground(new Color(183,115,247));        // TODO add your handling code here:
    }//GEN-LAST:event_samsungBtnMouseExited

    private void iPhoneBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iPhoneBtnMouseEntered
        // TODO add your handling code here:
        iPhoneBtn.setBackground(new Color(225,190,231));

    }//GEN-LAST:event_iPhoneBtnMouseEntered

    private void iPhoneBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iPhoneBtnMouseExited
        // TODO add your handling code here:
        iPhoneBtn.setBackground(new Color(183,115,247));        // TODO add your handling code here:

    }//GEN-LAST:event_iPhoneBtnMouseExited

    private void iPhoneBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iPhoneBtnActionPerformed
        // TODO add your handling code here:
               
        this.setVisible(false);
        iPhone ip = new iPhone();
        ip.setVisible(true);

    }//GEN-LAST:event_iPhoneBtnActionPerformed

    private void huaweiBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_huaweiBtnMouseEntered
        huaweiBtn.setBackground(new Color(225,190,231));        // TODO add your handling code here:
        huaweiBtn.setBackground(new Color(183,115,247));    // TODO add your handling code here:
    }//GEN-LAST:event_huaweiBtnMouseEntered

    private void huaweiBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_huaweiBtnMouseExited
        // TODO add your handling code here:
        huaweiBtn.setBackground(new Color(183,115,247));        // TODO add your handling code here:

    }//GEN-LAST:event_huaweiBtnMouseExited

    private void huaweiBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_huaweiBtnActionPerformed
        // TODO add your handling code here:
           this.setVisible(false);
        huawei hu =  new huawei();
        hu.setVisible(true);
    }//GEN-LAST:event_huaweiBtnActionPerformed

    private void SearchTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchTextFieldActionPerformed

    private void SearchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchBtnActionPerformed
        // TODO add your handling code here:
        
         searchData = SearchTextField.getText().toString();
         search(searchData);
         
       SearchTextField.setText("");
        searchData ="";
     

    }//GEN-LAST:event_SearchBtnActionPerformed

    private void nokiaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nokiaBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nokiaBtnActionPerformed

    private void nokiaBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nokiaBtnMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_nokiaBtnMouseExited

    private void nokiaBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nokiaBtnMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_nokiaBtnMouseEntered

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
            java.util.logging.Logger.getLogger(mobInventoryFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mobInventoryFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mobInventoryFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mobInventoryFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mobInventoryFrame().setVisible(true);
             
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane HomeTabbedPane;
    private javax.swing.JButton SearchBtn;
    private javax.swing.JTextField SearchTextField;
    private javax.swing.JButton huaweiBtn;
    private javax.swing.JButton iPhoneBtn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton nokiaBtn;
    private javax.swing.JButton samsungBtn;
    // End of variables declaration//GEN-END:variables
}
