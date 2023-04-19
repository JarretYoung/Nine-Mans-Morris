package game.Drawables;

import game.UIComponents.*;
import java.awt.*;

public class Text extends Drawable {
    Color color;
    Font font;
    String textStr;
    double x;
    double y;
    
    public Text(Page page, Color color, Font font, String textStr, double x, double y) {
        super(page);
        this.color = color;
        this.font = font;
        this.textStr = textStr;
        this.x = x;
        this.y = y;
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

    public void setFont(Font font) {
        this.font = font;
    }

    public void setText(String text) {
        this.textStr = text;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Color getColor() {
        return this.color;
    }

    public Font getFont() {
        return this.font;
    }

    public String getText() {
        return this.textStr;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }
}
