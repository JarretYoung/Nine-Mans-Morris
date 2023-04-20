package game.Drawables;

import game.UIComponents.*;

import javax.swing.*;
import java.awt.*;

public class Token extends Sprite {
    // attributes
    public final static double SIZE = 64;
    boolean player; // false = goose
    public Token(Page page, double x, double y, boolean player) {
        super(page, x, y, SIZE, SIZE, (new ImageIcon(player ? "images/duck.png" : "images/goose.png")).getImage());
        this.player = player;
        //More attributes soon
    }

    public void paint(Graphics2D g) {
        super.paint(g);
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
