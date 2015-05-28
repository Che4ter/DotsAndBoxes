package dotsandboxes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by philipp on 5/28/15.
 */
public class GameSetupDialog extends JFrame
{
    private JLabel player1Label;
    private JLabel player2Label;
    private JLabel boxxSizeLabel;
    private JLabel boxySizeLabel;
    private JLabel infoMessage;
    public JButton okButton;
    private JButton cancelButton;
    private JTextField player1Name;
    private JTextField player2Name;
    private JTextField xSize;
    private JTextField ySize;
    private JPanel settingsPanel;
    private JLabel errorLabel;
    protected GameSetupListener mgameSetupListener;

    public GameSetupDialog(ActionListener pactionListener)
    {
        this.setTitle("Neues Lokales Spiel");
        settingsPanel = new JPanel();
        settingsPanel.setLayout(new GridLayout(6, 2));

        player1Label = new JLabel("Name Player 1");
        player2Label = new JLabel("Name Player 2");
        boxxSizeLabel= new JLabel("Horizontale Grösse");
        boxySizeLabel= new JLabel("Verticale Grösse");
        errorLabel = new JLabel();
        player1Name = new JTextField();
        player2Name = new JTextField();

        xSize = new JTextField();
        ySize = new JTextField();

        okButton = new JButton("Starten");
        okButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                setupGame();
            }
        });
        cancelButton = new JButton("Abbrechen");
        cancelButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                setVisible(false);

            }
        });
        okButton.addActionListener(pactionListener);
        cancelButton.addActionListener(pactionListener);

        settingsPanel.add(player1Label);
        settingsPanel.add(player1Name);
        settingsPanel.add(player2Label);
        settingsPanel.add(player2Name);
        settingsPanel.add(boxxSizeLabel);
        settingsPanel.add(xSize);
        settingsPanel.add(boxySizeLabel);
        settingsPanel.add(ySize);
        settingsPanel.add(okButton);
        settingsPanel.add(cancelButton);
        settingsPanel.add(errorLabel);
        this.add(settingsPanel);
        this.setMinimumSize(new Dimension(200,100));
        this.pack();
        this.setVisible(true);
    }




    public void setupGame()
    {
        System.out.println("Player 1 Name:"+player1Name.getText());
        System.out.println("Player 2 Name:"+player2Name.getText());

        if(player1Name.getText().isEmpty()|| player2Name.getText().isEmpty() || xSize.getText().isEmpty()||ySize
                .getText().isEmpty())
        {
            errorLabel.setText("Bitte alles Ausfüllen");
            System.out.println("Input Error");
        }
        else
        {
            try
            {
                int x = Integer.parseInt(xSize.getText());
                int y = Integer.parseInt(ySize.getText());
                System.out.println("Box Size x:"+x+" y:"+y);

                if(x<2 || y<2)
                {
                    errorLabel.setText("Grösse muss grösser als 2 sein");

                }
                else
                {
                    setVisible(false);
                    this.mgameSetupListener.newGameSetup(player1Name.getText(), player2Name.getText(), x,y);

                }
            }
            catch (Exception ex)
            {
                errorLabel.setText("Ungültige Box Grösse");

            }

        }
    }

    public void  addGameSetupListener(GameSetupListener listener)
    {
        this.mgameSetupListener = (listener);
    }
}
