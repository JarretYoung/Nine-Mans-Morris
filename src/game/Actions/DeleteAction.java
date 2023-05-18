package game.Actions;

import game.UndoFunction.GameState;
import game.Players.Player;

import game.Drawables.Position;
// action representing the deletion of a token
public class DeleteAction extends Action {
    private Position position;

    /**
     *
     * @param player
     * @param position
     */
    public DeleteAction(Player player, Position position) {
        super(ActionType.DELETE, player);
        this.position = position;
    }
    // remove the token

    /**
     *
     * @param gameState state of the game
     */
    @Override
    public void performAction(GameState gameState) {
        gameState.removePiece(player,position);
    }

    /**
     *
     * @return
     */
    @Override
    public Position getInitialPosition() {
        return this.position;
    }

    /**
     *
     * @return
     */
    @Override
    public Position getFinalPosition() {
        return null;
    }
}

