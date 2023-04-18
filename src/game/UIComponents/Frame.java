package game.UIComponents;

import javax.swing.*;

public class Frame extends JFrame {
    private Panel panel;


    public Frame() {
        super("Nine Man Morris");
        this.panel = new Panel(this);
        this.add(this.panel);
        this.addMouseListener(Mouse.getInstance().getMouseListener());
        this.setFocusable(true);
        this.setResizable(false);
        this.setSize(400+16,400+39);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
