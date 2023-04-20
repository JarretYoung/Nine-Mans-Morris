package game.UIComponents;

import game.Drawables.Line;
import game.Drawables.Position;
import game.Drawables.Token;

public class GamePage extends Page {
    public static final String ID = "game";
    private Board board;
    public GamePage(Panel panel) {
        super(panel, ID);
        this.board = new Board(this);
    }
}
