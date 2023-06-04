package game.Commands;

import game.SaveFunction.SaveStrategy;
import game.SaveFunction.txtSaveStrategy;
import game.UIComponents.GamePage;
import game.UIComponents.Panel;
// command to load the game from a file
public class LoadCommand implements Command {
    private Panel panel;
    private SaveStrategy saveStrategy = new txtSaveStrategy();

    public LoadCommand(Panel panel) {
        this.panel = panel;
    }
    /**
     * run the command
     */
    @Override
    public void execute() {
        this.panel.registerPage(saveStrategy.restoreToProgress());
    }
}
