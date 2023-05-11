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
    ArrayList<Position> neighbours = new ArrayList<Position>();
    private Token token = null;

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
}
