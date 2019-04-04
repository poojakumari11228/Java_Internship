
package FeeManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author POOJA KUMARI
 */
public class Add extends javax.swing.JFrame {

 ///INSTANCE VARIABLE
    String name, fname, doa, lastfeepaid, monthlyfee, dues, rollno, course,subYear;
//for connection
    Connection con;
  Statement st;
    ResultSet rs;
    
      //CONNECTION TO DB
    public void connect(){
   
       try{ 
        Class.forName("oracle.jdbc.driver.OracleDriver");
        con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","POOJA","null");
        if(con!=null)
        System.out.println("Connection successful");
        else System.out.println("Connection failed");
        
       }catch(ClassNotFoundException | SQLException e){
       System.out.println(e.getMessage());
       }
    }

    //inserting data
    public void insertData(){
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
        doa = sdf.format(dateChooser.getDate());
         
        name = nameField.getText();
      fname = fnameField.getText();
      lastfeepaid  =  lastfeeField.getText();
      monthlyfee = monthlyField.getText();
      dues = duesField.getText();
      //rollno = rollnoField.getText(); 
      course =  courseCombo.getSelectedItem().toString();
       subYear = (String) courseCombo.getSelectedItem()+"-";
      System.out.println(name+"\n"+fname+"\n"+doa+"\n"+lastfeepaid+"\n"+monthlyfee+"\n"+"course===="+course+"=====");
      
     try{   st = con.createStatement();
     int result = st.executeUpdate("INSERT INTO FEEMANAGEMENT(NAME,FNAME,DOA,LAST_PAID,MONTHLY,DUES,COURSE,ROLL_NO)VALUES('"+name+"','"+fname+"','"+doa+"','"+lastfeepaid+"','"+monthlyfee+"','"+dues+"','"+course+" ' ,CONCAT('"+subYear+"',STUDENT_SEQUENCE.NEXTVAL) )");
  if(result==1){
  JOptionPane.showMessageDialog(null, "DATA INSERTED");
  }else
  JOptionPane.showMessageDialog(null, "DATA NOT INSERTED");
     }catch(SQLException e){
       System.out.println(e.getMessage());
       }
     
    
    }
/////Validate if emp data already exist or not
    void validateIns() {
    String name = nameField.getText();
    String fname = fnameField.getText();
    String course = courseCombo.getSelectedItem().toString();
    System.out.println("--------------------------------------------"+name+" "+fname+" "+course);
        try{
    Statement stm = con.createStatement();
    rs = stm.executeQuery("SELECT name, fname, course FROM FEEMANAGEMENT WHERE  NAME = '"+name+"' AND FNAME='"+fname+"' AND COURSE LIKE  '%"+course+"%' ");
   
    if(rs.next()){
          System.out.println("if");
        JOptionPane.showMessageDialog(null,"Data of "+nameField.getText()+" already exist.");

    }else{
        System.out.println("else");
        ////if validate thn insert is called
    insertData();
       
       
    }
    } catch (SQLException ex) {
       System.out.println(ex.getMessage());
    }
}
   
    public Add() {
        initComponents();
        connect();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        fnameField = new javax.swing.JTextField();
        lastfeeField = new javax.swing.JTextField();
        monthlyField = new javax.swing.JTextField();
        duesField = new javax.swing.JTextField();
        backBtn = new javax.swing.JButton();
        dateChooser = new com.toedter.calendar.JDateChooser();
        courseCombo = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        addBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(242, 242, 242));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 255));
        jLabel4.setText("NAME                               :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 270, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 255));
        jLabel3.setText("FATHER NAME             :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 270, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 255));
        jLabel5.setText("LAST FEE PAID             :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, 270, -1));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 255));
        jLabel6.setText("MONTHLY FEE             :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 320, 270, -1));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 153, 255));
        jLabel8.setText("DUES                                :");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 360, 270, -1));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 153, 255));
        jLabel9.setText("DATE OF ADMISSSION:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, 270, -1));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 153, 255));
        jLabel10.setText("COURSE                          :");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 400, 270, -1));

        nameField.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jPanel1.add(nameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 160, 210, -1));

        fnameField.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jPanel1.add(fnameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 200, 210, -1));

        lastfeeField.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jPanel1.add(lastfeeField, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 280, 210, -1));

        monthlyField.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jPanel1.add(monthlyField, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 320, 210, -1));

        duesField.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jPanel1.add(duesField, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 360, 210, -1));

        backBtn.setBackground(new java.awt.Color(255, 255, 255));
        backBtn.setFont(new java.awt.Font("Snap ITC", 1, 18)); // NOI18N
        backBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FeeManagement/icons8-back-48.png"))); // NOI18N
        backBtn.setText("BACK");
        backBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        backBtn.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        backBtn.setIconTextGap(15);
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });
        jPanel1.add(backBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 490, 170, 60));

        dateChooser.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jPanel1.add(dateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 240, 210, 30));

        courseCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "JAVA2K18", "ANDROID2K18", "JAVASCRIPT2K18", "PHP2K18", "PYTHON2K18" }));
        jPanel1.add(courseCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 400, 210, 30));

        jLabel7.setFont(new java.awt.Font("Wide Latin", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 153, 255));
        jLabel7.setText("STUDENT FORM");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 380, 80));

        addBtn.setBackground(new java.awt.Color(255, 255, 255));
        addBtn.setFont(new java.awt.Font("Snap ITC", 1, 18)); // NOI18N
        addBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FeeManagement/icons8-plus-48 (2).png"))); // NOI18N
        addBtn.setText("ADD");
        addBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        addBtn.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        addBtn.setIconTextGap(25);
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });
        jPanel1.add(addBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 490, 160, 60));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FeeManagement/blue.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, 630, 630));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setSize(new java.awt.Dimension(904, 669));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
this.setVisible(false);
new HomeFrame().setVisible(true);
    }//GEN-LAST:event_backBtnActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
if(nameField.getText().equals("") || fnameField.getText().equals("") ||  dateChooser.getDate().equals("") || lastfeeField.getText().equals("") || monthlyField.getText().equals("") || duesField.getText().equals("") ) {
  JOptionPane.showMessageDialog(null,"Please enter the required fields");
}else{
    validateIns();
}
    }//GEN-LAST:event_addBtnActionPerformed

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
            java.util.logging.Logger.getLogger(Add.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Add.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Add.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Add.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Add().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JButton backBtn;
    private javax.swing.JComboBox<String> courseCombo;
    private com.toedter.calendar.JDateChooser dateChooser;
    private javax.swing.JTextField duesField;
    private javax.swing.JTextField fnameField;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField lastfeeField;
    private javax.swing.JTextField monthlyField;
    private javax.swing.JTextField nameField;
    // End of variables declaration//GEN-END:variables
}
