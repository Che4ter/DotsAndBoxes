/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dotsandboxes;

import javax.swing.JFrame;

/**
 *
 * @author Arakis
 */
public class TestMainPlayGround {
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("PlayGround Sandbox");
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.add(new PlayGround());
        
        frame.pack();
        frame.setVisible(true);
    }
}
