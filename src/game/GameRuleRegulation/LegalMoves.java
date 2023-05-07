package game.GameRuleRegulation;

import game.Actions.Action;
import game.Actions.PlaceAction;
import game.Drawables.Position;
import game.Players.Player;
import game.UIComponents.Board;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;

public class LegalMoves extends GameRules {
    public LegalMoves() {
    }
    public ArrayList<Action> getAllowableActions(Player player, Board board) {
        if(player.checkPiecesInHand()>0) {
            return this.getPlacingActions(player,board);
        }
        else if(player.checkPiecesLeft()>3) {
            throw new NotImplementedException();
        }
        else {
            throw new NotImplementedException();
        }
    }
    private ArrayList<Action> getPlacingActions(Player player, Board board) {
        ArrayList<Action> actionList = new ArrayList<>();
        for(Position position : board.getPositionsCopy()) {
            if(position.getToken()==null) { // if no token
                actionList.add(new PlaceAction(player,position));
            }
        }
        return actionList;
    }
}
