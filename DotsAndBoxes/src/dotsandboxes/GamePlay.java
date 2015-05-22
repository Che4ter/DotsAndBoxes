/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dotsandboxes;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author mario_000
 */


public class GamePlay implements MadeMoveListener{
    

    private PlayGround playGroundPanel;
    private JPanel informationPanel;
    private InformationPanel infoPanel;
    private Player[] players;
    private int activePlayer;
    private boolean drawline;
    

    public GamePlay(){
        
        players = new Player[2];
        players[0] = new LocalPlayer("Player 1", 1); //lokaler Spieler
        players[1] = new LocalPlayer("Player 2", 2);
        playGroundPanel = new PlayGround(4, 4, players[0]);
        infoPanel = new InformationPanel();
        informationPanel = infoPanel.getinformationPanel();
        activePlayer = 1; //startet immer mit Spieler 2
        players[0].addMadeMoveListener(this);
        players[1].addMadeMoveListener(this);
        changePlayer();

                
    }

    public void changePlayer(){

        if(this.activePlayer == 1){
            players[0].setInactive();
            players[1].setActive();
            this.activePlayer = 2;
            playGroundPanel.addMouseListener((LocalPlayer)players[1]);
            playGroundPanel.removeMouseListener((LocalPlayer)players[0]);
            System.out.println("change from 1 to 2");
            updatePoints();
            infoPanel.changeNextPlayer();
        } else{
        
            players[1].setInactive();
            players[0].setActive();
            this.activePlayer = 1;
            playGroundPanel.addMouseListener((LocalPlayer)players[0]);
            playGroundPanel.removeMouseListener((LocalPlayer)players[1]);
            System.out.println("change from 2 to 1");
            updatePoints();
            infoPanel.changeNextPlayer();
        }

    }
    
    public void updatePoints(){
        int i = players[activePlayer -1].getPoints();
        infoPanel.updatePointsLabel(Integer.toString(i)) ;
    }
  
    public PlayGround getPlayGroundPanel(){
    
        return playGroundPanel;
    }

    public JPanel getinformationPanel(){
    
        return informationPanel;
    }
    
    @Override
    public void nextMove(int x, int y, int id) {
        System.out.println("nextMoveID" + id);
        if(id == this.activePlayer){
         List<Drawable> playGroundElements = playGroundPanel.getPlayGroundList();
        for(Drawable element : playGroundElements)
            {
                if(element.isItMe(x, y) && element.getState() == 0)
                {
                    element.setState(activePlayer);
                    players[activePlayer -1].setPoints();
                    changePlayer();
                    break;
                }
            }
            
            playGroundPanel.repaint();
            
        } else{
        
            System.out.println("player" + id + "not active");
        }
        
        
//System.out.println("mademove Listener" + x + y);
    }
}
