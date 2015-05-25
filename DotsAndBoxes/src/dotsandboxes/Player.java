/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dotsandboxes;

/**
 *
 * @author mario_000
 */
public abstract class Player
{
    protected int points;
    protected final String username;
    protected boolean active;
    protected int userid;
    protected MadeMoveListener playerMoveListener;


    public Player(String username, int id)
    {
        this.userid = id;
        this.points = 0;
        this.username = username;
        this.active = false;
    }

    public int setPoints(final int newPoints)
    {
        this.points = newPoints;
        return points;
    }

    public int getPoints()
    {
        return this.points;
    }
        
    public void setActive(final boolean newActiveState)
    {
        this.active = newActiveState;
    }

    public void makeMove(int x, int y)
    {
        this.playerMoveListener.nextMove(x, y, userid);
    }

    public void  addMadeMoveListener(MadeMoveListener listener)
    {
        this.playerMoveListener = (listener);
    }

    public abstract void yourTurn();
}


