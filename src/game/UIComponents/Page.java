package game.UIComponents;



import java.awt.*;

public abstract class Page {
    private String id;
    private Panel panel;
    // TODO: add a list of drawables

    public Page(Panel panel, String id) {
        this.panel = panel;
        this.id = id;
    }

    public String getId() {return id;}

    // draw everything
    public void paintComponent(Graphics g) {
        // TODO: loop through every drawable
    }

    // run every frame
    public void tick() {
        // TODO: loop through every drawable
    };

    public Panel getPanel() {return panel;}
}
