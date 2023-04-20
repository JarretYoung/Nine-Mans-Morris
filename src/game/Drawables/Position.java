package game.Drawables;

import game.UIComponents.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Position extends Sprite {
    // attributes
    public final static double SIZE = 32;
    public final static String IMG_PATH = "images/blackCircle.png";
    ArrayList<Position> neighbours = new ArrayList<Position>();

    public Position(Page page, double x, double y) { // , ArrayList<Position> neighbours
        super(page, x, y, SIZE, SIZE, (new ImageIcon(IMG_PATH)).getImage());
        //this.neighbours = neighbours;
        //More attributes soon
    }



    public void addNeighbours(Position newPos) {
        this.neighbours.add(newPos);
    }

    public ArrayList<Position> getNeighbours() {
        return this.neighbours;
    }
}
