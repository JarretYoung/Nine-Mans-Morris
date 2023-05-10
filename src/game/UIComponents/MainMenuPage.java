package game.UIComponents;


import game.Commands.GotoGameCommand;
import game.Drawables.Button;
import game.Commands.ExitCommand;
import game.Drawables.Token;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

public class MainMenuPage extends Page {
    public static final String ID = "mainMenu";
    public MainMenuPage(Panel panel) {
        super(panel, ID);
        new Button(this,300,100,150,80,"START GAME",new GotoGameCommand(this.getPanel()));
//        new Button(this,300,300,150,80,"LOAD GAME",new LoadCommand(this.getPanel()));
        new Button(this,300,500,150,80,"EXIT",new ExitCommand(this.getPanel()));
    }

    @Override
    public void tick() {
        super.tick();
    }
}
