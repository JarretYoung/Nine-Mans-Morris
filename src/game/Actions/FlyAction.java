package game.Actions;

import UndoFunction.GameState;
import game.Players.Player;

import game.Drawables.Position;

public class FlyAction extends MoveAction {
    public FlyAction(Player player, Position startPosition, Position endPosition) {
        super(ActionType.FLY, player, startPosition, endPosition);
    }

    @Override
    public void performAction(GameState gameState) {
        gameState.movePiece(player, startPosition, endPosition);
    }
}


