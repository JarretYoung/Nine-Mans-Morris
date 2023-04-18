package game.Actions;

import javax.swing.text.Position;

public class FlyAction extends MoveAction {
    public FlyAction(Player player, Position startPosition, Position endPosition) {
        super(ActionType.FLY, player, startPosition, endPosition);
    }

    @Override
    public void performAction(GameState gameState) {
        gameState.movePiece(player, startPosition, endPosition);
    }
}


