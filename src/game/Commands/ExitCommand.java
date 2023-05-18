package game.Commands;

import game.UIComponents.GamePage;
import game.UIComponents.Panel;

import java.awt.event.WindowEvent;
// command to close the game
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
