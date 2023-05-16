package game.Drawables;

import game.UIComponents.*;
import java.awt.*;

public class Text extends Drawable {
    private static Color defaultColor = new Color(255,255,255);
    private static String defaultFontStr = "Arial";
    private Color color;
    private Font font;
    private String textStr;
    private double x;
    private double y;
    private boolean center;
    public Text(Page page, String textStr, double x, double y,boolean center) {
        super(page);
        this.font = new Font(defaultFontStr,Font.PLAIN,20);
        this.color = defaultColor;
        this.textStr = textStr;
        this.x = x;
        this.y = y;
        this.center = center;
    }

    public Text(Page page, String textStr, double x, double y, boolean center, Color color, String font, int size) {
        super(page);
        this.font = new Font(font,Font.BOLD,size);
        this.color = color;
        this.textStr = textStr;
        this.x = x;
        this.y = y;
        this.center = center;
    }

    // draw text
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

    @Override
    public void tick() {
    }

    public void setTextStr(String textStr) {
        this.textStr = textStr;
    }
}


