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
    
    //Konstruktor
    public PlayGround()
    {
        this.add(new JLabel("Label Test"));
        
    
    }
    
    private void doDrawing(Graphics g) 
    {

        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.blue);

        for (int i = 0; i <= 1000; i++) {

            Dimension size = getSize();
            Insets insets = getInsets();

            int w = size.width - insets.left - insets.right;
            int h = size.height - insets.top - insets.bottom;

            Random r = new Random();
            int x = Math.abs(r.nextInt()) % w;
            int y = Math.abs(r.nextInt()) % h;
            g2d.drawLine(x, y, x, y);
        }
    }

    @Override
    public void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        doDrawing(g);
    }

    
    //Methods
    public void generatePlayGround(final int pWidth, final int pHeigth)
    {
        
    }
    
    public int[] convertCordToPixel(final int pCordX, final int pCordY)
    {
        
        return null;
    }

    public int[] convertPixelToCord(final int pPixX, final int pPixY)
    {
        
        return null;
    }
    
    
            
            
            
            
            
}
