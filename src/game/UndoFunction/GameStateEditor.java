package game.UndoFunction;

import game.UIComponents.Board;

import java.util.Deque;
import java.util.LinkedList;

public class GameStateEditor {
    private Deque<GameState.Memento> stateHistory;
    private GameState gameState;

    public GameStateEditor() {
        stateHistory = new LinkedList<>();
        gameState = new GameState();
    }

    public void makeMove(Board board, Integer playerOnePieces, Integer playerTwoPieces) {
        gameState.set(board.getGrid(), playerOnePieces, playerTwoPieces);
        stateHistory.add(gameState.takeSnapshot());
    }

    public void undo() {
        gameState.restore(stateHistory.pop());
    }
}
