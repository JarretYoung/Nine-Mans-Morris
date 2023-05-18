package game.Commands;

import game.UIComponents.GamePage;
import game.UIComponents.Panel;

/**
 *  Class of Command to return to the game
 *
 * @author Garret Yong Shern Min
 * @version 1.0 18/4/2023
 */
public class GotoGameCommand implements Command {
    private Panel panel;
    public GotoGameCommand(Panel panel) {
        this.panel = panel;
    }
    /**
     * run the command
     */
    @Override
    public void execute() {
        this.panel.setCurrentPage(GamePage.ID);
    }
}
