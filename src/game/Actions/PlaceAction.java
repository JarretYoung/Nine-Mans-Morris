package game.Actions;

import javax.swing.text.Position;

public class PlaceAction extends Action {
    private Position position;

    public PlaceAction(Player player, int position) {
        super(ActionType.PLACE, player);
        this.position = position;
    }

    @Override
    public void performAction(GameState gameState) {
        gameState.placePiece(player, position);
    }
}

