/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import org.bluray.ui.event.HRcEvent;
import org.dvb.event.UserEvent;
import org.dvb.event.UserEventListener;
import org.dvb.event.UserEventRepository;
import org.dvb.ui.DVBColor;
import org.havi.ui.HComponent;


/**
 *
 * @author student
 */
public class Playfield extends HComponent implements UserEventListener {

    ArrayList slang=new ArrayList();
    int hx=100;
    int hy=100;
    int r=1;    //richting
    int length= 6;
    Graphics apple;
    SlangSegment s;
    boolean hasCollided = false;
    int maxWidth = 720;
    int maxHeight = 576;
    boolean paintApple = true;
    int randX;
    int randY;
    
    public Playfield()
    {
        this.setBounds(0,0,720,576); // full screen
        
        
    }
    
    public void paint(Graphics g)
    {
        g.setColor(new DVBColor(191,227,87,255));
        g.fillRect(0, 0, maxWidth, maxHeight);
        
        for (int i=0;i<slang.size();i++)
        {
            g.setColor(Color.BLACK);
            s=new SlangSegment();
            s=(SlangSegment)slang.get(i);
            
            g.fillOval(s.x,s.y , 10, 10);
                        
        }
        if(paintApple){
            randX =  (int) (Math.floor( (Math.random() * (maxWidth/10)))*10);
            randY =  (int) (Math.floor(Math.random()*(maxHeight/10))*10);   
        }
        paintApples(g);
        
        
        
    }

    
    public void run()
    {
        
        
        
        s=new SlangSegment();
        if (r==1) hx = hx+10;   //rechts
        else if (r==2) hy = hy+10;  //onder
        else if (r==3) hx = hx-10;  //links
        else if (r==4) hy = hy-10;  //boven
        s.x=hx;
        s.y=hy;
        
        
        
        System.out.println(hasCollided);
        checkCollision();
        if(hasCollided == false){
        
            
            
            slang.add(s);
            setLengthSnake(length);
            this.repaint();
        }
        
        
        System.out.println(s.x);
        System.out.println(s.y);
            
        
        
        
        
        
        //setLengthSnake(length);
        
        //this.repaint();
    }
    public void userEventReceived(UserEvent e) {
        if(e.getCode() == HRcEvent.VK_LEFT && r!=1){
            r = 3;
        }
        else if(e.getCode() == HRcEvent.VK_RIGHT && r!=3){
            r = 1;
        }
        else if(e.getCode() == HRcEvent.VK_UP && r!=2){
            r = 4;
        }
        else if(e.getCode() == HRcEvent.VK_DOWN && r!=4){
            r = 2;
        }
        
    }
    
    public void setLengthSnake(int maxLength){
        if(slang.size() == maxLength){
            slang.remove(0);
        }
    }
    public void checkCollision(){
        int xCoordHead = s.x;
        int yCoordHead = s.y;
        for (int i=0;i<slang.size();i++)
        {   
            
            int xCoordSlangDeel = ((SlangSegment)(slang.get(i))).x;
            
            int yCoordSlangDeel = ((SlangSegment)(slang.get(i))).y;
            
            
            
            if(xCoordSlangDeel == xCoordHead && yCoordSlangDeel == yCoordHead ){
                
                hasCollided = true;
            }
            else if(xCoordHead > 720 || xCoordHead < 0 || yCoordHead < 0 || yCoordHead < -580){
                hasCollided = true;
            }
            
        }
        if(xCoordHead == randX && yCoordHead == randY){
            paintApple = true;
            length ++;
        }
    }
    
    public void paintApples (Graphics g){
            g.setColor(Color.RED);
            g.fillOval(randX,randY , 10, 10);
            paintApple = false;
    }
    
    public void CheckAppleCollision(){
        
    }
}

