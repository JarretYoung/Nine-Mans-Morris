package game.Actions;

import game.UndoFunction.GameState;
import game.Players.Player;

import game.Drawables.Position;
import game.UndoFunction.GameStateEditor;

//
public class PlaceAction extends Action {
    private Position position;
/**
 * Action representing the insertion of a token onto the board
 * @author Syed Zubin Hafiz
 * @version 1.1
 */
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
     * @param gameStateEditor state of the game
     */
    @Override
    public void performAction(GameStateEditor gameStateEditor) {
        gameStateEditor.placePiece(player, position);
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

