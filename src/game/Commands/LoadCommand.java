package game.Commands;

import game.UIComponents.Panel;

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
