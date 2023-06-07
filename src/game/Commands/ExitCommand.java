package game.Commands;

import game.UIComponents.GamePage;
import game.UIComponents.Panel;

import java.awt.event.WindowEvent;

/**
 *  Class of Command that exits the game
 *
 * @author Ong Chien Ming
 * @version 1.0 10/5/2023
 */
public class ExitCommand implements Command {
    private Panel panel;
    public ExitCommand(Panel panel) {
        this.panel = panel;
    }
    /**
     * run the command
     */
    @Override
    public void execute() {
        this.panel.getFrame().dispatchEvent(new WindowEvent(this.panel.getFrame(), WindowEvent.WINDOW_CLOSING));
    }
}
