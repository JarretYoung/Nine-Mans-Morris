package game.Commands;

import game.UIComponents.Panel;

public class SaveCommand implements Command{
    private Panel panel;

    public SaveCommand(Panel panel) {
        this.panel = panel;
    }
    /**
     * run the command
     */
    @Override
    public void execute() {
        //do smtg
        // step 1: do the parsing
        // step 2: do the saving
    }
}
