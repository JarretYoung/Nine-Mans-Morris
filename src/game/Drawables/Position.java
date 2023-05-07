package game.Drawables;

import game.UIComponents.*;

import javax.swing.*;
import java.awt.*;
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
        if(this.isHovered()) {
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
}
