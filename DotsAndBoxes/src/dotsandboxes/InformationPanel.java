/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dotsandboxes;

import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author mario_000
 */
public class InformationPanel {
    private JPanel informationPanel;
    private JLabel nextMoveLabel;
    private JLabel moveP1Label;
    private JLabel moveP2Label;
    private JLabel playerLabel1;
    private JLabel playerLabel2;
    private JLabel pointsPlayer1;
    private JLabel pointsPlayer2;
    private JLabel players;
    private JLabel points;
        
    public InformationPanel() {
    
        
        informationPanel = new JPanel();
        informationPanel.setLayout(new GridLayout(3,3));   
        
        players = new JLabel("Players");
        points = new JLabel("Points");
        nextMoveLabel = new JLabel ("next");
        playerLabel1 = new JLabel("Player 1");        
        Font font = new Font("Courier", Font.BOLD,15);    
        points.setFont(font);
        players.setFont(font);
        nextMoveLabel.setFont(font);
        moveP1Label = new JLabel(Character.toString((char)9658));
        moveP2Label = new JLabel(Character.toString((char)9658));
        moveP2Label.setVisible(false);
        playerLabel2 = new JLabel("Player 2");
        pointsPlayer1 = new JLabel("0");
        pointsPlayer2 = new JLabel("0");
        informationPanel.add(nextMoveLabel);
        informationPanel.add(players);
        informationPanel.add(points);
        informationPanel.add(moveP1Label);
        informationPanel.add(playerLabel1);
        informationPanel.add(pointsPlayer1);
        informationPanel.add(moveP2Label);
        informationPanel.add(playerLabel2);
        informationPanel.add(pointsPlayer2);
    }
    
    public JPanel getinformationPanel(){
    
        return informationPanel;
    }
    
    public void changeNextPlayer(){
    
        if( moveP2Label.isVisible() == false){
        
            moveP1Label.setVisible(false);
            moveP2Label.setVisible(true);
        } else{
             
            moveP1Label.setVisible(true);
            moveP2Label.setVisible(false);
        }
    }
    
    public void updatePointsLabel(String points){
    
        if( moveP2Label.isVisible() == false){
        
            pointsPlayer1.setText(points);
        } else{
            pointsPlayer2.setText(points);
        }
        
        informationPanel.repaint();
    }
}
