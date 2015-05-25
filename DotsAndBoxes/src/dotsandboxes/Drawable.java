package dotsandboxes;


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
public interface Drawable {
    void    draw(Graphics2D g);
    void    setOwner(final int newOwner);
    int     getOwner();
}
