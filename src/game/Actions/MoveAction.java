package game.Actions;

import game.UndoFunction.GameState;
import game.Players.Player;

import game.Drawables.Position;
// abstract action handling movements for tokens from one place to another
public abstract class MoveAction extends Action {
    protected Position startPosition;
    protected Position endPosition;

    /**
     *
     * @param actionType
     * @param player
     * @param startPosition
     * @param endPosition
     */
    public MoveAction(ActionType actionType, Player player, Position startPosition, Position endPosition) {
        super(actionType, player);
        this.startPosition = startPosition;
        this.endPosition = endPosition;
    }

    /**
     *
     * @param gameState state of the game
     */
    @Override
    public abstract void performAction(GameState gameState);

    /**
     *
     * @return
     */
    @Override
    public Position getInitialPosition() {
        return this.startPosition;
    }

    /**
     *
     * @return
     */
    @Override
    public Position getFinalPosition() {
        return this.endPosition;
    }
}


