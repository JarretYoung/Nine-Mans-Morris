package game.Actions;
public class FlyAction extends MoveAction {
    public FlyAction(Player player, int from, int to) {
        super(ActionType.FLY, player, from, to);
    }

    @Override
    public void execute(GameState gameState) {
        gameState.movePiece(player, from, to);
    }

    @Override
    public void undo(GameState gameState) {
        gameState.movePiece(player, to, from);
    }
}

