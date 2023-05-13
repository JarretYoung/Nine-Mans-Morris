package game.UndoFunction;

import game.Drawables.Position;
import game.Drawables.Token;
import game.Players.Player;
import game.UIComponents.Board;

public class GameState {
    private Position[][] grid;
    private Integer playerOnePieces;
    private Integer playerTwoPieces;

//    public GameState(Board board, Integer playerOnePieces, Integer playerTwoPieces) {
//        this.board = board;
//        this.playerOnePieces = playerOnePieces;
//        this.playerTwoPieces = playerTwoPieces;
//    }

    public void placePiece(Player player, Position position) {
        position.setToken(new Token(position.getPage(),position.getX(),position.getY(),player.getTeam()));
        player.changePiecesInHand(-1);
    }

    public void movePiece(Player player, Position startPos, Position endPos) {
        startPos.getToken().moveSelf(startPos,endPos);
    }

    public void removePiece(Player player, Position position) {
        position.getToken().delete();
        position.setToken(null);
    }

    /** Maybe I should add the turn */
    public void set(Position[][] grid, Integer playerOnePieces, Integer playerTwoPieces) {
        this. grid = grid;
        this.playerOnePieces = playerOnePieces;
        this.playerTwoPieces = playerTwoPieces;
    }

    public void set(Board board, Integer playerOnePieces, Integer playerTwoPieces) {
        this. grid = board.getGrid();
        this.playerOnePieces = playerOnePieces;
        this.playerTwoPieces = playerTwoPieces;
    }

    public Memento takeSnapshot() {
        return new Memento(this.grid, this.playerOnePieces, this.playerTwoPieces);
    }

    public void restore(Memento memento) {
        this.grid = memento.getSavedBoardState();
        this.playerOnePieces = memento.getPlayerOnePieces();
        this.playerTwoPieces = memento.getPlayerTwoPieces();
    }


    public static class Memento {
        private Position[][] grid;
        private Integer playerOnePieces;
        private Integer playerTwoPieces;

        private Memento (Position[][] grid, Integer playerOnePieces, Integer playerTwoPieces) {
            this.grid = grid;
            this.playerOnePieces = playerOnePieces;
            this.playerTwoPieces = playerTwoPieces;
        }

        private Position[][] getSavedBoardState() {
            return this.grid;
        }

        private Integer getPlayerOnePieces() {
            return this.playerOnePieces;
        }

        private Integer getPlayerTwoPieces() {
            return this.playerTwoPieces;
        }
    }
}
