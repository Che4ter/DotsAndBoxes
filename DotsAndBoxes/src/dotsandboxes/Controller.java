/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dotsandboxes;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
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
public class Controller extends JFrame implements ActionListener, GameFinishedListener
{
    private final JMenu filemenu;
    private final JMenuBar menubar;
    private final JMenuItem newLocalGame;
    private final JMenuItem newNetworkGame;
    private final JMenuItem saveGame;
    private final JMenuItem closeGame;
    private JPanel informationPanel;
    private PlayGround playGroundPanel;
    private GamePlay game1;
    
    
    public Controller(){
        super("Dots and Boxes");
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        game1 = new GamePlay();
        game1.AddgameFinishedListener(this);
        playGroundPanel = game1.getPlayGroundPanel();
        playGroundPanel.setCoordsAndSize();
        playGroundPanel.repaintPlayGround();
        
        add(playGroundPanel, BorderLayout.SOUTH);       
        informationPanel = game1.getinformationPanel();
        add(informationPanel, BorderLayout.CENTER);
        
        /**if(game1.isFinished()){
        
            if(game1.gameFinished() == 0){
                
                clearPanel();
                newLocalGame();
            }else{
        
            closeGame();
            }
        
        } **/
            
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

            clearPanel();
            newLocalGame();
            
        }

        if(e.getSource() == this.newNetworkGame){
        }

        if(e.getSource() == this.saveGame){
        }

        if(e.getSource() == this.closeGame){
            
        }   
    }
    
    public void clearPanel(){
    
        if(playGroundPanel != null){
        
            this.remove(playGroundPanel);
            this.remove(informationPanel);
            this.repaint();
            game1 = null;
            repaint();
        }
    }

    @Override
    public void GameFinished() {
        
        Object[] options = {"neues Spiel","Spiel beenden"};
        //int n = JOptionPane.showOptionDialog(playGroundPanel, getWinner(), JOptionPane.YES_NO_OPTION,null, options, options[0]);

        int n = JOptionPane.showOptionDialog(playGroundPanel,game1.getWinner(),"Spiel Ende",JOptionPane.YES_NO_OPTION,  JOptionPane.QUESTION_MESSAGE, null, options,options[0]);
        
        if(n==0){
             
            clearPanel();
            newLocalGame();
        }else{
            
            closeGame();

        }
        
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
