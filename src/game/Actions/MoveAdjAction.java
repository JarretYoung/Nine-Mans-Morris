package game.Actions;

import UndoFunction.GameState;
import game.Players.Player;

import game.Drawables.Position;

public class MoveAdjAction extends MoveAction {
    public MoveAdjAction(Player player, Position startPosition, Position endPosition) {
        super(ActionType.MOVE_ADJ, player, startPosition, endPosition);
    }

    @Override
    public void performAction(GameState gameState) {
        gameState.movePiece(player, startPosition, endPosition);
    }
}


