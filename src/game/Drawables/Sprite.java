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
     * constructor
     * @param page page that the sprite is on
     * @param x horizontal coordinate position of the sprite
     * @param y vertical coordinate position of the sprite
     * @param width horizontal size of the sprite in pixels
     * @param height vertical size of the sprite in pixels
     * @param baseImage image class to draw onto the screen to represent the sprite
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
     * draws the sprite
     * @param g graphics object
     */
    public void paint(Graphics2D g) {
        g.drawImage(this.img,(int) this.getX1(),(int) this.getY1(), this.getPage().getPanel());
    }

    /**
     * does something each frame
     */
    public void tick() {}

    /**
     * setter
     * @param x horizontal coordinate position of the sprite
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * setter
     * @param y vertical coordinate position of the sprite
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * setter
     * @param width horizontal size of the sprite in pixels
     */
    public void setWidth(double width) {
        this.width = width;
    }

    /**
     * setter
     * @param height vertical size of the sprite in pixels
     */
    public void setHeight(double height) {
        this.height = height;
    }
    // resize the img according to the width and height of the sprite
    /**
     * setter
     * @param baseImg image class to draw onto the screen to represent the sprite
     */
    public void setBaseImg(Image baseImg) {
        this.baseImg = baseImg;
        this.img = baseImg.getScaledInstance((int) this.getWidth(), (int) this.getHeight(), Image.SCALE_DEFAULT);
    }

    /**
     * setter
     * @param img transformed image class to draw onto the screen to represent the sprite
     */
    public void setImg(Image img) {
        this.img = img;
    }

    /**
     * getter
     * @return x
     */
    public double getX() {
        return this.x;
    }

    /**
     * getter
     * @return y
     */
    public double getY() {
        return this.y;
    }

    /**
     * getter
     * @return width
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * getter
     * @return height
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * getter
     * @return top left x coordinate
     */
    public double getX1() {return this.getX() - this.getWidth()/2;}

    /**
     * getter
     * @return top left y coordinate
     */
    public double getY1() {return this.getY() - this.getHeight()/2;}

    /**
     * getter
     * @return bottom right x coordinate
     */
    public double getX2() {return this.getX() + this.getWidth()/2;}

    /**
     * getter
     * @return bottom right y coordinate
     */
    public double getY2() {return this.getY() + this.getHeight()/2;}

    /**
     * getter
     * @return base image
     */
    public Image getBaseImg() {
        return this.baseImg;
    }

    /**
     * getter
     * @return image
     */
    public Image getImg() {
        return this.img;
    }

    /**
     * getter
     * @return page
     */
    @Override
    public Page getPage() {
        return super.getPage();
    }

    /**
     * check if a coordinate is within the sprite
     * @param x horizontal coordinate position of the sprite
     * @param y vertical coordinate position of the sprite
     * @return boolean
     */
    public boolean intersectsPoint(double x, double y) {
        return x >= this.getX1() && y >= this.getY1() && x <= this.getX2() && y <= this.getY2();
    }
    /**
     * check if a coordinate is within the sprite + a given range
     * @param x horizontal coordinate position of the sprite
     * @param y vertical coordinate position of the sprite
     * @param range extra space where the point is considered to still intersect
     * @return boolean
     */
    public boolean intersectsPointWithinRange(double x, double y, double range) {
        return x >= this.getX1()-range && y >= this.getY1()-range && x <= this.getX2()+range && y <= this.getY2()+range;
    }

    /**
     * check if the mouse is hovering over the sprite
     * @return boolean
     */
    public boolean isHovered() {
        return this.intersectsPoint(Mouse.getInstance().x(),Mouse.getInstance().y());
    }

    /**
     * check if the mouse is hovering over the sprite + a given range
     * @param range extra space where the point is considered to still intersect
     * @return boolean
     */
    public boolean isHoveredWithinRange(double range) {
        return this.intersectsPointWithinRange(Mouse.getInstance().x(),Mouse.getInstance().y(),range);
    }

    /**
     * check if the sprite is clicked
     * @return boolean
     */
    public boolean isClicked() {
        return this.isHovered() && Mouse.getInstance().leftClicked();
    }

    /**
     * check if the sprite is clicked + a given range
     * @param range extra space where the point is considered to still intersect
     * @return boolean
     */
    public boolean isClickedWithinRange(double range) {
        return  this.isHoveredWithinRange(range) && Mouse.getInstance().leftClicked();
    }
}