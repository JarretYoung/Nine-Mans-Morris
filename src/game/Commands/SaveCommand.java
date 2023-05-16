package game.Commands;

import game.UIComponents.Panel;

public class SaveCommand implements Command{
    private Panel panel;

    public SaveCommand(Panel panel) {
        this.panel = panel;
    }

    @Override
    public void execute() {
        //do smtg
    }
}
