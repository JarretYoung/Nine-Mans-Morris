package game.Drawables;

import game.UIComponents.*;
import java.awt.*;

public abstract class Drawable {
    // page that the drawable is on
    private Page page;

    public Drawable(Page page) {
        this.page = page;
        this.page.addDrawable(this);
    }

    public Page getPage() {return this.page;}
    // java swing periodically calls this function
    public abstract void paint(Graphics2D g);
    // java swing periodically calls this function
    public abstract void tick();

    public void delete() {
        this.page.removeDrawable(this);
    }
}