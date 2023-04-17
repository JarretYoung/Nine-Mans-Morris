package UIComponents;

import javax.swing.*;
import java.awt.*;

public class Mouse {
    private double mousePosX;
    private double mousePosY;

    private static Mouse mouse = null;
    private MorrisMouseListener mouseListener;
    public MorrisMouseListener getMouseListener() {return mouseListener;}

    public static Mouse getInstance() {
        if(Mouse.mouse==null) {Mouse.mouse = new Mouse();}
        return Mouse.mouse;
    }
    private Mouse() {
        this.mouseListener = new MorrisMouseListener();
    }

    protected void tickStart(Frame frame) {
        Point p = MouseInfo.getPointerInfo().getLocation();
        SwingUtilities.convertPointFromScreen(p, frame);
        this.mousePosX = p.getX()-8; // constants to make this align with the window
        this.mousePosY = p.getY()-31; // constants to make this align with the window
    }

    protected void tickEnd() {
        this.mouseListener.tick();
    }

    // 1 = left click, 2 = middle click, 3 = right click
    public boolean clicked(int button) {return this.mouseListener.clicked(button);}
    public boolean held(int button) {return this.mouseListener.held(button);}

    // left click
    public boolean leftClicked() {return this.clicked(1);}

    // mouse position
    public double x() {return mousePosX;}
    public double y() {return mousePosY;}
}
