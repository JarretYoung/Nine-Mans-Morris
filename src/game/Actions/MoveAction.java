package game.Actions;

import game.UndoFunction.GameState;
import game.Players.Player;

import game.Drawables.Position;
// abstract action handling movements for tokens from one place to another
public abstract class MoveAction extends Action {
    protected Position startPosition;
    protected Position endPosition;

    /**
     * constructor
     * @param actionType type of action
     * @param player player doing the action
     * @param startPosition starting move position
     * @param endPosition ending move position
     */
    public MoveAction(ActionType actionType, Player player, Position startPosition, Position endPosition) {
        super(actionType, player);
        this.startPosition = startPosition;
        this.endPosition = endPosition;
    }

    /**
     * does the action
     * @param gameState state of the game
     */
    @Override
    public abstract void performAction(GameState gameState);

    /**
     * the starting position of the token (or null if the token doesn't exist yet)
     * @return initial position
     */
    @Override
    public Position getInitialPosition() {
        return this.startPosition;
    }

    /**
     * the final position of the token (or null if the token will be deleted)
     * @return final position
     */
    @Override
    public Position getFinalPosition() {
        return this.endPosition;
    }
}


