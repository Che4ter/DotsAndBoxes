/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dotsandboxes;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
    private final int pxDotDiameter = 14;
    private final int pxLineHeight = 7;
    private final int pxLineWidth = 50;
    
    
    //int mPointNumberX = 0;
    //int mPointNumberY = 0;
    
    private int mDotCountX = 0;
    private int mDotCountY = 0;
    private int mCurrentState = 2;
    
    
    private List<Drawable> playGroundElements = new ArrayList<>();
    
    //Konstruktor
    public PlayGround(final int pDotCountX, final int pDotCountY, Player p[]) {
        mDotCountX = pDotCountX;
        mDotCountY = pDotCountY;

        this.setPreferredSize(new Dimension(this.getWidth(pDotCountX), this.getHeight(pDotCountY)));

        this.addMouseListener(p[0]);
        this.addMouseListener(p[1]);
    }
        
        /*        
        {
          @Override
          public void mousePressed(MouseEvent e)
          {
            for(Drawable element : playGroundElements)
            {
                if(element.isItMe(e.getX(), e.getY()))
                {
                    element.setState(mCurrentState);
                    break;
                }
            }
            repaint();

          }
        });
    }
    
    public void chooseLine(){
    }
    */
    
    //Methods
    
    public List getPlayGroundList(){
    
        return playGroundElements;
    }
    
    public void repaintPlayGround(){
    
        repaint();
    }
    
    public void generatePlayGround() {
        //Generate Horizontal Line
        for(int x = 0; x < mDotCountX - 1; x++)
        {
            for(int y = 0; y < mDotCountY; y++)
            {
                playGroundElements.add(new Line(this.pxPadding + (x * pxLineWidth), this.pxPadding + (y * pxLineWidth) - (this.pxLineHeight / 2), this.pxLineWidth ,this.pxLineHeight));
            }
        }

        //Generate Vertical Line
        for(int x = 0; x < mDotCountX; x++)
        {
            for(int y = 0; y < mDotCountY - 1; y++)
            {
                playGroundElements.add(new Line(this.pxPadding + (x * pxLineWidth) - (this.pxLineHeight / 2), this.pxPadding + (y * pxLineWidth), this.pxLineHeight ,this.pxLineWidth));
            }
        }
        
        //Generate Dots
        for(int x = 0; x < mDotCountX; x++)
        {
            for(int y = 0; y < mDotCountY; y++)
            {
                playGroundElements.add(new Dot(this.pxPadding + x * pxLineWidth, this.pxPadding + y * pxLineWidth, this.pxDotDiameter));
            }
        }
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        for(Drawable element : playGroundElements)
        {
            element.draw(g);
        }
    }
    
    public int getWidth(final int newDotCountX)
    {
        return (2 * this.pxPadding) + ((newDotCountX - 1) * pxLineWidth);
    }
    
    public int getHeight(final int newDotCountY)
    {
        return (2 * this.pxPadding) + ((newDotCountY - 1) * pxLineWidth);
    }

    public void setmCurrentState(int i){
    
        this.mCurrentState = i;
    }
 }
