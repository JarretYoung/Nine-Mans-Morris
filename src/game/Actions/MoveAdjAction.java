package game.Actions;
public class MoveAdjAction extends MoveAction {
    public MoveAdjAction(Player player, int from, int to) {
        super(ActionType.MOVE_ADJ, player, from, to);
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

