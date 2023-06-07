package game.Drawables;

import game.UIComponents.*;
import java.awt.*;

/**
 *  Drawable abstract class which is used for all displayed images and texts
 *
 * @author Ong Chien Ming
 * @version 1.0 19/4/2023
 */
public abstract class Drawable {
    // page that the drawable is on
    private Page page;

    /**
     * constructor
     * @param page page that the drawable is on
     */
    public Drawable(Page page) {
        this.page = page;
        this.page.addDrawable(this);
    }

    /**
     *
     * @return the page that the drawable is on
     */
    public Page getPage() {return this.page;}
    // java swing periodically calls this function

    /**
     * display the drawable on the application window
     * @param g
     */
    public abstract void paint(Graphics2D g);
    // java swing periodically calls this function

    /**
     * run something every frame
     */
    public abstract void tick();

    /**
     * delete the drawable
     */
    public void delete() {
        this.page.removeDrawable(this);
    }
}