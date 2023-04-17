package UIComponents;

import javax.swing.*;

public class Frame extends JFrame {
    private Panel panel;


    public Frame() {
        super("Nine Man Morris");
        this.panel = new Panel(this);
        this.add(this.panel);
        this.setFocusable(true);
        this.setResizable(false);
        this.setSize(400,400);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
