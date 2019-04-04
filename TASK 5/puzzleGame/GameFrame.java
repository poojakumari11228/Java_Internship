/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzleGame;

import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author POOJA KUMARI
 */
public class GameFrame extends javax.swing.JFrame {

    /**
     * Creates new form GameFrame
     */
    int moves=50;
    public static String name="";
    int score;
    Connection con;
    ResultSet rs;
    Statement st;
    int tryAgain;
    //lose condition
    public void lose(String name,int move){
       
 if(moves==0){
     score=0;
     insertData(name,score,move);
          tryAgain=  JOptionPane.showConfirmDialog(null,name+" You lose ! try again","Lose",JOptionPane.YES_NO_OPTION);

  if(tryAgain==0){

 setImages();
 moves=50;
 movesLabel.setText("MOVES: "+moves);
 }else{
  this.setVisible(false);
  startFrame sf = new startFrame();
  sf.show();
  } }
    }
    
    //wining condition
    public void win(String name,int move){
        
    if(jButton1.getText().equals("1") && jButton2.getText().equals("2") && jButton3.getText().equals("3") && jButton4.getText().equals("4")&& 
                jButton5.getText().equals("5") && jButton6.getText().equals("6") && jButton7.getText().equals("7")& jButton8.getText().equals("8") && 
               jButton9.getText().equals(" "))
        {
score = (move*5);        

insertData(name,score,move);
tryAgain=  JOptionPane.showConfirmDialog(null,"CONGRATULATION "+name+" YOU WON"+"\n"+"SCORE: "+score+"\n"+"MOVES : "+move+"\n"+"Do you want to play again","Lose",JOptionPane.YES_NO_OPTION);
  if(tryAgain==0){

 setImages();
 moves=50;
 movesLabel.setText("MOVES: "+moves);
 }else{
  this.setVisible(false);
  startFrame sf = new startFrame();
  sf.show();
  } 
        } 
    }
     //    inserting into database
   
    public void insertData(String name,int score,int move){
   try{
       int result = st.executeUpdate("INSERT INTO puzzleGame(NAME,SCORE,MOVES) VALUES('" +name+"','" +score+"','" +move+"')");
             
}catch(Exception e){
        e.printStackTrace();
        }
    }
    
   //setting images randomly
    public void setImages(){
        moves=50;
        score=0;
   ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i=1; i<9; i++) {
            list.add(new Integer(i));
        }
  
        Collections.shuffle(list);
           
         try {   
    Image img = ImageIO.read(getClass().getResource("images/easy/"+list.get(0)+".png"));
    jButton1.setIcon(new ImageIcon(img));
  
     img = ImageIO.read(getClass().getResource("images/easy/"+list.get(1)+".png"));
    jButton2.setIcon(new ImageIcon(img));
       
     img = ImageIO.read(getClass().getResource("images/easy/"+list.get(2)+".png"));
    jButton3.setIcon(new ImageIcon(img));
    
     img = ImageIO.read(getClass().getResource("images/easy/"+list.get(3)+".png"));
    jButton4.setIcon(new ImageIcon(img));
     
     img = ImageIO.read(getClass().getResource("images/easy/"+list.get(4)+".png"));
    jButton5.setIcon(new ImageIcon(img));
     
     img = ImageIO.read(getClass().getResource("images/easy/"+list.get(5)+".png"));
    jButton6.setIcon(new ImageIcon(img));
     
     img = ImageIO.read(getClass().getResource("images/easy/"+list.get(6)+".png"));
    jButton7.setIcon(new ImageIcon(img));
     
     img = ImageIO.read(getClass().getResource("images/easy/"+list.get(7)+".png"));
    jButton8.setIcon(new ImageIcon(img));
   
    jButton9.setIcon(null);
   
    jButton1.setText(list.get(0).toString());
    jButton2.setText(list.get(1).toString());
    jButton3.setText(list.get(2).toString());
    jButton4.setText(list.get(3).toString());
    jButton5.setText(list.get(4).toString());
    jButton6.setText(list.get(5).toString());
    jButton7.setText(list.get(6).toString());
    jButton8.setText(list.get(7).toString());
    jButton9.setText(" ");
    
    
   
    
         } catch (Exception ex) {
    System.out.println(ex);
  }  
    }
    
    
    public GameFrame(String name) {
        initComponents();
        setImages();
        this.name = name;
        NameLabel.setText(name);
                          //connection to database
      try{
            
            Class.forName("oracle.jdbc.driver.OracleDriver");
            
 con=DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:XE","POOJA","null");
            if(con!=null){
            System.out.println("connection success ");
            }
             st = con.createStatement();
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

        backgroundPanel = new javax.swing.JPanel();
        containerPanel = new javax.swing.JPanel();
        GridPanel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        ScorePanel = new javax.swing.JPanel();
        movesLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        NameLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        containerPanel.setBackground(new java.awt.Color(124, 77, 255));
        containerPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        GridPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GridPanelMouseClicked(evt);
            }
        });
        GridPanel.setLayout(new java.awt.GridLayout(3, 3));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 1)); // NOI18N
        jButton1.setForeground(new java.awt.Color(240, 240, 240));
        jButton1.setMaximumSize(new java.awt.Dimension(478, 478));
        jButton1.setMinimumSize(new java.awt.Dimension(478, 478));
        jButton1.setPreferredSize(new java.awt.Dimension(478, 478));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton1MouseReleased(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        GridPanel.add(jButton1);

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 1)); // NOI18N
        jButton2.setForeground(new java.awt.Color(240, 240, 240));
        jButton2.setMaximumSize(new java.awt.Dimension(373, 652));
        jButton2.setMinimumSize(new java.awt.Dimension(373, 652));
        jButton2.setPreferredSize(new java.awt.Dimension(478, 478));
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton2MouseReleased(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        GridPanel.add(jButton2);

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 1)); // NOI18N
        jButton3.setForeground(new java.awt.Color(240, 240, 240));
        jButton3.setMaximumSize(new java.awt.Dimension(373, 652));
        jButton3.setMinimumSize(new java.awt.Dimension(373, 652));
        jButton3.setPreferredSize(new java.awt.Dimension(478, 478));
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton3MouseReleased(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        GridPanel.add(jButton3);

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 1)); // NOI18N
        jButton4.setForeground(new java.awt.Color(240, 240, 240));
        jButton4.setMaximumSize(new java.awt.Dimension(373, 652));
        jButton4.setMinimumSize(new java.awt.Dimension(373, 652));
        jButton4.setPreferredSize(new java.awt.Dimension(478, 478));
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton4MouseReleased(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        GridPanel.add(jButton4);

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 1)); // NOI18N
        jButton5.setForeground(new java.awt.Color(240, 240, 240));
        jButton5.setMaximumSize(new java.awt.Dimension(373, 652));
        jButton5.setMinimumSize(new java.awt.Dimension(373, 652));
        jButton5.setPreferredSize(new java.awt.Dimension(478, 478));
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton5MouseReleased(evt);
            }
        });
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        GridPanel.add(jButton5);

        jButton6.setFont(new java.awt.Font("Tahoma", 0, 1)); // NOI18N
        jButton6.setForeground(new java.awt.Color(240, 240, 240));
        jButton6.setMaximumSize(new java.awt.Dimension(373, 652));
        jButton6.setMinimumSize(new java.awt.Dimension(373, 652));
        jButton6.setPreferredSize(new java.awt.Dimension(478, 478));
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton6MouseReleased(evt);
            }
        });
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        GridPanel.add(jButton6);

        jButton7.setFont(new java.awt.Font("Tahoma", 0, 1)); // NOI18N
        jButton7.setForeground(new java.awt.Color(240, 240, 240));
        jButton7.setMaximumSize(new java.awt.Dimension(373, 652));
        jButton7.setMinimumSize(new java.awt.Dimension(373, 652));
        jButton7.setPreferredSize(new java.awt.Dimension(478, 478));
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton7MouseReleased(evt);
            }
        });
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        GridPanel.add(jButton7);

        jButton8.setFont(new java.awt.Font("Tahoma", 0, 1)); // NOI18N
        jButton8.setForeground(new java.awt.Color(240, 240, 240));
        jButton8.setMaximumSize(new java.awt.Dimension(373, 652));
        jButton8.setMinimumSize(new java.awt.Dimension(373, 652));
        jButton8.setPreferredSize(new java.awt.Dimension(478, 478));
        jButton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton8MouseReleased(evt);
            }
        });
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        GridPanel.add(jButton8);

        jButton9.setFont(new java.awt.Font("Tahoma", 0, 1)); // NOI18N
        jButton9.setForeground(new java.awt.Color(240, 240, 240));
        jButton9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton9MouseReleased(evt);
            }
        });
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        GridPanel.add(jButton9);

        containerPanel.add(GridPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 710, 730));

        ScorePanel.setBackground(new java.awt.Color(124, 77, 255));
        ScorePanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        ScorePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        movesLabel.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        movesLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        movesLabel.setText("50");
        ScorePanel.add(movesLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 194, 50));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("You Have");
        ScorePanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 170, 50));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("50");
        ScorePanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 169, 40));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText(" TOTAL MOVES ");
        ScorePanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 190, 56));

        NameLabel.setFont(new java.awt.Font("Snap ITC", 1, 18)); // NOI18N
        NameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NameLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        ScorePanel.add(NameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 190, 60));
        ScorePanel.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 320, 10));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/puzzleGame/images/easy/Img.JPG"))); // NOI18N
        ScorePanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 300, 340));

        jButton10.setBackground(new java.awt.Color(255, 255, 255));
        jButton10.setFont(new java.awt.Font("Snap ITC", 1, 22)); // NOI18N
        jButton10.setText("Shuffle");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        ScorePanel.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, 170, 60));

        containerPanel.add(ScorePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 80, 320, 710));

        jButton11.setBackground(new java.awt.Color(255, 255, 255));
        jButton11.setFont(new java.awt.Font("Snap ITC", 1, 22)); // NOI18N
        jButton11.setText("Back");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        containerPanel.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 130, 50));

        javax.swing.GroupLayout backgroundPanelLayout = new javax.swing.GroupLayout(backgroundPanel);
        backgroundPanel.setLayout(backgroundPanelLayout);
        backgroundPanelLayout.setHorizontalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundPanelLayout.createSequentialGroup()
                .addComponent(containerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        backgroundPanelLayout.setVerticalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundPanelLayout.createSequentialGroup()
                .addComponent(containerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 814, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(backgroundPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(backgroundPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(1070, 864));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

  
  //win(name, moves);        
       
if(jButton7.getIcon()==null && jButton7.getText()==" ")
       {   if(moves!=0)
           moves--;
        movesLabel.setText("MOVES "+moves);
          Icon temp=jButton4.getIcon();
           jButton4.setIcon(null);
           jButton7.setIcon(temp);
           
           String stemp=jButton4.getText();
           jButton4.setText(" ");
           jButton7.setText(stemp);
       }  
if(jButton5.getIcon()==null && jButton5.getText()==" ")
       {  if(moves!=0)
           moves--;
        movesLabel.setText("MOVES "+moves);
          Icon temp=jButton4.getIcon();
           jButton4.setIcon(null);
           jButton5.setIcon(temp);
           
             String stemp=jButton4.getText();
           jButton4.setText(" ");
           jButton5.setText(stemp);
       }  

if(jButton1.getIcon()==null&& jButton1.getText()==" ")
       {   if(moves!=0)
           moves--;
        movesLabel.setText("MOVES "+moves);
          Icon temp=jButton4.getIcon();
           jButton4.setIcon(null);
           jButton1.setIcon(temp);
           
           String stemp=jButton4.getText();
           jButton4.setText(" ");
           jButton1.setText(stemp);
       } 
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

     
if(jButton2.getIcon()==null && jButton2.getText()==" ")
       {  if(moves!=0)
           moves--;
        movesLabel.setText("MOVES "+moves);
          Icon temp=jButton1.getIcon();
           jButton1.setIcon(null);
           jButton2.setIcon(temp);
           
           String stemp=jButton1.getText();
           jButton1.setText(" ");
           jButton2.setText(stemp);
       }    
                   
if(jButton4.getIcon()==null && jButton4.getText()==" " )
       {  if(moves!=0)
           moves--;
        movesLabel.setText("MOVES "+moves);
          Icon temp=jButton1.getIcon();
           jButton1.setIcon(null);
           jButton4.setIcon(temp);
           
           String stemp=jButton1.getText();
           jButton1.setText(" ");
           jButton4.setText(stemp);
       }    

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

  
if(jButton1.getIcon()==null && jButton1.getText()==" ")
       {   if(moves!=0)
           moves--;
        movesLabel.setText("MOVES "+moves);
          Icon temp=jButton2.getIcon();
           jButton2.setIcon(null);
           jButton1.setIcon(temp);
           
           String stemp=jButton2.getText();
           jButton2.setText(" ");
           jButton1.setText(stemp);
       }    
if(jButton5.getIcon()==null && jButton5.getText()==" ")
       {  if(moves!=0)
           moves--;
        movesLabel.setText("MOVES "+moves);
          Icon temp=jButton2.getIcon();
           jButton2.setIcon(null);
           jButton5.setIcon(temp);
           
           
           String stemp=jButton2.getText();
           jButton2.setText(" ");
           jButton5.setText(stemp);
       }    
if(jButton3.getIcon()==null && jButton3.getText()==" ")
       {  if(moves!=0)
           moves--;
        movesLabel.setText("MOVES "+moves);
          Icon temp=jButton2.getIcon();
           jButton2.setIcon(null);
           jButton3.setIcon(temp);
           
           String stemp=jButton2.getText();
           jButton2.setText(" ");
           jButton3.setText(stemp);
       }    
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

if(jButton2.getIcon()==null && jButton2.getText()==" ")
       {  if(moves!=0)
           moves--;
        movesLabel.setText("MOVES "+moves);
          Icon temp=jButton3.getIcon();
           jButton3.setIcon(null);
           jButton2.setIcon(temp);
           
           String stemp=jButton3.getText();
           jButton3.setText(" ");
           jButton2.setText(stemp);
       }    

if(jButton6.getIcon()==null && jButton6.getText()==" ")
       {   if(moves!=0)
           moves--;
        movesLabel.setText("MOVES "+moves);
          Icon temp=jButton3.getIcon();
           jButton3.setIcon(null);
           jButton6.setIcon(temp);
           
           String stemp=jButton3.getText();
           jButton3.setText(" ");
           jButton6.setText(stemp);
       }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

   
       

if(jButton4.getIcon()==null && jButton4.getText()==" ")
       {   if(moves!=0)
           moves--;
        movesLabel.setText("MOVES "+moves);
          Icon temp=jButton5.getIcon();
           jButton5.setIcon(null);
           jButton4.setIcon(temp);
           
           String stemp=jButton5.getText();
           jButton5.setText(" ");
           jButton4.setText(stemp);
       }  
if(jButton8.getIcon()==null && jButton8.getText()==" ")
       {   if(moves!=0)
           moves--;
        movesLabel.setText("MOVES "+moves);
          Icon temp=jButton5.getIcon();
           jButton5.setIcon(null);
           jButton8.setIcon(temp);
           
           String stemp=jButton5.getText();
           jButton5.setText(" ");
           jButton8.setText(stemp);
       }   
if(jButton2.getIcon()==null && jButton2.getText()==" ")
       {   if(moves!=0)
           moves--;
        movesLabel.setText("MOVES "+moves);
          Icon temp=jButton5.getIcon();
           jButton5.setIcon(null);
           jButton2.setIcon(temp);
           
           String stemp=jButton5.getText();
           jButton5.setText(" ");
           jButton2.setText(stemp);
       }  
if(jButton6.getIcon()==null && jButton6.getText()==" ")
       {   if(moves!=0)
           moves--;
        movesLabel.setText("MOVES "+moves);
          Icon temp=jButton5.getIcon();
           jButton5.setIcon(null);
           jButton6.setIcon(temp);
           
           String stemp=jButton5.getText();
           jButton5.setText(" ");
           jButton6.setText(stemp);
       }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
System.out.println("6 clicked");

if(jButton9.getIcon()==null && jButton9.getText().equals(" "))
       { 
           System.out.println("inside of if");

           if(moves!=0)
           moves--;
        movesLabel.setText("MOVES "+moves);
          Icon temp=jButton6.getIcon();
           jButton6.setIcon(null);
           jButton9.setIcon(temp);
           
           String stemp=jButton6.getText();
           jButton6.setText(" ");
           jButton9.setText(stemp);
       }  

if(jButton5.getIcon()==null && jButton5.getText()==" ")
       {  if(moves!=0)
           moves--;
        movesLabel.setText("MOVES "+moves);
          Icon temp=jButton6.getIcon();
           jButton6.setIcon(null);
           jButton5.setIcon(temp);
           
           String stemp=jButton6.getText();
           jButton6.setText(" ");
           jButton5.setText(stemp);
       }  
 
if(jButton3.getIcon()==null && jButton3.getText()==" ")
       {   if(moves!=0)
           moves--;
        movesLabel.setText("MOVES "+moves);
          Icon temp=jButton6.getIcon();
           jButton6.setIcon(null);
           jButton3.setIcon(temp);
           
           String stemp=jButton6.getText();
           jButton6.setText(" ");
           jButton3.setText(stemp);
       }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
       
if(jButton8.getIcon()==null && jButton8.getText()==" ")
       {   if(moves!=0)
           moves--;
        movesLabel.setText("MOVES "+moves);
          Icon temp=jButton7.getIcon();
           jButton7.setIcon(null);
           jButton8.setIcon(temp);
           
           String stemp=jButton7.getText();
           jButton7.setText(" ");
           jButton8.setText(stemp);
       }  
if(jButton4.getIcon()==null && jButton4.getText()==" ")
       {   if(moves!=0)
           moves--;
        movesLabel.setText("MOVES "+moves);
          Icon temp=jButton7.getIcon();
           jButton7.setIcon(null);
           jButton4.setIcon(temp);
           
           String stemp=jButton7.getText();
           jButton7.setText(" ");
           jButton4.setText(stemp);
       } 
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
       
if(jButton9.getIcon()==null && jButton9.getText()==" ")
       {   if(moves!=0)
           moves--;
        movesLabel.setText("MOVES "+moves);
          Icon temp=jButton8.getIcon();
           jButton8.setIcon(null);
           jButton9.setIcon(temp);
           
           String stemp=jButton8.getText();
           jButton8.setText(" ");
           jButton9.setText(stemp);
       }  
if(jButton5.getIcon()==null && jButton5.getText()==" ")
       {  if(moves!=0)
           moves--;
        movesLabel.setText("MOVES "+moves);
          Icon temp=jButton8.getIcon();
           jButton8.setIcon(null);
           jButton5.setIcon(temp);
           
           String stemp=jButton8.getText();
           jButton8.setText(" ");
           jButton5.setText(stemp);
       }           
if(jButton7.getIcon()==null && jButton7.getText()==" ")
       {  if(moves!=0)
           moves--;
        movesLabel.setText("MOVES "+moves);
          Icon temp=jButton8.getIcon();
           jButton8.setIcon(null);
           jButton7.setIcon(temp);
           
           String stemp=jButton8.getText();
           jButton8.setText(" ");
           jButton7.setText(stemp);
       }  

    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed

        if(jButton6.getIcon()==null && jButton6.getText()==" ")
       {   if(moves!=0)
           moves--;
        movesLabel.setText("MOVES "+moves);
          Icon temp=jButton9.getIcon();
           jButton9.setIcon(null);
           jButton6.setIcon(temp);
           
           String stemp=jButton9.getText();
           jButton9.setText(" ");
           jButton6.setText(stemp);
       } 

  
if(jButton8.getIcon()==null && jButton8.getText()==" ")
       {   if(moves!=0)
           moves--;
        movesLabel.setText("MOVES "+moves);
          Icon temp=jButton9.getIcon();
           jButton9.setIcon(null);
           jButton8.setIcon(temp);
           
           String stemp=jButton9.getText();
           jButton9.setText(" ");
           jButton8.setText(stemp);
           
       }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void GridPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GridPanelMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_GridPanelMouseClicked

    private void jButton1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseReleased
        // TODO add your handling code here:
 if(moves==0) 
 lose(name, moves);
 win(name, moves);
    }//GEN-LAST:event_jButton1MouseReleased

    private void jButton2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseReleased
        // TODO add your handling code here:
         if(moves==0) 
 lose(name, moves);
 win(name, moves);
    }//GEN-LAST:event_jButton2MouseReleased

    private void jButton3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseReleased
  if(moves==0) 
 lose(name, moves);
  win(name, moves);
    }//GEN-LAST:event_jButton3MouseReleased

    private void jButton4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseReleased
         win(name, moves);
        if (moves == 0) {
            lose(name, moves);
        }    }//GEN-LAST:event_jButton4MouseReleased

    private void jButton5MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseReleased
        win(name, moves);
        if (moves == 0) {
            lose(name, moves);
        }    }//GEN-LAST:event_jButton5MouseReleased

    private void jButton6MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseReleased
        win(name, moves);
        if(moves==0) 
 lose(name, moves);
    }//GEN-LAST:event_jButton6MouseReleased

    private void jButton7MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseReleased
 win(name, moves);
        if(moves==0) 
 lose(name, moves);
    }//GEN-LAST:event_jButton7MouseReleased

    private void jButton8MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MouseReleased
        win(name, moves);
        if (moves == 0) {
            lose(name, moves);
        }
    }//GEN-LAST:event_jButton8MouseReleased

    private void jButton9MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton9MouseReleased
        win(name, moves);
        if (moves == 0) {
            lose(name, moves);
        }
    }//GEN-LAST:event_jButton9MouseReleased

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        setImages();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
this.setVisible(false);
new startFrame().show();
    }//GEN-LAST:event_jButton11ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
              
                   
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel GridPanel;
    private javax.swing.JLabel NameLabel;
    private javax.swing.JPanel ScorePanel;
    private javax.swing.JPanel backgroundPanel;
    private javax.swing.JPanel containerPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel movesLabel;
    // End of variables declaration//GEN-END:variables

    private void JButton1(ImageIcon imageIcon) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
