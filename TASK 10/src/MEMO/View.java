package MEMO;

import java.awt.Color;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public final class View extends javax.swing.JFrame {

    int r=205;
    int g=80;
    int b =50;
    String todo,date,time,title,fetchId,search;
    String query = "select * from TASKLIST ORDER BY ID ASC ";
    viewMemoPanel m1;
    
        //for connection
    Connection con;
    Statement st;
    ResultSet rs;
    
   
 
    ////fetch all data
   public  void fetchAll(String q){
 try{
  //   System.out.println("******************fetch is called******************");
    // System.out.println("******************"+q+"******************");
     st = con.createStatement();
  rs = st.executeQuery(q);
//if(rs.next()){
   // System.out.println("******************inside if******************");
    
    //int i=0;
  while(rs.next()){  
  // System.out.println(++i);
      m1 = new viewMemoPanel();
m1.memoText.setBackground(new Color(r,g,b));
m1.headPanel.setBackground(new Color(r,g,b));
m1.editBtn.setBackground(new Color(r,g,b));
m1.dltBtn.setBackground(new Color(r,g,b));
m1.setBackground(new Color(r,g,b));
backPanel.add(m1);
m1.setVisible(true);

m1.revalidate();
m1.repaint();
r-=5;
g+=10;
b+=50;
if(r<=5 || g>=250 || b>=250){
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
    public View() {
        initComponents();
             connect();

        fetchAll(query);        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton4 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        searchField = new javax.swing.JTextField();
        backBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        backPanel = new javax.swing.JPanel();

        jButton4.setText("jButton4");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 0, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        searchField.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        searchField.setText("SEARCH THROUGH TITLE OR DESCCRIPTION");
        searchField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchFieldMouseClicked(evt);
            }
        });
        searchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFieldActionPerformed(evt);
            }
        });
        searchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchFieldKeyReleased(evt);
            }
        });
        jPanel2.add(searchField, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 810, 40));

        backBtn.setBackground(new java.awt.Color(0, 0, 204));
        backBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MEMO/icons8-back-48.png"))); // NOI18N
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });
        jPanel2.add(backBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 40, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 11, 1070, 110));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        backPanel.setBackground(new java.awt.Color(255, 255, 255));
        backPanel.setLayout(new java.awt.GridLayout(0, 2, 6, 6));
        jScrollPane1.setViewportView(backPanel);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 1040, 510));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void searchFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchFieldKeyReleased
backPanel.removeAll();
backPanel.validate();
backPanel.repaint();
search =searchField.getText();
        if(!search.equals(""))
{ String query2 = "SELECT * FROM TASKLIST WHERE TITLE LIKE UPPER('"+search+"%') OR TITLE LIKE LOWER('"+search+"%') OR DESCR LIKE UPPER( '"+search+"%' ) OR DESCR LIKE LOWER( '"+search+"%' ) ";
fetchAll(query2);
}else fetchAll(query);
    }//GEN-LAST:event_searchFieldKeyReleased

    private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFieldActionPerformed
 
    }//GEN-LAST:event_searchFieldActionPerformed

    private void searchFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchFieldMouseClicked
 searchField.setText("");
    }//GEN-LAST:event_searchFieldMouseClicked

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        this.setVisible(false);
        
    }//GEN-LAST:event_backBtnActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                v= new View();
//                v.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    public javax.swing.JPanel backPanel;
    private javax.swing.JButton jButton4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextField searchField;
    // End of variables declaration//GEN-END:variables
}
