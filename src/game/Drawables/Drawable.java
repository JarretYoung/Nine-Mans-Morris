package game.Drawables;

import game.UIComponents.*;
import java.awt.*;

public class Drawable {
    private Page page;

    public Drawable(Page page) {
        this.page = page;
    }

    public Page getPage() {return this.page;}
    
    public void paint(Graphics2D g) {
        //TODO: display
    }

    public void tick() {
        //TODO: run frame
    }

    public void delete() {
        //TODO: delete the drawable
    }
}