package game.UndoFunction;

import game.Drawables.Position;
import game.Drawables.Token;
import game.GameRuleRegulation.Mill;
import game.GameRuleRegulation.MillCondition;
import game.Players.Player;
import game.UIComponents.Board;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class GameStateEditor {
    private Stack<GameState.Memento> stateHistory;
    private GameState gameState;

    public GameStateEditor(MillCondition millCondition) {
        stateHistory = new Stack<>();
        gameState = new GameState(millCondition);
    }


    public void placePiece(Player player, Position position) {
        this.gameState.placePiece(player.getTeam(),position);
        this.stateHistory.add(this.gameState.takeSnapshot(player,null,position));
        player.changePiecesInHand(-1);
    }

    public void movePiece(Player player, Position startPos, Position endPos) {
        this.gameState.movePiece(startPos,endPos);
        this.stateHistory.add(this.gameState.takeSnapshot(player,startPos,endPos));
    }

    public void removePiece(Player player, Position position) {
        this.gameState.removePiece(position);
        this.stateHistory.add(this.gameState.takeSnapshot(player,position,null));

    }

//    public void makeMove(Board board, Integer playerOnePieces, Integer playerTwoPieces) {
//        gameState.set(board.getGrid(), playerOnePieces, playerTwoPieces);
//        stateHistory.add(gameState.takeSnapshot());
//    }

    public void undo() {
        GameState.Memento memento = stateHistory.pop();
        gameState.restore(memento);
        if(memento.getStartPosition()!=null && memento.getEndPosition()==null) { // if deleting a piece, undo again
            this.undo();
        }
    }
}
