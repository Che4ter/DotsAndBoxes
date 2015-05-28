/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dotsandboxes;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
//import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
/**
 *
 * @author mario_000
 */
public class Controller extends JFrame implements ActionListener, GameFinishedListener,GameSetupListener
{
    private final JMenu filemenu;
    private final JMenuBar menubar;
    private final JMenuItem newLocalGame;
    private final JMenuItem newNetworkGame;
    private final JMenuItem saveGame;
    private final JMenuItem closeGame;
    private JPanel informationPanel;
    private PlayGround playGroundPanel;
    private JPanel localGameSetupPanel;
    private GameSetupDialog setupDialog;
    private GamePlay game;
    public Controller(){
        super("Dots and Boxes");
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        //setMinimumSize(new Dimension(500, 500));
        
        filemenu = new JMenu("Game Setup");
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
        this.setMinimumSize(new Dimension(400, 300));
        setVisible(true);

    }
    
    public void newLocalGame(String pPlayerName1, String pPlayerName2,int pX,int pY){
        generateGame(pPlayerName1, pPlayerName2, pX, pY);

        setVisible(true);        
        this.pack();
        }
        
        public void generateGame(String pPlayerName1, String pPlayerName2,int pX,int pY){
         game = new GamePlay( pPlayerName1,  pPlayerName2, pX, pY);
        game.AddgameFinishedListener(this);
            playGroundPanel = game.getPlayGroundPanel();
        playGroundPanel.setCoordsAndSize();
        playGroundPanel.repaintPlayGround();
        
        add(playGroundPanel, BorderLayout.SOUTH);       
        informationPanel = game.getinformationPanel();
        add(informationPanel, BorderLayout.CENTER);
}

    public void closeGame(){
        System.exit(0); //Close program
        this.dispose(); //Close window
        this.setVisible(false); //Hide window
        
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == this.newLocalGame){
            //int x = Integer.parseInt(JOptionPane.showInputDialog("test"));
            
           //clearRunningGame();
            setupDialog=new GameSetupDialog(this);
            setupDialog.addGameSetupListener(this);
        }

        if(e.getSource() == this.newNetworkGame){
        }

        if(e.getSource() == this.saveGame){
        }

        else if(e.getSource() == this.closeGame){
           exitGame();
        }   
    }


    public void exitGame()
    {
        System.exit(0); //Close program
        this.dispose(); //Close window
        this.setVisible(false); //Hide window
    }

    @Override
    public void newGameSetup(String pPlayerName1, String pPlayerName2,int pX,int pY)
    {
        clearPanel();
        newLocalGame(pPlayerName1,pPlayerName2,pX,pY);
    }
    
    public void clearPanel(){
    
        if(playGroundPanel != null){
        
            this.remove(playGroundPanel);
            this.remove(informationPanel);
            this.repaint();
            game= null;
            repaint();
        }
    }

    @Override
    public void GameFinished() {
        
        Object[] options = {"neues Spiel","Spiel beenden"};
        //int n = JOptionPane.showOptionDialog(playGroundPanel, getWinner(), JOptionPane.YES_NO_OPTION,null, options, options[0]);

        int n = JOptionPane.showOptionDialog(playGroundPanel,game.getWinner(),"Spiel Ende",JOptionPane.YES_NO_OPTION,  JOptionPane.QUESTION_MESSAGE, null, options,options[0]);
        
        if(n==0){
             
            clearPanel();
            setupDialog=new GameSetupDialog(this);
            setupDialog.addGameSetupListener(this);
        }else{
            
            closeGame();

        }
        
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
