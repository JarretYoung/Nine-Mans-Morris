package game.Commands;

import game.UIComponents.GamePage;
import game.UIComponents.Panel;

public class GotoNewGameCommand implements Command {
    private Panel panel;
    private boolean singleplayer;
    public GotoNewGameCommand(Panel panel, boolean singleplayer) {
        this.panel = panel;
        this.singleplayer = singleplayer;
    }
    /**
     * run the command
     */
    @Override
    public void execute() {
        this.panel.registerPage(new GamePage(this.panel,this.singleplayer));
        this.panel.setCurrentPage(GamePage.ID);
    }
}
