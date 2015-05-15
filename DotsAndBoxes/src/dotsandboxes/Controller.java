/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dotsandboxes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
/**
 *
 * @author mario_000
 */
public class Controller extends JFrame implements ActionListener{
    
    private final JMenu filemenu;
    private final JMenuBar menubar;
    private final JMenuItem newLocalGame;
    private final JMenuItem newNetworkGame;
    private final JMenuItem saveGame;
    private final JMenuItem closeGame;
    private JLabel playerLabel1;
    private JLabel playerLabel2;
    private JLabel pointsPlayer1;
    private JLabel pointsPlayer2;
    private JLabel players;
    private JLabel points;
    private JPanel informationPanel;
    private PlayGround playGroundPanel;
    
    
    public Controller(){
    
        super("Dots and Boxes");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setMinimumSize(new Dimension(500, 500));
        
        filemenu = new JMenu("File");
        menubar = new JMenuBar();
        newLocalGame = new JMenuItem("New local Game");
        newNetworkGame = new JMenuItem("new network Game");
        saveGame =  new JMenuItem("Save Game");
        closeGame = new JMenuItem("Close Game");
        
        filemenu.add(newLocalGame);
        filemenu.add(newNetworkGame);
        filemenu.add(saveGame);
        filemenu.add(closeGame);
        menubar.add(filemenu);
        add(menubar, BorderLayout.NORTH);
        
        newLocalGame.addActionListener(this);
        newNetworkGame.addActionListener(this);
        saveGame.addActionListener(this);
        closeGame.addActionListener(this);

        setVisible(true);
        this.pack();
    }
    
    public void newLocalGame(){

        playGroundPanel = new PlayGround(4, 4);     
        
        informationPanel = new JPanel();
        informationPanel.setLayout(new GridLayout(3,2));   
        
        players = new JLabel("Players");
        points = new JLabel("Points");
        playerLabel1 = new JLabel("Player 1");
        
        Font font = new Font("Courier", Font.BOLD,15);    
        points.setFont(font);
        players.setFont(font);
        playerLabel2 = new JLabel("Player 2");
        pointsPlayer1 = new JLabel("0");
        pointsPlayer2 = new JLabel("0");
        informationPanel.add(players);
        informationPanel.add(points);
        informationPanel.add(playerLabel1);
        informationPanel.add(pointsPlayer1);
        informationPanel.add(playerLabel2);
        informationPanel.add(pointsPlayer2);       

        
        

        add(informationPanel, BorderLayout.CENTER);
        add(playGroundPanel, BorderLayout.SOUTH);
        

        setVisible(true);
        this.pack();
        
        }
        
        @Override
        public void actionPerformed(ActionEvent e){
        
        if(e.getSource() == this.newLocalGame){
        newLocalGame();
        }
        
        if(e.getSource() == this.newNetworkGame){
        
            
        }
        
        if(e.getSource() == this.saveGame){
        
            
            
        }
        
        if(e.getSource() == this.closeGame){
        
            System.exit(0); //Close program
            this.dispose(); //Close window
            this.setVisible(false); //Hide window

        }
        
    }
}
