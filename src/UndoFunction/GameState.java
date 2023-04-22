package UndoFunction;

import game.Colours;
import game.Drawables.Position;
import game.Drawables.Token;
import game.Players.Player;
import game.UIComponents.Board;

public class GameState {
    private Board board;

    public GameState(Board board) {
        this.board = board;
    }

    public void placePiece(Player player, Position position) {
        position.setToken(new Token(position.getPage(),position.getX(),position.getY(),player.getColour() == Colours.WHITE));
    }

    public void movePiece(Player player, Position startPos, Position endPos) {}

    public void removePiece(Position position) {}
}
