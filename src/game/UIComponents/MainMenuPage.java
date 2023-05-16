package game.UIComponents;


import game.Commands.GotoGameCommand;
import game.Commands.LoadCommand;
import game.Drawables.Button;
import game.Commands.ExitCommand;
import game.Drawables.DecorativeSprite;
import game.Drawables.Text;
import game.Drawables.Token;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

public class MainMenuPage extends Page {
    public static final String ID = "mainMenu";
    public final static String IMG_PATH_DUCK = "images/duck.png";
    public final static String IMG_PATH_GOOSE = "images/goose.png";
    public DecorativeSprite duck;
    public DecorativeSprite goose;

    public MainMenuPage(Panel panel) {
        super(panel, ID);
        this.duck = new DecorativeSprite(this, 100, 110, IMG_PATH_DUCK);
        this.goose =new DecorativeSprite(this, 500, 110, IMG_PATH_GOOSE);
        new Text(this, "NINE MAN", 300, 100, true, Color.DARK_GRAY,"Engravers MT",35);
        new Text(this, "MORRIS", 300, 150, true, Color.DARK_GRAY,"Engravers MT",35);
        new Button(this,300,250,180,60,"SINGLE PLAYER",new GotoGameCommand(this.getPanel()));
        new Button(this,300,325,180,60,"MULTIPLAYER",new GotoGameCommand(this.getPanel()));
        new Button(this,300,400,180,60,"LOAD GAME",new LoadCommand(this.getPanel()));
        new Button(this,300,475,180,60,"EXIT",new ExitCommand(this.getPanel()));
    }

    @Override
    public void tick() {
        super.tick();
    }
}
