package game.Actions;

import game.UndoFunction.GameState;
import game.Players.Player;

import game.Drawables.Position;
// action representing the insertion of a token onto the board
public class PlaceAction extends Action {
    private Position position;

    public PlaceAction(Player player, Position position) {
        super(ActionType.PLACE, player);
        this.position = position;
    }

    @Override
    public void performAction(GameState gameState) {
        gameState.placePiece(player, position);
    }

    @Override
    public Position getInitialPosition() {
        return null;
    }

    @Override
    public Position getFinalPosition() {
        return this.position;
    }
}

