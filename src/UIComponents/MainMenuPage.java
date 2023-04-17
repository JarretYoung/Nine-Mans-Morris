package UIComponents;



public class MainMenuPage extends Page {
    public static final String ID = "mainMenu";
    public MainMenuPage(Panel panel) {
        super(panel, ID);
    }

    @Override
    public void tick() {
        if(Mouse.getInstance().leftClicked()) {
            System.out.printf("left click at x=%s,y=%s%n",Mouse.getInstance().x(),Mouse.getInstance().y());
        }
        super.tick();
    }
}
