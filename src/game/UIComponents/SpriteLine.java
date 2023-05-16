package game.UIComponents;

import game.Drawables.Sprite;

import java.awt.*;
import java.util.ArrayList;

public class SpriteLine {
    private Page page;
    private double startX; // start x position of where to draw sprites
    private double startY; // start y position of where to draw sprites
    private double spacing; // gap between each sprite
    private double width; // width of each sprite
    private double height; // height of each sprite
    private Image baseImg; // image of each sprite
    private int spriteCount = 0; // number of sprites to draw
    private ArrayList<Sprite> sprites; // array of sprites
    private int horMod; // how far to horizontally displace the sprite by spacing
    private int vertMod; // how far to vertically displace the sprite by spacing
    public SpriteLine(Page page, double startX, double startY, double width, double height, Image baseImg, double spacing, int spriteCount, int horMod, int vertMod) {
        this.page = page;
        this.startX = startX;
        this.startY = startY;
        this.spacing = spacing;
        this.width = width;
        this.height = height;
        this.baseImg = baseImg;
        this.sprites = new ArrayList<>();
        this.horMod = horMod;
        this.vertMod = vertMod;
        this.setSpriteCount(spriteCount);

    }

    public void setSpriteCount(int spriteCount) {
        // don't do anything if the sprite count hasn't changed
        if(this.spriteCount==spriteCount) {return;}
        // update sprite count
        this.spriteCount = spriteCount;
        // delete sprites
        for(Sprite sprite : this.sprites) {
            sprite.delete();
        }
        this.sprites.clear();
        // recreate sprites
        for(int i = 0; i < this.spriteCount; i++) {
            this.sprites.add(new Sprite(this.page,this.startX + this.spacing*i*horMod,this.startY + this.spacing*i*vertMod,this.width,this.height,this.baseImg));
        }
    }
}
