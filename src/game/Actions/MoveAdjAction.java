package game.Actions;

import game.UndoFunction.GameState;
import game.Players.Player;

import game.Drawables.Position;
// action representing a token moving only to adjacent locations
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
     * @param gameState state of the game
     */
    @Override
    public void performAction(GameState gameState) {
        gameState.movePiece(player, startPosition, endPosition);
    }
}


