/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dotsandboxes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Arakis
 */
public class PlayGround extends JPanel
{
    //Attributes
    final int SIZE_POINT        = 20;
    final int SIZE_PADDING      = 50;
    final int SIZE_LINE_LENGTH  = 60;
    final int SIZE_LINE_HEIGTH  = 6;
    
    int mPointNumberX =0;
    int mPointNumberY=0;
    //Konstruktor
    public PlayGround(final int pWidth, final int pHeigth)
    {
        mPointNumberX=pWidth;
        mPointNumberY=pHeigth;
        
        this.setPreferredSize(new Dimension(this.getPanelWidth(pWidth), this.getPanelHeigth(pHeigth)));        
    }
    

    @Override
    public void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        generatePlayGround(g);
    }
    
    
    //Methods
    public void generatePlayGround( Graphics g)
    {
        int x=SIZE_PADDING;
        int y=SIZE_PADDING;
        
      
        for(int i=0;i<mPointNumberY;i++)
        {
            for(int j=0;j<mPointNumberX;j++)
            {
           
                drawPoint(x,y,g);
                x+=(SIZE_POINT)+SIZE_LINE_LENGTH;
            }
            y+=(SIZE_POINT)+SIZE_LINE_LENGTH;
            x=SIZE_PADDING;
        }
    
    
    }
    
    private void drawPoint(final int pX, final int pY,Graphics g)
    {
        Graphics2D graphics = (Graphics2D)g;
        graphics.setColor(Color.red);
        graphics.fillOval(pX,pY,SIZE_POINT,SIZE_POINT);   
    }
    
    private void drawLine(int pX,int pY,Graphics g)
    {
        Graphics2D graphics = (Graphics2D)g;
        pY=(SIZE_POINT-SIZE_LINE_HEIGTH)/2;
        pX+=2;
        
        graphics.setColor(Color.red);
        graphics.fillRect(pX, pY,SIZE_LINE_LENGTH,SIZE_LINE_HEIGTH-4);   
    }
    
    
    public int[] convertCordToPixel(final int pCordX, final int pCordY)
    {
        
        return null;
    }

    public int[] convertPixelToCord(final int pPixX, final int pPixY)
    {
        
        return null;
    }
    
    private int getPanelHeigth(final int pHeigth)
    {
        return(( 2 * this.SIZE_PADDING) + (pHeigth * this.SIZE_POINT) + ((pHeigth - 1) * this.SIZE_LINE_LENGTH));
    }

    private int getPanelWidth(final int pWidth)
    {
        return 2 * this.SIZE_PADDING + (pWidth * this.SIZE_POINT) + (pWidth - 1) * this.SIZE_LINE_LENGTH;
    
}
    
    
            
            
            
            
            
}
