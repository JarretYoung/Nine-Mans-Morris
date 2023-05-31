package game.Actions;

import game.UndoFunction.GameState;
import game.Players.Player;

import game.Drawables.Position;
import game.UndoFunction.GameStateEditor;

// action representing a token moving anywhere
public class FlyAction extends MoveAction {
    /**
     * constructor
     * @param player
     * @param startPosition
     * @param endPosition
     */
    public FlyAction(Player player, Position startPosition, Position endPosition) {
        super(ActionType.FLY, player, startPosition, endPosition);
    }

    /**
     * does the action
     * @param gameStateEditor state of the game
     */
    @Override
    public void performAction(GameStateEditor gameStateEditor) {
        gameStateEditor.movePiece(player, startPosition, endPosition);
    }
}


