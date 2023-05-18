package game.UIComponents;

import game.Commands.GotoGameCommand;
import game.Commands.GotoMenuCommand;
import game.Drawables.Button;
import game.Drawables.Text;

public class ConfirmPage extends Page {
    public static final String ID = "confirm";

    /**
     *
     * @param panel
     */
    public ConfirmPage(Panel panel) {
        super(panel, ID);
        new Text(this,"confirm going back to the main menu?",300,250,true);
        new Button(this,200,350,100,50,"Yes",new GotoMenuCommand(panel));
        new Button(this,400,350,100,50,"No",new GotoGameCommand(panel));

    }
}
