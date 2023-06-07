package game.Drawables;

import game.UIComponents.*;

import javax.swing.*;
import java.awt.*;

/**
 *  Line class which extends Sprite used to display lines on the game
 *
 * @author Ong Chien Ming
 * @version 1.0 25/4/2023
 */
public class Line extends Sprite {
    // attributes
    public static final double LINE_WIDTH = 8; // how large the line is
    public final static String IMG_PATH = "images/blackSquare.png";

    /**
     *
     * @param page page that the sprite is on
     * @param pos1 first location of the line on the main axis
     * @param pos2 second location of the line on the main axis
     * @param otherMidPoint location of the line on the secondary axis
     * @param isHorizontal whether x is the main axis or not
     */
    public Line(Page page, double pos1, double pos2, double otherMidPoint,boolean isHorizontal) {
        super(page,
                isHorizontal ? (pos1 + pos2)/2 : otherMidPoint, // x
                !isHorizontal ? (pos1 + pos2)/2 : otherMidPoint, // y
                isHorizontal ? pos2 - pos1 : LINE_WIDTH, // width
                !isHorizontal ? pos2 - pos1 : LINE_WIDTH, // height
                (new ImageIcon(IMG_PATH)).getImage());

    }


}
