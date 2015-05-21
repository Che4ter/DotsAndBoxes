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
    
    public Box(final Line newLeft, final Line newTop, final Line newRight, final Line newBottom)
    {
        this.mLeftLine = newLeft;
        this.mTopLine = newTop;
        this.mRightLine = newRight;
        this.mBottomLine = newBottom;
    }
    
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
    public boolean isItMe(final int newMouseX, final int newMouseY)
    {
        return false;
    }
    
    @Override
    public void draw(Graphics g)
    {
        return;
    }
}
