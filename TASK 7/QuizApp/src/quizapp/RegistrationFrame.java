
package quizapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author POOJA KUMARI
 */


public class RegistrationFrame extends javax.swing.JFrame {

  //Instance variables
      //for connection
    Connection con;
    java.sql.Statement st;
    int rs;
 
    //for data
    String name,fname,email,uni,dept,rollno,course,regid;
    //for validation
    boolean insert = true; 
    boolean validEmail=false;
    
    //Auto generating students registration id
    public void generateId() throws SQLException{
     ResultSet result = st.executeQuery("select REGS_ID from STUDENTQUIZ where NAME='"+name+"' AND COURSE ='"+course+"' AND ROLLNO='"+rollno+"' and DEPT ='"+dept+"' ");
              while(result.next()){
                  regid = result.getString("REGS_ID");
              }
            JOptionPane.showMessageDialog(null,name +" You are registered with the registration id of "+regid); 
            this.setVisible(false);
            new  HomeFrame().setVisible(true);
    }
    
    //ckecking if student have already registered or not
    public void validateRegs() throws SQLException{
    ResultSet result = st.executeQuery("select REGS_ID from STUDENTQUIZ where NAME='"+name+"' AND FNAME ='"+fname+"' AND COURSE ='"+course+"' AND ROLLNO='"+rollno+"' and DEPT ='"+dept+"'  AND EMAIL ='"+email+"' ");
        if(result.next()){
              insert = false;
              JOptionPane.showMessageDialog(null, "You are already registered");
        }else insert=true;    
    }
    
    //inserting data
    public void insertData(){
          name = nameField.getText();
      fname = fnameField.getText();
      email = emailField.getText();
      uni  =  uniField.getText();
      dept = deptField.getText();
      rollno = rollnoField.getText();
      course = (String) courseCombo.getSelectedItem();
      //System.out.println(name+"\n"+fname+"\n"+email+"\n"+uni+"\n"+dept+"\n"+rollno+"\n"+course);
      
     try{   st = con.createStatement();
     validateRegs();
     if(insert){  //checking if the requesting student is already registered or not
           
     if(course.equalsIgnoreCase("java")){
     rs = st.executeUpdate("INSERT INTO STUDENTQUIZ(REGS_ID,NAME,FNAME,EMAIL,UNIVERSITY,DEPT,ROLLNO,COURSE)VALUES(CONCAT('"+course+"',STUDENTJAVA_SEQUENCE.NEXTVAL),'"+name+"','"+fname+"','"+email+"','"+uni+"','"+dept+"','"+rollno+"','"+course+"')");
     }
     else{
     rs = st.executeUpdate("INSERT INTO STUDENTQUIZ(REGS_ID,NAME,FNAME,EMAIL,UNIVERSITY,DEPT,ROLLNO,COURSE)VALUES(CONCAT('"+course+"',STUDENTANDROID_SEQUENCE.NEXTVAL),'"+name+"','"+fname+"','"+email+"','"+uni+"','"+dept+"','"+rollno+"','"+course+"')");
        }
     if(rs==1){ //auto generating id
             generateId();
            }
     }
     }catch(SQLException e){
       System.out.println(e.getMessage());
       }
     
    
    }
    
  
    
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
    
///////// set fields to initial condition
    void emptyFields(){
        nameField.setText("");
    fnameField.setText("");
    emailField.setText("");    
     uniField.setText("");  
     deptField.setText("");
     rollnoField.setText("");
    }
///////////validate email field
void validateEmail(String email){
if(email.endsWith(".com") && email.contains("@")  ){
    
    if(email.indexOf("@")!=email.lastIndexOf("@")){
    System.out.println("invalid email have mpre than 1 @");
     }
    else{ 
      validEmail=true;
    }
}
     
    
}    
    //CONSTRUCTOR
    public RegistrationFrame() {
        initComponents();
        
        connect();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        fnameField = new javax.swing.JTextField();
        emailField = new javax.swing.JTextField();
        uniField = new javax.swing.JTextField();
        deptField = new javax.swing.JTextField();
        rollnoField = new javax.swing.JTextField();
        courseCombo = new javax.swing.JComboBox<>();
        submitBtn = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("REGISTRATION");

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("STUDENT NAME       :");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 178, -1, 48));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("FATHER NAME         :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 244, -1, 48));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("EMAIL                         :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 310, 240, 48));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("UNIVERSITY              :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 376, 240, 48));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("ROLL NUMBER        :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 512, 240, 48));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("DEPARTMENT          :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 444, 240, 48));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("COURSE                     :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 580, 240, 48));

        nameField.setBackground(new java.awt.Color(204, 204, 255));
        nameField.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jPanel1.add(nameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(353, 178, 320, 48));

        fnameField.setBackground(new java.awt.Color(204, 204, 255));
        fnameField.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jPanel1.add(fnameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(353, 244, 320, 48));

        emailField.setBackground(new java.awt.Color(204, 204, 255));
        emailField.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jPanel1.add(emailField, new org.netbeans.lib.awtextra.AbsoluteConstraints(353, 310, 320, 48));

        uniField.setBackground(new java.awt.Color(204, 204, 255));
        uniField.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jPanel1.add(uniField, new org.netbeans.lib.awtextra.AbsoluteConstraints(353, 378, 320, 48));

        deptField.setBackground(new java.awt.Color(204, 204, 255));
        deptField.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jPanel1.add(deptField, new org.netbeans.lib.awtextra.AbsoluteConstraints(353, 446, 320, 48));

        rollnoField.setBackground(new java.awt.Color(204, 204, 255));
        rollnoField.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jPanel1.add(rollnoField, new org.netbeans.lib.awtextra.AbsoluteConstraints(353, 514, 320, 48));

        courseCombo.setBackground(new java.awt.Color(204, 204, 255));
        courseCombo.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        courseCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "JAVA", "ANDROID" }));
        jPanel1.add(courseCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(353, 580, 320, 48));

        submitBtn.setBackground(new java.awt.Color(204, 204, 255));
        submitBtn.setFont(new java.awt.Font("Stencil", 0, 18)); // NOI18N
        submitBtn.setText("SUBMIT");
        submitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitBtnActionPerformed(evt);
            }
        });
        jPanel1.add(submitBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(558, 647, 115, 46));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setText("Already registered ?");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(353, 646, 176, 46));

        jLabel9.setFont(new java.awt.Font("Stencil", 1, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("REGISTRATION FORM");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 82, 425, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(957, 757));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void submitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitBtnActionPerformed

        
//Validate insertion
if(nameField.getText().equals("") || fnameField.getText().equals("") || emailField.getText().equals("") || 
              uniField.getText().equals("") || deptField.getText().equals("") || rollnoField.getText().equals(""))
           JOptionPane.showMessageDialog(null,"Please enter the required data");
      else {
    validateEmail(emailField.getText());
   if(validEmail)    ///////email valodation
   {insertData();
   emptyFields();
} else  
       JOptionPane.showMessageDialog(null,"Invalid email");
}

    }//GEN-LAST:event_submitBtnActionPerformed

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
this.setVisible(false);
new HomeFrame().setVisible(true);
    }//GEN-LAST:event_jLabel8MouseClicked

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
            java.util.logging.Logger.getLogger(RegistrationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrationFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> courseCombo;
    private javax.swing.JTextField deptField;
    private javax.swing.JTextField emailField;
    private javax.swing.JTextField fnameField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nameField;
    private javax.swing.JTextField rollnoField;
    private javax.swing.JButton submitBtn;
    private javax.swing.JTextField uniField;
    // End of variables declaration//GEN-END:variables
}
