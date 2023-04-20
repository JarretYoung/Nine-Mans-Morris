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
        g.drawImage(this.img,(int) (this.getX()-this.getWidth()/2),(int) (this.getY()-this.getHeight()/2), this.getPage().getPanel());
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

    public Image getBaseImg() {
        return this.baseImg;
    }

    public Image getImg() {
        return this.img;
    }
}