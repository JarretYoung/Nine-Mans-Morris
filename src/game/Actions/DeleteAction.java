package game.Actions;

import UndoFunction.GameState;
import game.Players.Player;

import game.Drawables.Position;

public class DeleteAction extends Action {
    private Position position;

    public DeleteAction(Player player, Position position) {
        super(ActionType.DELETE, player);
        this.position = position;
    }

    @Override
    public void performAction(GameState gameState) {
        gameState.removePiece(position);
    }
}

