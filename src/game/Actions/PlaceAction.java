package game.Actions;
public class PlaceAction extends Action {
    private int position;

    public PlaceAction(Player player, int position) {
        super(ActionType.PLACE, player);
        this.position = position;
    }

    @Override
    public void execute(GameState gameState) {
        gameState.placePiece(player, position);
    }

    @Override
    public void undo(GameState gameState) {
        gameState.removePiece(position);
    }
}

