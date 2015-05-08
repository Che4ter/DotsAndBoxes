/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dotsandboxes;

import java.awt.BorderLayout;
import java.awt.GridLayout;
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
    
    private JMenu filemenu;
    private JMenuBar menubar;
    private JMenuItem game; 
    private JLabel label1;
    private JLabel label2;
    private JPanel panel1;
    private JPanel panel2;
    
    
    public Controller(){
    
        super("Dots and Boxes");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel1 = new JPanel();
        setLayout(new BorderLayout());
        
        label1 = new JLabel("Player 1");
        label2 = new JLabel("Player 2");
        filemenu = new JMenu("File");
        menubar = new JMenuBar();
        game = new JMenuItem("new Game");
        filemenu.add(game);
        menubar.add(filemenu);
        setJMenuBar(menubar);
        
        panel2 = new JPanel();
        panel2.setLayout(new GridLayout(1,2));
        panel2.add(label1);
        panel2.add(label2);
        add(panel2);
        
        setVisible(true);
        
    }
}
