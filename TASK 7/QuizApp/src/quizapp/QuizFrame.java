
package quizapp;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

/**
 *
 * @author POOJA KUMARI
 */

public final class QuizFrame extends javax.swing.JFrame {
    
 //Instance variables
      //for connection
    Connection con;
    java.sql.Statement st;
    ResultSet rs;
    //group fro jRadioButtons
    ButtonGroup btnG;
    //for fetching info;
    
    ArrayList<Integer> randomQues;
    public int currentQues=0;
    public int right,wrong,score;
    public int totalScore=10;
    public String qno,ques,optnA,optnB,optnC,optnD,ans;
    public String selectedAns;
    public String selectedCourse="JAVA";
    boolean startTest=false;
    String regsId=null;



//for selecting random questions from db  
public void generateRandomQues(){
        randomQues = new ArrayList<>();
   
for(int i=1; i<11; i++){
  randomQues.add(i);
}
Collections.shuffle(randomQues);
}
    
    
    
//GROUP RADIO BTNS
   public void groupBtns(){
            btnG = new ButtonGroup();
btnG.add(RadioBtnA);
btnG.add(RadioBtnB);
btnG.add(RadioBtnC);
btnG.add(RadioBtnD);

   }
 //For Handling radioButtons
public void enableClearSelection(){
         RadioBtnA.setEnabled(true);
         RadioBtnB.setEnabled(true);
         RadioBtnC.setEnabled(true);
         RadioBtnD.setEnabled(true);   
         btnG.clearSelection();
}
  
    
    
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
   
    //Fetching data (quiz) from db 
    public void fetchQuiz(int QNO) {
        try{
    st = con.createStatement();
     rs = st.executeQuery("SELECT * FROM "+selectedCourse+"QUIZ"+" WHERE QNO = '"+QNO+"'");
     while(rs.next()){
          qno = rs.getString("QNO");
         ques = rs.getString("QUES");
         optnA = rs.getString("OPTIONA");
         optnB = rs.getString("OPTIONB");
         optnC = rs.getString("OPTIONC");
         optnD = rs.getString("OPTIOND");
           ans = rs.getString("ANS");
                 }
  //  System.out.println(ques+"\n"+ans+"\n"+optnA+"\n"+optnB+"\n"+optnC+"\n"+optnD);
    
        }catch(SQLException e){ System.out.println(e.getMessage());}
    }
    
    //setdata to Frame
    public void setData(){
    
    quesLabel.setText("Q."+(currentQues+1)+"      "+ques);
    RadioBtnA.setText(optnA);
    RadioBtnB.setText(optnB);
    RadioBtnC.setText(optnC);
    RadioBtnD.setText(optnD);
    }
    
    //set score and right and wrong ques
    //Set field TESTCOMPLETED to 1 so that no one can attempt test again
    public void setComplete(){
      try{  
          st=con.createStatement();
    int rs = st.executeUpdate("UPDATE STUDENTQUIZ SET RIGHT='"+right+"',WRONG='"+wrong+"',TESTCOMPLETED=1,score='"+score+"' WHERE REGS_ID = '"+regsId+"' ");
    }catch(SQLException e){ System.out.println(e.getMessage());}
    }
   
 /////////////////on next button click
    void onNextQues(){
      
        if(!RadioBtnA.isSelected() && !RadioBtnB.isSelected() && !RadioBtnC.isSelected() && !RadioBtnD.isSelected()){
        JOptionPane.showMessageDialog(null,"Selct any option");
        }else{
        if(selectedAns.equals(ans)){
            right++;
        RProgressBar.setValue(right*10);
        }else {  wrong++;
        WProgressBar.setValue(wrong*10);
        }
        if(currentQues==9){
            score=right*10;
            setComplete();
JOptionPane.showMessageDialog(null,"Test Completed");
        currentQues=0;
        this.setVisible(false);
        new ResultFrame(regsId).setVisible(true);
        } 
       enableClearSelection();
        currentQues++;
        if(currentQues==9){nextBtn.setText("Finish");}
        fetchQuiz(randomQues.get(currentQues));
        setData();
        
        }
    }
  
    
    
    
    //CONSTRUCTOR
    public QuizFrame(String regsId,String selectedCourse) {
        initComponents();
       connect();
       
       RProgressBar.setStringPainted(true);
       RProgressBar.setForeground(Color.GREEN);

       WProgressBar.setStringPainted(true);
       WProgressBar.setForeground(Color.RED);
       
       this.regsId=regsId;
       this.selectedCourse = selectedCourse;
       
       generateRandomQues();
      groupBtns();
      nextBtn.setText("Next");
      fetchQuiz(randomQues.get(currentQues));
      setData();
       JOptionPane.showMessageDialog(null, "Start test");
  
        
          
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        quesLabel = new javax.swing.JLabel();
        RadioBtnB = new javax.swing.JRadioButton();
        RadioBtnC = new javax.swing.JRadioButton();
        RadioBtnA = new javax.swing.JRadioButton();
        RadioBtnD = new javax.swing.JRadioButton();
        nextBtn = new javax.swing.JButton();
        RProgressBar = new javax.swing.JProgressBar();
        WProgressBar = new javax.swing.JProgressBar();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("QUIZ");

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        quesLabel.setFont(new java.awt.Font("Times New Roman", 1, 19)); // NOI18N
        jPanel1.add(quesLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 83, 806, 78));

        RadioBtnB.setBackground(new java.awt.Color(153, 153, 255));
        RadioBtnB.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        RadioBtnB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioBtnBActionPerformed(evt);
            }
        });
        jPanel1.add(RadioBtnB, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 237, -1, 40));

        RadioBtnC.setBackground(new java.awt.Color(153, 153, 255));
        RadioBtnC.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        RadioBtnC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioBtnCActionPerformed(evt);
            }
        });
        jPanel1.add(RadioBtnC, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 291, -1, 40));

        RadioBtnA.setBackground(new java.awt.Color(153, 153, 255));
        RadioBtnA.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        RadioBtnA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioBtnAActionPerformed(evt);
            }
        });
        jPanel1.add(RadioBtnA, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 179, -1, 40));

        RadioBtnD.setBackground(new java.awt.Color(153, 153, 255));
        RadioBtnD.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        RadioBtnD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioBtnDActionPerformed(evt);
            }
        });
        jPanel1.add(RadioBtnD, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, -1, 40));

        nextBtn.setBackground(new java.awt.Color(153, 153, 255));
        nextBtn.setFont(new java.awt.Font("Stencil", 1, 18)); // NOI18N
        nextBtn.setText("jButton1");
        nextBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                nextBtnMouseReleased(evt);
            }
        });
        nextBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextBtnActionPerformed(evt);
            }
        });
        jPanel1.add(nextBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 530, 140, 49));

        RProgressBar.setBackground(new java.awt.Color(102, 255, 102));
        RProgressBar.setForeground(new java.awt.Color(102, 255, 102));
        jPanel1.add(RProgressBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 506, 231, 30));

        WProgressBar.setBackground(new java.awt.Color(255, 153, 153));
        WProgressBar.setForeground(new java.awt.Color(255, 153, 153));
        jPanel1.add(WProgressBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 569, 231, 27));

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 790, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 140, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 480, 790, 140));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 633, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setSize(new java.awt.Dimension(890, 672));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void nextBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextBtnActionPerformed
onNextQues();      

      
    }//GEN-LAST:event_nextBtnActionPerformed

    private void RadioBtnDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioBtnDActionPerformed
   
        RadioBtnA.setEnabled(false);
        RadioBtnB.setEnabled(false);
        RadioBtnC.setEnabled(false);
        selectedAns = RadioBtnD.getText();
     
    }//GEN-LAST:event_RadioBtnDActionPerformed

    private void RadioBtnAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioBtnAActionPerformed
    
        RadioBtnB.setEnabled(false);
        RadioBtnC.setEnabled(false);
        RadioBtnD.setEnabled(false);
    selectedAns = RadioBtnA.getText();
    
      
    }//GEN-LAST:event_RadioBtnAActionPerformed

    private void RadioBtnCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioBtnCActionPerformed

        RadioBtnA.setEnabled(false);
        RadioBtnB.setEnabled(false);
        RadioBtnD.setEnabled(false);
    selectedAns = RadioBtnC.getText();    
    }//GEN-LAST:event_RadioBtnCActionPerformed

    private void RadioBtnBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioBtnBActionPerformed

        RadioBtnA.setEnabled(false);
        RadioBtnC.setEnabled(false);
        RadioBtnD.setEnabled(false);
        selectedAns = RadioBtnB.getText();
    }//GEN-LAST:event_RadioBtnBActionPerformed

    private void nextBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextBtnMouseReleased


    }//GEN-LAST:event_nextBtnMouseReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       
       
            


        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new QuizFrame().setVisible(true);
            
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar RProgressBar;
    public static javax.swing.JRadioButton RadioBtnA;
    public static javax.swing.JRadioButton RadioBtnB;
    public static javax.swing.JRadioButton RadioBtnC;
    public static javax.swing.JRadioButton RadioBtnD;
    private javax.swing.JProgressBar WProgressBar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private static javax.swing.JButton nextBtn;
    private javax.swing.JLabel quesLabel;
    // End of variables declaration//GEN-END:variables
}
