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
import java.awt.RenderingHints;
import javax.swing.JPanel;

/**
 *
 * @author Arakis
 */

public class PlayGround extends JPanel{
    //Field
    private final int pxPadding = 20;
    private final int pxDotDiameter = 14;
    private final int pxLineHeight = 8;
    private final int pxLineWidth = 70;
    private Box[][] arrBoxes;
    private boolean clearPanel=false;

    //Konstruktor
    public PlayGround (final Box[][] newBoxArray, Player p)
    {
        this.arrBoxes = newBoxArray;
        this.setPreferredSize(new Dimension(this.getWidth(newBoxArray[0].length), this.getHeight(newBoxArray.length)));
    } //-- PlayGround()
    

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
                    this.arrBoxes[y][x].getTopLine().setCoords(this.pxPadding + (x * pxLineWidth),
                                                               this.pxPadding - (this.pxLineHeight / 2), 
                                                               this.pxLineWidth ,
                                                               this.pxLineHeight);
                    
                    this.arrBoxes[y][x].getBottomLine().setCoords(this.pxPadding + (x * pxLineWidth),
                                                                  this.pxPadding + (pxLineWidth) - (this.pxLineHeight / 2),
                                                                  this.pxLineWidth ,
                                                                  this.pxLineHeight);
                }
                else
                {
                    this.arrBoxes[y][x].getBottomLine().setCoords(this.pxPadding + (x * pxLineWidth),
                                                                  this.pxPadding + ((y + 1) * pxLineWidth) - (this.pxLineHeight / 2),
                                                                  this.pxLineWidth,
                                                                  this.pxLineHeight);
                }
                
                //Set coordinates for vertical lines
                if(x == 0)
                {
                    this.arrBoxes[y][x].getLeftLine().setCoords(this.pxPadding + (x * pxLineWidth) - (this.pxLineHeight / 2),
                                                                this.pxPadding + (y * pxLineWidth),
                                                                this.pxLineHeight,
                                                                this.pxLineWidth);
                }
                
                this.arrBoxes[y][x].getRightLine().setCoords(this.pxPadding + ((x + 1) * pxLineWidth) - (this.pxLineHeight / 2),
                                                             this.pxPadding + (y * pxLineWidth),
                                                             this.pxLineHeight,
                                                             this.pxLineWidth);
            } //-- for()
        } //-- for()
    } //-- setCoordsAndSize()

    
    public void repaintPlayGround()
    {
        this.repaint();
    } //-- repaintPlayGround()
    
    
    public int getDotRadius()
    {
        return this.pxDotDiameter / 2;
    } //-- getDotRadius()
    
    
    /**
     * Counts every box witch belongs to submitted owner nr
     *
     * @param newOwnerNr as Integer
     * @return Number of boxes witch belongs to submitted owner
     * @author Adrian Kauz
     */
    public int getBoxCountByOwner(final int newOwnerNr)
    {
        int count = 0;
        
        for (Box[] arrBoxes : this.arrBoxes)
        {
            for (Box box : arrBoxes)
            {
                if(box.getOwner() == newOwnerNr)
                    count++;
            } //-- for()
        } //-- for()
        
        return count;
    } //-- getBoxCountByOwner()
    
    
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

        if (!clearPanel)
        {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            //Draw boxes
            for (Box[] arrBoxes : this.arrBoxes)
                for (Box box : arrBoxes)
                    box.draw(g2);

            //Draw lines
            for (int y = 0; y < this.arrBoxes.length; y++)
            {
                for (int x = 0; x < this.arrBoxes[y].length; x++)
                {
                    //Draw horizontal lines
                    if (y == 0)
                        this.arrBoxes[y][x].getTopLine().draw(g2);

                    this.arrBoxes[y][x].getBottomLine().draw(g2);

                    //Draw vertical lines
                    if (x == 0)
                        this.arrBoxes[y][x].getLeftLine().draw(g2);

                    this.arrBoxes[y][x].getRightLine().draw(g2);
                } //-- for()
            } //-- for()


            //Draw Points
            int pointCounterX = this.arrBoxes[0].length + 1;
            int pointCounterY = this.arrBoxes.length + 1;

            for (int y = 0; y < pointCounterY; y++)
            {
                for (int x = 0; x < pointCounterX; x++)
                {
                    g2.setColor(Color.DARK_GRAY);
                    g2.fillOval(this.pxPadding + (x * pxLineWidth) - (this.pxDotDiameter / 2), this.pxPadding + y * pxLineWidth - (this.pxDotDiameter / 2), this.pxDotDiameter, this.pxDotDiameter);
                    g2.setColor(Color.BLACK);
                    g2.drawOval(this.pxPadding + (x * pxLineWidth) - (this.pxDotDiameter / 2), this.pxPadding + y * pxLineWidth - (this.pxDotDiameter / 2), this.pxDotDiameter, this.pxDotDiameter);
                } //-- for()
            } //-- for()
        } //-- paintComponent()
    }
    
    
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

    public void clearPlayGround()
    {
        clearPanel=true;
        this.removeAll();
        this.repaintPlayGround();
        clearPanel=false;
    }
 }
