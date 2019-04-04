
package quizapp;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author POOJA KUMARI
 */

public class ResultFrame extends javax.swing.JFrame {
//Instance variables
      //for connection
    Connection con;
    java.sql.Statement st;
    ResultSet rs;
    String regsId,name,fname,rollno,regsid,email,uni,dept,course,right,wrong,score,testCompleted,result;
    String remarks ="Best of Luck!";
    
    
    
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
    ////for fetching student data
    
     public void fetchData(String regsId) {
         
         this.regsId=regsId;
        try{
    st = con.createStatement();
     rs = st.executeQuery("SELECT * FROM STUDENTQUIZ WHERE REGS_ID = '"+regsId+"'");
     if(rs.next()){
         testCompleted = rs.getString("TESTCOMPLETED");
         name = rs.getString("NAME");
         fname= rs.getString("FNAME");
         email = rs.getString("EMAIL");
         dept = rs.getString("DEPT");
         uni = rs.getString("UNIVERSITY");
         rollno = rs.getString("ROLLNO");
         course = rs.getString("COURSE");
         right = rs.getString("RIGHT");
         wrong = rs.getString("WRONG");
         score = rs.getString("SCORE");
   //         System.out.println(name+"\n"+fname+"\n"+testCompleted+"\n"+right+"\n"+score+"\n"+regsId);
         if(Integer.parseInt(score)>=60){
             result="Pass";
             remarks="CONGRATULATION !";
         }else{result="Fail";}
                 
        } else{
            JOptionPane.showMessageDialog(null,"No such ID exist");
     }
        }catch(SQLException e){ System.out.println(e.getMessage());}
    }
     public void setData(){
     studentInfoArea.setText("NAME : "+"\t"+name+"\n"+"FATHER NAME : "+fname+"\n"+"UNIVERSITY : "+uni+"\n"+"DEPARTMENT : "+dept+"\n"+"ROLL NUMBER : "+rollno+"\n"+"EMAIL : "+"\t"+email);
     studentPerformanceArea.setText("REGISTRATION ID : "+regsId+"\n"+"COURSE : "+"\t"+course+"\n"+"RIGHT : "+"\t"+right+"\n"+"WRONG : "+"\t"+wrong+"\n"+"SCORE : "+"\t"+score+"\n"+"RESULT : "+"\t"+result+"\n"+"\t"+remarks);
     }
     //constructor
    public ResultFrame(String regsId) {
        initComponents();
        connect();
        fetchData(regsId);
        
        setData();
    }
 
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBox1 = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        studentInfoArea = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        studentPerformanceArea = new javax.swing.JTextArea();
        PrintPanel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        printBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();
        keyBtn = new javax.swing.JButton();

        jCheckBox1.setText("jCheckBox1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 4, true));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Wide Latin", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("RESULT CARD");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, 380, 46));

        jLabel2.setFont(new java.awt.Font("Wide Latin", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText(" STUDENT DETAIL");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 350, 40));

        jLabel3.setFont(new java.awt.Font("Wide Latin", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText(" PERFORMANCE");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 80, 330, 40));

        studentInfoArea.setEditable(false);
        studentInfoArea.setBackground(new java.awt.Color(204, 204, 255));
        studentInfoArea.setColumns(20);
        studentInfoArea.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        studentInfoArea.setRows(5);
        studentInfoArea.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray));
        jScrollPane1.setViewportView(studentInfoArea);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 390, 172));

        studentPerformanceArea.setEditable(false);
        studentPerformanceArea.setBackground(new java.awt.Color(204, 204, 255));
        studentPerformanceArea.setColumns(20);
        studentPerformanceArea.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        studentPerformanceArea.setRows(5);
        studentPerformanceArea.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray));
        jScrollPane2.setViewportView(studentPerformanceArea);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 130, 418, 170));

        PrintPanel.setBackground(new java.awt.Color(153, 153, 255));
        PrintPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 4, true));
        jPanel1.add(PrintPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 920, 310));

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 930, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 370, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 930, 370));

        printBtn.setBackground(new java.awt.Color(204, 204, 255));
        printBtn.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 18)); // NOI18N
        printBtn.setForeground(new java.awt.Color(255, 255, 255));
        printBtn.setText("PRINT");
        printBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printBtnActionPerformed(evt);
            }
        });
        jPanel1.add(printBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 450, 120, 40));

        backBtn.setBackground(new java.awt.Color(204, 204, 255));
        backBtn.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 18)); // NOI18N
        backBtn.setForeground(new java.awt.Color(255, 255, 255));
        backBtn.setText("Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });
        jPanel1.add(backBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 120, 40));

        keyBtn.setBackground(new java.awt.Color(204, 204, 255));
        keyBtn.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 18)); // NOI18N
        keyBtn.setForeground(new java.awt.Color(255, 255, 255));
        keyBtn.setText("RESULT");
        keyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keyBtnActionPerformed(evt);
            }
        });
        jPanel1.add(keyBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 450, 120, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setSize(new java.awt.Dimension(962, 545));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void printBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printBtnActionPerformed
   PrinterJob job = PrinterJob.getPrinterJob();
 job.setJobName("Printing");
 job.setPrintable(new Printable(){
     public int print(Graphics pg,PageFormat pf, int pageNum){
     if(pageNum>0){
        return Printable.NO_SUCH_PAGE;
     }
     Graphics2D g2 = (Graphics2D)pg;
     g2.translate(pf.getImageableX(), pf.getImageableY());
     g2.scale(0.24,0.24);
     
     PrintPanel.paint(g2);
     return Printable.PAGE_EXISTS;
     }

       
     
 });
 boolean ok = job.printDialog();
 if(ok){
   try{job.print();
   }catch(PrinterException ex){ ex.printStackTrace();}
 }
    }//GEN-LAST:event_printBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
this.setVisible(false);
new HomeFrame().setVisible(true);
    }//GEN-LAST:event_backBtnActionPerformed

    private void keyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keyBtnActionPerformed
 new KeyFrame(course).show();
    }//GEN-LAST:event_keyBtnActionPerformed

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
            java.util.logging.Logger.getLogger(ResultFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ResultFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ResultFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ResultFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ResultFrame("JAVA7").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel PrintPanel;
    private javax.swing.JButton backBtn;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton keyBtn;
    private javax.swing.JButton printBtn;
    private javax.swing.JTextArea studentInfoArea;
    private javax.swing.JTextArea studentPerformanceArea;
    // End of variables declaration//GEN-END:variables
}
