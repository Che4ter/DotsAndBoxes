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
    private int state = 0; //0 = neutral, 1 = Player 1, 2 = Player 2
    private int posX = 0;
    private int posY = 0;
    private int height = 0;
    private int width = 0;
    
    //Konstruktor
    public Line(final int newPosX, final int newPosY, final int newWidth, final int newHeight)
    {
        this.posX = newPosX;
        this.posY = newPosY;
        this.height = newHeight;
        this.width = newWidth;
    }
    
    //Methods
    @Override
    public void draw(Graphics g)
    {
        Color fillColor;
        Color borderColor;
        
        switch(this.state)
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
        g.fillRect(this.posX, this.posY, this.width, this.height);
        g.setColor(borderColor);
        g.drawRect(this.posX, this.posY, this.width, this.height);
    }
    
    @Override
    public void setState(final int newState)
    {
        this.state = newState;
    }
    
    @Override
    public int getState()
    {
        return this.state;
    }
    
    @Override
    public boolean isItMe(final int newMouseX, final int newMouseY)
    {
        return ((this.posX < newMouseX && newMouseX < (this.posX + this.width)) && (this.posY < newMouseY && newMouseY < (this.posY + this.height)));
    }
}
