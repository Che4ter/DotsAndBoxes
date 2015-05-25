/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dotsandboxes;

import java.awt.Graphics;

/**
 *
 * @author Arakis
 */
public class Box implements Drawable{
    //Field
    private Line mLeftLine;
    private Line mTopLine;
    private Line mRightLine;
    private Line mBottomLine;
    private int mState = 0; //0 = neutral, 1 = Player 1, 2 = Player 2
    
    //Konstruktor
    public Box()
    {
        
    }
    
    public boolean boxIsFull()
    {
        return (mLeftLine.getState() > 0 && mRightLine.getState() > 0 && mTopLine.getState() > 0 && mBottomLine.getState() > 0);
    }
    
    @Override
    public void setState(final int newState)
    {
        return;
    }
    
    @Override
    public int getState()
    {
        return this.mState;
    }
    
    @Override
    public void draw(Graphics g)
    {
        //Zeichne Boxeninhalt
        
        //Zeichne Linien
        this.mLeftLine.draw(g);
        this.mTopLine.draw(g);
        this.mRightLine.draw(g);
        this.mBottomLine.draw(g);
    }
    
    //AddLine Methods
    //--------------------------------------------------------------------------
    public void addLeftLine(final Line newLine)
    {
        this.mLeftLine = newLine;
    }
    
    public void addTopLine(final Line newLine)
    {
        this.mTopLine = newLine;
    }
    
    public void addRightLine(final Line newLine)
    {
        this.mRightLine = newLine;
    }
    
    public void addBottomLine(final Line newLine)
    {
        this.mBottomLine = newLine;
    }
    /*
    //setCoords Methods
    //--------------------------------------------------------------------------
    public void setCoordLeftLine(final Line newLine)
    {
        this.mLeftLine = newLine;
    }
    
    public void setCoordTopLine(final Line newLine)
    {
        this.mTopLine = newLine;
    }
    
    public void setCoordRightLine(final Line newLine)
    {
        this.mRightLine = newLine;
    }
    
    public void setCoordBottomLine(final Line newLine)
    {
        this.mBottomLine = newLine;
    }*/
    
    //getLine Methods
    //--------------------------------------------------------------------------
    public Line getLeftLine()
    {
        return this.mLeftLine;
    }
    
    public Line getTopLine()
    {
        return this.mTopLine;
    }
    
    public Line getRightLine()
    {
        return this.mRightLine;
    }
    
    public Line getBottomLine()
    {
        return this.mBottomLine;
    }
}
