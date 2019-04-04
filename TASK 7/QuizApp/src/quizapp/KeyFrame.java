
package quizapp;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.JTableHeader;
import net.proteanit.sql.DbUtils;


public class KeyFrame extends javax.swing.JFrame {

   String course;
   String qno ,ques,ans;
    Connection con;
    Statement st;
    ResultSet rs;
    
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
    
     void refreshTable(){
     try {
        st= con.createStatement();
       rs = st.executeQuery("SELECT QNO , QUES , ANS FROM "+course+"QUIZ ORDER BY QNO ASC");
      while(rs.next()){
          qno = rs.getString("QNO");
          ques = rs.getString("QUES");
          ans = rs.getString("ANS");
          
       keyArea.append("QNO "+qno+":"+"\t"+ques+"\n"+"ANS:"+"\t"+ans+"\n");
     }
     }catch(Exception ex){
         JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    public KeyFrame(String course) {
        initComponents();
         connect();
        this.course = course;
        courseKayLabel.setText("ANS KEY FOR "+course);
        refreshTable();
       
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        courseKayLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        keyArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        courseKayLabel.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        courseKayLabel.setForeground(new java.awt.Color(255, 255, 255));
        courseKayLabel.setText("ANS KEY");
        jPanel1.add(courseKayLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, 580, 64));

        keyArea.setEditable(false);
        keyArea.setColumns(20);
        keyArea.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        keyArea.setRows(5);
        jScrollPane1.setViewportView(keyArea);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 900, 420));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1046, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1062, 619));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel courseKayLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea keyArea;
    // End of variables declaration//GEN-END:variables
}
