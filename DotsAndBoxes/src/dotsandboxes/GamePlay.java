/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dotsandboxes;

import javax.swing.*;

/**
 * @author mario_000
 */

public class GamePlay implements MadeMoveListener
{

    //Field
    private PlayGround playGroundPanel;
    private Box[][] arrBoxes;
    private JPanel informationPanel;
    private InformationPanel infoPanel;
    private Player[] players;
    private int activePlayer;
    private GameFinishedListener finishedListener;


    public GamePlay(String pPlayerName1, String pPlayerName2, int pX, int pY)
    {
        players = new Player[2];
        players[0] = new LocalPlayer(pPlayerName1, 1); //lokaler Spieler
        players[1] = new LocalPlayer(pPlayerName2, 2);

        //Generiere Box-Array
        this.arrBoxes = generateBoxArray(pX, pY);
        playGroundPanel = new PlayGround(this.arrBoxes, players[0]);

        infoPanel = new InformationPanel(pPlayerName1, pPlayerName2);
        informationPanel = infoPanel.getinformationPanel();
        activePlayer = 1; //startet immer mit Spieler 2
        players[0].addMadeMoveListener(this);
        players[1].addMadeMoveListener(this);
        changePlayer();
    } //-- GamePlay()


    public void changePlayer()
    {
        if (this.activePlayer == 1)
        {
            players[0].setActive(false);
            players[1].setActive(true);
            this.activePlayer = 2;
            playGroundPanel.addMouseListener((LocalPlayer) players[1]);
            playGroundPanel.removeMouseListener((LocalPlayer) players[0]);
            System.out.println("change from 1 to 2");
            infoPanel.changeNextPlayer();
        }
        else
        {
            players[0].setActive(true);
            players[1].setActive(false);
            this.activePlayer = 1;
            playGroundPanel.addMouseListener((LocalPlayer) players[0]);
            playGroundPanel.removeMouseListener((LocalPlayer) players[1]);
            System.out.println("change from 2 to 1");
            infoPanel.changeNextPlayer();
        }
    } //-- changePlayer()


    public void updatePoints()
    {
        int i = players[activePlayer - 1].getPoints();
        infoPanel.updatePointsLabel(Integer.toString(i));
    } //-- updatePoints()

    public PlayGround getPlayGroundPanel()
    {
        return playGroundPanel;
    } //-- getPlayGroundPanel()

    public JPanel getinformationPanel()
    {
        return informationPanel;
    } //-- getinformationPanel()

    @Override
    public void nextMove(final int newPosX, final int newPosY, int id)
    {
        System.out.println("nextMoveID" + id);
        if (id == this.activePlayer)
        {
            boolean bPlayerHasClickedANeutralLine = false;
            boolean bPlayerHasFilledABox = false;

            //First check Lines
            for (Box[] arrBoxes : this.arrBoxes)
            {
                for (Box box : arrBoxes)
                {
                    Line clickedLine = box.getLineIfClicked(newPosX, newPosY, playGroundPanel.getDotRadius());

                    if (clickedLine != null && clickedLine.getOwner() == 0)
                    {
                        bPlayerHasClickedANeutralLine = true;
                        clickedLine.setOwner(activePlayer);
                    }
                } //-- for()
            } //-- for()

            if (bPlayerHasClickedANeutralLine)
            {
                //Now check boxes
                for (Box[] arrBoxes : this.arrBoxes)
                {
                    for (Box box : arrBoxes)
                    {
                        if (box.isFull() && box.getOwner() == 0)
                        {
                            bPlayerHasFilledABox = true;
                            box.setOwner(activePlayer);
                        }
                    } //-- for()
                } //-- for()
            }

            if (bPlayerHasClickedANeutralLine && !bPlayerHasFilledABox)
            {
                changePlayer();
            }

            players[0].setPoints(playGroundPanel.getBoxCountByOwner(1));
            players[1].setPoints(playGroundPanel.getBoxCountByOwner(2));

            playGroundPanel.repaint();
            updatePoints();
            //infoPanel.repaint();
        }
        else
        {
            System.out.println("player" + id + "not active");
        }

        if (isFinished())
        {
            gameFinished();
        }
    } //-- nextMove()


    /**
     * Counts neutral sides of the box
     *
     * @param pBoxCountX Width
     * @param pBoxCountY Height
     * @return 2d-Array of boxes
     * @author Adrian Kauz
     */
    public Box[][] generateBoxArray(final int pBoxCountX, final int pBoxCountY)
    {
        //Generiere zuerst die Boxen
        Box[][] boxes = new Box[pBoxCountY][pBoxCountX];

        for (int y = 0; y < pBoxCountY; y++)
        {
            for (int x = 0; x < pBoxCountX; x++)
            {
                boxes[y][x] = new Box();
            } //-- for()
        } //-- for()

        //Befülle nun die Boxen mit den Linien
        for (int y = 0; y < pBoxCountY; y++)
        {
            for (int x = 0; x < pBoxCountX; x++)
            {
                //Horizontale Linien
                if (y == 0) //Erste Reihe
                {
                    boxes[y][x].addTopLine(new Line());
                }
                else
                {
                    Line newHLine = new Line();
                    boxes[y - 1][x].addBottomLine(newHLine);
                    boxes[y][x].addTopLine(newHLine);

                    if (y == pBoxCountY - 1) //Letzte Reihe
                    {
                        boxes[y][x].addBottomLine(new Line());
                    }
                }

                //Vertikale Linien
                if (x == 0) //Erste Reihe
                {
                    boxes[y][x].addLeftLine(new Line());
                }
                else
                {
                    Line newVLine = new Line();
                    boxes[y][x - 1].addRightLine(newVLine);
                    boxes[y][x].addLeftLine(newVLine);

                    if (x == pBoxCountX - 1) //Letzte Reihe
                    {
                        boxes[y][x].addRightLine(new Line());
                    }
                }
            } //-- for()
        } //-- for()

        return boxes;
    } //-- generateBoxArray()

    public boolean isFinished()
    {

        boolean finished = true;
        for (Box[] arrBoxes : this.arrBoxes)
        {
            for (Box box : arrBoxes)
            {
                if (!box.isFull())
                {
                    finished = false;
                }
            }
        }

        return finished;
    }

    public void gameFinished()
    {
        finishedListener.GameFinished();
    }

    public String getWinner()
    {

        if (players[0].getPoints() != players[1].getPoints())
        {
            if (players[0].getPoints() > players[1].getPoints())
            {
                return "Gewonnen hat " + players[0].username + " mit " + players[0].getPoints() + " Punkten";
            }
            else
            {

                return "Gewonnen hat " + players[1].username + " mit " + players[1].getPoints() + " Punkten";
            }
        }
        else
        {
            return "Unentschieden";
        }
    }

    public void AddgameFinishedListener(GameFinishedListener e)
    {

        finishedListener = e;
    }
}
