package game.GameRuleRegulation;

import game.Actions.*;
import game.Drawables.Position;
import game.Players.Player;
import game.UIComponents.Board;

import java.util.ArrayList;

public class LegalMoves {
    public LegalMoves() {
    }
    public ArrayList<Action> getAllowableActions(Player player, Board board,boolean millFormed) {
        if(millFormed) {
            return this.getDeleteActions(player,board);
        }
        else if(player.checkPiecesInHand()>0) {
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
                    && startPos.getToken().getPlayer() == player.getTeam()) {
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
                    && startPos.getToken().getPlayer() == player.getTeam()) {
                for(Position endPos : board.getPositionsCopy()) {
                    if(endPos.getToken()==null) {
                        actionList.add(new FlyAction(player,startPos,endPos));
                    }
                }
            }
        }
        return actionList;
    }

    private ArrayList<Action> getDeleteActions(Player player, Board board) {
        ArrayList<Action> actionList = new ArrayList<>();
        for(Position position : board.getPositionsCopy()) {
            if(position != null && position.getToken() != null
                    && position.getToken().getPlayer() != player.getTeam()) {
                actionList.add(new DeleteAction(player,position));
            }
        }
        return actionList;
    }
}
