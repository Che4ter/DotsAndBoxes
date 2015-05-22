/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dotsandboxes;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mario_000
 */
public class Player extends MouseAdapter{
    private int points;
    private final String username;
    private boolean active;
    private  int userid;
    //private final List<MadeMoveListener> playerMoveListener = new ArrayList<MadeMoveListener>();
    private MadeMoveListener playerMoveListener;
    
    public Player(String username, int id){
    
        this.userid = id;
        points = 0;
        this.username = username;
        active = false;
    }
    
    
    public int setPoints(){
    
        points++;
        return points;
    }
    
    public void setActive(){
     
        active = true;
    }
    
    public void setInactive(){
     
        active = false;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        /**for(Drawable element : playGroundElements)
        {
            if(element.isItMe(e.getX(), e.getY()))
            {
                element.setState(mCurrentState);
                break;
            }
        }
        repaint();
    **/
        e.consume();
        if(active){
        System.out.println("mousepressed" + userid);
        makeMove(e.getX(), e.getY());
        }
    }
    
    public void makeMove(int x, int y){
    
        
        //for(MadeMoveListener listener : playerMoveListener){
        
        //    listener.nextMove(4);
        //}
        playerMoveListener.nextMove(x, y, userid);
    }
    
    public void  addMadeMoveListener(MadeMoveListener listener){
    
        playerMoveListener = (listener);
    }
    
    
}


