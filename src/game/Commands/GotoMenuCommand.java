package game.Commands;

import game.UIComponents.GamePage;
import game.UIComponents.MainMenuPage;
import game.UIComponents.Panel;

/**
 *  Class of Command to return to the menu
 *
 * @author Garret Yong Shern Min
 * @version 1.0 18/4/2023
 */
public class GotoMenuCommand implements Command{
    private Panel panel;
    public GotoMenuCommand(Panel panel) {
        this.panel = panel;
    }
    /**
     * run the command
     */
    @Override
    public void execute() {
        this.panel.registerPage(new GamePage(this.panel));
        this.panel.setCurrentPage(MainMenuPage.ID);
    }
}
