package game.UndoFunction;

import game.Drawables.Position;
import game.Drawables.Token;
import game.GameRuleRegulation.MillCondition;
import game.Players.Player;
import game.Teams;
import game.UIComponents.Board;
import game.UIComponents.GamePage;

public class GameState {
    private Position[][] grid;
    private Integer playerOnePieces;
    private Integer playerTwoPieces;
    private MillCondition millCondition;

//    public GameState(Board board, Integer playerOnePieces, Integer playerTwoPieces) {
//        this.board = board;
//        this.playerOnePieces = playerOnePieces;
//        this.playerTwoPieces = playerTwoPieces;
//    }
    public GameState(MillCondition millCondition) {
        this.millCondition = millCondition;
    }

    public void placePiece(Enum<Teams> team, Position position) {
        position.setToken(new Token(position.getPage(),position.getX(),position.getY(),team));
    }

    public void movePiece(Position startPos, Position endPos) {
        startPos.getToken().moveSelf(startPos,endPos);
    }

    public void removePiece(Position position) {
        position.getToken().delete();
        position.setToken(null);
    }

    public Memento takeSnapshot(Player player, Position startPosition, Position endPosition) {
        return new Memento(player,startPosition,endPosition,this.millCondition);
    }

    public void restore(Memento memento) {
        if(memento.getStartPosition()==null && memento.getEndPosition()!=null) {
            this.removePiece(memento.getEndPosition());
            memento.getPlayer().changePiecesInHand(1);
            ((GamePage) memento.getEndPosition().getPage()).nextTurn();
        } else if (memento.getStartPosition()!=null && memento.getEndPosition()!=null) {
            this.movePiece(memento.getEndPosition(),memento.getStartPosition());
            ((GamePage) memento.getEndPosition().getPage()).nextTurn();
        } else if (memento.getStartPosition()!=null && memento.getEndPosition()==null) {
            this.placePiece(memento.getPlayer().getTeam()== Teams.DUCK ? Teams.GOOSE : Teams.DUCK,memento.getStartPosition());
        }
        this.millCondition.copyValues(memento.getMillCondition());
//      this.grid = memento.getSavedBoardState();
//      this.playerOnePieces = memento.getPlayerOnePieces();
//      this.playerTwoPieces = memento.getPlayerTwoPieces();
    }


    public static class Memento {
        private Player player;
        private Position startPosition;
        private Position endPosition;
        private MillCondition millCondition;
        private Memento (Player player,Position startPosition, Position endPosition, MillCondition millCondition) {
            this.player = player;
            this.startPosition = startPosition;
            this.endPosition = endPosition;
            this.millCondition = millCondition.clone();
        }

        public Player getPlayer() {return player;}
        public Position getStartPosition() {return startPosition;}
        public Position getEndPosition() {return endPosition;}
        public MillCondition getMillCondition() {return millCondition;}
    }
}
