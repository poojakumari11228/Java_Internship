
package quizapp;
/**
 *
 * @author Pooja kumari
 */
public class QuizApp {

    public static void main(String[] args) throws InterruptedException {
         splash sp = new splash();
    HomeFrame hf = new HomeFrame();
    sp.show();
   for(int loading=0;loading<=50;loading++){
        Thread.sleep(20);
        sp.setVisible(true);
        if(loading==50){
        sp.setVisible(false);
        hf.setVisible(true);
               }
        }
    }
    
}
