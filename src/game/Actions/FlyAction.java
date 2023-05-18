package game.Actions;

import game.UndoFunction.GameState;
import game.Players.Player;

import game.Drawables.Position;
// action representing a token moving anywhere
public class FlyAction extends MoveAction {
    /**
     *
     * @param player
     * @param startPosition
     * @param endPosition
     */
    public FlyAction(Player player, Position startPosition, Position endPosition) {
        super(ActionType.FLY, player, startPosition, endPosition);
    }

    /**
     *
     * @param gameState state of the game
     */
    @Override
    public void performAction(GameState gameState) {
        gameState.movePiece(player, startPosition, endPosition);
    }
}


