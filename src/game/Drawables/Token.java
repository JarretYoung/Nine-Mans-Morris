package game.Drawables;

import game.UIComponents.*;
import javafx.geometry.Pos;

import javax.swing.*;
import java.awt.*;

public class Token extends Sprite {
    // attributes
    public final static double SIZE = 64;
    public final static String IMG_PATH_DUCK = "images/duck.png";
    public final static String IMG_PATH_GOOSE = "images/goose.png";
    boolean player; // false = goose
    public Token(Page page, double x, double y, boolean player) {
        super(page, x, y, SIZE, SIZE, (new ImageIcon(player ? IMG_PATH_DUCK : IMG_PATH_GOOSE)).getImage());
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

    public void moveSelf(Position startPos, Position endPos) {
        startPos.setToken(null);
        endPos.setToken(this);
        this.setX(endPos.getX());
        this.setY(endPos.getY());
    }
}
