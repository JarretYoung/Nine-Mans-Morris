package game.Drawables;

import game.UIComponents.*;
import java.awt.*;
import java.util.ArrayList;

public class Position extends Sprite {
    // attributes
    ArrayList<Position> neighbours = new ArrayList<Position>();

    public Position(Page page, double x, double y, double width, double height, Image baseImage, ArrayList<Position> neighbours) {
        super(page, x, y, width, height, baseImage);
        this.neighbours = neighbours;
        //More attributes soon
    }

    public void paint(Graphics2D g) {
        //TODO:
    }
    
    public void tick() {
        //TODO:
    }

    public void addNeighbours(Position newPos) {
        this.neighbours.add(newPos);
    }

    public ArrayList<Position> getNeighbours() {
        return this.neighbours;
    }
}
