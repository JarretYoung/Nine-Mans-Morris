package game.Actions;

import game.Players.Player;

public abstract class MoveAction extends Action {
    protected int from;
    protected int to;

    public MoveAction(ActionType actionType, Player player, int from, int to) {
        super(actionType, player);
        this.from = from;
        this.to = to;
    }
}

