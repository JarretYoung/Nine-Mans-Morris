package game.Drawables;

import com.google.gson.internal.LinkedTreeMap;
import game.SaveFunction.Saveable;
import game.Teams;
import game.UIComponents.*;

import javax.swing.*;
import java.awt.*;

/**
 *  Token class which extends Sprite and implements Saveable to have tokens for players
 *
 * @author Ong Chien Ming
 * @version 1.0 19/4/2023
 */
public class Token extends Sprite implements Saveable {
    // attributes
    public final static double SIZE = 64;
    public final static String IMG_PATH_DUCK = "images/duck.png"; // default duck image
    public final static String IMG_PATH_GOOSE = "images/goose.png"; // default goose image
    public final static String IMG_PATH_DUCK_SELECTED = "images/duckSelected.png"; // duck image when selected for movement
    public final static String IMG_PATH_GOOSE_SELECTED = "images/gooseSelected.png"; // goose image when selected for movement
    public final static String IMG_PATH_DUCK_ALLOWED = "images/duckHighlight.png"; // duck image when the duck can be selected
    public final static String IMG_PATH_GOOSE_ALLOWED = "images/gooseHighlight.png"; // goose image when the goose can be selected
    private boolean allowed = false; // can this token do anything this turn?
    Enum<Teams> player; // side that the token is on
    private boolean selected = false; // is this token in the process of being moved?

    /**
     * constructor
     * @param page page that the sprite is on
     * @param x horizontal coordinate position of the sprite
     * @param y vertical coordinate position of the sprite
     * @param team team that the token is a part of
     */
    public Token(Page page, double x, double y, Enum<Teams> team) {
        super(page, x, y, SIZE, SIZE, (new ImageIcon(team== Teams.DUCK ? IMG_PATH_DUCK : IMG_PATH_GOOSE)).getImage());
        this.player = team;
        //More attributes soon
    }

    /**
     * draw the token on the screen
     * @param g graphics object
     */
    public void paint(Graphics2D g) {
        super.paint(g);
    }

    /**
     * do nothing each frame
     */
    public void tick() {
    }

    /**
     * setter
     * @param player team that the token is on
     */
    public void setPlayer(Enum<Teams> player) {
        this.player = player;
    }

    /**
     * getter
     * @return team that the token is on
     */
    public Enum<Teams> getPlayer() {
        return this.player;
    }

    /**
     * move token
     * @param startPos start position
     * @param endPos end position
     */
    public void moveSelf(Position startPos, Position endPos) {
        startPos.setToken(null);
        endPos.setToken(this);
        this.setX(endPos.getX());
        this.setY(endPos.getY());
    }

    /**
     * setter
     * @param selected whether the token is being moved by the player
     */
    public void setSelected(boolean selected) {
        this.selected = selected;
        this.updateImg();
    }

    /**
     * setter
     * @param allowed whether the player can select this token
     */
    public void setAllowed(boolean allowed) {
        this.allowed = allowed;
        this.updateImg();
    }

    /**
     * update image according to current conditions
     */
    public void updateImg() {
        // if selected, show accordingly
        if(this.selected) {
            this.setBaseImg((new ImageIcon(player== Teams.DUCK ? IMG_PATH_DUCK_SELECTED : IMG_PATH_GOOSE_SELECTED)).getImage());
        }
        else {
            // if selectable, show accordingly
            if(allowed) {
                this.setBaseImg((new ImageIcon(player== Teams.DUCK ? IMG_PATH_DUCK_ALLOWED: IMG_PATH_GOOSE_ALLOWED)).getImage());
            }
            else {
                this.setBaseImg((new ImageIcon(player== Teams.DUCK ? IMG_PATH_DUCK: IMG_PATH_GOOSE)).getImage());
            }
        }
    }

    @Override
    public LinkedTreeMap<String, Object> shelve() {
        LinkedTreeMap<String,Object> data = new LinkedTreeMap<>();
        data.put("player",this.player);
        return data;
    }

    @Override
    public void restore(LinkedTreeMap<String, Object> data) {
        this.setPlayer(data.get("player").equals("DUCK") ? Teams.DUCK : Teams.GOOSE);
        this.updateImg();
    }
}
