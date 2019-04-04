
package FeeManagement;

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
public class searchFrame extends javax.swing.JFrame {
String rollno,name,fname,doa,lastpaid,monthly,dues,course;
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
    
    ///retrive data
    void showData(){
      try {
            st= con.createStatement();
              rs = st.executeQuery("SELECT * FROM FEEMANAGEMENT WHERE ROLL_NO='"+rollno+"' "   ) ;
              if(rs.next()){
              name = rs.getString("NAME");
              fname = rs.getString("FNAME");
              doa = rs.getString("DOA");
              lastpaid = rs.getString("LAST_PAID");
              monthly = rs.getString("MONTHLY");
              dues = rs.getString("DUES");
              course = rs.getString("COURSE");
               infoArea.setText("NAME : "+"\t"+name+"\n"+"FATHER NAME : "+"\t"+fname+"\n"+"ROLL NO : "+"\t"+rollno+"\n"+"DATE OF ADMISSION : "+"\t"+doa+"\n"+"LAST FEE PAID: "+"\t"+lastpaid+
                       "\n"+"MONTHLY FEE : "+"\t"+monthly+"\n"+"DUES : "+"\t"+dues+"\n"+"COURSE : "+"\t"+course);
              }else{JOptionPane.showMessageDialog(null,"Data doesnot exist");}
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public searchFrame(String rollno) {
        initComponents();
        connect();
        this.rollno= rollno;
        System.out.println("rolln0---------------"+rollno);
        rollnoLabel.setText("DATA OF STUDENT WITH ROLL # : "+rollno);
        showData();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        rollnoLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        infoArea = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(242, 242, 242));
        jPanel1.setLayout(null);

        rollnoLabel.setFont(new java.awt.Font("Stencil", 1, 18)); // NOI18N
        rollnoLabel.setForeground(new java.awt.Color(0, 153, 255));
        rollnoLabel.setText("DATA OF");
        jPanel1.add(rollnoLabel);
        rollnoLabel.setBounds(30, 50, 480, 70);

        infoArea.setEditable(false);
        infoArea.setBackground(new java.awt.Color(0, 153, 255));
        infoArea.setColumns(20);
        infoArea.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        infoArea.setForeground(new java.awt.Color(255, 255, 255));
        infoArea.setRows(5);
        jScrollPane1.setViewportView(infoArea);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(50, 200, 510, 380);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FeeManagement/blue.jpg"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(220, 0, 626, 620);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 849, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(862, 651));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    public static void main(String args[]) {
    
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new searchFrame("JAVA2K18-13").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea infoArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel rollnoLabel;
    // End of variables declaration//GEN-END:variables
}
