package dotsandboxes;

import java.awt.Color;
import java.awt.Graphics2D;

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
    private int mOwner = 0; //0 = neutral, 1 = Player 1, 2 = Player 2
    private int mPosX = 0;
    private int mPosY = 0;
    private int mHeight = 0;
    private int mWidth = 0;
    
    //Konstruktor
    public Line(){}
    
    //Methods
    @Override
    public void draw(Graphics2D g2)
    {
        Color fillColor;
        Color borderColor;
        
        switch(this.mOwner)
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
                borderColor = Color.DARK_GRAY;
                break;
        }
        
        g2.setColor(fillColor);
        g2.fillRect(this.mPosX, this.mPosY, this.mWidth, this.mHeight);
        g2.setColor(borderColor);
        g2.drawRect(this.mPosX, this.mPosY, this.mWidth, this.mHeight);
    } //-- draw()
    
    
    @Override
    public void setOwner(final int newOwner)
    {
        System.out.println(newOwner);
        this.mOwner = newOwner;
    } //-- setOwner()
    
    
    @Override
    public int getOwner()
    {
        return this.mOwner;
    } //-- getOwner()
    
    
    public boolean isItMe(final int newMouseX, final int newMouseY, final int newRadius)
    {
        if(this.mHeight < this.mWidth)
        {
            //Horizontal line
            return (((this.mPosX + newRadius) < newMouseX && newMouseX < (this.mPosX + this.mWidth - newRadius)) && (this.mPosY < newMouseY && newMouseY < (this.mPosY + this.mHeight)));
        }
        else
        {
            //Vertical line
            return ((this.mPosX < newMouseX && newMouseX < (this.mPosX + this.mWidth)) && ((this.mPosY + newRadius) < newMouseY && newMouseY < (this.mPosY + this.mHeight - newRadius)));
        }
    } //-- isItMe();
    
    
    public void setCoords(final int newPosX, final int newPosY, final int newWidth, final int newHeight)
    {
        this.mPosX = newPosX;
        this.mPosY = newPosY;
        this.mHeight = newHeight;
        this.mWidth = newWidth;
    } //-- setCoords()
    
    
    public int getPosX()
    {
        return this.mPosX;
    } //-- getPosX()
    
    
    public int getPosY()
    {
        return this.mPosY;
    } //-- getPosX()
    
    
    public int getHeight()
    {
        return this.mHeight;
    } //-- getHeight()
    
    
    public int getWidth()
    {
        return this.mWidth;
    } //-- getWidth()
}
