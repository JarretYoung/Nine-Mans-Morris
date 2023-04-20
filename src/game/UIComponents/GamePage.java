package game.UIComponents;

import game.Drawables.Line;
import game.Drawables.Position;
import game.Drawables.Token;

public class GamePage extends Page {
    public static final String ID = "game";
    public GamePage(Panel panel) {
        super(panel, ID);
        new Position(this,50,50);
        new Position(this,100,50);
        new Position(this,50,100);
        new Line(this,50,100,50,true);
        new Line(this,50,100,50,false);
        new Token(this,200,200,true);
    }
}
