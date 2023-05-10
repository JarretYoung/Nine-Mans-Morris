package game.Commands;

import game.UIComponents.GamePage;
import game.UIComponents.Panel;

import java.awt.event.WindowEvent;

public class ExitCommand implements Command {
    private Panel panel;
    public ExitCommand(Panel panel) {
        this.panel = panel;
    }
    @Override
    public void execute() {
        this.panel.getFrame().dispatchEvent(new WindowEvent(this.panel.getFrame(), WindowEvent.WINDOW_CLOSING));
    }
}
