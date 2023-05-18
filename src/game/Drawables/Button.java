package game.Drawables;

import game.Commands.Command;
import game.Teams;
import game.UIComponents.*;

import javax.swing.*;
import java.awt.*;
// class to represent buttons that can be pressed
public class Button extends Sprite {
    // attributes
    public final static String IMG_PATH = "images/button.png"; // image for buttons by default
    public final static String IMG_PATH_HOVER = "images/buttonLight.png"; // image for when the button is hovered over
    private Command command; // object that contains the command to run when the button is clicked
    private Text text; // text describing the button's action
    private boolean hovered; // is there a mouse hovering on the button?

    /**
     *
     * @param page
     * @param x
     * @param y
     * @param width
     * @param height
     * @param textStr
     * @param command
     */
    public Button(Page page, double x, double y, double width, double height, String textStr, Command command) {
        super(page, x, y, width, height, (new ImageIcon(IMG_PATH)).getImage());
        //More attributes soon
        this.command = command;
        this.text = new Text(page,textStr,x,y,true);
        this.hovered = false;
    }


    /**
     *
     */
    public void tick() {
        // is the mouse hovering over the button?
        if(this.intersectsPoint(Mouse.getInstance().x(),Mouse.getInstance().y())) {
            // set values accordingly
            Mouse.getInstance().setCursor(new Cursor(Cursor.HAND_CURSOR));
            this.setHovered(true);
            // is the button being clicked? run command if so
            if(Mouse.getInstance().leftClicked()) {
                this.command.execute();
            }
        }
        else {
            // button is not hovered over
            this.setHovered(false);
        }
    }

    /**
     *
     * @param hovered
     */
    public void setHovered(boolean hovered) {
        // don't do anything if the hover status hasn't changed
        if(this.hovered==hovered) {return;}
        // set
        this.hovered = hovered;
        // change image accordingly
        if(!this.hovered) {
            this.setBaseImg((new ImageIcon(IMG_PATH).getImage()));
        }
        else {
            this.setBaseImg((new ImageIcon(IMG_PATH_HOVER).getImage()));
        }
    }
}
