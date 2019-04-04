
package mobileinventory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author POOJA KUMARI
 */
public class GalaxyS6Edge extends javax.swing.JPanel {

    /**
     * Creates new form GalaxyS9
     */
      
    
    public Connection con;
    public Statement st;
    public ResultSet rs;
    public PreparedStatement pst =null; 
   String BRAND,MODEL,DIMENSION,WEIGHT,BATTERY_CAP,COLOUR_ONE, COLOURS_TWO,COLOURS_THREE,SCREEN_SIZE,RESOLUTION,PROCESSOR,RAM,INTERNAL_STRG,EXTNDABLE_STRG,REAR_CAM,FRONT_CAM,O_S,WIFI_STANDARD,BLUETOOTH,GPS,THREE_G,FOUR_G_LTE,NFC,USB_OTG,NO_OF_SIMS;
    
    public GalaxyS6Edge() {
        initComponents();
                //connection to database
      try{
            
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","Computershop","null");
             if(con!=null){
            System.out.println("connection success ");
            }
        st = con.createStatement();
        }catch(Exception e){
        e.printStackTrace();   
        }
           
    //FETCH GALAXY S6 Edge+ DATA FOR JAVA TABLE
     try{
       
    String query = "SELECT BRAND,MODEL,DIMENSION,WEIGHT,BATTERY_CAP,COLOUR_ONE, COLOURS_TWO,COLOURS_THREE FROM MOBILEINVENTORY where MODEL='GALAXY S6 Edge+' ";
    String query1 = "SELECT SCREEN_SIZE,RESOLUTION,PROCESSOR,RAM,INTERNAL_STRG,EXTNDABLE_STRG,REAR_CAM,FRONT_CAM,O_S FROM MOBILEINVENTORY where MODEL='GALAXY S6 Edge+' ";
    String query2 = "SELECT WIFI_STANDARD,BLUETOOTH,GPS,THREE_G,FOUR_G_LTE,NFC,USB_OTG,NO_OF_SIMS FROM MOBILEINVENTORY where MODEL='GALAXY S6 Edge+' ";
    
    pst = con.prepareStatement(query);
    rs = pst.executeQuery();
    galaxyS9Table.setModel(DbUtils.resultSetToTableModel(rs));
    
    pst = con.prepareStatement(query1);
    rs = pst.executeQuery();
    galaxyS9Table1.setModel(DbUtils.resultSetToTableModel(rs));
    
    
    pst = con.prepareStatement(query2);
    rs = pst.executeQuery();
    galaxyS9Table2.setModel(DbUtils.resultSetToTableModel(rs));
    
    }catch(Exception e){
    JOptionPane.showMessageDialog(null,e);
    }
      
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        galaxyS9Table = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        galaxyS9Table1 = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        galaxyS9Table2 = new javax.swing.JTable();

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(3, 78, 162));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(3, 78, 162));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mobileinventory/galaxyEdge2.JPG"))); // NOI18N
        jLabel3.setText("jLabel3");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 390, 690, 460));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mobileinventory/galaxyEdge.JPG"))); // NOI18N
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 720, 340));

        jScrollPane6.setViewportView(jPanel3);

        jPanel1.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, 960, 580));

        jPanel2.setBackground(new java.awt.Color(3, 78, 162));

        galaxyS9Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9", "Title 10", "Title 11", "Title 12", "Title 13", "Title 14", "Title 15", "Title 16", "Title 17", "Title 18", "Title 19", "Title 20", "Title 21", "Title 22", "Title 23", "Title 24", "Title 25"
            }
        ));
        jScrollPane2.setViewportView(galaxyS9Table);

        galaxyS9Table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9", "Title 10", "Title 11", "Title 12", "Title 13", "Title 14", "Title 15", "Title 16", "Title 17", "Title 18", "Title 19", "Title 20", "Title 21", "Title 22", "Title 23", "Title 24", "Title 25"
            }
        ));
        jScrollPane4.setViewportView(galaxyS9Table1);

        galaxyS9Table2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9", "Title 10", "Title 11", "Title 12", "Title 13", "Title 14", "Title 15", "Title 16", "Title 17", "Title 18", "Title 19", "Title 20", "Title 21", "Title 22", "Title 23", "Title 24", "Title 25"
            }
        ));
        jScrollPane5.setViewportView(galaxyS9Table2);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 1304, Short.MAX_VALUE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(0, 117, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(261, Short.MAX_VALUE))
        );

        jScrollPane3.setViewportView(jPanel2);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 610, 1320, 240));

        jScrollPane1.setViewportView(jPanel1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1470, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable galaxyS9Table;
    public javax.swing.JTable galaxyS9Table1;
    public javax.swing.JTable galaxyS9Table2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    // End of variables declaration//GEN-END:variables
}
