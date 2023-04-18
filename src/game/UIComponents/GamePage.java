package game.UIComponents;

public class GamePage extends Page {
    public static final String ID = "game";
    public GamePage(Panel panel) {
        super(panel, ID);
    }

    @Override
    public void tick() {
        if(Mouse.getInstance().leftClicked()) { // on click go to main menu page (testing code)
            this.getPanel().setCurrentPage(MainMenuPage.ID);
        }
        super.tick();
    }
}
