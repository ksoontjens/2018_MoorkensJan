package hellotvxlet;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.tv.xlet.*;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;
import org.havi.ui.HStaticText;
import org.havi.ui.HTextButton;
import org.havi.ui.HVisible;
import org.havi.ui.event.HActionListener;
import org.bluray.ui.event.HRcEvent;


public class HelloTVXlet implements Xlet, HActionListener {

    public static int moveNr = 1;
    
  HScene scene;
    public HelloTVXlet() {
        
    }

    public void initXlet(XletContext context) {
      HScene scene = HSceneFactory.getInstance().getDefaultHScene();
    }

    public void startXlet() {
    
    }

    public void pauseXlet() {
     
    }

    public void destroyXlet(boolean unconditional) {
     
    }

    public void actionPerformed(ActionEvent arg0) {
        System.out.println(arg0.getActionCommand());
    }
    
    public int keyPressed(int key){
        if (key == HRcEvent.VK_LEFT){ 
            moveNr = 1;
        }
        if (key == HRcEvent.VK_RIGHT){
            moveNr = 2;
        }
        if (key == HRcEvent.VK_DOWN){
            moveNr = 3;
        }
        if (key == HRcEvent.VK_UP) {
            moveNr = 4;
        }
                
        return moveNr;
        
        
    }
}
    

