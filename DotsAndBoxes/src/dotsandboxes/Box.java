/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dotsandboxes;

import java.awt.*;

/**
 * @author Adrian Kauz
 */
public class Box implements Drawable
{
    //Field
    private Line mLeftLine;
    private Line mTopLine;
    private Line mRightLine;
    private Line mBottomLine;
    private int mOwner = 0; //0 = neutral, 1 = Player 1, 2 = Player 2

    //Konstruktor
    public Box()
    {
    }

    /**
     * Returns true if box is full
     *
     * @return Result as Boolean
     *
     */
    public boolean isFull()
    {
        return (mLeftLine.getOwner() > 0 && mRightLine.getOwner() > 0 && mTopLine.getOwner() > 0 && mBottomLine.getOwner() > 0);
    } //-- isFull()


    public Line getLineIfClicked(final int newPosX, final int newPosY, final int newRadius)
    {
        if (this.mLeftLine.isItMe(newPosX, newPosY, newRadius))
        {
            return this.mLeftLine;
        }

        if (this.mTopLine.isItMe(newPosX, newPosY, newRadius))
        {
            return this.mTopLine;
        }

        if (this.mRightLine.isItMe(newPosX, newPosY, newRadius))
        {
            return this.mRightLine;
        }

        if (this.mBottomLine.isItMe(newPosX, newPosY, newRadius))
        {
            return this.mBottomLine;
        }

        return null;
    } //-- getLineIfClicked()

    /**
     * Counts neutral sides of the box
     *
     * @return Count of neutral sides of the box as Integer (For A.I.)
     * @author Adrian Kauz
     */
    public int getNeutralSideCount()
    {
        int counter = 0;

        if (this.mLeftLine.getOwner() > 0)
        {
            counter++;
        }

        if (this.mTopLine.getOwner() > 0)
        {
            counter++;
        }

        if (this.mRightLine.getOwner() > 0)
        {
            counter++;
        }

        if (this.mBottomLine.getOwner() > 0)
        {
            counter++;
        }

        return 4 - counter;
    } //-- getNeutralSideCount()

    @Override
    public int getOwner()
    {
        return this.mOwner;
    } //-- getOwner()

    @Override
    public void setOwner(final int newOwner)
    {
        this.mOwner = newOwner;
    } //-- setOwner()

    @Override
    public void draw(Graphics2D g2)
    {
        int boxPosX = this.mTopLine.getPosX();
        int boxPosY = this.mTopLine.getPosY();
        int boxLength = this.mTopLine.getWidth();

        //Zeichne Boxeninhalt
        GradientPaint gradient;

        switch (this.mOwner)
        {
            case 1:
                gradient = new GradientPaint(boxPosX, boxPosY, new Color(0, 0, 255), boxPosX + boxLength, boxPosY + boxLength, new Color(51, 204, 255), false);
                break;
            case 2:
                gradient = new GradientPaint(boxPosX, boxPosY, new Color(255, 0, 0), boxPosX + boxLength, boxPosY + boxLength, new Color(255, 153, 0), false);
                break;
            default:
                gradient = new GradientPaint(boxPosX, boxPosY, new Color(150, 150, 150), boxPosX + boxLength, boxPosY + boxLength, new Color(230, 230, 230), false);
                break;
        } //-- switch()

        g2.setPaint(gradient);
        g2.fillRect(boxPosX, boxPosY, boxLength, boxLength);
    } //-- draw()


    //AddLine Methods
    //--------------------------------------------------------------------------
    public void addLeftLine(final Line newLine)
    {
        this.mLeftLine = newLine;
    } //-- addLeftLine()

    public void addTopLine(final Line newLine)
    {
        this.mTopLine = newLine;
    } //-- addTopLine()

    public void addRightLine(final Line newLine)
    {
        this.mRightLine = newLine;
    } //-- addRightLine()

    public void addBottomLine(final Line newLine)
    {
        this.mBottomLine = newLine;
    } //-- addBottomLine()


    //getLine Methods
    //--------------------------------------------------------------------------
    public Line getLeftLine()
    {
        return this.mLeftLine;
    } //-- getLeftLine()

    public Line getTopLine()
    {
        return this.mTopLine;
    } //-- getTopLine()

    public Line getRightLine()
    {
        return this.mRightLine;
    } //-- getRightLine()

    public Line getBottomLine()
    {
        return this.mBottomLine;
    } //-- getBottomLine()
}
