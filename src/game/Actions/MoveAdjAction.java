package game.Actions;

import game.UndoFunction.GameState;
import game.Players.Player;

import game.Drawables.Position;
import game.UndoFunction.GameStateEditor;


/**
 * Action representing a token moving only to adjacent locations
 * @author Syed Zubin Hafiz
 * @version 1.2
 */
public class MoveAdjAction extends MoveAction {
    /**
     * constructor
     * @param player player doing the action
     * @param startPosition starting move position
     * @param endPosition ending move position
     */
    public MoveAdjAction(Player player, Position startPosition, Position endPosition) {
        super(ActionType.MOVE_ADJ, player, startPosition, endPosition);
    }

    /**
     * does the action
     * @param gameStateEditor state of the game
     */
    @Override
    public void performAction(GameStateEditor gameStateEditor) {
        gameStateEditor.movePiece(player, startPosition, endPosition);
    }
}


