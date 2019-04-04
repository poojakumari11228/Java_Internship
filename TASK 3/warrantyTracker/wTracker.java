/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warrantyTracker;


import java.sql.*;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;


/**
 *
 * @author POOJA KUMARI
 */
public class wTracker extends javax.swing.JFrame {

    /**
     * Creates new form wTracker
     */
      Connection con;
      
    Statement st;
    ResultSet rs;
    PreparedStatement pst =null;    
    
    public String CNAME , PNAME, IMEI, SERIALNO ,SDATE, WDATE, PRICE, ITEM; 
    String searchData ;
     boolean insert=false;
     
   
//Function for searching 
     void searchBySno(String searchData){ //    SEARCH FOR data by serial no
               

                      
 try{
         rs = st.executeQuery("SELECT C_NAME,IMEI,P_NAME,SNO,SALE_DATE,W_END_DATE,ITEM,PRICE ,MONTHS_BETWEEN(W_END_DATE,SYSDATE) AS REM_DAYS FROM PRODUCTS WHERE SNO = upper('"+searchData+"') OR SNO = lower('"+searchData+"') ");
   
         while(rs.next()){
      
          String cname = rs.getString("C_NAME");
         String pname = rs.getString("P_NAME");
         String sdate = rs.getString("SALE_DATE");
         String wdate = rs.getString("W_END_DATE");
         String imei = rs.getString("IMEI");
         String item = rs.getString("ITEM");
         String price = rs.getString("PRICE");
     String remDays = rs.getString("REM_DAYS");
     
      
      outputText.append("CUSTOMER NAME : "+cname+"\n"+"PRODUCT NAME : "+pname+"\n"+"ITEM : "+"\t"+item+"\n"+"PRICE : "+"\t"+price+" RS"+"\n"+"IMEI number : "+imei+"\n"+"SALE DATE : "+sdate.substring(0,10)+"\n"+"WARRANTY END DATE : "+wdate.substring(0,10)+"\n"+"Remaining months are : "+remDays+"\n"+"\t"+"------------------------------------"+"\t"+"\n");
          
          }
}catch(Exception e){
       JOptionPane.showMessageDialog(null,  e);
        }
     }
      void searchByImei(String searchData){ //    SEARCH FOR data by IMEI no
                      
 try{
         rs = st.executeQuery("SELECT C_NAME,SNO,P_NAME,SNO,SALE_DATE,W_END_DATE,ITEM,PRICE,MONTHS_BETWEEN(W_END_DATE,SYSDATE) AS REM_DAYS FROM PRODUCTS WHERE IMEI = '"+searchData+"' ");
        while(rs.next()){
          String cname = rs.getString("C_NAME");
         String pname = rs.getString("P_NAME");
         String sdate = rs.getString("SALE_DATE");
         String wdate = rs.getString("W_END_DATE");
         String sno = rs.getString("SNO");
         String item = rs.getString("ITEM");
         String price = rs.getString("PRICE");
         
     String remDays = rs.getString("REM_DAYS");
    
      outputText.append("CUSTOMER NAME : "+cname+"\n"+"PRODUCT NAME : "+pname+"\n"+"ITEM : "+item+"\n"+"PRICE : "+price+" RS"+"\n"+"Serial number : "+sno+"\n"+"SALE DATE : "+sdate.substring(0,10)+"\n"+"WARRANTY END DATE : "+wdate.substring(0,10)+"\n"+"Remaining months are : "+remDays+"\n"+"\t"+"------------------------------------"+"\t"+"\n");
          
          }

}catch(Exception e){
       
       JOptionPane.showMessageDialog(null,  e);
        }
      }
     
 
 //    inserting into database
   
    public void insertData(String CNAME,String PNAME, int IMEI, String SERIALNO, String SDATE, String WDATE, String ITEM, int PRICE){
   try{
        int result = st.executeUpdate("INSERT INTO PRODUCTS(C_NAME, P_NAME, IMEI, SALE_DATE, W_END_DATE,SNO, ITEM, PRICE) VALUES('" +CNAME+"','" +PNAME+"','" +IMEI+"',TO_DATE('"+ SDATE+"','MM-DD-YYYY'),TO_DATE('"+ WDATE+"','MM-DD-YYYY'),'" +SERIALNO+"','" +ITEM+"','" +PRICE+"') ");
                      if(result==1){
              insert = true;
              }
                      else{
                          insert = false;
              }


}catch(Exception e){
        e.printStackTrace();
        }
    }
    //setting fields ti initial condition
    void emptyFields(){
    cName.setText("");
    pName.setText("");
    imei.setText("");
    PriceField.setText("");
    sNo.setText("");
    SM.setText("MM");
    SD.setText("DD");
    SY.setText("YYYY");
    WM.setText("MM");
    WD.setText("DD");
    WY.setText("YYYY");
    
    
    
    
    }
    
    //FETCH DATA FOR JAVA TABLE
    
    public void fetch(){
    try{
       
    String query = "SELECT * FROM PRODUCTS";
    pst = con.prepareStatement(query);
    rs = pst.executeQuery();
    Table.setModel(DbUtils.resultSetToTableModel(rs));
    
    }catch(Exception e){
    JOptionPane.showMessageDialog(null,e);
    }
    }
    //CONSTRUCTOR
    public wTracker() {
        
        initComponents();
        jPanel1.setSize(1034, 835);
        jTabbedPane1.setVisible(false);
        
        
                  //connection to database
      try{
            
            Class.forName("oracle.jdbc.driver.OracleDriver");
            
 con=DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:XE","Computershop","null");
            if(con!=null){
            System.out.println("connection success ");
            }
             st = con.createStatement();
        }catch(Exception e){
        e.printStackTrace();
        }
      fetch();
    }
  
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        pName = new javax.swing.JTextField();
        imei = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        sNo = new javax.swing.JTextField();
        SM = new javax.swing.JTextField();
        SD = new javax.swing.JTextField();
        SY = new javax.swing.JTextField();
        WY = new javax.swing.JTextField();
        WD = new javax.swing.JTextField();
        WM = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        ItemCombo = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        PriceField = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        searchField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        outputText = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane3 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(166, 89, 89));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CUSTOMER NAME :");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 170, 174, 38));

        cName.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        cName.setForeground(new java.awt.Color(166, 89, 89));
        cName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cNameActionPerformed(evt);
            }
        });
        jPanel2.add(cName, new org.netbeans.lib.awtextra.AbsoluteConstraints(294, 170, 280, 31));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("PRODUCT NAME    :");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, 174, 38));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("IMEI NUMBER        :");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 320, 174, 38));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("PRICE                      :");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 410, 174, 38));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("SALE DATE              :");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 460, -1, 38));

        pName.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        pName.setForeground(new java.awt.Color(166, 89, 89));
        pName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pNameActionPerformed(evt);
            }
        });
        jPanel2.add(pName, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 270, 292, 33));

        imei.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        imei.setForeground(new java.awt.Color(166, 89, 89));
        imei.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imeiActionPerformed(evt);
            }
        });
        jPanel2.add(imei, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 320, 292, 33));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("WARRANTY DATE  :");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 510, 174, 38));

        sNo.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        sNo.setForeground(new java.awt.Color(166, 89, 89));
        sNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sNoActionPerformed(evt);
            }
        });
        jPanel2.add(sNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 370, 292, 33));

        SM.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        SM.setForeground(new java.awt.Color(166, 89, 89));
        SM.setText("MM");
        SM.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                SMFocusGained(evt);
            }
        });
        SM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SMMouseClicked(evt);
            }
        });
        SM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SMActionPerformed(evt);
            }
        });
        jPanel2.add(SM, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 460, 46, 30));

        SD.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        SD.setForeground(new java.awt.Color(166, 89, 89));
        SD.setText("DD");
        SD.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                SDFocusGained(evt);
            }
        });
        SD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SDActionPerformed(evt);
            }
        });
        jPanel2.add(SD, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 460, 40, 30));

        SY.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        SY.setForeground(new java.awt.Color(166, 89, 89));
        SY.setText("YYYY");
        SY.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                SYFocusGained(evt);
            }
        });
        SY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SYActionPerformed(evt);
            }
        });
        jPanel2.add(SY, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 460, -1, 29));

        WY.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        WY.setForeground(new java.awt.Color(166, 89, 89));
        WY.setText("YYYY");
        WY.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                WYFocusGained(evt);
            }
        });
        WY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WYActionPerformed(evt);
            }
        });
        jPanel2.add(WY, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 510, -1, 29));

        WD.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        WD.setForeground(new java.awt.Color(166, 89, 89));
        WD.setText("DD");
        WD.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                WDFocusGained(evt);
            }
        });
        WD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WDActionPerformed(evt);
            }
        });
        jPanel2.add(WD, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 510, 40, 30));

        WM.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        WM.setForeground(new java.awt.Color(166, 89, 89));
        WM.setText("MM");
        WM.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                WMFocusGained(evt);
            }
        });
        WM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WMActionPerformed(evt);
            }
        });
        jPanel2.add(WM, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 510, 46, 30));

        jButton1.setText("SAVE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(487, 707, 99, 37));

        jLabel8.setBackground(new java.awt.Color(166, 89, 89));
        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("ADD CUSTOMER DETAILS");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 48, 517, 36));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("ITEM                        :");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, 174, 38));

        ItemCombo.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ItemCombo.setForeground(new java.awt.Color(166, 89, 89));
        ItemCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MOBILE", "COMPUTER" }));
        jPanel2.add(ItemCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 220, 290, 30));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("SERIAL NUMBER   :");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 370, 174, 38));

        PriceField.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        PriceField.setForeground(new java.awt.Color(166, 89, 89));
        jPanel2.add(PriceField, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 420, 290, 30));

        jTabbedPane1.addTab("ADD DATA", jPanel2);

        jPanel3.setBackground(new java.awt.Color(166, 89, 89));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setBackground(new java.awt.Color(166, 89, 89));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/warrantyTracker/searchnew.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 60, 54, 50));

        searchField.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        searchField.setText("SEARCH FOR DATA");
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
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchFieldKeyPressed(evt);
            }
        });
        jPanel3.add(searchField, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 770, 50));

        outputText.setEditable(false);
        outputText.setBackground(new java.awt.Color(166, 89, 89));
        outputText.setColumns(20);
        outputText.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        outputText.setRows(5);
        jScrollPane1.setViewportView(outputText);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 150, 520, 420));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/warrantyTracker/searchBack.png"))); // NOI18N
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(-190, 110, 590, 520));

        jTabbedPane1.addTab("SEARCH DATA", jPanel3);

        jPanel4.setBackground(new java.awt.Color(166, 89, 89));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setBackground(new java.awt.Color(166, 89, 89));
        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("TABLE OF CUSTOMERS RECORD");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, 610, 60));
        jPanel4.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 570, 20));

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "C_NAME", "P_NAME", "IMEI", "SNO", "SALE_DATE", "WARRANTY_DATE", "ITEMl", "PRICE"
            }
        ));
        jScrollPane3.setViewportView(Table);

        jPanel4.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 940, 510));

        jTabbedPane1.addTab("SHOW TABLE", jPanel4);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 3, 990, 780));

        jPanel1.setBackground(new java.awt.Color(255, 51, 51));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setBackground(new java.awt.Color(204, 0, 51));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/warrantyTracker/warranty.jpg"))); // NOI18N
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 141, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 670));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        // TODO add your handling code here:
        jPanel1.setVisible(false);
        jTabbedPane1.setVisible(true);
    }//GEN-LAST:event_jPanel1MouseClicked

    private void cNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cNameActionPerformed

    private void pNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pNameActionPerformed

    private void imeiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imeiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_imeiActionPerformed

    private void sNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sNoActionPerformed

    private void SYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SYActionPerformed
        // TODO add your handling code here:
  SY.setText("");
    }//GEN-LAST:event_SYActionPerformed

    private void WYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WYActionPerformed
        // TODO add your handling code here:
         WY.setText("");  
    }//GEN-LAST:event_WYActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        CNAME = cName.getText().toString();
        PNAME = pName.getText().toString();
        IMEI = imei.getText().toString();
        SERIALNO = sNo.getText().toString();
        ITEM = ItemCombo.getSelectedItem().toString();
        SDATE  = SM.getText().toString()+"-"+SD.getText().toString()+"-"+SY.getText().toString();
        WDATE  = WM.getText().toString()+"-"+WD.getText().toString()+"-"+WY.getText().toString();
        PRICE = PriceField.getText(); 
insertData(CNAME,PNAME,Integer.parseInt(IMEI),SERIALNO, SDATE, WDATE, ITEM, Integer.parseInt(PRICE));
        if(insert){
     JOptionPane.showMessageDialog(null,"Data Saved");
 }else{
     JOptionPane.showMessageDialog(null,"Not Inserted");
 }
        
  emptyFields();
  fetch();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void SMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SMMouseClicked
        // TODO add your handling code here:
  SM.setText("");  
    }//GEN-LAST:event_SMMouseClicked

    private void SDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SDActionPerformed
          // TODO add your handling code here:
           SD.setText("");  
    }//GEN-LAST:event_SDActionPerformed

    private void WMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WMActionPerformed
        // TODO add your handling code here:
         WM.setText("");  
    }//GEN-LAST:event_WMActionPerformed

    private void SMFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SMFocusGained
 SM.setText("");          // TODO add your handling code here:
    }//GEN-LAST:event_SMFocusGained

    private void SMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SMActionPerformed
 SD.setText("");          // TODO add your handling code here:
    }//GEN-LAST:event_SMActionPerformed

    private void WDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WDActionPerformed
 WD.setText("");          // TODO add your handling code here:
    }//GEN-LAST:event_WDActionPerformed

    private void SYFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SYFocusGained
 SY.setText("");          // TODO add your handling code here:
    }//GEN-LAST:event_SYFocusGained

    private void SDFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SDFocusGained
 SD.setText("");          // TODO add your handling code here:
    }//GEN-LAST:event_SDFocusGained

    private void WMFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_WMFocusGained
 WM.setText("");          // TODO add your handling code here:
    }//GEN-LAST:event_WMFocusGained

    private void WDFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_WDFocusGained
 WD.setText("");          // TODO add your handling code here:
    }//GEN-LAST:event_WDFocusGained

    private void WYFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_WYFocusGained
 WY.setText("");          // TODO add your handling code here:
    }//GEN-LAST:event_WYFocusGained

    private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFieldActionPerformed
        // TODO add your handling code here:
    searchField.setText("");
    }//GEN-LAST:event_searchFieldActionPerformed

    private void searchFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchFieldKeyPressed
        // TODO add your handling code here:
      
    }//GEN-LAST:event_searchFieldKeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

        outputText.setText("");
        searchData ="";
     
         searchData = searchField.getText().toString();
         if(searchData.equals("")){
      
     JOptionPane.showMessageDialog(null,"Please Enter data");
         }
        else if(searchData.matches("[0-9]*")){
         searchByImei(searchData);
         }else {
searchBySno(searchData);
         }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void searchFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchFieldMouseClicked
        // TODO add your handling code here:
        searchField.setText("");
    }//GEN-LAST:event_searchFieldMouseClicked

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
            java.util.logging.Logger.getLogger(wTracker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(wTracker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(wTracker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(wTracker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new wTracker().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ItemCombo;
    private javax.swing.JTextField PriceField;
    private javax.swing.JTextField SD;
    private javax.swing.JTextField SM;
    private javax.swing.JTextField SY;
    private javax.swing.JTable Table;
    private javax.swing.JTextField WD;
    private javax.swing.JTextField WM;
    private javax.swing.JTextField WY;
    private javax.swing.JTextField cName;
    private javax.swing.JTextField imei;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea outputText;
    private javax.swing.JTextField pName;
    private javax.swing.JTextField sNo;
    private javax.swing.JTextField searchField;
    // End of variables declaration//GEN-END:variables
}
