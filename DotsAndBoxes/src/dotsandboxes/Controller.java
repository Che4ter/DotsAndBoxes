/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dotsandboxes;

import java.awt.BorderLayout;
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
import javax.swing.JOptionPane;
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
    private JPanel informationPanel;
    private PlayGround playGroundPanel;
    
    
    public Controller(){
        
        super("Dots and Boxes");
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        //setMinimumSize(new Dimension(500, 500));
        
        filemenu = new JMenu("File");
        menubar = new JMenuBar();
        newLocalGame = new JMenuItem("New local Game");
        newNetworkGame = new JMenuItem("New network Game");
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
        
        generateGame();

        setVisible(true);        
        this.pack();
        }
        
        public void generateGame(){
        GamePlay game1 = new GamePlay();
        playGroundPanel = game1.getPlayGroundPanel();
        playGroundPanel.generatePlayGround();
        add(playGroundPanel, BorderLayout.SOUTH);       
        informationPanel = game1.getinformationPanel();
        add(informationPanel, BorderLayout.CENTER);
    }
                
        @Override
        public void actionPerformed(ActionEvent e){
        
        if(e.getSource() == this.newLocalGame){

        //int x = Integer.parseInt(JOptionPane.showInputDialog("test"));
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
