package game.GameRuleRegulation;

import game.Actions.Action;
import game.Actions.FlyAction;
import game.Actions.MoveAdjAction;
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
            return this.getMovingActions(player,board);
        }
        else {
            return this.getFlyingActions(player,board);
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

    private ArrayList<Action> getMovingActions(Player player, Board board) {
        ArrayList<Action> actionList = new ArrayList<>();
        for(Position startPos : board.getPositionsCopy()) {
            if(startPos != null && startPos.getToken() != null
                    && startPos.getToken().getPlayer() == player.getTeam()) { // if no token
                for(Position endPos : startPos.getNeighboursCopy()) {
                    if(endPos.getToken()==null) {
                        actionList.add(new MoveAdjAction(player,startPos,endPos));
                    }
                }
            }
        }
        return actionList;
    }

    private ArrayList<Action> getFlyingActions(Player player, Board board) {
        ArrayList<Action> actionList = new ArrayList<>();
        for(Position startPos : board.getPositionsCopy()) {
            if(startPos != null && startPos.getToken() != null
                    && startPos.getToken().getPlayer() == player.getTeam()) { // if no token
                for(Position endPos : board.getPositionsCopy()) {
                    if(endPos.getToken()==null) {
                        actionList.add(new FlyAction(player,startPos,endPos));
                    }
                }
            }
        }
        return actionList;
    }
}
