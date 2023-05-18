package game.Actions;

import game.UndoFunction.GameState;
import game.Players.Player;

import game.Drawables.Position;
// action representing the insertion of a token onto the board
public class PlaceAction extends Action {
    private Position position;

    /**
     * constructor
     * @param player player that will place the token
     * @param position position to place the token on
     */
    public PlaceAction(Player player, Position position) {
        super(ActionType.PLACE, player);
        this.position = position;
    }

    /**
     * does the action
     * @param gameState state of the game
     */
    @Override
    public void performAction(GameState gameState) {
        gameState.placePiece(player, position);
    }

    /**
     * the starting position of the token (or null if the token doesn't exist yet)
     * @return initial position
     */
    @Override
    public Position getInitialPosition() {
        return null;
    }

    /**
     * the final position of the token (or null if the token will be deleted)
     * @return final position
     */
    @Override
    public Position getFinalPosition() {
        return this.position;
    }
}

