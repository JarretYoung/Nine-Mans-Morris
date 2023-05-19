package game.GameRuleRegulation;

import game.Actions.*;
import game.Drawables.Position;
import game.Players.Player;
import game.UIComponents.Board;

import java.util.ArrayList;

public class LegalMoves {

    /**
     * constructor
     * @param player current turn's player
     * @param board board of the game
     * @param millFormed whether a mill has been formed
     * @return
     */
    public ArrayList<Action> getAllowableActions(Player player, Board board,boolean millFormed) {
        if(millFormed) { // is there a mill that the player needs to handle?
            return this.getDeleteActions(player,board);
        }
        else if(player.checkPiecesInHand()>0) { // are there any more pieces that the player needs to place?
            return this.getPlacingActions(player,board);
        }
        else if(player.checkPiecesLeft()>3) { // does the player have enough pieces that it can only move adjacently?
            return this.getMovingActions(player,board);
        }
        else { // player can move pieces anywhere
            return this.getFlyingActions(player,board);
        }
    }

    /**
     * method to get actions corresponding to locations where tokens can be placed
     * @param player current turn's player
     * @param board board of the game
     * @return list of actions that can be taken by the player
     */
    private ArrayList<Action> getPlacingActions(Player player, Board board) {
        ArrayList<Action> actionList = new ArrayList<>();
        // for each position on the board
        for(Position position : board.getPositionsCopy()) {
            // if no token
            if(position.getToken()==null) {
                // add action
                actionList.add(new PlaceAction(player,position));
                position.setAllowed(true);
            }
        }
        return actionList;
    }

    /**
     * method to get actions corresponding to locations where tokens can be moved to
     * @param player current turn's player
     * @param board board of the game
     * @return list of actions that can be taken by the player
     */
    private ArrayList<Action> getMovingActions(Player player, Board board) {
        ArrayList<Action> actionList = new ArrayList<>();
        // for each position on the board
        for(Position startPos : board.getPositionsCopy()) {
            // if a token exists of the correct team
            if(startPos != null && startPos.getToken() != null
                    && startPos.getToken().getPlayer() == player.getTeam()) {
                // for each neighbour
                for(Position endPos : startPos.getNeighboursCopy()) {
                    // if the position is empty
                    if(endPos.getToken()==null) {
                        // add action
                        actionList.add(new MoveAdjAction(player,startPos,endPos));
                        startPos.setAllowed(true);
                        endPos.setAllowed(true);
                    }
                }
            }
        }
        return actionList;
    }

    /**
     * method to get actions corresponding to locations where tokens can be moved to
     * @param player current turn's player
     * @param board board of the game
     * @return list of actions that can be taken by the player
     */
    private ArrayList<Action> getFlyingActions(Player player, Board board) {
        ArrayList<Action> actionList = new ArrayList<>();
        // for each position on the board
        for(Position startPos : board.getPositionsCopy()) {
            // if a token exists of the correct team
            if(startPos != null && startPos.getToken() != null
                    && startPos.getToken().getPlayer() == player.getTeam()) {
                // for each position on the board
                for(Position endPos : board.getPositionsCopy()) {
                    // if the position is empty
                    if(endPos.getToken()==null) {
                        // add action
                        actionList.add(new FlyAction(player,startPos,endPos));
                        startPos.setAllowed(true);
                        endPos.setAllowed(true);
                    }
                }
            }
        }
        return actionList;
    }

    /**
     * method to get actions corresponding to locations with tokens that can be deleted
     * @param player current turn's player
     * @param board board of the game
     * @return list of actions that can be taken by the player
     */
    private ArrayList<Action> getDeleteActions(Player player, Board board) {
        ArrayList<Action> actionList = new ArrayList<>();
        // for each position on the board
        for(Position position : board.getPositionsCopy()) {
            // if a token exists of the correct team and it is not in a mill
            if(position != null && position.getToken() != null
                    && position.getToken().getPlayer() != player.getTeam()
                    && position.isMillExists()==false) {
                // add action
                actionList.add(new DeleteAction(player,position));
                position.setAllowed(true);
            }
        }
        return actionList;
    }
}
