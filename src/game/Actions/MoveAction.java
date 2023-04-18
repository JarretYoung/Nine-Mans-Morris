package game.Actions;

import javax.swing.text.Position;

public abstract class MoveAction extends Action {
    protected Position startPosition;
    protected Position endPosition;

    public MoveAction(ActionType actionType, Player player, int startPosition, int endPosition) {
        super(actionType, player);
        this.startPosition = startPosition;
        this.endPosition = endPosition;
    }

    @Override
    public abstract void performAction(GameState gameState);
}


