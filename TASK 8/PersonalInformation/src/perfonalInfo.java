
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;



public class perfonalInfo extends javax.swing.JFrame {

    ///INSTANCE VARIABLES
     //for connection
    Connection con;
    Statement st;
    PreparedStatement ps;
    ResultSet rs;
    
     String selectedImg,gender=null;
     ButtonGroup btnG;
     ImageIcon newimg ;
     String id;
    
    //group buttons
    void groupBtns(){
    btnG = new ButtonGroup();
    btnG.add(maleRB);
    btnG.add(femaleRB);
    }
    //////insert method
    void insertData(String name,String gender,String age,String blood,String contact,String quali,String addr){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
String date = sdf.format(DateChooser.getDate());

  try {
             InputStream is = new FileInputStream(new File(selectedImg)); 
            ps = con.prepareStatement("INSERT INTO EMPINFO (EMP_ID,EMP_NAME,GENDER,AGE,BLOOD_GROUP,CONTACT_NO,QUALIFICATION,JOINING_DATE,ADDR,EMP_IMG)VALUES(EMPINFO_sequence.NEXTVAL,?,?,?,?,?,?,?,?,?)" );
     
            ps.setString(1, name);
            ps.setString(2, gender);
            ps.setString(3,age);
            ps.setString(4,blood);
            ps.setString(5,contact );
            ps.setString(6, quali);
            ps.setString(7, date);
            ps.setString(8, addr);
            ps.setBlob(9, is);
            
    int result = ps.executeUpdate();
    if (result==1){
    JOptionPane.showMessageDialog(null,"Data inserted");
    }else{
    JOptionPane.showMessageDialog(null,"Data not inserted");
    }
    
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    
    
    }
    ///insert data to jTable
    
    void refreshTable(){
     try {
         
         JTableHeader THeader = empTable.getTableHeader();
         THeader.setBackground(Color.BLUE);
         THeader.setForeground(Color.WHITE);
       THeader.setFont(new Font("Times New Roman",Font.BOLD,20));
         ps= con.prepareStatement("SELECT * FROM EMPINFO");
       rs = ps.executeQuery();
        empTable.setModel(DbUtils.resultSetToTableModel(rs));
     }catch(Exception ex){
         JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    //delete from database
    void deleteRow(){
     int index = empTable.getSelectedRow();
   TableModel model  = empTable.getModel();
   String id =  model.getValueAt(index, 0).toString();
        try {
            st = con.createStatement();
        ResultSet   result = st.executeQuery("DELETE FROM EMPINFO WHERE EMP_ID = '"+id+"' ");
         
            
        } catch (SQLException ex) {
            Logger.getLogger(perfonalInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
        refreshTable();
  
    
    }
    
   //clear fields
    void clear(){
          imgpathField.setText("");
        try {
            Image defaultimg = ImageIO.read(getClass().getResource("empuser.png"));
            imgLabel.setIcon(new ImageIcon(defaultimg));
        } catch (IOException ex) {
        }
      idField.setText("");
            nameField.setText("");
            ageField.setText("");
            contactField.setText("");
            qualiCombo.setSelectedItem(null);
            bloodCombo.setSelectedItem(null);
            addArea.setText("");
           DateChooser.setDate(null);
            btnG.clearSelection();
    }
    
    /// on update button
    void update(){
          int index = empTable.getSelectedRow();
        TableModel model = empTable.getModel();
        id = model.getValueAt(index, 0).toString();
        
        try{
        st = con.createStatement();
        rs = st.executeQuery(" SELECT * FROM EMPINFO WHERE EMP_ID='"+id+"' ");
        if(rs.next()){
    
   //for setting image to the label
            byte[] img = rs.getBytes("EMP_IMG");
            ImageIcon image = new ImageIcon(img);
            Image im = image.getImage();
            Image myimage =im.getScaledInstance(imgLabel.getWidth(), imgLabel.getHeight(),Image.SCALE_SMOOTH);
             newimg = new ImageIcon(myimage);
           
            imgLabel.setIcon(newimg);
            
    ///for other fields
            idField.setText(rs.getString("EMP_ID"));
            nameField.setText(rs.getString("EMP_NAME"));
            ageField.setText(rs.getString("AGE"));
            contactField.setText(rs.getString("CONTACT_NO"));
            qualiCombo.setSelectedItem(rs.getString("QUALIFICATION"));
            bloodCombo.setSelectedItem(rs.getString("BLOOD_GROUP"));
            addArea.setText(rs.getString("ADDR"));
           DateChooser.setDate(rs.getDate("JOINING_DATE"));
            
 
//for gender
             gender = rs.getString("GENDER");
          //  btnG.setSelected(m, rootPaneCheckingEnabled);
            if(gender.equalsIgnoreCase("Male"))
            { maleRB.setSelected(true);
        }else{femaleRB.setSelected(true);                     }
    
        }
        else{JOptionPane.showMessageDialog(null,"no data found");}
 }catch(Exception e){
 System.out.println(e.getMessage());
 }
    }
    
    ///on save changing after updation
    void save(){
                 
        String name = nameField.getText();
        String age = ageField.getText();
        String blood = bloodCombo.getSelectedItem().toString();
        String contact = contactField.getText();
        String quali = qualiCombo.getSelectedItem().toString();
        String addr = addArea.getText();
       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(DateChooser.getDate());
 
  try { 
         if(selectedImg!=null){
             InputStream is = new FileInputStream(selectedImg);
             ps = con.prepareStatement("UPDATE EMPINFO set EMP_NAME=?,GENDER=?,AGE=?,BLOOD_GROUP=?,CONTACT_NO=?,QUALIFICATION=?,JOINING_DATE=?,ADDR=?,EMP_IMG=? where EMP_ID = '"+id+"'  " );
           ps.setString(1, name);
            ps.setString(2, gender);
            ps.setString(3,age);
            ps.setString(4,blood);
            ps.setString(5,contact );
            ps.setString(6, quali);
            ps.setString(7, date);
            ps.setString(8, addr);
            ps.setBlob(9, is);
          
         }else{
         
          ps = con.prepareStatement("UPDATE EMPINFO set EMP_NAME=?,GENDER=?,AGE=?,BLOOD_GROUP=?,CONTACT_NO=?,QUALIFICATION=?,JOINING_DATE=?,ADDR=? where EMP_ID = '"+id+"'  " );
           ps.setString(1, name);
            ps.setString(2, gender);
            ps.setString(3,age);
            ps.setString(4,blood);
            ps.setString(5,contact );
            ps.setString(6, quali);
            ps.setString(7, date);
            ps.setString(8, addr);      
         }
            
            
    int result = ps.executeUpdate();
    if (result==1){
    JOptionPane.showMessageDialog(null,"Data updated");
    }else{
    JOptionPane.showMessageDialog(null,"Data not updated");
    }
    
        } catch (Exception ex) {
           JOptionPane.showMessageDialog(null,ex.getMessage());
        }  
    }
 /////Validate if emp data already exist or not
    void validateEmp(String name,String contact) throws SQLException{
    try{
    st = con.createStatement();
    rs = st.executeQuery("SELECT * FROM EMPINFO WHERE  CONTACT_NO = '"+contact+"' ");
    if(rs.next()){
        JOptionPane.showMessageDialog(null,"Data of "+name+" already exist.");
    }else{
        ////if validate thn insert is called
    insertData(nameField.getText(),gender,ageField.getText(),bloodCombo.getSelectedItem().toString(),contactField.getText(),qualiCombo.getSelectedItem().toString(), addArea.getText());
        refreshTable(); 
       
    }
    } catch (SQLException ex) {
        Logger.getLogger(perfonalInfo.class.getName()).log(Level.SEVERE, null, ex);
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
     
    //constructor
    public perfonalInfo() {
        initComponents();
        connect();
        groupBtns();
        refreshTable();
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        imgPanel = new javax.swing.JPanel();
        imgLabel = new javax.swing.JLabel();
        infoPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        idField = new javax.swing.JTextField();
        nameField = new javax.swing.JTextField();
        ageField = new javax.swing.JTextField();
        contactField = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        addArea = new javax.swing.JTextArea();
        maleRB = new javax.swing.JRadioButton();
        femaleRB = new javax.swing.JRadioButton();
        DateChooser = new com.toedter.calendar.JDateChooser();
        bloodCombo = new javax.swing.JComboBox<>();
        qualiCombo = new javax.swing.JComboBox<>();
        uploadBtn = new javax.swing.JButton();
        imgpathField = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        empTable = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        btnsPanel = new javax.swing.JPanel();
        newBtn = new javax.swing.JButton();
        saveBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        dltBtn = new javax.swing.JButton();
        clearBtn = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(3, 50, 152));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PERSONAL INFORMATION", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(102, 0, 51))); // NOI18N

        jPanel2.setBackground(new java.awt.Color(3, 50, 152));

        imgPanel.setBackground(new java.awt.Color(100, 149, 237));
        imgPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        imgLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imgLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/empuser.png"))); // NOI18N
        imgPanel.add(imgLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 360, 270));

        infoPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("EMPLOYEE ID   :");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText("NAME                   :");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setText("GENDER              :");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setText("AGE                      :");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setText("BLOOD GROUP  :");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setText("CONTACT N0#   :");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setText("QUALIFICATION:");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setText("JOINING DATE   :");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel9.setText("ADDRESS            :");

        idField.setEditable(false);
        idField.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        idField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        nameField.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N

        ageField.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N

        contactField.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N

        addArea.setColumns(20);
        addArea.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        addArea.setRows(5);
        jScrollPane2.setViewportView(addArea);

        maleRB.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        maleRB.setText("Male");
        maleRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maleRBActionPerformed(evt);
            }
        });

        femaleRB.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        femaleRB.setText("Female");
        femaleRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                femaleRBActionPerformed(evt);
            }
        });

        DateChooser.setDateFormatString("MM d, yyyy");
        DateChooser.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N

        bloodCombo.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        bloodCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-" }));

        qualiCombo.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        qualiCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Phd", "Doctor", "Engineering" }));

        javax.swing.GroupLayout infoPanelLayout = new javax.swing.GroupLayout(infoPanel);
        infoPanel.setLayout(infoPanelLayout);
        infoPanelLayout.setHorizontalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(infoPanelLayout.createSequentialGroup()
                        .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(idField, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                                .addComponent(nameField)
                                .addComponent(ageField))
                            .addGroup(infoPanelLayout.createSequentialGroup()
                                .addComponent(maleRB, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(femaleRB, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(infoPanelLayout.createSequentialGroup()
                        .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(26, 26, 26)
                        .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(DateChooser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(qualiCombo, javax.swing.GroupLayout.Alignment.TRAILING, 0, 263, Short.MAX_VALUE)
                            .addComponent(contactField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(bloodCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        infoPanelLayout.setVerticalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nameField)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(maleRB)
                    .addComponent(femaleRB))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                    .addComponent(ageField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bloodCombo, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                    .addComponent(contactField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(qualiCombo, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                    .addComponent(DateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(89, 89, 89))
        );

        uploadBtn.setBackground(new java.awt.Color(100, 149, 237));
        uploadBtn.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        uploadBtn.setForeground(new java.awt.Color(255, 255, 255));
        uploadBtn.setText("UPLOAD IMAGE");
        uploadBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadBtnActionPerformed(evt);
            }
        });

        imgpathField.setEditable(false);
        imgpathField.setBackground(new java.awt.Color(100, 149, 237));
        imgpathField.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        imgpathField.setForeground(new java.awt.Color(255, 255, 255));
        imgpathField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        imgpathField.setText("IMAGE PATH");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(infoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(imgPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(uploadBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(imgpathField, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(606, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(uploadBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imgpathField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(infoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 627, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(362, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel2);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 540, 1100));

        jPanel3.setBackground(new java.awt.Color(100, 149, 237));

        jScrollPane3.setBackground(new java.awt.Color(204, 204, 255));

        empTable.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        empTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9", "Title 10"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        empTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        empTable.setGridColor(new java.awt.Color(102, 102, 255));
        jScrollPane3.setViewportView(empTable);
        if (empTable.getColumnModel().getColumnCount() > 0) {
            empTable.getColumnModel().getColumn(0).setResizable(false);
            empTable.getColumnModel().getColumn(0).setPreferredWidth(4);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 920, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 210, 940, 540));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("EMPLOYEES INFORMATION TABLE");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 20, 850, 80));

        btnsPanel.setBackground(new java.awt.Color(255, 255, 255));
        btnsPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        newBtn.setBackground(new java.awt.Color(100, 149, 237));
        newBtn.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        newBtn.setForeground(new java.awt.Color(255, 255, 255));
        newBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-new-slide-48.png"))); // NOI18N
        newBtn.setText("NEW");
        newBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newBtnActionPerformed(evt);
            }
        });
        btnsPanel.add(newBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 130, 48));

        saveBtn.setBackground(new java.awt.Color(100, 149, 237));
        saveBtn.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        saveBtn.setForeground(new java.awt.Color(255, 255, 255));
        saveBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-save-all-48.png"))); // NOI18N
        saveBtn.setText("SAVE");
        saveBtn.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });
        btnsPanel.add(saveBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 140, 48));

        updateBtn.setBackground(new java.awt.Color(100, 149, 237));
        updateBtn.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        updateBtn.setForeground(new java.awt.Color(255, 255, 255));
        updateBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-compose-48.png"))); // NOI18N
        updateBtn.setText("UPDATE");
        updateBtn.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });
        btnsPanel.add(updateBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, 160, 48));

        dltBtn.setBackground(new java.awt.Color(100, 149, 237));
        dltBtn.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        dltBtn.setForeground(new java.awt.Color(255, 255, 255));
        dltBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-trash-can-48.png"))); // NOI18N
        dltBtn.setText("DELETE");
        dltBtn.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        dltBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dltBtnActionPerformed(evt);
            }
        });
        btnsPanel.add(dltBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 10, 160, 48));

        clearBtn.setBackground(new java.awt.Color(100, 149, 237));
        clearBtn.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        clearBtn.setForeground(new java.awt.Color(255, 255, 255));
        clearBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-broom-48.png"))); // NOI18N
        clearBtn.setText("CLEAR");
        clearBtn.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtnActionPerformed(evt);
            }
        });
        btnsPanel.add(clearBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 10, 150, 48));

        jPanel1.add(btnsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 120, 800, 70));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 200, 960, 10));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 110, 950, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        setSize(new java.awt.Dimension(1524, 826));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void maleRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maleRBActionPerformed
       gender = maleRB.getText();
    }//GEN-LAST:event_maleRBActionPerformed

    private void femaleRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_femaleRBActionPerformed
        gender = femaleRB.getText();
    }//GEN-LAST:event_femaleRBActionPerformed

    private void uploadBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadBtnActionPerformed
       JFileChooser jf = new JFileChooser();
      jf.setCurrentDirectory(new File("C:\\Users\\Vijay\\Desktop"));
       jf.setDialogTitle("select Image");
      FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE","JPEG","PNG","JPG");
     jf.addChoosableFileFilter(filter);
    
     int resultImg = jf.showSaveDialog(null);
       
       if(resultImg==JFileChooser.APPROVE_OPTION){
     
           selectedImg =  jf.getSelectedFile().getAbsolutePath();
     imgpathField.setText(selectedImg);
     imgLabel.setIcon(new ImageIcon(selectedImg));
       }
       
       
    }//GEN-LAST:event_uploadBtnActionPerformed

    private void newBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newBtnActionPerformed

  /////////////////for validation
        if(nameField.getText().equals("") || gender==null || contactField.getText().equals("")  
                 || bloodCombo.getSelectedItem().toString().equals(null) ||qualiCombo.getSelectedItem().toString().equals(null)|| bloodCombo.getSelectedItem().toString().equals(null)
                    || addArea.getText().equals(null)){
            JOptionPane.showMessageDialog(null,"Please enter the required details");
        }else if(!nameField.getText().matches("[a-zA-Z]+") ){
      JOptionPane.showMessageDialog(null,"Invalid data");
     
            }else if(selectedImg==null){
            
          
            JOptionPane.showMessageDialog(null,"Please upload your picture");
}else{ 
           
    try {
///////////////validate and then insert data
        validateEmp(nameField.getText().toString(),contactField.getText());
    } catch (SQLException ex) {
       
    }
    
           }
 
 
    }//GEN-LAST:event_newBtnActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
if(empTable.getSelectedRowCount()==0){
        JOptionPane.showMessageDialog(null,"Please select row");
   }else if(empTable.getSelectedRowCount()>1){
        JOptionPane.showMessageDialog(null,"Please select any one row.");
   }else
        update();  
    }//GEN-LAST:event_updateBtnActionPerformed

    private void dltBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dltBtnActionPerformed
if(empTable.getSelectedRowCount()==0){
        JOptionPane.showMessageDialog(null,"Please select row");
   }else if(empTable.getSelectedRowCount()>1){
        JOptionPane.showMessageDialog(null,"Please select any one row.");
   }else  deleteRow(); 
    }//GEN-LAST:event_dltBtnActionPerformed

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
clear();    
           
    }//GEN-LAST:event_clearBtnActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
    save();
    refreshTable();
    
    }//GEN-LAST:event_saveBtnActionPerformed

   
    public static void main(String args[]) {
    
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DateChooser;
    private javax.swing.JTextArea addArea;
    private javax.swing.JTextField ageField;
    private javax.swing.JComboBox<String> bloodCombo;
    private javax.swing.JPanel btnsPanel;
    private javax.swing.JButton clearBtn;
    private javax.swing.JTextField contactField;
    private javax.swing.JButton dltBtn;
    private javax.swing.JTable empTable;
    private javax.swing.JRadioButton femaleRB;
    private javax.swing.JTextField idField;
    private javax.swing.JLabel imgLabel;
    private javax.swing.JPanel imgPanel;
    private javax.swing.JTextField imgpathField;
    private javax.swing.JPanel infoPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JRadioButton maleRB;
    private javax.swing.JTextField nameField;
    private javax.swing.JButton newBtn;
    private javax.swing.JComboBox<String> qualiCombo;
    private javax.swing.JButton saveBtn;
    private javax.swing.JButton updateBtn;
    private javax.swing.JButton uploadBtn;
    // End of variables declaration//GEN-END:variables
}
