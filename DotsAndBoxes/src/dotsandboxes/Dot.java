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
public class Dot implements Drawable
{
    //Field
    private int state = 0; //0 = neutral, 1 = Player 1, 2 = Player 2
    private int posX = 0;
    private int posY = 0;
    private int diameter = 0;
    
    //Konstruktor
    public Dot(final int newPosX, final int newPosY, final int newDiameter)
    {
        this.posX = newPosX - (newDiameter / 2); //Nullpunkt beim Mittelpunkt
        this.posY = newPosY - (newDiameter / 2); //Nullpunkt beim Mittelpunkt
        this.diameter = newDiameter;
    }
    
    //Methods
    @Override
    public void draw(Graphics g)
    {
        switch(this.state)
        {
            case 1:
                g.setColor(Color.BLUE);
                break;
            case 2:
                g.setColor(Color.RED);
                break;
            default:
                g.setColor(Color.DARK_GRAY);
                break;
        }
        
        g.fillOval(this.posX, this.posY, this.diameter, this.diameter);
        g.setColor(Color.BLACK);
        g.drawOval(this.posX, this.posY, this.diameter, this.diameter);
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
}
