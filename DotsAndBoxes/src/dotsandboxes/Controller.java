/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dotsandboxes;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

/**
 *
 * @author mario_000
 */
public class Controller extends JFrame{
    
    private JMenu filemenu;
    private JMenuBar menubar;
    private JMenuItem game; 
    private JLabel playerLabel1;
    private JLabel playerLabel2;
    private JLabel pointsPlayer1;
    private JLabel pointsPlayer2;
    private JLabel players;
    private JLabel points;
    private JPanel informationPanel;
    private JPanel playGroundPanel;
    private Canvas canvas;
    
    
    public Controller(){
    
        super("Dots and Boxes");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(500, 500);
        
        filemenu = new JMenu("File");
        menubar = new JMenuBar();
        game = new JMenuItem("new Game");
        filemenu.add(game);
        menubar.add(filemenu);
        
        playGroundPanel = new JPanel();
        canvas = new Canvas();
        canvas.setBackground(Color.white);
        canvas.setVisible(true);
        canvas.setSize(500,350);
        playGroundPanel.add(canvas);
        
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

        
        
        add(menubar, BorderLayout.NORTH);
        add(informationPanel, BorderLayout.CENTER);
        add(playGroundPanel, BorderLayout.SOUTH);
        

        
        setVisible(true);
        
    }
    
    public void test(){

         
        
        }
}
