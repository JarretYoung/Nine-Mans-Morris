package game.Actions;
import game.UndoFunction.GameState;
import game.Drawables.Position;
import game.Players.Player;
import game.UndoFunction.GameStateEditor;

import java.time.LocalDateTime;


/**
 *  Class representing a player doing something
 *
 * @author Syed Zubin Hafiz
 * @version 1.1 16/4/2023
 */
public abstract class Action {
    protected ActionType actionType;
    protected Player player;
    protected LocalDateTime timestamp;
    /**
     * constructor for Action
     * @param actionType type of action performed
     * @param player player playing the action
     */
    public Action(ActionType actionType, Player player) {
        this.actionType = actionType;
        this.player = player;
        this.timestamp = LocalDateTime.now();
    }
    // perform the action
    /**
     * does the action
     * @param gameStateEditor state of the game
     */
    public abstract void performAction(GameStateEditor gameStateEditor);
    /**
     * the starting position of the token (or null if the token doesn't exist yet)
     * @return initial position
     */
    public abstract Position getInitialPosition();
    /**
     * the final position of the token (or null if the token will be deleted)
     * @return final position
     */
    public abstract Position getFinalPosition();
}
