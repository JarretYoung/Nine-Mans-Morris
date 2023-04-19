package game.Drawables;

import game.UIComponents.*;
import java.awt.*;

public class Token extends Sprite {
    // attributes
    boolean player; // false = enemy
    public Token(Page page, double x, double y, double width, double height, Image baseImage, boolean player) {
        super(page, x, y, width, height, baseImage);
        this.player = player;
        //More attributes soon
    }

    public void paint(Graphics2D g) {
        //TODO:
    }
    
    public void tick() {
        //TODO:
    }

    public void setPlayer(boolean player) {
        this.player = player;
    }

    public boolean getPlayer() {
        return this.player;
    }
}
