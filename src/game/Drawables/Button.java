package game.Drawables;

import game.Commands.Command;
import game.Teams;
import game.UIComponents.*;

import javax.swing.*;
import java.awt.*;

public class Button extends Sprite {
    // attributes
    public final static String IMG_PATH = "images/button.png";
    public final static String IMG_PATH_HOVER = "images/buttonLight.png";
    private Command command;
    private Text text;
    private boolean hovered;
    public Button(Page page, double x, double y, double width, double height, String textStr, Command command) {
        super(page, x, y, width, height, (new ImageIcon(IMG_PATH)).getImage());
        //More attributes soon
        this.command = command;
        this.text = new Text(page,textStr,x,y,true);
        this.hovered = false;
    }

    
    public void tick() {
        if(this.intersectsPoint(Mouse.getInstance().x(),Mouse.getInstance().y())) {
            Mouse.getInstance().setCursor(new Cursor(Cursor.HAND_CURSOR));
            this.setHovered(true);
            //this.getPage().getPanel().setCursor(new Cursor(Cursor.HAND_CURSOR));
            if(Mouse.getInstance().leftClicked()) {
                this.command.execute();
            }
        }
        else {
            this.setHovered(false);
        }
    }

    public void setHovered(boolean hovered) {
        if(this.hovered==hovered) {return;}
        this.hovered = hovered;
        if(!this.hovered) {
            this.setBaseImg((new ImageIcon(IMG_PATH).getImage()));
        }
        else {
            this.setBaseImg((new ImageIcon(IMG_PATH_HOVER).getImage()));
        }
    }
}
