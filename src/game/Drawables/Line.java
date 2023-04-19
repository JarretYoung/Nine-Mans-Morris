package game.Drawables;

import game.UIComponents.*;
import java.awt.*;

public class Line extends Sprite {
    // attributes
    Color color;
    public Line(Page page, double x, double y, double width, double height, Image baseImage, Color color) {
        super(page, x, y, width, height, baseImage);
        this.color = color;
        //More attributes soon
    }

    public void paint(Graphics2D g) {
        //TODO:
    }
    
    public void tick() {
        //TODO:
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return this.color;
    }
}
