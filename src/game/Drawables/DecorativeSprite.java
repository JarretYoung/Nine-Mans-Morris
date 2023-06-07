package game.Drawables;

import game.UIComponents.Page;

import javax.swing.*;
import java.awt.*;

/**
 *  DecorativeSprite which extends Sprite which is used to display image that is used as decorations
 *
 * @author Ong Chien Ming
 * @version 1.0 16/5/2023
 */
public class DecorativeSprite extends Sprite {
    public final static double SIZE = 120;
    Image img;

    /**
     * constructor
     * @param page page that the sprite is on
     * @param x horizontal coordinate position of the sprite
     * @param y vertical coordinate position of the sprite
     * @param IMG_PATH path where the image is stored
     */
    public DecorativeSprite(Page page, double x, double y, String IMG_PATH) {
        super(page, x, y, SIZE, SIZE, (new ImageIcon(IMG_PATH)).getImage());

    }

    /**
     * paint
     * @param g graphic object
     */
    public void paint(Graphics2D g) {
        super.paint(g);
    }
}
