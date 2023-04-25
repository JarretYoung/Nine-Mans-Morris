package game.Drawables;

import game.Teams;
import game.UIComponents.*;

import javax.swing.*;
import java.awt.*;

public class Token extends Sprite {
    // attributes
    public final static double SIZE = 64;
    public final static String IMG_PATH_DUCK = "images/duck.png";
    public final static String IMG_PATH_GOOSE = "images/goose.png";
    public final static String IMG_PATH_DUCK_SELECTED = "images/duckSelected.png";
    public final static String IMG_PATH_GOOSE_SELECTED = "images/gooseSelected.png";
    Enum<Teams> player;
    private boolean selected = false;
    public Token(Page page, double x, double y, Enum<Teams> team) {
        super(page, x, y, SIZE, SIZE, (new ImageIcon(team== Teams.DUCK ? IMG_PATH_DUCK : IMG_PATH_GOOSE)).getImage());
        this.player = team;
        //More attributes soon
    }

    public void paint(Graphics2D g) {
        super.paint(g);
    }
    
    public void tick() {
        //TODO:
    }

    public void setPlayer(Enum<Teams> player) {
        this.player = player;
    }

    public Enum<Teams> getPlayer() {
        return this.player;
    }

    public void moveSelf(Position startPos, Position endPos) {
        startPos.setToken(null);
        endPos.setToken(this);
        this.setX(endPos.getX());
        this.setY(endPos.getY());
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
        if(this.selected) {
            this.setBaseImg((new ImageIcon(player== Teams.DUCK ? IMG_PATH_DUCK_SELECTED : IMG_PATH_GOOSE_SELECTED)).getImage());
        }
        else {
            this.setBaseImg((new ImageIcon(player== Teams.DUCK ? IMG_PATH_DUCK: IMG_PATH_GOOSE)).getImage());
        }
    }
}
