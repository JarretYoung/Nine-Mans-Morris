package game.Actions;

import game.UndoFunction.GameState;
import game.Players.Player;

import game.Drawables.Position;
import game.UndoFunction.GameStateEditor;

//
/**
 *  Action representing the deletion of a token
 *
 * @author Syed Zubin Hafiz
 * @version 1.2 20/4/2023
 */
public class DeleteAction extends Action {
    private Position position;

    /**
     * constructor
     * @param player player that formed the mill
     * @param position position of the token to ddelete
     */
    public DeleteAction(Player player, Position position) {
        super(ActionType.DELETE, player);
        this.position = position;
    }
    // remove the token

    /**
     * does the action
     * @param gameStateEditor state of the game
     */
    @Override
    public void performAction(GameStateEditor gameStateEditor) {
        gameStateEditor.removePiece(player,position);
    }

    /**
     * the starting position of the token (or null if the token doesn't exist yet)
     * @return initial position
     */
    @Override
    public Position getInitialPosition() {
        return this.position;
    }

    /**
     * the final position of the token (or null if the token will be deleted)
     * @return final position
     */
    @Override
    public Position getFinalPosition() {
        return null;
    }
}

