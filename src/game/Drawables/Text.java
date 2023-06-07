package game.Drawables;

import game.UIComponents.*;
import java.awt.*;

/**
 *  Text class which extends Drawable which deals with texts
 *
 * @author Ong Chien Ming
 * @version 1.0 19/4/2023
 */
public class Text extends Drawable {
    private static Color defaultColor = new Color(255,255,255);
    private static String defaultFontStr = "Arial";
    private Color color;
    private Font font;
    private String textStr;
    private double x;
    private double y;
    private boolean center;

    /**
     * constructor
     * @param page page that the sprite is on
     * @param textStr content of the text
     * @param x horizontal coordinate position of the sprite
     * @param y vertical coordinate position of the sprite
     * @param center whether the text is left aligned or center aligned
     */
    public Text(Page page, String textStr, double x, double y,boolean center) {
        super(page);
        this.font = new Font(defaultFontStr,Font.PLAIN,20);
        this.color = defaultColor;
        this.textStr = textStr;
        this.x = x;
        this.y = y;
        this.center = center;
    }

    /**
     * constructor
     * @param page page that the sprite is on
     * @param textStr content of the text
     * @param x horizontal coordinate position of the sprite
     * @param y vertical coordinate position of the sprite
     * @param center whether the text is left aligned or center aligned
     * @param color text colour
     * @param font text font
     * @param size text font size
     */
    public Text(Page page, String textStr, double x, double y, boolean center, Color color, String font, int size) {
        super(page);
        this.font = new Font(font,Font.BOLD,size);
        this.color = color;
        this.textStr = textStr;
        this.x = x;
        this.y = y;
        this.center = center;
    }

    /**
     * drawing the text on the screen
     * @param g2d graphic object
     */
    @Override
    public void paint(Graphics2D g2d) {
        g2d.setColor(this.color);
        g2d.setFont(this.font);
        if(this.center) { // if this text should be centered
            Font f = g2d.getFont();
            FontMetrics fm = g2d.getFontMetrics(f);
            // get width of text
            double width = fm.getStringBounds(this.textStr,g2d).getWidth();
            // get height of text
            double height = fm.getStringBounds(this.textStr, g2d).getHeight()*0.6522; // constant calculated via trial and error
            // center and draw
            g2d.drawString(this.textStr,(int) (this.x - width/2),(int) (this.y + height/2));
        }
        else {
            // draw
            g2d.drawString(this.textStr,(int) this.x,(int) this.y);
        }

    }

    /**
     * do nothing
     */
    @Override
    public void tick() {
    }

    /**
     * setter
     * @param textStr string of text
     */
    public void setTextStr(String textStr) {
        this.textStr = textStr;
    }
}


