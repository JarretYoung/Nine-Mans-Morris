package game.Drawables;

import game.UIComponents.*;
import java.awt.*;

public class Sprite extends Drawable {
    double x; // horizontal midpoint
    double y; // vertical midpoint
    double width;
    double height;
    Image baseImg; // image before transformations
    Image img; // image after transformations

    /**
     *
     * @param page
     * @param x
     * @param y
     * @param width
     * @param height
     * @param baseImage
     */
    public Sprite(Page page, double x, double y, double width, double height, Image baseImage) {
        super(page);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.baseImg = baseImage;
        this.img = baseImg.getScaledInstance((int) this.getWidth(), (int) this.getHeight(), Image.SCALE_DEFAULT);
    }

    /**
     *
     * @param g
     */
    public void paint(Graphics2D g) {
        g.drawImage(this.img,(int) this.getX1(),(int) this.getY1(), this.getPage().getPanel());
    }

    /**
     *
     */
    public void tick() {}

    /**
     *
     * @param x
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     *
     * @param y
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     *
     * @param width
     */
    public void setWidth(double width) {
        this.width = width;
    }

    /**
     *
     * @param height
     */
    public void setHeight(double height) {
        this.height = height;
    }
    // resize the img according to the width and height of the sprite
    /**
     *
     * @param baseImg
     */
    public void setBaseImg(Image baseImg) {
        this.baseImg = baseImg;
        this.img = baseImg.getScaledInstance((int) this.getWidth(), (int) this.getHeight(), Image.SCALE_DEFAULT);
    }

    /**
     *
     * @param img
     */
    public void setImg(Image img) {
        this.img = img;
    }

    /**
     *
     * @return
     */
    public double getX() {
        return this.x;
    }

    /**
     *
     * @return
     */
    public double getY() {
        return this.y;
    }

    /**
     *
     * @return
     */
    public double getWidth() {
        return this.width;
    }

    /**
     *
     * @return
     */
    public double getHeight() {
        return this.height;
    }

    /**
     *
     * @return
     */
    public double getX1() {return this.getX() - this.getWidth()/2;}

    /**
     *
     * @return
     */
    public double getY1() {return this.getY() - this.getHeight()/2;}

    /**
     *
     * @return
     */
    public double getX2() {return this.getX() + this.getWidth()/2;}

    /**
     *
     * @return
     */
    public double getY2() {return this.getY() + this.getHeight()/2;}

    /**
     *
     * @return
     */
    public Image getBaseImg() {
        return this.baseImg;
    }

    /**
     *
     * @return
     */
    public Image getImg() {
        return this.img;
    }

    // check if a coordinate is within the sprite
    /**
     *
     * @param x
     * @param y
     * @return
     */
    public boolean intersectsPoint(double x, double y) {
        return x >= this.getX1() && y >= this.getY1() && x <= this.getX2() && y <= this.getY2();
    }
    // check if a coordinate is within the sprite + a given range
    /**
     *
     * @param x
     * @param y
     * @param range
     * @return
     */
    public boolean intersectsPointWithinRange(double x, double y, double range) {
        return x >= this.getX1()-range && y >= this.getY1()-range && x <= this.getX2()+range && y <= this.getY2()+range;
    }
    // check if the mouse is hovering over the sprite
    /**
     *
     * @return
     */
    public boolean isHovered() {
        return this.intersectsPoint(Mouse.getInstance().x(),Mouse.getInstance().y());
    }
    // check if the mouse is hovering over the sprite + a given range
    /**
     *
     * @param range
     * @return
     */
    public boolean isHoveredWithinRange(double range) {
        return this.intersectsPointWithinRange(Mouse.getInstance().x(),Mouse.getInstance().y(),range);
    }

    /**
     *
     * @return
     */
    public boolean isClicked() {
        return this.isHovered() && Mouse.getInstance().leftClicked();
    }

    /**
     *
     * @param range
     * @return
     */
    public boolean isClickedWithinRange(double range) {
        return  this.isHoveredWithinRange(range) && Mouse.getInstance().leftClicked();
    }
}