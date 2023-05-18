package game.Drawables;

import game.UIComponents.*;
import javafx.geometry.Pos;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.ArrayList;

public class Position extends Sprite {
    // attributes
    public final static double SIZE = 16; // width and height of the position
    public final static String IMG_PATH = "images/blackCircle.png"; // default image
    public final static String IMG_PATH_ALLOWED = "images/blackCircleHighlight.png"; // image when the player can click on the position
    ArrayList<Position> neighbours = new ArrayList<Position>(); // adjacent positions
    private Token token = null; // token occupying the position, or null if there aren't any
    private boolean allowed = false; // can the player click on the position to do an action?
    private boolean newAllowed = false; // to avoid the allowed variable being changed constantly, newAllowed is used
    boolean millExists = false; // is this position part of a mill?

    /**
     * constructor
     * @param page page that the sprite is on
     * @param x horizontal coordinate position of the sprite
     * @param y vertical coordinate position of the sprite
     */
    public Position(Page page, double x, double y) { // , ArrayList<Position> neighbours
        super(page, x, y, SIZE, SIZE, (new ImageIcon(IMG_PATH)).getImage());
    }

    /**
     * updating cursor and position image according to circumstances
     */
    @Override
    public void tick() {
        super.tick();
        // extra leeway in clicking for usability reasons
        if(this.isHoveredWithinRange(20)) {
            // set cursor to show that the position can be clicked
            Mouse.getInstance().setCursor(new Cursor(Cursor.HAND_CURSOR));
        }

        if(this.newAllowed!=this.allowed) { // only allow for allowed to be updated once per frame to avoid flickering
            this.allowed = this.newAllowed;
            // highlight image if allowed, otherwise don't
            if(this.allowed) {
                this.setBaseImg((new ImageIcon(IMG_PATH_ALLOWED)).getImage());
            }
            else {
                this.setBaseImg((new ImageIcon(IMG_PATH)).getImage());
            }
            // also update the token accordingly
            if(this.token!=null) {
                this.token.setAllowed(this.allowed);
            }
        }
    }

    /**
     * adding a neighbour to the position
     * @param newPos a neighbouring position
     */
    public void addNeighbour(Position newPos) {
        this.neighbours.add(newPos);
    }
    /**
     * get neighbours (returns a copy to avoid a leak)
     * @return a copy of the position's neighbour list
     */
    public ArrayList<Position> getNeighboursCopy() {
        return (ArrayList<Position>) this.neighbours.clone();
    }

    /**
     * setter
     * @param token token
     */
    public void setToken(Token token) {this.token = token;}

    /**
     * getter
     * @return token
     */
    public Token getToken() {return token;}

    /**
     * to string
     * @return str representing the position
     */
    @Override
    public String toString() {
        return String.format("Position<token=%s,x=%s,y=%s>",this.getToken(),this.getX(),this.getY());
    }
    /**
     * recursively gets horizontal points for the purpose of mill identification
     * @param pointsLeft number of iterations left to go through
     * @return list of positions to the right including this position
     */
    public ArrayList<Position> getPointsToRight(int pointsLeft) {
        if(pointsLeft>0) { // there are still points left
            for(Position pos: neighbours) {
                if(pos.getX()>this.getX()) { // if the position is to the right of this position
                    ArrayList<Position> positions = pos.getPointsToRight(pointsLeft-1);
                    positions.add(this);
                    return positions;
                }
            }
        }
        ArrayList<Position> positions = new ArrayList<>();
        positions.add(this);
        return positions;
    }
    /**
     * recursively gets vertical points for the purpose of mill identification
     * @param pointsLeft  number of iterations left to go through
     * @return list of positions to the bottom including this position
     */
    public ArrayList<Position> getPointsToBottom(int pointsLeft) {
        if(pointsLeft>0) { // there are still points left
            for(Position pos: neighbours) {
                if(pos.getY()>this.getY()) { // if the position is to the bottom of this position
                    ArrayList<Position> positions = pos.getPointsToBottom(pointsLeft-1);
                    positions.add(this);
                    return positions;
                }
            }
        }
        ArrayList<Position> positions = new ArrayList<>();
        positions.add(this);
        return positions;
    }
    /**
     * update newAllowed instead of allowed; allowed is updated in the tick function
     * @param allowed allowed
     */
    public void setAllowed(boolean allowed) {
        this.newAllowed = allowed;
    }
    /**
     * setter
     * @param millExists whether this position is part of a mill
     */
    public void setMillExists(boolean millExists) {this.millExists = millExists;}
    /**
     * getter
     * @return whether this position is part of a mill
     */
    public boolean isMillExists() {return millExists;}
}
