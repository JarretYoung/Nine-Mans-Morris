package game.UIComponents;

import com.sun.javaws.exceptions.InvalidArgumentException;
import game.Drawables.Line;
import game.Drawables.Position;
import game.Drawables.Sprite;

import javax.swing.*;

public class Board extends Sprite {
    public final static double SIZE = 200;
    public final static String IMG_PATH = "images/greenSquare.png";
    public final static double X = 200;
    public final static double Y = 200;
    public final static int GRID_SIZE_X = 7;
    public final static int GRID_SIZE_Y = 7;

    private final Position[][] grid;
    private Page page;
    public Board(Page page) {
        super(page,X,Y,SIZE,SIZE,(new ImageIcon(IMG_PATH)).getImage());
        this.page = page;
        this.grid = new Position[GRID_SIZE_X][GRID_SIZE_Y];
        this.initializeBoard();
    }
    private double gridPosXtoCoordX(int gridPosX) {
        return this.getX1() + gridPosX/((double) GRID_SIZE_X-1) * this.getWidth();
    }
    private double gridPosYtoCoordY(int gridPosY) {
        return this.getY1() + gridPosY/((double) GRID_SIZE_Y-1) * this.getHeight();
    }
    private void addPoint(int gridPosX,int gridPosY) {
        double x = this.gridPosXtoCoordX(gridPosX);
        double y = this.gridPosYtoCoordY(gridPosY);
        this.grid[gridPosX][gridPosY] = new Position(this.getPage(),x,y);
    }
    private void addLine(int gridPosX1, int gridPosY1, int gridPosX2, int gridPosY2) {
        if(gridPosX1==gridPosX2)  { // vertical line
            double y1 = this.gridPosYtoCoordY(gridPosY1);
            double y2 = this.gridPosYtoCoordY(gridPosY2);
            double x = this.gridPosXtoCoordX(gridPosX1);
            new Line(this.getPage(),y1,y2,x,false);
        }
        else if(gridPosY1==gridPosY2) { // horizontal line
            double x1 = this.gridPosXtoCoordX(gridPosX1);
            double x2 = this.gridPosXtoCoordX(gridPosX2);
            double y = this.gridPosYtoCoordY(gridPosY1);
            new Line(this.getPage(),x1,x2,y,true);
        }
        else {
            throw new IllegalArgumentException("line must either be vertical or horizontal");
        }
    }
    private void initializeBoard() {
        // top row
        this.addPoint(0,0);
        this.addPoint(3,0);
        this.addPoint(6,0);
        // second row
        this.addPoint(1,1);
        this.addPoint(3,1);
        this.addPoint(5,1);
        // third row
        this.addPoint(2,2);
        this.addPoint(3,2);
        this.addPoint(4,2);
        // fourth row (center row)
        this.addPoint(0,3);
        this.addPoint(1,3);
        this.addPoint(2,3);
        this.addPoint(4,3);
        this.addPoint(5,3);
        this.addPoint(6,3);
        // fifth row
        this.addPoint(2,4);
        this.addPoint(3,4);
        this.addPoint(4,4);
        // sixth row
        this.addPoint(1,5);
        this.addPoint(3,5);
        this.addPoint(5,5);
        // seventh row
        this.addPoint(0,6);
        this.addPoint(3,6);
        this.addPoint(6,6);

        // ---- lines ----
        // horizontal
        this.addLine(0,0,3,0);
        this.addLine(3,0,6,0);

        this.addLine(1,1,3,1);
        this.addLine(3,1,5,1);

        this.addLine(2,2,3,2);
        this.addLine(3,2,4,2);

        this.addLine(0,3,1,3);
        this.addLine(1,3,2,3);
        this.addLine(4,3,5,3);
        this.addLine(5,3,6,3);

        this.addLine(2,4,3,4);
        this.addLine(3,4,4,4);

        this.addLine(1,5,3,5);
        this.addLine(3,5,5,5);

        this.addLine(0,6,3,6);
        this.addLine(3,6,6,6);

        // vertical
        this.addLine(0,0,0,3);
        this.addLine(0,3,0,6);

        this.addLine(1,1,1,3);
        this.addLine(1,3,1,5);

        this.addLine(2,2,2,3);
        this.addLine(2,3,2,4);

        this.addLine(3,0,3,1);
        this.addLine(3,1,3,2);
        this.addLine(3,4,3,5);
        this.addLine(3,5,3,6);

        this.addLine(4,2,4,3);
        this.addLine(4,3,4,4);

        this.addLine(5,1,5,3);
        this.addLine(5,3,5,5);

        this.addLine(6,0,6,3);
        this.addLine(6,3,6,6);
    }
}
