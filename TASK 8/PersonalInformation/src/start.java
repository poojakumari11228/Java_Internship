
public class start {
public static void main(String []args) throws InterruptedException{
    splash sp = new splash();
    sp.setVisible(true);
    
    for(int i=0;i<=50;i++){

            Thread.sleep(20);
        if(i==50){
        sp.setVisible(false);
        new firstFrame().setVisible(true);
        }
    }
}    
}
