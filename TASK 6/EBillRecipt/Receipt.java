
package EBillRecipt;

import TransportApp.*;
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
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author POOJA KUMARI
 */
public class Receipt extends javax.swing.JFrame {

    //variables
    public static String cName, cId,noOfItems, totalBill, discountInPer, netBill;
    boolean insert=false;
     Connection con;
    Statement st;
    ResultSet rs;
    
    
   
//
    public void setValue() throws SQLException{
        st=con.createStatement();
   rs = st.executeQuery("SELECT * FROM EBILLRECIPT WHERE C_NAME = '"+cName+"'");
    while(rs.next()){
     netBill=rs.getString("NET_BILL");
     cId = rs.getString("C_ID");
       
    }
    
    cidfield.setText(cId);
   cnamefield.setText(cName);
   noofitemsfield.setText(noOfItems);
   totalbillfield.setText(totalBill);
   netbillfield.setText(netBill);
   discountfield.setText(discountInPer+" %");
   
    }
   
    public Receipt(String cName,String noOfItems,String totalBill, String discountInPer) throws SQLException {
        initComponents();
   this.cName = cName;
   this.noOfItems = noOfItems;
   this.totalBill = totalBill;
   this.discountInPer = discountInPer; 
   this.netBill = netBill;
   
   
   //connection to database
      try{
            
            Class.forName("oracle.jdbc.driver.OracleDriver");
            
 con=DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:XE","POOJA","null");
            if(con!=null){
            System.out.println("connection ");
            }
             st = con.createStatement();
        }catch(Exception e){
        e.printStackTrace();
        }
setValue();   
   
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        printPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        cidfield = new javax.swing.JLabel();
        cnamefield = new javax.swing.JLabel();
        noofitemsfield = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        totalbillfield = new javax.swing.JLabel();
        discountfield = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        netbillfield = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 121, 107));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(77, 182, 172));
        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Print");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 550, -1, -1));

        printPanel.setBackground(new java.awt.Color(0, 121, 107));
        printPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Wide Latin", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("RECIPT");
        printPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, 310, 72));

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("TOTAL BILL           :");
        printPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 300, 180, 34));

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("CUSTOMER ID        :");
        printPanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, 180, 34));

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("CUSTOMER NAME  :");
        printPanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, 190, 34));

        jLabel7.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("DISCOUNT IN %     :");
        printPanel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 340, -1, 34));

        jLabel8.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("NO OF ITEM           :");
        printPanel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, 170, 34));

        jLabel9.setFont(new java.awt.Font("Segoe Script", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Signature :");
        printPanel.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 460, 160, 34));

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        printPanel.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 92, 290, 20));

        cidfield.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        cidfield.setForeground(new java.awt.Color(255, 255, 255));
        printPanel.add(cidfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 190, 320, 34));

        cnamefield.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        cnamefield.setForeground(new java.awt.Color(255, 255, 255));
        printPanel.add(cnamefield, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 230, 320, 34));

        noofitemsfield.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        noofitemsfield.setForeground(new java.awt.Color(255, 255, 255));
        printPanel.add(noofitemsfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 270, 300, 34));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        printPanel.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 280, 320, 34));

        totalbillfield.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        totalbillfield.setForeground(new java.awt.Color(255, 255, 255));
        printPanel.add(totalbillfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 300, 300, 34));

        discountfield.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        discountfield.setForeground(new java.awt.Color(255, 255, 255));
        printPanel.add(discountfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 350, 280, 34));

        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        printPanel.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 480, 170, 20));

        jLabel16.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("NET BILL               :");
        printPanel.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 380, 180, 34));

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        printPanel.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 420, 280, 34));

        netbillfield.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        netbillfield.setForeground(new java.awt.Color(255, 255, 255));
        printPanel.add(netbillfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 380, 290, 34));

        jLabel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(77, 182, 172), 3, true));
        printPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 590, 300));

        jPanel1.add(printPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 770, 510));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 630));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
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
     
     printPanel.paint(g2);
     return Printable.PAGE_EXISTS;
     }

       
     
 });
 boolean ok = job.printDialog();
 if(ok){
   try{job.print();
   }catch(PrinterException ex){ ex.printStackTrace();}
 }
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
            java.util.logging.Logger.getLogger(Receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cidfield;
    private javax.swing.JLabel cnamefield;
    private javax.swing.JLabel discountfield;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel netbillfield;
    private javax.swing.JLabel noofitemsfield;
    private javax.swing.JPanel printPanel;
    private javax.swing.JLabel totalbillfield;
    // End of variables declaration//GEN-END:variables
}