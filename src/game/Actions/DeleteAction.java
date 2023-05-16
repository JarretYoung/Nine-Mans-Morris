package game.Actions;

import game.UndoFunction.GameState;
import game.Players.Player;

import game.Drawables.Position;
// action representing the deletion of a token
public class DeleteAction extends Action {
    private Position position;

    public DeleteAction(Player player, Position position) {
        super(ActionType.DELETE, player);
        this.position = position;
    }
    // remove the token
    @Override
    public void performAction(GameState gameState) {
        gameState.removePiece(player,position);
    }

    @Override
    public Position getInitialPosition() {
        return this.position;
    }

    @Override
    public Position getFinalPosition() {
        return null;
    }
}

