package game.Actions;

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
}


