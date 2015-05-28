package dotsandboxes;

import java.awt.*;

/**
 * @author Surri
 */
public interface Drawable
{
    void draw(Graphics2D g);

    int getOwner();

    void setOwner(final int newOwner);
}
