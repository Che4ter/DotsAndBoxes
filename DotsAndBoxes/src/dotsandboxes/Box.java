/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dotsandboxes;

/**
 *
 * @author Arakis
 */
public class Box {
    //Field
    private Line mLeftLine;
    private Line mTopLine;
    private Line mRightLine;
    private Line mBottomLine;
    private int mState = 0; //0 = neutral, 1 = Player 1, 2 = Player 2
    
    //Konstruktor
    public Box(final Line newLeft, final Line newTop, final Line newRight, final Line newBottom)
    {
        this.mLeftLine = newLeft;
        this.mTopLine = newTop;
        this.mRightLine = newRight;
        this.mBottomLine = newBottom;
    }
    
    public boolean boxIsFull()
    {
        return (mLeftLine.getState() > 0 && mRightLine.getState() > 0 && mTopLine.getState() > 0 && mBottomLine.getState() > 0);
    }
    
    public int getState()
    {
        return this.mState;
    }
}
