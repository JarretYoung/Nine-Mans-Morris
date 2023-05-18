package game.UIComponents;

import javax.swing.*;
import java.awt.*;

public class Mouse {
    private double mousePosX;
    private double mousePosY;
    private Cursor cursor;
    private Panel panel;

    private static Mouse mouse = null;
    private MorrisMouseListener mouseListener;

    /**
     *
     * @return
     */
    public MorrisMouseListener getMouseListener() {return mouseListener;}

    /**
     *
     * @return
     */
    public static Mouse getInstance() {
        if(Mouse.mouse==null) {Mouse.mouse = new Mouse();}
        return Mouse.mouse;
    }

    /**
     *
     */
    private Mouse() {
        this.mouseListener = new MorrisMouseListener();
    }

    /**
     *
     * @param frame
     */
    protected void tickStart(Frame frame) {
        Point p = MouseInfo.getPointerInfo().getLocation();
        SwingUtilities.convertPointFromScreen(p, frame);
        this.mousePosX = p.getX()-8; // constants to make this align with the window
        this.mousePosY = p.getY()-31; // constants to make this align with the window
    }

    /**
     *
     */
    protected void tickEnd() {
        this.mouseListener.tick();
        this.panel.setCursor(this.getCursor());
    }

    // 1 = left click, 2 = middle click, 3 = right click
    /**
     *
     * @param button
     * @return
     */
    public boolean clicked(int button) {return this.mouseListener.clicked(button);}

    /**
     *
     * @param button
     * @return
     */
    public boolean held(int button) {return this.mouseListener.held(button);}

    // left click
    /**
     *
     * @return
     */
    public boolean leftClicked() {return this.clicked(1);}

    // mouse position
    /**
     *
     * @return
     */
    public double x() {return mousePosX;}
    /**
     *
     * @return
     */
    public double y() {return mousePosY;}

    // mouse cursor
    /**
     *
     * @return
     */
    public Cursor getCursor() {return cursor;}

    /**
     *
     * @param cursor
     */
    public void setCursor(Cursor cursor) {this.cursor = cursor;}

    // set panel
    /**
     *
     * @param panel
     */
    public void setPanel(Panel panel) {this.panel = panel;}
}
