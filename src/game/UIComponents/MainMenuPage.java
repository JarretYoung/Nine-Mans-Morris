package game.UIComponents;


import game.Drawables.Token;

import javax.swing.*;
import java.awt.*;

public class MainMenuPage extends Page {
    public static final String ID = "mainMenu";
    private Image img;
    public MainMenuPage(Panel panel) {
        super(panel, ID);
        new Token(this,50,50,true);
        new Token(this,200,50,false);
        new Token(this,100,100,true);
        new Token(this,300,200,false);
    }

    @Override
    public void tick() {
        super.tick();
        if(Mouse.getInstance().leftClicked()) { // on click go to game page (testing code)
            this.getPanel().setCurrentPage(GamePage.ID);
        }
        super.tick();
    }

}
