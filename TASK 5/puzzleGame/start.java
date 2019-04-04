/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzleGame;

/**
 *
 * @author POOJA KUMARI
 */
public class start {
    public static void main(String args[]) throws InterruptedException{
        splash sp = new splash();
       startFrame sf = new startFrame();      
       int x=5;
        for(int loading=0;loading<=100;loading++){
        Thread.sleep(30);
        sp.setVisible(true);
        sp.loadingBar.setValue(loading);
        if(loading==100){
        sp.setVisible(false);
        sf.setVisible(true);
               }
        }
    
    }
}
