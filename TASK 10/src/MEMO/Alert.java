
package MEMO;

/**
 *
 * @author Pooja Kumari
 */
  

import java.awt.Color;
import java.awt.Frame;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;


public class Alert extends javax.swing.JFrame {
    public static Alert v;
    alertPanel m1;
    String fetchId;
    int r=205;
    int g=80;
    int b =50;
    
 //for connection
    Connection con;
    Statement st;
    ResultSet rs;
 ///connection to DB
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
      ////fetch all data
   public  void fetch(String q){
 try{
     System.out.println("******************fetch is called******************");
     System.out.println("******************"+q+"******************");
     st = con.createStatement();
  rs = st.executeQuery(q);

    int i=0;
  if(rs.next()){  
   System.out.println(++i);
      m1 = new alertPanel();
m1.memoText.setBackground(new Color(r,g,b));
m1.headPanel.setBackground(new Color(r,g,b));
m1.setBackground(new Color(r,g,b));
alertPanel.add(m1);
m1.setVisible(true);

m1.revalidate();
m1.repaint();
r-=5;
g+=10;
b+=50;
while(r<=5 || g>=250 || b>=250){
  //  System.out.println("red "+r+"  b "+b+"  g  "+g);
     if(r<=5) r=205;
     if(g>=250) g=80;
     if(b>=250) b=50;
    
}
      
      m1.titleField.setText(rs.getString("TITLE"));
    m1.todoDate.setDate(rs.getDate("TODODATE"));
   m1.todoTime.setTime(rs.getTime("TODOTIME"));
    m1.memoText.setText(rs.getString("DESCR"));
    fetchId = rs.getString("ID");
  m1.jPanel1.setName(fetchId);
  m1.setName(fetchId);
  }
//}//else JOptionPane.showMessageDialog(null, "Data does not exist");
  
 }catch(SQLException ex){
 System.out.println(ex.getMessage());
 }
    
    }
   
   public void invisible(){
   this.setVisible(false);
   }
   
    public Alert(String query) throws FileNotFoundException, IOException {
        initComponents();
        connect();
        fetch(query);
        
       
                
InputStream music =  new FileInputStream(new File("C:\\Users\\Vijay\\Documents\\NetBeansProjects\\JavaApp\\src\\MEMO\\to-the-point.wav"));
    AudioStream audio = new AudioStream(music);
    AudioPlayer.player.start(audio);
    
        setState(Frame.ICONIFIED);



    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        alertPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        alertPanel.setLayout(new javax.swing.BoxLayout(alertPanel, javax.swing.BoxLayout.LINE_AXIS));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(alertPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(alertPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(772, 285));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Alert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Alert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Alert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Alert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
//                try {
//                    new Alert("SELECT * FROM TASKLIST WHERE ID='346' ").setVisible(true);
//                } catch (IOException ex) {
//                    Logger.getLogger(Alert.class.getName()).log(Level.SEVERE, null, ex);
//                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel alertPanel;
    // End of variables declaration//GEN-END:variables
}
