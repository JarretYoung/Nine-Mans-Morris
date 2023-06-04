package game.Players;
import game.Actions.Action;
import game.Drawables.Position;
import game.Teams;
import game.UIComponents.Board;

/**
 *  Class representing a human player
 *
 * @author Garret Yong Shern Min
 * @version 1.0 18/4/2023
 */
public class HumanPlayer extends Player {
    private Position firstClickedLocation;
    // Final Position
    private Position secondClickedLocation;
    /**
     * Constructor for multiplayer where player is assigned a "colour"
     *
     * @param colour is the team that the current player is a part of
     */
    public HumanPlayer(Teams colour) {
        super(true, colour);
    }

    /**
     * Constructor (lazy initialisation) where player's default colour is BLACK
     */
    public HumanPlayer() {
        super(false, Teams.GOOSE);
    }

    public Action playTurn(Board board, boolean millFormed) {
        // get a list of allowed actions
        this.setAllowableActions(this.generateAllowableActions(board, millFormed));
        Position pos = board.getClickedPosition();
        if (millFormed) { // Deleting phase
            if (pos == null) {
                return null;
            } else {
                return checkValidMove(pos, null);
            }
        } else if (this.checkPiecesInHand() > 0) { // Placing Phase
            if (pos == null) {
                return null;
            } else {
                return checkValidMove(null, pos);
            }
        } else { // Moving or Flying Phase
            if (pos == null) {
                return null;
            } else {
                if (this.firstClickedLocation == null && pos.getToken() != null) {
                    this.firstClickedLocation = pos;
                    if (this.firstClickedLocation.getToken() != null) {
                        this.firstClickedLocation.getToken().setSelected(true);
                    }
                    return null;

                } else if (this.firstClickedLocation != null && this.secondClickedLocation == null) {
                    this.secondClickedLocation = pos;
                    Action action = checkValidMove(this.firstClickedLocation, this.secondClickedLocation);
                    if (this.firstClickedLocation.getToken() != null) {
                        this.firstClickedLocation.getToken().setSelected(false);
                    }
                    this.firstClickedLocation = null;
                    this.secondClickedLocation = null;
                    return action;
                } else {
                    if (this.firstClickedLocation != null && this.firstClickedLocation.getToken() != null) {
                        this.firstClickedLocation.getToken().setSelected(false);
                    }
                    this.firstClickedLocation = null;
                    this.secondClickedLocation = null;
                }
            }
        }
        return null;
    }
}
