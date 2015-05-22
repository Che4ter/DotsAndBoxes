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


    public Player(String username, int id){
        this.userid = id;
        points = 0;
        this.username = username;
        active = false;
    }

    public int setPoints(){

        points++;
        return points;
    }

    public void setActive(){

        active = true;
    }

    public void setInactive(){

        active = false;
    }

    public void makeMove(int x, int y)
    {
        playerMoveListener.nextMove(x, y, userid);
    }

    public void  addMadeMoveListener(MadeMoveListener listener){

        playerMoveListener = (listener);
    }

    public abstract void yourTurn();

}


