package game.Drawables;

import game.Commands.Command;
import game.Teams;
import game.UIComponents.*;

import javax.swing.*;
import java.awt.*;

/**
 *  Button class that extends Sprite superclass which will be used to display buttons on the UI
 *
 * @author Ong Chien Ming
 * @version 1.0 10/5/2023
 */
public class Button extends Sprite {
    // attributes
    public final static String IMG_PATH = "images/button.png"; // image for buttons by default
    public final static String IMG_PATH_HOVER = "images/buttonLight.png"; // image for when the button is hovered over
    private Command command; // object that contains the command to run when the button is clicked
    private Text text; // text describing the button's action
    private boolean hovered; // is there a mouse hovering on the button?

    /**
     * constructor
     * @param page page that the sprite is on
     * @param x horizontal coordinate position of the sprite
     * @param y vertical coordinate position of the sprite
     * @param width horizontal size of the sprite in pixels
     * @param height vertical size of the sprite in pixels
     * @param textStr text to show on the button
     * @param command function to run upon click
     */
    public Button(Page page, double x, double y, double width, double height, String textStr, Command command) {
        super(page, x, y, width, height, (new ImageIcon(IMG_PATH)).getImage());
        //More attributes soon
        this.command = command;
        this.text = new Text(page,textStr,x,y,true);
        this.hovered = false;
    }


    /**
     * check if clicked, and run function if so
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
     * setter, with associated image change
     * @param hovered whether the mouse is over the button
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
