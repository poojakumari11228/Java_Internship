
package MEMO;

import com.sbix.jnotify.NPosition;
import com.sbix.jnotify.NoticeType;
import com.sbix.jnotify.NoticeWindow;
import java.awt.AWTException;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Thread.sleep;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Pooja kumari
 */
public class Home extends javax.swing.JFrame {

    public static View v;
     public static Add m;
     public static Alert a;
     public static String date,time;     
        //for connection
   public static Connection con;
   public static Statement st;
  public static  ResultSet rs;
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
   public  static void fetchAll(){
       try{
 
           st = con.createStatement();
  rs = st.executeQuery("SELECT * FROM TASKLIST where TODOTIME='"+time+"' AND TODODATE=TO_CHAR(SYSDATE,'YYYY-MM-DD') ");

    while(rs.next()){
        System.out.println("exist");
    new NoticeWindow(NoticeType.SUCCESS_NOTIFICATION,"Alert you have something to do!"+"\n"+rs.getString("TITLE"),NoticeWindow.LONG_DELAY,NPosition.TOP_RIGHT);
    a = new Alert("SELECT * FROM TASKLIST WHERE ID = '"+rs.getString("ID")+"' " );
    a.setVisible(true);   
}
//    else{
  System.out.println("doesnot exist");
//
       System.out.println("---------------------------------------------------------------");
//    
//    }
 }catch(Exception ex){
 System.out.println(ex.getMessage());
 }
    }
   
   ///for time 
   void time(){
 
       Thread clock = new Thread(){
        public  void run()
        { 

            try {
            for(;;){
            
    Calendar c = new GregorianCalendar();
    int day =c.get(Calendar.DAY_OF_MONTH);
    int month =c.get(Calendar.MONTH)+1;
    int year =c.get(Calendar.YEAR);
   
String sec =Integer.toString(c.get(Calendar.SECOND));                                                                        
   if(sec.length()==1){
       sec = "0"+sec;
   }
   String hour =Integer.toString(c.get(Calendar.HOUR_OF_DAY));                                                                      
   if(hour.length()==1){
       hour = "0"+hour;
         
   }
    String min =Integer.toString(c.get(Calendar.MINUTE));                                                                      
   if(min.length()==1){
      min = "0"+min;
         
   }
   
    timeLabel.setText(hour+":"+min+":"+sec);
    dateLabel.setText(day+":"+month+":"+year);
    date= year+"-"+month+"-"+day;
    time= hour+":"+min+":"+sec;
  //  System.out.println("time : "+time);
       
        fetchAll();
        sec="";
        hour="";
        min="";
            sleep(1000);   // for 1 sec
            }
            } catch (InterruptedException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            }
       };
       clock.start();
    }
    public Home() {
        connect();
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addBtn.setVisible(false);
        viewAndSearchBtn.setVisible(false);
        exitBtn.setVisible(false);
          //   startWindow();
        //     startThread();      
//time();


    
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        addBtn = new javax.swing.JButton();
        viewAndSearchBtn = new javax.swing.JButton();
        exitBtn = new javax.swing.JButton();
        dateLabel = new javax.swing.JLabel();
        timeLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(0, 0, 204));

        jLabel4.setFont(new java.awt.Font("Snap ITC", 1, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("AlertMe!");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(473, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 310, 648);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MEMO/circle.png"))); // NOI18N
        jLabel1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jLabel1FocusGained(evt);
            }
        });
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel1MouseExited(evt);
            }
        });
        jPanel1.add(jLabel1);
        jLabel1.setBounds(778, 469, 150, 150);

        addBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MEMO/plus.gif"))); // NOI18N
        addBtn.setText("ADD");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });
        jPanel1.add(addBtn);
        addBtn.setBounds(740, 122, 210, 200);

        viewAndSearchBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MEMO/viewsearch.gif"))); // NOI18N
        viewAndSearchBtn.setText("VIEW");
        viewAndSearchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewAndSearchBtnActionPerformed(evt);
            }
        });
        jPanel1.add(viewAndSearchBtn);
        viewAndSearchBtn.setBounds(490, 200, 240, 220);

        exitBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MEMO/exit.png"))); // NOI18N
        exitBtn.setText("EXIT");
        exitBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        exitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBtnActionPerformed(evt);
            }
        });
        jPanel1.add(exitBtn);
        exitBtn.setBounds(410, 430, 260, 200);

        dateLabel.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        dateLabel.setForeground(new java.awt.Color(0, 0, 204));
        dateLabel.setText("DATE :");
        jPanel1.add(dateLabel);
        dateLabel.setBounds(760, 60, 190, 40);

        timeLabel.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        timeLabel.setForeground(new java.awt.Color(0, 0, 204));
        timeLabel.setText("TIME");
        jPanel1.add(timeLabel);
        timeLabel.setBounds(760, 20, 190, 40);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MEMO/icons8-watch-48.png"))); // NOI18N
        jPanel1.add(jLabel2);
        jLabel2.setBounds(700, 10, 50, 50);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MEMO/icons8-calendar-48.png"))); // NOI18N
        jPanel1.add(jLabel3);
        jLabel3.setBounds(700, 60, 50, 40);

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

        setSize(new java.awt.Dimension(976, 687));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
//        this.setVisible(false);
       m = new Add();
       m.setVisible(true);
    }//GEN-LAST:event_addBtnActionPerformed

    private void viewAndSearchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewAndSearchBtnActionPerformed
//    this.setVisible(false);
    v =  new View();
       v.setVisible(true);
    }//GEN-LAST:event_viewAndSearchBtnActionPerformed

    private void exitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBtnActionPerformed
System.exit(0);
    }//GEN-LAST:event_exitBtnActionPerformed

    private void jLabel1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jLabel1FocusGained

    }//GEN-LAST:event_jLabel1FocusGained

    private void jLabel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseEntered
        addBtn.setVisible(true);
        viewAndSearchBtn.setVisible(true);
        exitBtn.setVisible(true);
    }//GEN-LAST:event_jLabel1MouseEntered

    private void jLabel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseExited

        
    }//GEN-LAST:event_jLabel1MouseExited

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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
              //  new Home().setVisible(true);
            
             startWindow();
             startThread();
           }
        });
    }
    /////////////////
    
	public static int i = 0;
	public static JLabel jLabel = new JLabel();
	public static Thread thread = null;
	public static PopupMenu popupMenu;
	public static MenuItem relaunchMenuItem;
	public static void startThread(){
		thread = new Thread(new Runnable() {
				@Override
				public void run() 
					   
        { 

            try {
            for(;;){
            
    Calendar c = new GregorianCalendar();
    int day =c.get(Calendar.DAY_OF_MONTH);
    int month =c.get(Calendar.MONTH)+1;
    int year =c.get(Calendar.YEAR);
   
String sec =Integer.toString(c.get(Calendar.SECOND));                                                                        
   if(sec.length()==1){
       sec = "0"+sec;
   }
   String hour =Integer.toString(c.get(Calendar.HOUR_OF_DAY));                                                                      
   if(hour.length()==1){
       hour = "0"+hour;
         
   }
    String min =Integer.toString(c.get(Calendar.MINUTE));                                                                      
   if(min.length()==1){
      min = "0"+min;
         
   }
   
    timeLabel.setText(hour+":"+min+":"+sec);
    dateLabel.setText(day+":"+month+":"+year);
    date= year+"-"+month+"-"+day;
    time= hour+":"+min+":"+sec;
    System.out.println("time : "+time);
       
        fetchAll();
        sec="";
        hour="";
        min="";
            sleep(1000);   // for 1 sec
            }
            } catch (InterruptedException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
            
				}
		});
		thread.start();
	}
	public static void startWindow(){

	 Home h = new Home();
             h.setVisible(true);	
                        h.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		if(SystemTray.isSupported()){
			SystemTray systemTray = SystemTray.getSystemTray();
			popupMenu = new PopupMenu("Setting");
			MenuItem quitMenuItem = new MenuItem("Quit");
			quitMenuItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
//					thread.stop();
					System.exit(0);
				}
			});
			relaunchMenuItem = new MenuItem("Launch");
			relaunchMenuItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					h.setVisible(true);
				}
			});
			
			popupMenu.add(relaunchMenuItem);
			popupMenu.add(quitMenuItem);
//			Image image = TrayIcon
			TrayIcon trayIcon = new TrayIcon(Toolkit.getDefaultToolkit().getImage("java.png"), "JavaApp", popupMenu );
			try {
				systemTray.add(trayIcon);
			} catch (AWTException e1) {
				e1.printStackTrace();
			}
		}else{
			System.out.println("System tray isn't supported");
		}
	}

    
////////////////////
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private static javax.swing.JLabel dateLabel;
    private javax.swing.JButton exitBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private static javax.swing.JLabel timeLabel;
    private javax.swing.JButton viewAndSearchBtn;
    // End of variables declaration//GEN-END:variables
}
