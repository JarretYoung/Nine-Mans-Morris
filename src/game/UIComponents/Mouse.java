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
     * getter
     * @return mouse listener
     */
    public MorrisMouseListener getMouseListener() {return mouseListener;}

    /**
     * singleton function
     * @return self
     */
    public static Mouse getInstance() {
        if(Mouse.mouse==null) {Mouse.mouse = new Mouse();}
        return Mouse.mouse;
    }

    /**
     * constructor
     */
    private Mouse() {
        this.mouseListener = new MorrisMouseListener();
    }

    /**
     * calculate mouse position
     * @param frame game frame
     */
    protected void tickStart(Frame frame) {
        Point p = MouseInfo.getPointerInfo().getLocation();
        SwingUtilities.convertPointFromScreen(p, frame);
        this.mousePosX = p.getX()-8; // constants to make this align with the window
        this.mousePosY = p.getY()-31; // constants to make this align with the window
    }

    /**
     * update cursor and mouse listener
     */
    protected void tickEnd() {
        this.mouseListener.tick();
        this.panel.setCursor(this.getCursor());
    }


    /**
     * check whether a mouse click occurred
     * @param button 1 = left, 2 = middle, 3 = right
     * @return whether a mouse click occurred
     */
    public boolean clicked(int button) {return this.mouseListener.clicked(button);}

    /**
     * check whether the mouse is being held
     * @param button 1 = left, 2 = middle, 3 = right
     * @return whether the mouse is being held
     */
    public boolean held(int button) {return this.mouseListener.held(button);}

    /**
     * check whether a mouse click occurred
     * @return whether a mouse click occurred
     */
    public boolean leftClicked() {return this.clicked(1);}


    /**
     * get mouse x pos
     * @return mouse x pos
     */
    public double x() {return mousePosX;}
    /**
     * get mouse y pos
     * @return mouse y pos
     */
    public double y() {return mousePosY;}


    /**
     * get cursor
     * @return cursor
     */
    public Cursor getCursor() {return cursor;}

    /**
     * set cursor
     * @param cursor cursor
     */
    public void setCursor(Cursor cursor) {this.cursor = cursor;}

    /**
     * set panel
     * @param panel panel
     */
    public void setPanel(Panel panel) {this.panel = panel;}
}
