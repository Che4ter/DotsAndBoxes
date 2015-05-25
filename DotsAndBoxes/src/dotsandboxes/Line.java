package dotsandboxes;

import java.awt.Color;
import java.awt.Graphics;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Surri
 */
public class Line implements Drawable{
    //Field
    private int mState = 0; //0 = neutral, 1 = Player 1, 2 = Player 2
    private int mPosX = 0;
    private int mPosY = 0;
    private int mHeight = 0;
    private int mWidth = 0;
    
    //Konstruktor
    public Line(){}
    
    //Methods
    @Override
    public void draw(Graphics g)
    {
        Color fillColor;
        Color borderColor;
        
        switch(this.mState)
        {
            case 1:
                fillColor = Color.BLUE;
                borderColor = Color.BLACK;
                break;
            case 2:
                fillColor = Color.RED;
                borderColor = Color.BLACK;
                break;
            default:
                fillColor = new Color(220,220,220);
                borderColor = Color.LIGHT_GRAY;
                break;
        }
        
        g.setColor(fillColor);
        g.fillRect(this.mPosX, this.mPosY, this.mWidth, this.mHeight);
        g.setColor(borderColor);
        g.drawRect(this.mPosX, this.mPosY, this.mWidth, this.mHeight);
    }
    
    @Override
    public void setState(final int newState)
    {
        System.out.println(newState);
        this.mState = newState;
    }
    
    @Override
    public int getState()
    {
        return this.mState;
    }
    
    
    public boolean isItMe(final int newMouseX, final int newMouseY)
    {
        return ((this.mPosX < newMouseX && newMouseX < (this.mPosX + this.mWidth)) && (this.mPosY < newMouseY && newMouseY < (this.mPosY + this.mHeight)));
    } //-- isItMe();
    
    public void setCoords(final int newPosX, final int newPosY, final int newWidth, final int newHeight)
    {
        this.mPosX = newPosX;
        this.mPosY = newPosY;
        this.mHeight = newHeight;
        this.mWidth = newWidth;
    } //-- setCoords()
}
