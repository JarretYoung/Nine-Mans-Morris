package game.UIComponents;



import game.Drawables.Drawable;

import java.awt.*;
import java.util.ArrayList;

public abstract class Page {
    private String id;
    private Panel panel;
    private ArrayList<Drawable> drawables = new ArrayList<>();
    /**
     * add drawable
     * @param drawable drawable
     */
    public void addDrawable(Drawable drawable) {
        this.drawables.add(drawable);
    }
    /**
     * remove drawable
     * @param drawable drawable
     */
    public void removeDrawable(Drawable drawable) {this.drawables.remove(drawable);}

    /**
     * draw the drawable first each frame
     * @param drawable drawable
     */
    public void moveToFront(Drawable drawable) {
        this.removeDrawable(drawable);
        this.addDrawable(drawable);
    }

    /**
     * constructor
     * @param panel game panel
     * @param id page id
     */
    public Page(Panel panel, String id) {
        this.panel = panel;
        this.id = id;
    }

    /**
     * getter
     * @return id
     */
    public String getId() {return id;}

    /**
     * draw all drawables
     * @param g graphic object
     */
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        for(Drawable drawable : drawables) {
            drawable.paint(g2d);
        }
    }

    /**
     * run drawable info every frame
     */
    public void tick() {
        for(Drawable drawable : (ArrayList<Drawable>) drawables.clone()) {
            drawable.tick();
        }
    };
    /**
     * getter
     * @return panel
     */
    public Panel getPanel() {return panel;}
}
