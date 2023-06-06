package game.Commands;

import game.SaveFunction.SaveObj;
import game.SaveFunction.SaveStrategy;
import game.SaveFunction.txtSaveStrategy;
import game.UIComponents.GamePage;
import game.UIComponents.Panel;
// command to load the game from a file
public class LoadCommand implements Command {
    private Panel panel;
    private SaveStrategy saveStrategy;

    public LoadCommand(Panel panel) {
        this.panel = panel;
    }
    /**
     * run the command
     */
    @Override
    public void execute() {
        GamePage gamePage = new GamePage(this.panel,false);
        this.panel.registerPage(gamePage);
        saveStrategy = new txtSaveStrategy(gamePage.genSaveObj());
        saveStrategy.restoreToProgress();
        this.panel.setCurrentPage(gamePage.getId());
    }
}
