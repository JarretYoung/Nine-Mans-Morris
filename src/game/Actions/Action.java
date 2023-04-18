package game.Actions;
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

    public abstract void execute(GameState gameState);
    public abstract void undo(GameState gameState);

    public ActionType getActionType() {
        return actionType;
    }

    public Player getPlayer() {
        return player;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}

enum ActionType {
    PLACE, DELETE, MOVE_ADJ, FLY
}

