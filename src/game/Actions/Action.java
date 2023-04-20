package game.Actions;
import UndoFunction.GameState;
import game.Players.Player;

import java.time.LocalDateTime;

public abstract class Action {
    protected ActionType actionType;
    protected Player player;
    protected LocalDateTime timestamp;

    public Action(ActionType actionType, Player player) {
        this.actionType = actionType;
        this.player = player;
        this.timestamp = LocalDateTime.now();
    }

    public abstract void performAction(GameState gameState);
}
