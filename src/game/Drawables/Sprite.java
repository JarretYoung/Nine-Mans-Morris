package game.Drawables;

import game.UIComponents.*;
import java.awt.*;

public class Sprite extends Drawable {
    double x;
    double y;
    double width;
    double height;
    Image baseImg;
    Image img;

    public Sprite(Page page, double x, double y, double width, double height, Image baseImage) {
        super(page);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.baseImg = baseImage;
        this.img = baseImg.getScaledInstance((int) this.getWidth(), (int) this.getHeight(), Image.SCALE_DEFAULT);
    }

    public void paint(Graphics2D g) {
        g.drawImage(this.img,(int) this.getX1(),(int) this.getY1(), this.getPage().getPanel());
    }
    
    public void tick() {
        //TODO:
    }

    public void transform(Image baseImg) {
        //TODO: some transformation then store to img
        this.img = baseImg;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setBaseImg(Image baseImg) {
        this.baseImg = baseImg;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double getWidth() {
        return this.width;
    }

    public double getHeight() {
        return this.height;
    }

    public double getX1() {return this.getX() - this.getWidth()/2;}
    public double getY1() {return this.getY() - this.getHeight()/2;}
    public double getX2() {return this.getX() + this.getWidth()/2;}
    public double getY2() {return this.getY() + this.getHeight()/2;}

    public Image getBaseImg() {
        return this.baseImg;
    }

    public Image getImg() {
        return this.img;
    }

    // check if a coordinate is within the sprite
    public boolean intersectsPoint(double x, double y) {
        return x >= this.getX1() && y >= this.getY1() && x <= this.getX2() && y <= this.getY2();
    }
    public boolean isHovered() {
        return this.intersectsPoint(Mouse.getInstance().x(),Mouse.getInstance().y());
    }
    public boolean isClicked() {
        return this.isHovered() && Mouse.getInstance().leftClicked();
    }
}