/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EBillRecipt;
/**
 *
 * @author Pooja Kumari
 */
public class start {
    public static void main(String []args) throws InterruptedException{
    splash sp = new splash();
    FormFrame ff = new FormFrame();
    sp.show();
   for(int loading=0;loading<=100;loading++){
        Thread.sleep(30);
        sp.setVisible(true);
        sp.ProgressBar.setValue(loading);
        if(loading==100){
        sp.setVisible(false);
        ff.setVisible(true);
               }
        }
    }
    
}
