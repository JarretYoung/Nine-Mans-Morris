package game.Players;

import game.Colours;

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
    private Enum<?> colour;
    // Initial Position
    private Position firstClickedLocation;
    // Final Position
    private Position secondClickedLocation;
    private Enum<Colours> colour;

    /**
     * Constructor
     * Used when fresh creation
     *
     * @param _isHuman      Status if this actor is a human or AI
     * @param _colour       "Colour" of the piece in control
     */
    public Player(boolean _isHuman, Enum<Colours> _colour) {
        this.isHuman = _isHuman;
        this.colour = _colour;
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
    public Player(boolean _isHuman, Enum<?> _colour, int _pricesInHand, int _piecesLeft) {
        this.isHuman = _isHuman;
        this.colour = _colour;
        this.piecesInHand = _pricesInHand;
        this.piecesLeft = _piecesLeft;
    }

    /**
     *  Play the turn of this player
     */
    public Action playTurn(Board board) {
        //check valid move
        if (isHuman == true) { // If player is human player
            if (this.piecesInHand > 0) { // Placing Phase
                Position pos =  board.getClickedPosition();
                if (pos == null) {
                    return null;
                } else {
                    return checkValidMove(null, pos);
                }
            } else { // Moving or Flying Phase
                Position pos =  board.getClickedPosition();
                if (pos == null) {
                    return null;
                } else {
                    if (this.firstClickedLocation == null) {
                        this.firstClickedLocation = pos;
                        return null;

                    }
                    if (this.secondClickedLocation == null) {
                        this.secondClickedLocation = pos;
                        return checkValidMove(this.firstClickedLocation, this.secondClickedLocation);
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
        for (int i=0; i < allowableActions.size(); i++ ){
            // check
            if ((allowableActions.get(i).getInitialPosition() == initialLocation) && (allowableActions.get(i).getFinalPosition() == finalLocation)) {
                // check for valid moves
                return allowableActions.get(i);
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

    public Enum<Colours> getColour() {
        return colour;
    }
}
