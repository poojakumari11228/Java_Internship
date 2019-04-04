/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Pooja kumari
 */
public class SHOW extends javax.swing.JInternalFrame {

    /**
     * Creates new form SHOW
     */
    
     Connection con;
    Statement st;
    ResultSet rs;
    String name;
    String price;
    String sname;  
    int countItem;
    int totalItem;
    StringBuffer sb = new StringBuffer();
// show method for keyboard
    public void ShowKeyboard(){
                  totalItem=0;
                    sb=new StringBuffer();
        try{
     st = con.createStatement();
                
              rs = st.executeQuery("SELECT NAME,PRICE,SUPPNAME , COUNT(*) AS itemPerSupp FROM ITEMS GROUP BY SUPPNAME,price,name HAVING NAME IN 'Keyboard' ");
while(rs.next())                    //Continue block of code
{
 countItem=0;
 countItem=Integer.parseInt(rs.getString("itemPerSupp")); 
     totalItem+=countItem; 
 name = rs.getString("NAME");
 sname = rs.getString("SUPPNAME");
 price = rs.getString("PRICE");
 sb.append("Item name : "+name+" Price is : "+price+" Supplier : "+sname+" Item per upplier : "+countItem+"\n");
    	}
JOptionPane.showMessageDialog(null,"TOTAL KEYBOARDS ARE: "+totalItem+"\n"+sb);

        }catch(Exception e){
        e.printStackTrace();
        }

    }
//Show method for mouse
    public void ShowMouse(){
        totalItem=0;
                    sb=new StringBuffer();
        try{
     st = con.createStatement();
             rs = st.executeQuery("SELECT NAME,PRICE,SUPPNAME , COUNT(*) AS itemPerSupp FROM ITEMS GROUP BY SUPPNAME,price,name HAVING NAME IN 'Mouse' ");
while(rs.next())                    //Continue block of code
{
     countItem=0;
 countItem=Integer.parseInt(rs.getString("itemPerSupp")); 
     totalItem+=countItem; 
 name = rs.getString("NAME");
 sname = rs.getString("SUPPNAME");
 price = rs.getString("PRICE");
 sb.append("Item name : "+name+" Price is : "+price+" Supplier : "+sname+" Item per upplier : "+countItem+"\n");
    	}
JOptionPane.showMessageDialog(null,"TOTAL MOUSE ARE: "+totalItem+"\n"+sb);

        }catch(Exception e){
        e.printStackTrace();
        }

    }
 //Show method for monitor
        public void ShowMonitor(){
            totalItem=0;
                    sb=new StringBuffer();
        try{
     st = con.createStatement();
              rs = st.executeQuery("SELECT NAME,PRICE,SUPPNAME , COUNT(*) AS itemPerSupp FROM ITEMS GROUP BY SUPPNAME,price,name HAVING NAME IN 'Monitor' ");
while(rs.next())                    //Continue block of code
{
     countItem=0;
 countItem=Integer.parseInt(rs.getString("itemPerSupp")); 
     totalItem+=countItem; 
 name = rs.getString("NAME");
 sname = rs.getString("SUPPNAME");
 price = rs.getString("PRICE");
 sb.append("Item name : "+name+" Price is : "+price+" Supplier : "+sname+" Item per upplier : "+countItem+"\n");
    	}
JOptionPane.showMessageDialog(null,"TOTAL MONITORS ARE: "+totalItem+"\n"+sb);

        }catch(Exception e){
        e.printStackTrace();
        }

    }
 //Show method for VGA
            public void ShowVGA(){
                totalItem=0;
                    sb=new StringBuffer();
        try{
     st = con.createStatement();
             rs = st.executeQuery("SELECT NAME,PRICE,SUPPNAME , COUNT(*) AS itemPerSupp FROM ITEMS GROUP BY SUPPNAME,price,name HAVING NAME IN 'VGA Cables' ");
while(rs.next())                    //Continue block of code
{
     countItem=0;
 countItem=Integer.parseInt(rs.getString("itemPerSupp")); 
     totalItem+=countItem; 
 name = rs.getString("NAME");
 sname = rs.getString("SUPPNAME");
 price = rs.getString("PRICE");
 sb.append("Item name : "+name+" Price is : "+price+" Supplier : "+sname+" Item per upplier : "+countItem+"\n");
    	}
JOptionPane.showMessageDialog(null,"TOTAL VGA CABLES ARE: "+totalItem+"\n"+sb);

        }catch(Exception e){
        e.printStackTrace();
        }

    }
//Show method for GRAPHIC CARD
                public void ShowGraphic(){
                    totalItem=0;
                    sb=new StringBuffer();
        try{
     st = con.createStatement();
              rs = st.executeQuery("SELECT NAME,PRICE,SUPPNAME , COUNT(*) AS itemPerSupp FROM ITEMS GROUP BY SUPPNAME,price,name HAVING NAME IN 'Graphic Card' ");
while(rs.next())                    //Continue block of code
{
     countItem=0;
 countItem=Integer.parseInt(rs.getString("itemPerSupp")); 
     totalItem+=countItem; 
 name = rs.getString("NAME");
 sname = rs.getString("SUPPNAME");
 price = rs.getString("PRICE");
 sb.append("Item name : "+name+" Price is : "+price+" Supplier : "+sname+" Item per upplier : "+countItem+"\n");
    	}
JOptionPane.showMessageDialog(null,"TOTAL GRAPHIC CARDS ARE: "+totalItem+"\n"+sb);

        }catch(Exception e){
        e.printStackTrace();
        }

    }
//Show method for LCD
                    public void ShowLcd(){
                        totalItem=0;
                    sb=new StringBuffer();
        try{
     st = con.createStatement();
             rs = st.executeQuery("SELECT NAME,PRICE,SUPPNAME , COUNT(*) AS itemPerSupp FROM ITEMS GROUP BY SUPPNAME,price,name HAVING NAME IN 'LCD' ");
while(rs.next())                    //Continue block of code
{
     countItem=0;
 countItem=Integer.parseInt(rs.getString("itemPerSupp")); 
     totalItem+=countItem; 
 name = rs.getString("NAME");
 sname = rs.getString("SUPPNAME");
 price = rs.getString("PRICE");
 sb.append("Item name : "+name+" Price is : "+price+" Supplier : "+sname+" Item per upplier : "+countItem+"\n");
    	}
JOptionPane.showMessageDialog(null,"TOTAL LCD ARE: "+totalItem+"\n"+sb);

        }catch(Exception e){
        e.printStackTrace();
        }

    }
//Show method for Laptops
                        public void ShowLaptop(){
                            totalItem=0;
                    sb=new StringBuffer();
        try{
     st = con.createStatement();
           rs = st.executeQuery("SELECT NAME,PRICE,SUPPNAME , COUNT(*) AS itemPerSupp FROM ITEMS GROUP BY SUPPNAME,price,name HAVING NAME IN 'Laptop' ");
while(rs.next())                    //Continue block of code
{
     countItem=0;
 countItem=Integer.parseInt(rs.getString("itemPerSupp")); 
     totalItem+=countItem; 
 name = rs.getString("NAME");
 sname = rs.getString("SUPPNAME");
 price = rs.getString("PRICE");
 sb.append("Item name : "+name+" Price is : "+price+" Supplier : "+sname+" Item per upplier : "+countItem+"\n");
    	}
JOptionPane.showMessageDialog(null,"TOTAL LAPTOPS ARE: "+totalItem+"\n"+sb);

        }catch(Exception e){
        e.printStackTrace();
        }

    }


    
    public SHOW() {
        initComponents();
        
  //connection to database
      try{
            
            Class.forName("oracle.jdbc.driver.OracleDriver");
            
 con=DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:XE","Computershop","null");
            if(con!=null){
  //          System.out.println("connection ");
            }
             st = con.createStatement();
                
              rs = st.executeQuery("SELECT * FROM ITEMS ");
while(rs.next())                    //Continue block of code
{
String name = rs.getString("NAME");
String roll = rs.getString("SUPPNAME");
//System.out.println("name "+name+" roll number "+roll);
    	}

             


        }catch(Exception e){
        e.printStackTrace();
        }
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setClosable(true);
        setResizable(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapp/k.jpg"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 11, 242, 242));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapp/images.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(286, 11, 263, 242));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapp/VGA.jpg"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 187, 290));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapp/MONITOR2.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(559, 11, 274, 282));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapp/GraphicCard.jpg"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, 390, 260));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapp/LCD.png"))); // NOI18N
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 280, 260, 220));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapp/LAPTOP2.jpg"))); // NOI18N
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 290, 160, 160));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 102, 0));
        jLabel8.setText("CLICK THE ITEM FOR DETAILS");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 460, 380, 60));

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

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
      ShowKeyboard();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        ShowMouse();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        ShowMonitor();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
        ShowVGA();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        ShowGraphic();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
        ShowLaptop();
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
        ShowLcd();
    }//GEN-LAST:event_jLabel6MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
