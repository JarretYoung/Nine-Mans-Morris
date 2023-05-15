package game.UIComponents;

import game.Drawables.Sprite;

import java.awt.*;
import java.util.ArrayList;

public class SpriteLine {
    private Page page;
    private double startX;
    private double startY;
    private double spacing;
    private double width;
    private double height;
    private Image baseImg;
    private int spriteCount = 0;
    private ArrayList<Sprite> sprites;
    private int horMod;
    private int vertMod;
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
        if(this.spriteCount==spriteCount) {return;}
        this.spriteCount = spriteCount;
        for(Sprite sprite : this.sprites) {
            sprite.delete();
        }
        this.sprites.clear();

        for(int i = 0; i < this.spriteCount; i++) {
            this.sprites.add(new Sprite(this.page,this.startX + this.spacing*i*horMod,this.startY + this.spacing*i*vertMod,this.width,this.height,this.baseImg));
        }
    }
}
