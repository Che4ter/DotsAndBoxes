package dotsandboxes;


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
public interface Drawable {
    void draw(Graphics g);
    void setState(final int newState);
    int getState();
}
