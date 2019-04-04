package MEMO;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;




public class Add extends javax.swing.JFrame {

    int r=205;
    int g=80;
    int b =50;
    String todo,date,time,title;
  String fetchId;
    newPanel m1;
    boolean insert = false;
    
        //for connection
    Connection con;
    Statement st;
    ResultSet rs;
    
 
    ////fetch last inserted data
    void fetchLast(){
 try{
  rs = st.executeQuery("select * from TASKLIST  where ID=(select max(ID) from TASKLIST) ");
  if(rs.next()){
      System.out.println(rs.getString("TITLE")+rs.getDate("TODODATE")+rs.getTime("TODOTIME")+rs.getString("DESCR"));
    m1.titleField.setText(rs.getString("TITLE"));
    m1.todoDate.setDate(rs.getDate("TODODATE"));
   m1.todoTime.setTime(rs.getTime("TODOTIME"));
    m1.memoText.setText(rs.getString("DESCR"));
    fetchId = rs.getString("ID");
  m1.jPanel1.setName(fetchId);
  
  }else{
      System.out.println("data not inserted");}
  
 }catch(SQLException ex){
 System.out.println(ex.getMessage());
 }
    
    }
    
    void insertTask() {
    //////////insert
  try {
      
//Date d = new SimpleDateFormat("hh:mm:ss").parse(time);
//time = new SimpleDateFormat("hh:mm:ss a").format(d);
//System.out.println(time);   
        
        st = con.createStatement();
        int result = st.executeUpdate("INSERT INTO TASKLIST (ID,TODOTIME,TODODATE,TITLE,DESCR) VALUES(TASK_SEQUENCE.NEXTVAL,'"+time+"','"+date+"','"+title+"' ,'"+todo+"' )");
        if(result==0){
        System.out.println("not inserted");
        }else{
            fetchLast();
        System.out.println("inserted");}
        
  }catch (Exception ex) {
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
     
     ///validate todo
     void validateTodo(){
try{
    st = con.createStatement();
         
         ResultSet rs2 = st.executeQuery("select * from TASKLIST  where TODOTIME='"+time+"'  AND TODODATE='"+date+"' AND DESCR='"+todo+"'  ");
    if(rs2.next()){
        JOptionPane.showMessageDialog(null,"This task alredy exist");
        insert=false;
        
    }else{
        
         rs = st.executeQuery("select * from TASKLIST  where TODOTIME='"+time+"'  AND TODODATE LIKE '%"+date+"%' ");
        if(rs.next()){
    int confrm =   JOptionPane.showConfirmDialog(null,"You have already added One task at this time and date!"+"\n"+"Do you want to add another?");
    if(confrm==JOptionPane.YES_OPTION){
        insert=true;
    }else insert=false;
     }else insert=true;
}
}catch(SQLException ex){
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

        jButton4 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        newText = new javax.swing.JTextArea();
        todoDate = new com.toedter.calendar.JDateChooser();
        titleField = new javax.swing.JTextField();
        backBtn = new javax.swing.JButton();
        todoTime = new lu.tudor.santec.jtimechooser.JTimeChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        backPanel = new javax.swing.JPanel();

        jButton4.setText("jButton4");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 0, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(0, 0, 204));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MEMO/icons8-plus-math-48.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 70, 50, 50));

        newText.setColumns(2);
        newText.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        newText.setLineWrap(true);
        newText.setRows(5);
        jScrollPane2.setViewportView(newText);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, 710, 70));
        jPanel2.add(todoDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(781, 20, 130, 30));

        titleField.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        titleField.setText("TITLE");
        titleField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                titleFieldActionPerformed(evt);
            }
        });
        jPanel2.add(titleField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, 180, 30));

        backBtn.setBackground(new java.awt.Color(0, 0, 204));
        backBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MEMO/icons8-back-48.png"))); // NOI18N
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });
        jPanel2.add(backBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 40, 40));

        todoTime.setEnabled(false);
        jPanel2.add(todoTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 20, 90, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 11, 1070, 160));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        backPanel.setBackground(new java.awt.Color(255, 255, 255));
        backPanel.setLayout(new java.awt.GridLayout(600, 1, 6, 6));
        jScrollPane1.setViewportView(backPanel);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 1040, 480));

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
if(newText.getText().equals("") || titleField.getText().equals("") ||
        ((JTextField) todoDate.getDateEditor().getUiComponent()).getText().toString().equals("") || todoTime.getFormatedTime().equals("00:00:00") ){JOptionPane.showMessageDialog(null, "Fields can't be empty");

}else{ 
        
        time = todoTime.getFormatedTime();


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
       date = sdf.format(todoDate.getDate());
       
       
       todo =newText.getText();
       
        if(titleField.getText().equalsIgnoreCase("title")){
            title = "";
        }else
        title = titleField.getText();
        
validateTodo();        
      if(insert==true){
if( !todo.equals("")  ){  //&& !titleField.getText().equals("") && !todoTime.getFormatedDate().equals("") && !todoDate.getDate().equals("")
 m1 = new newPanel();
 m1.memoText.setBackground(new Color(r,g,b));
m1.headPanel.setBackground(new Color(r,g,b));
m1.setBackground(new Color(r,g,b));
m1.editBtn.setBackground(new Color(r,g,b));
m1.dltBtn.setBackground(new Color(r,g,b));
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
insertTask();
 
  }
    }
}
    }//GEN-LAST:event_jButton1ActionPerformed

    private void titleFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_titleFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_titleFieldActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
 this.setVisible(false);
// new Home().show();
    }//GEN-LAST:event_backBtnActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                m = new Add();
//                m.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    public javax.swing.JPanel backPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTextArea newText;
    private javax.swing.JTextField titleField;
    private com.toedter.calendar.JDateChooser todoDate;
    public lu.tudor.santec.jtimechooser.JTimeChooser todoTime;
    // End of variables declaration//GEN-END:variables
}
