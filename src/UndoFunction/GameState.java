package UndoFunction;

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
        position.setToken(new Token(position.getPage(),position.getX(),position.getY(),player.getTeam()));
        player.changePiecesLeft(1);
        player.changePiecesInHand(-1);
    }

    public void movePiece(Player player, Position startPos, Position endPos) {
        startPos.getToken().moveSelf(startPos,endPos);

    }

    public void removePiece(Position position) {}
}
