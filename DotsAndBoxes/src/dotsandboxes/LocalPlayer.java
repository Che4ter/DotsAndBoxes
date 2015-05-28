package dotsandboxes;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by philipp on 5/22/15.
 */
public class LocalPlayer extends Player implements MouseListener
{

    public LocalPlayer(String username, int id){
        super(username,id);

    }


    @Override
    public void mousePressed(MouseEvent e) {

        if(active){
            System.out.println("mousepressed" + userid);
            makeMove(e.getX(), e.getY());

        }
    }





    @Override
    public void mouseClicked(MouseEvent e)
    {
        System.out.println("Ignore Mouseclicked Event");
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
        System.out.println("Ignore MouseReleased Event");
    }

    @Override
    public void mouseEntered(MouseEvent e)
    {
        System.out.println("Ignore MouseEntered Event");

    }

    @Override
    public void mouseExited(MouseEvent e)
    {
        System.out.println("Ignore MouseExited Event");

    }

    public void yourTurn()
    {
        System.out.println("Waiting for Input from Local Player");
    }

}