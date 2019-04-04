/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobileinventory;

/**
 *
 * @author POOJA KUMARI
 */
public class startApp {
    public static void main(String args[]) throws InterruptedException{
        Splash sp = new Splash();
        sp.setVisible(true);
        int progress=0;
        for(; progress<=100; progress++){
        Thread.sleep(20);
       // sp.ProgressNum.setText(Integer.toString(progress)+"%");
        sp.ProgressBar.setValue(progress);
        
          if(progress==100){
        sp.setVisible(false);
         new mobInventoryFrame().setVisible(true);
        
        }
        }
      
    }
    
    
}
