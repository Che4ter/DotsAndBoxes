/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dotsandboxes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author Arakis
 */
public class PlayGround extends JPanel{
    //Attributes
    private final int pxPadding = 20;
    private final int pxDotDiameter = 20;
    private final int pxLineHeight = 8;
    private final int pxLineWidth = 70;
    private Box[][] arrBoxes;
    
    
    //int mPointNumberX = 0;
    //int mPointNumberY = 0;
    
    //private int mDotCountX = 0;
    //private int mDotCountY = 0;
    //private int mCurrentState = 2;
    
    
    private List<Drawable> playGroundElements = new ArrayList<>();
    
    //Konstruktor
    /*public PlayGround(final int pDotCountX, final int pDotCountY, Player p) {
        mDotCountX = pDotCountX;
        mDotCountY = pDotCountY;

        this.setPreferredSize(new Dimension(this.getWidth(pDotCountX), this.getHeight(pDotCountY)));        
    }
    */
    public PlayGround (final Box[][] newBoxArray, Player p)
    {
        this.arrBoxes = newBoxArray;
        this.setPreferredSize(new Dimension(this.getWidth(newBoxArray[0].length), this.getHeight(newBoxArray.length)));
    }
    

     /**
     * Calculates and sets the coordinates for every line
     *
     * @author Adrian Kauz
     */
    public void setCoordsAndSize()
    {
        for(int y = 0; y < this.arrBoxes.length; y++)
        {
            for(int x = 0; x < this.arrBoxes[y].length; x++)
            {
                //Set coordinates for horizontal lines
                if(y == 0) //First Row
                {
                    this.arrBoxes[y][x].getTopLine().setCoords(this.pxPadding + (x * pxLineWidth), this.pxPadding - (this.pxLineHeight / 2), this.pxLineWidth ,this.pxLineHeight);
                    this.arrBoxes[y][x].getBottomLine().setCoords(this.pxPadding + (x * pxLineWidth), this.pxPadding + (pxLineWidth) - (this.pxLineHeight / 2), this.pxLineWidth ,this.pxLineHeight);
                }
                else
                {
                    this.arrBoxes[y][x].getBottomLine().setCoords(this.pxPadding + (x * pxLineWidth), this.pxPadding + ((y + 1) * pxLineWidth) - (this.pxLineHeight / 2), this.pxLineWidth ,this.pxLineHeight);
                }
                
                //Set coordinates for vertical lines
                if(x == 0)
                {
                    this.arrBoxes[y][x].getLeftLine().setCoords(this.pxPadding + (x * pxLineWidth) - (this.pxLineHeight / 2), this.pxPadding + (y * pxLineWidth), this.pxLineHeight ,this.pxLineWidth);
                }
                
                this.arrBoxes[y][x].getRightLine().setCoords(this.pxPadding + ((x + 1) * pxLineWidth) - (this.pxLineHeight / 2), this.pxPadding + (y * pxLineWidth), this.pxLineHeight ,this.pxLineWidth);
            } //-- for()
        } //-- for()
    } //-- setCoordsAndSize()
    
    public List getPlayGroundList()
    {
        return playGroundElements;
    }
    
     /**
     * Refresh PlayGround
     */
    public void repaintPlayGround()
    {
        repaint();
    }
    
    
    /**
     * Draw all Lines and Dots
     *
     * @param g Graphics g
     * @author Adrian Kauz
     */
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        //Draw Lines
        for(int y = 0; y < this.arrBoxes.length; y++)
        {
            for(int x = 0; x < this.arrBoxes.length; x++)
            {
                this.arrBoxes[y][x].draw(g);
            } //-- for()
        } //-- for()
        
        //Draw Points
        for(int y = 0; y <= this.arrBoxes.length; y++)
        {
            for(int x = 0; x <= this.arrBoxes.length; x++)
            {
                g.setColor(Color.DARK_GRAY);
                g.fillOval(this.pxPadding + (x * pxLineWidth) - (this.pxDotDiameter / 2), this.pxPadding + y * pxLineWidth - (this.pxDotDiameter / 2), this.pxDotDiameter, this.pxDotDiameter);
                g.setColor(Color.BLACK);
                g.drawOval(this.pxPadding + (x * pxLineWidth) - (this.pxDotDiameter / 2), this.pxPadding + y * pxLineWidth - (this.pxDotDiameter / 2), this.pxDotDiameter, this.pxDotDiameter);
            } //-- for()
        } //-- for()
    } //-- paintComponent()
    
    
     /**
     * Get panel width in pixel
     *
     * @param newBoxCountX Count of boxes in x-axis
     * @return width in pixel
     * @author Adrian Kauz
     */
    public int getWidth(final int newBoxCountX)
    {
        return (2 * this.pxPadding) + (newBoxCountX * pxLineWidth);
    } //-- getWidth()
    
    
     /**
     * Get panel height in pixel
     *
     * @param newBoxCountY Count of boxes in y-axis
     * @return height in pixel
     * @author Adrian Kauz
     */
    public int getHeight(final int newBoxCountY)
    {
        return (2 * this.pxPadding) + (newBoxCountY * pxLineWidth);
    } //-- getHeight()

    
    /**
     * Set state
     *
     * @param i Status: 0 = Neutral, 1 = Spieler 1, 2 = SPieler 2
     * @author Adrian Kauz
     */
    /*public void setmCurrentState(int i){
    
        this.mCurrentState = i;
    }*/
 }
