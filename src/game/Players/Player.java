package game.Players;

import game.Actions.FlyAction;
import game.Actions.PlaceAction;
import game.GameRuleRegulation.GameRules;
import game.GameRuleRegulation.LegalMoves;
import game.Teams;

import game.Actions.Action;
import game.Drawables.Position;
import game.UIComponents.Board;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Random;

/**
 *  Abstract class that is template for all player classes.
 *
 * @author Garret Yong Shern Min
 * @version 1.0 18/4/2023
 */
abstract public class Player {

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
        this.piecesInHand = 5;
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
    public Action playTurn(Board board, boolean millFormed) {
        // temporary
        this.allowableActions = this.legalMoves.getAllowableActions(this,board,millFormed);
        // -----
        //check valid move
        if (isHuman == true) { // If player is human player
            Position pos = board.getClickedPosition();
            if(millFormed) { // Deleting phase
                if (pos == null) {
                    return null;
                } else {
                    return checkValidMove(pos, null);
                }
            }
            else if (this.piecesInHand > 0) { // Placing Phase
                if (pos == null) {
                    return null;
                } else {
                    return checkValidMove(null, pos);
                }
            } else { // Moving or Flying Phase
                if (pos == null) {
                    return null;
                } else {
                    if (this.firstClickedLocation == null && pos.getToken()!=null) {
                        this.firstClickedLocation = pos;
                        if(this.firstClickedLocation.getToken()!=null) {
                            this.firstClickedLocation.getToken().setSelected(true);
                        }
                        return null;

                    }
                    else if (this.firstClickedLocation != null && this.secondClickedLocation == null) {
                        this.secondClickedLocation = pos;
                        Action action = checkValidMove(this.firstClickedLocation, this.secondClickedLocation);
                        if(this.firstClickedLocation.getToken()!=null) {
                            this.firstClickedLocation.getToken().setSelected(false);
                        }
                        this.firstClickedLocation = null;
                        this.secondClickedLocation = null;
                        return action;
                    }
                    else {
                        if(this.firstClickedLocation != null && this.firstClickedLocation.getToken()!=null) {
                            this.firstClickedLocation.getToken().setSelected(false);
                        }
                        this.firstClickedLocation = null;
                        this.secondClickedLocation = null;
                    }
                }
            }

        } else { // If player is AI player
            Random random = new Random();
            int randIndex = random.nextInt(this.allowableActions.size());
            return this.allowableActions.get(randIndex);
        }
        return null;
    }

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
}
