package game.UIComponents;


import game.Drawables.Token;

import javax.swing.*;
import java.awt.*;

public class MainMenuPage extends Page {
    public static final String ID = "mainMenu";
    public MainMenuPage(Panel panel) {
        super(panel, ID);
    }

    @Override
    public void tick() {
        super.tick();
        if(Mouse.getInstance().leftClicked()) { // on click go to game page (temporary code before buttons are implemented)
            this.getPanel().setCurrentPage(GamePage.ID);
        }
        super.tick();
    }

}
