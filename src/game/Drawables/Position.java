package game.Drawables;

import game.UIComponents.*;
import javafx.geometry.Pos;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.ArrayList;

public class Position extends Sprite {
    // attributes
    public final static double SIZE = 16;
    public final static String IMG_PATH = "images/blackCircle.png";
    public final static String IMG_PATH_ALLOWED = "images/blackCircleHighlight.png";
    ArrayList<Position> neighbours = new ArrayList<Position>();
    private Token token = null;
    private boolean allowed = false;
    private boolean newAllowed = false;
    boolean millExists = false;

    public Position(Page page, double x, double y) { // , ArrayList<Position> neighbours
        super(page, x, y, SIZE, SIZE, (new ImageIcon(IMG_PATH)).getImage());
        //this.neighbours = neighbours;
        //More attributes soon
    }

    @Override
    public void tick() {
        super.tick();
        if(this.isHoveredWithinRange(20)) {
            Mouse.getInstance().setCursor(new Cursor(Cursor.HAND_CURSOR));
        }

        if(this.newAllowed!=this.allowed) { // only allow for allowed to be updated once per frame
            this.allowed = this.newAllowed;
            if(this.allowed) {
                this.setBaseImg((new ImageIcon(IMG_PATH_ALLOWED)).getImage());
            }
            else {
                this.setBaseImg((new ImageIcon(IMG_PATH)).getImage());
            }
            if(this.token!=null) {
                this.token.setAllowed(this.allowed);
            }
        }
    }

    public void addNeighbour(Position newPos) {
        this.neighbours.add(newPos);
    }

    public ArrayList<Position> getNeighboursCopy() {
        return (ArrayList<Position>) this.neighbours.clone();
    }

    public void setToken(Token token) {this.token = token;}
    public Token getToken() {return token;}

    @Override
    public String toString() {
        return String.format("Position<token=%s,x=%s,y=%s>",this.getToken(),this.getX(),this.getY());
    }

    public ArrayList<Position> getPointsToRight(int pointsLeft) {
//        System.out.println(String.format("points left: %s", pointsLeft));
//        System.out.println(neighbours);
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

    public void setAllowed(boolean allowed) {
        this.newAllowed = allowed;
    }

    public void setMillExists(boolean millExists) {this.millExists = millExists;}

    public boolean isMillExists() {return millExists;}
}
