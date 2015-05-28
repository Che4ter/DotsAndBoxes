/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dotsandboxes;

import javax.swing.*;

/**
 * @author Arakis
 */
public class TestMainPlayGround
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("PlayGround Sandbox");
        //PlayGround play = new PlayGround(4, 4);

        TestNonsense test = new TestNonsense();
        test.generateBoxes(4, 4);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //frame.add(play);
        //play.generatePlayGround();
        frame.pack();
        frame.setVisible(true);

        //frame.pack();
    }
}
