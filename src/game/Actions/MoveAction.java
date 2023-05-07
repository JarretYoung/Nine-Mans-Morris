package game.Actions;

import UndoFunction.GameState;
import game.Players.Player;

import game.Drawables.Position;

public abstract class MoveAction extends Action {
    protected Position startPosition;
    protected Position endPosition;

    public MoveAction(ActionType actionType, Player player, Position startPosition, Position endPosition) {
        super(actionType, player);
        this.startPosition = startPosition;
        this.endPosition = endPosition;
    }

    @Override
    public abstract void performAction(GameState gameState);

    @Override
    public Position getInitialPosition() {
        return this.startPosition;
    }

    @Override
    public Position getFinalPosition() {
        return this.endPosition;
    }
}


