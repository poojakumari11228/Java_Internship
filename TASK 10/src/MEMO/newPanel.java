
package MEMO;

import static MEMO.Home.m;
import java.awt.Color;
import static java.awt.image.ImageObserver.WIDTH;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;

/**
 *
 * @author POOJA
 */
public class newPanel extends javax.swing.JPanel {
    
    
            //for connection
    Connection con;
    Statement st;
    ResultSet rs;
    
    String query = "select * from TASKLIST ORDER BY ID ASC ";
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
          //delete
     void delete(){
     
        try {
       st = con.createStatement();
        ResultSet   result = st.executeQuery("DELETE FROM TASKLIST WHERE ID = '"+jPanel1.getName()+"' ");


        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

     }
     
     
//update
void update(){
     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
   String date = sdf.format(todoDate.getDate());
  // System.out.println(titleField.getText()+"\n"+date+"\n"+memoText.getText()+"\n"+todoTime.getFormatedTime()+"\n"+jPanel1.getName());
           try {
               st = con.createStatement();
               int result  = st.executeUpdate("UPDATE TASKLIST SET TITLE='"+titleField.getText()+"' , DESCR = '"+memoText.getText()+"' ,"
                       + "TODODATE ='"+date+"',TODOTIME='"+todoTime.getFormatedTime()+"'  WHERE ID='"+jPanel1.getName()+"' ");
           if(result==1)System.out.println("Updated------");
           else System.out.println("not Updated------");
           
           } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null, ex.getMessage());
           }
   

}
     

     
    
     
    public newPanel() {
        initComponents();
        setBorder(BorderFactory.createBevelBorder(WIDTH, Color.BLACK, Color.BLACK));
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        editBtn = new javax.swing.JButton();
        dltBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        memoText = new javax.swing.JTextArea();
        headPanel = new javax.swing.JPanel();
        todoTime = new lu.tudor.santec.jtimechooser.JTimeChooser();
        todoDate = new com.toedter.calendar.JDateChooser();
        titleField = new javax.swing.JTextField();

        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        editBtn.setText("EDIT");
        editBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtnActionPerformed(evt);
            }
        });

        dltBtn.setText("DELETE");
        dltBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dltBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dltBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                    .addComponent(editBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dltBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        memoText.setEditable(false);
        memoText.setColumns(2);
        memoText.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        memoText.setLineWrap(true);
        memoText.setRows(5);
        jScrollPane1.setViewportView(memoText);

        todoTime.setEnabled(false);

        todoDate.setEnabled(false);

        titleField.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        titleField.setText("TITLE");
        titleField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                titleFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout headPanelLayout = new javax.swing.GroupLayout(headPanel);
        headPanel.setLayout(headPanelLayout);
        headPanelLayout.setHorizontalGroup(
            headPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headPanelLayout.createSequentialGroup()
                .addComponent(titleField, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(todoTime, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(todoDate, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        headPanelLayout.setVerticalGroup(
            headPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(headPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(titleField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(todoTime, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(todoDate, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(headPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 267, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(headPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 47, Short.MAX_VALUE)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void dltBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dltBtnActionPerformed
m.backPanel.remove(this);
m.validate();
m.repaint();
connect();
delete();



    }//GEN-LAST:event_dltBtnActionPerformed

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed

       System.out.println("id is"+jPanel1.getName());
        
        memoText.requestFocus();
        if(editBtn.getText().equalsIgnoreCase("edit")){
                        todoDate.setEnabled(true);
            todoTime.setEnabled(true);
            titleField.setEditable(true);
        this.memoText.setEditable(true);
        editBtn.setText("SAVE");
}else if (editBtn.getText().equalsIgnoreCase("SAVE")){
       todoDate.setEnabled(false);
            todoTime.setEnabled(false);
            titleField.setEditable(false);
   this.memoText.setEditable(false);
   connect();
   update();
   
        editBtn.setText("EDIT");
}
    }//GEN-LAST:event_editBtnActionPerformed

    private void titleFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_titleFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_titleFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton dltBtn;
    public javax.swing.JButton editBtn;
    public javax.swing.JPanel headPanel;
    public javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextArea memoText;
    public javax.swing.JTextField titleField;
    public com.toedter.calendar.JDateChooser todoDate;
    public lu.tudor.santec.jtimechooser.JTimeChooser todoTime;
    // End of variables declaration//GEN-END:variables
}
