package game.Actions;
import game.UndoFunction.GameState;
import game.Drawables.Position;
import game.Players.Player;

import java.time.LocalDateTime;
// class representing a player doing something
public abstract class Action {
    protected ActionType actionType;
    protected Player player;
    protected LocalDateTime timestamp;
    // constructor
    public Action(ActionType actionType, Player player) {
        this.actionType = actionType;
        this.player = player;
        this.timestamp = LocalDateTime.now();
    }
    // perform the action
    public abstract void performAction(GameState gameState);
    // the starting position of the token (or null if the token doesn't exist yet)
    public abstract Position getInitialPosition();
    // the final position of the token (or null if the token will be deleted)
    public abstract Position getFinalPosition();
}
