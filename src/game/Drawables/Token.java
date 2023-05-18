package game.Drawables;

import game.Teams;
import game.UIComponents.*;

import javax.swing.*;
import java.awt.*;

public class Token extends Sprite {
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
     *
     * @param page
     * @param x
     * @param y
     * @param team
     */
    public Token(Page page, double x, double y, Enum<Teams> team) {
        super(page, x, y, SIZE, SIZE, (new ImageIcon(team== Teams.DUCK ? IMG_PATH_DUCK : IMG_PATH_GOOSE)).getImage());
        this.player = team;
        //More attributes soon
    }

    /**
     *
     * @param g
     */
    public void paint(Graphics2D g) {
        super.paint(g);
    }

    /**
     *
     */
    public void tick() {
    }

    /**
     *
     * @param player
     */
    public void setPlayer(Enum<Teams> player) {
        this.player = player;
    }

    /**
     *
     * @return
     */
    public Enum<Teams> getPlayer() {
        return this.player;
    }

    /**
     *
     * @param startPos
     * @param endPos
     */
    public void moveSelf(Position startPos, Position endPos) {
        startPos.setToken(null);
        endPos.setToken(this);
        this.setX(endPos.getX());
        this.setY(endPos.getY());
    }

    /**
     *
     * @param selected
     */
    public void setSelected(boolean selected) {
        this.selected = selected;
        this.updateImg();
    }

    /**
     *
     * @param allowed
     */
    public void setAllowed(boolean allowed) {
        this.allowed = allowed;
        this.updateImg();
    }

    /**
     *
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
}
