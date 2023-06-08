package game.Players;

import com.google.gson.internal.LinkedTreeMap;
import game.GameRuleRegulation.LegalMoves;
import game.SaveFunction.Saveable;
import game.Teams;

import game.Actions.Action;
import game.Drawables.Position;
import game.UIComponents.Board;

import java.util.ArrayList;
import java.util.Random;

/**
 *  Abstract class that is template for all player classes.
 *
 * @author Garret Yong Shern Min
 * @version 1.0 18/4/2023
 */
abstract public class Player implements Saveable {

    // The status of whether the player is human
    private boolean isHuman;
    // The list of allowable actions
    private ArrayList<Action> allowableActions;
    // Number of pieces in hand
    private int piecesInHand;
    //Number of pieces left over
    private int piecesLeft;
    //"Colours"
    private Enum<Teams> team;
    // Initial Position
    private Position firstClickedLocation;
    // Final Position
    private Position secondClickedLocation;

    private LegalMoves legalMoves;

    /**
     * Constructor
     * Used when fresh creation
     *
     * @param _isHuman      Status if this actor is a human or AI
     * @param _team       "Colour" of the piece in control
     */
    public Player(boolean _isHuman, Enum<Teams> _team) {
        this.isHuman = _isHuman;
        this.team = _team;
        this.piecesInHand = 9;
        this.piecesLeft = 0;
        this.legalMoves = new LegalMoves();
    }

    /**
     * Constructor
     * Used when loading in a saved player
     *
     * @param _isHuman      Status if this actor is a human or AI
     * @param _colour       "Colour" of the piece in control
     * @param _pricesInHand Pieces that have yet to be placed on the board
     * @param _piecesLeft   Pieces that are left on the board / total pieces for this player
     */
    public Player(boolean _isHuman, Enum<Teams> _colour, int _pricesInHand, int _piecesLeft) {
        this.isHuman = _isHuman;
        this.team = _colour;
        this.piecesInHand = _pricesInHand;
        this.piecesLeft = _piecesLeft;
    }

    /**
     *  Play the turn of this player
     */
    public abstract Action playTurn(Board board, boolean millFormed);

    /**
     * This method is used to update the number of tokens in hand based on the actions of the board
     *
     * @param board the game board
     */
    public void updateTokenCount(Board board) {
        this.piecesLeft = board.getTokenCount(this.team);
    }

    /**
     * This action is used to check if a valid move was selected
     *
     * @param initialLocation the initial location of the piece
     * @param finalLocation the final location of the piece
     * @return the legal action given said legal action was made
     */
    public Action checkValidMove(Position initialLocation, Position finalLocation) { //parameter subject to change
        for (Action action: this.allowableActions){
            // check
            Position initialPosition = action.getInitialPosition();
            Position finalPosition = action.getFinalPosition();
            if(
                    ((initialPosition==null && initialPosition==initialLocation) || (initialPosition != null && initialPosition.equals(initialLocation)))
            &&      ((finalPosition==null && finalPosition==finalLocation) || (finalPosition!=null && finalPosition.equals(finalLocation)))) {
                return action;
            }
        }
        return null;
    }

    /**
     *  Getter for the pieces that have yet to be placed on the board
     *
     * @return the number of pieces that have yet to be placed on the board
     */
    public int checkPiecesInHand() {
        return piecesInHand;
    }

    /**
     *  Getter for the pieces that are left on the board / total pieces for this player
     *
     * @return the number of pieces that are left on the board / total pieces for this player
     */
    public int checkPiecesLeft() {
        return piecesLeft;
    }
    public void changePiecesInHand(int change) {this.piecesInHand += change;}
    public void changePiecesLeft(int change) {this.piecesLeft += change;}
    public Enum<Teams> getTeam() {
        return team;
    }
    public ArrayList<Action> generateAllowableActions(Board board, boolean millFormed) {return this.legalMoves.getAllowableActions(this,board,millFormed);}
    protected ArrayList<Action> getAllowableActions() {
        return allowableActions;
    }

    protected void setAllowableActions(ArrayList<Action> allowableActions) {
        this.allowableActions = allowableActions;
    }
    @Override
    public LinkedTreeMap<String, Object> shelve() {
        LinkedTreeMap<String,Object> data = new LinkedTreeMap<>();
        data.put("piecesInHand",this.piecesInHand);
        data.put("team",this.team);
        return data;
    }

    @Override
    public void restore(LinkedTreeMap<String, Object> data) {
        this.piecesInHand = Integer.parseInt(String.valueOf(Math.round((double) data.get("piecesInHand"))));
        this.team = data.get("team").equals("DUCK") ? Teams.DUCK : Teams.GOOSE;
    }

}
