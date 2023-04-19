package game.Players;

import java.util.ArrayList;

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
    private ArrayList<String> allowableActions; //String change to Action
    // Number of pieces in hand
    private int piecesInHand;
    //Number of pieces left over
    private int piecesLeft;
    //"Colours"
    private Enum<?> colour;

    /**
     * Constructor
     * Used when fresh creation
     *
     * @param _isHuman      Status if this actor is a human or AI
     * @param _colour       "Colour" of the piece in control
     */
    public Player(boolean _isHuman, Enum<?> _colour) {
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
    public boolean playTurn() {
        //check valid move
        if (isHuman == true) {
            int initialLocation = -1; // might need change type
            int finalLocation = -1; // might need change type
            //ask user input
            boolean validMove = checkValidMove(initialLocation, finalLocation) ;
            return validMove; // returns true when a valid move is made
        }
        return false;
    }

    public boolean checkValidMove(int initialLocation, int finalLocation) { //parameter subject to change
        for (int i=0; i < allowableActions.size(); i++ ){
            // check
            if ((initialLocation == i) && (finalLocation == i)) { // change i  to initial and final
                // check for valid moves
                return true;
            }
        }
        return false;
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
}
