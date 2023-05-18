package game.UIComponents;



import game.Drawables.Drawable;

import java.awt.*;
import java.util.ArrayList;

public abstract class Page {
    private String id;
    private Panel panel;
    private ArrayList<Drawable> drawables = new ArrayList<>();
    /**
     *
     * @param drawable
     */
    public void addDrawable(Drawable drawable) {
        this.drawables.add(drawable);
    }
    /**
     *
     * @param drawable
     */
    public void removeDrawable(Drawable drawable) {this.drawables.remove(drawable);}

    /**
     *
     * @param drawable
     */
    public void moveToFront(Drawable drawable) {
        this.removeDrawable(drawable);
        this.addDrawable(drawable);
    }

    /**
     *
     * @param panel
     * @param id
     */
    public Page(Panel panel, String id) {
        this.panel = panel;
        this.id = id;
    }

    /**
     *
     * @return
     */
    public String getId() {return id;}

    // draw everything
    /**
     *
     * @param g
     */
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        for(Drawable drawable : drawables) {
            drawable.paint(g2d);
        }
    }

    // run every frame
    /**
     *
     */
    public void tick() {
        for(Drawable drawable : drawables) {
            drawable.tick();
        }
    };
    /**
     *
     * @return
     */
    public Panel getPanel() {return panel;}
}
