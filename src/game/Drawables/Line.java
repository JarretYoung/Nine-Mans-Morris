package game.Drawables;

import game.UIComponents.*;

import javax.swing.*;
import java.awt.*;

public class Line extends Sprite {
    // attributes
    public static final double LINE_WIDTH = 8; // how large the line is
    public final static String IMG_PATH = "images/blackSquare.png";
    //Color color;
    public Line(Page page, double pos1, double pos2, double otherMidPoint,boolean isHorizontal) {
        super(page,
                isHorizontal ? (pos1 + pos2)/2 : otherMidPoint, // x
                !isHorizontal ? (pos1 + pos2)/2 : otherMidPoint, // y
                isHorizontal ? pos2 - pos1 : LINE_WIDTH, // width
                !isHorizontal ? pos2 - pos1 : LINE_WIDTH, // height
                (new ImageIcon(IMG_PATH)).getImage());
        //this.color = color;
        //More attributes soon
    }


    /*
    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return this.color;
    }
    */
}
