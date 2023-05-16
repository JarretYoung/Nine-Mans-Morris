package game.Drawables;

import game.UIComponents.Page;

import javax.swing.*;
import java.awt.*;

public class DecorativeSprite extends Sprite {
    public final static double SIZE = 120;
    Image img;

    public DecorativeSprite(Page page, double x, double y, String IMG_PATH) {
        super(page, x, y, SIZE, SIZE, (new ImageIcon(IMG_PATH)).getImage());

    }

    public void paint(Graphics2D g) {
        super.paint(g);
    }
}
