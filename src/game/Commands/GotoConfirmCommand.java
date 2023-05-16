package game.Commands;

import game.UIComponents.ConfirmPage;
import game.UIComponents.GamePage;
import game.UIComponents.Panel;

public class GotoConfirmCommand implements Command {
    private Panel panel;
    public GotoConfirmCommand(Panel panel) {
        this.panel = panel;
    }
    @Override
    public void execute() {
        this.panel.setCurrentPage(ConfirmPage.ID);
    }
}
