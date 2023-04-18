package game.Actions;
public class DeleteAction extends Action {
    private int position;

    public DeleteAction(Player player, int position) {
        super(ActionType.DELETE, player);
        this.position = position;
    }

    @Override
    public void execute(GameState gameState) {
        gameState.removePiece(position);
    }

    @Override
    public void undo(GameState gameState) {
        gameState.placePiece(player.getOpponent(), position);
    }
}
