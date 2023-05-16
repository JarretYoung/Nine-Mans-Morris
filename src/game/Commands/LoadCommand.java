package game.Commands;

import game.UIComponents.Panel;
// command to load the game from a file
public class LoadCommand implements Command {
    private Panel panel;

    public LoadCommand(Panel panel) {
        this.panel = panel;
    }

    @Override
    public void execute() {
        // do something
    }
}
