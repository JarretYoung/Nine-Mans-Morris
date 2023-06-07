package game.UndoFunction;

import com.google.gson.internal.LinkedTreeMap;
import game.Drawables.Position;
import game.Drawables.Token;
import game.GameRuleRegulation.Mill;
import game.GameRuleRegulation.MillCondition;
import game.Players.Player;
import game.SaveFunction.Saveable;
import game.UIComponents.Board;
import game.UIComponents.GamePage;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class GameStateEditor implements Saveable {
    private Stack<GameState.Memento> stateHistory;
    private GameState gameState;

    /**
     * Constructor for the GameStateEditor
     *
     * @param millCondition is whether a mill is in effect
     * @param gamePage the game page
     */
    public GameStateEditor(MillCondition millCondition, GamePage gamePage) {
        stateHistory = new Stack<>();
        gameState = new GameState(millCondition, gamePage);
    }

    /**
     * Method that updates the gamestateeditor when a place action is done
     *
     * @param player is the player that is making the move
     * @param position is the position of all the pieces on the board
     */
    public void placePiece(Player player, Position position) {
        this.gameState.placePiece(player.getTeam(),position);
        this.stateHistory.add(this.gameState.takeSnapshot(player,null,position));
        player.changePiecesInHand(-1);
    }

    /**
     * Method that updates the gamestateeditor when a move action is done
     *
     * @param player is the player that is making the move
     * @param startPos is the start position of the piece to be moved
     * @param endPos is the end position of the piece to be moved
     */
    public void movePiece(Player player, Position startPos, Position endPos) {
        this.gameState.movePiece(startPos,endPos);
        this.stateHistory.add(this.gameState.takeSnapshot(player,startPos,endPos));
    }

    /**
     * Method that updates the gamestateeditor when a remove action is done
     *
     * @param player is the player that is making the move
     * @param position is the position of the piece that is to be removed
     */
    public void removePiece(Player player, Position position) {
        this.gameState.removePiece(position);
        this.stateHistory.add(this.gameState.takeSnapshot(player,position,null));

    }

    /**
     * Method that calleds the undo method
     */
    public void undo() {
        this.undo(false);
    }

    /**
     * Method that handles the undo functionality
     * 
     * @param repeatOnce is a boolean value which determines whether to repeat the undo
     */
    public void undo(boolean repeatOnce) {
        GameState.Memento memento = stateHistory.pop();
        gameState.restore(memento);
        if(memento.getStartPosition()!=null && memento.getEndPosition()==null) { // if deleting a piece, undo again
            this.undo();
        }
        if(repeatOnce) {
            this.undo();
        }
    }

    @Override
    public LinkedTreeMap<String, Object> shelve() {
        LinkedTreeMap<String,Object> data = new LinkedTreeMap<>();
        Stack<GameState.Memento> copyStack = (Stack<GameState.Memento>) stateHistory.clone();
        ArrayList<Object> stateHistoryList = new ArrayList<>();
        while(!copyStack.empty()) {
            stateHistoryList.add(copyStack.pop().shelve());
        }
        data.put("stateHistory",stateHistoryList);
        return data;
    }

    @Override
    public void restore(LinkedTreeMap<String, Object> data) {
        ArrayList<Object> stateHistoryList = (ArrayList<Object>) data.get("stateHistory");
        for(int i = stateHistoryList.size()-1; i >= 0; i--) {
            this.stateHistory.add(GameState.getMementoFromData((LinkedTreeMap<String, Object>) stateHistoryList.get(i)));
        }
    }
}
