package game.UndoFunction;

import game.Drawables.Position;
import game.Drawables.Token;
import game.Players.Player;
import game.UIComponents.Board;

public class GameState {
    private Board board;
    private Integer playerOnePieces;
    private Integer playerTwoPieces;

//    public GameState(Board board, Integer playerOnePieces, Integer playerTwoPieces) {
//        this.board = board;
//        this.playerOnePieces = playerOnePieces;
//        this.playerTwoPieces = playerTwoPieces;
//    }

    public void placePiece(Player player, Position position) {
        position.setToken(new Token(position.getPage(),position.getX(),position.getY(),player.getTeam()));
        player.changePiecesLeft(1);
        player.changePiecesInHand(-1);
    }

    public void movePiece(Player player, Position startPos, Position endPos) {
        startPos.getToken().moveSelf(startPos,endPos);

    }

    public void removePiece(Player player, Position position) {
        position.getToken().delete();
        position.setToken(null);
        player.changePiecesLeft(-1);
    }

    public void set(Board board, Integer playerOnePieces, Integer playerTwoPieces) {
        this.board = board;
        this.playerOnePieces = playerOnePieces;
        this.playerTwoPieces = playerTwoPieces;
    }

    public Memento takeSnapshot() {
        return new Memento(this.board, this.playerOnePieces, this.playerTwoPieces);
    }

    public void restore(Memento memento) {
        this.board = memento.getSavedBoardState();
        this.playerOnePieces = memento.getPlayerOnePieces();
        this.playerTwoPieces = memento.getPlayerTwoPieces();
    }


    public static class Memento {
        private Board board;
        private Integer playerOnePieces;
        private Integer playerTwoPieces;

        private Memento (Board _board, Integer playerOnePieces, Integer playerTwoPieces) {
            this.board = _board;
            this.playerOnePieces = playerOnePieces;
            this.playerTwoPieces = playerTwoPieces;
        }

        private Board getSavedBoardState() {
            return this.board;
        }

        private Integer getPlayerOnePieces() {
            return this.playerOnePieces;
        }

        private Integer getPlayerTwoPieces() {
            return this.playerTwoPieces;
        }
    }
}
