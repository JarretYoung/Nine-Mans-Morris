package game.UIComponents;

import javax.swing.*;

public class Frame extends JFrame {
    private Panel panel;

    /**
     * Constructor for game frame
     */
    public Frame() {
        super("Nine Man Morris");
        this.panel = new Panel(this);
        this.add(this.panel);
        this.addMouseListener(Mouse.getInstance().getMouseListener());
        Mouse.getInstance().setPanel(this.panel);
        this.setFocusable(true);
        this.setResizable(false);
        this.setSize(600+16,600+39);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
