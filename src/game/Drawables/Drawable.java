package game.Drawables;

import game.UIComponents.*;
import java.awt.*;

public abstract class Drawable {
    private Page page;

    public Drawable(Page page) {
        this.page = page;
        this.page.addDrawable(this);
    }

    public Page getPage() {return this.page;}
    
    public abstract void paint(Graphics2D g);

    public abstract void tick();

    public void delete() {
        this.page.removeDrawable(this);
    }
}