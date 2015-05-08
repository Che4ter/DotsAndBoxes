/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dotsandboxes;

import java.awt.BorderLayout;
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
public class Controller extends JFrame{
    
    private JMenu DotsAndBoxes;
    private JMenuBar file;
    private JMenuItem game; 
    private JLabel label1;
    private JLabel label2;
    
    
    public Controller(){
    
        super("Dots and Boxes");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        label1 = new JLabel("Player 1");
        label2 = new JLabel("Player 2");
        DotsAndBoxes = new JMenu("File");
        file = new JMenuBar();
        game = new JMenuItem("new Game");    
        setLayout(new BorderLayout());
        add(DotsAndBoxes);
        
        
    }
}
