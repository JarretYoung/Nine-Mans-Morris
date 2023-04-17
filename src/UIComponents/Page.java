package UIComponents;



import java.awt.*;

public abstract class Page {
    private String id;
    private Panel panel;

    public Page(Panel panel, String id) {
        this.panel = panel;
        this.id = id;
    }

    public String getId() {return id;}

    // draw everything
    public void paintComponent(Graphics g) {
        System.out.println("paint!");
    }

    // run every frame
    public void tick() {
        System.out.println("tick!");
    };

    public Panel getPanel() {return panel;}
}
