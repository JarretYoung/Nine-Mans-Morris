package game.Players;
import game.Teams;

/**
 *  Class representing a human player
 *
 * @author Garret Yong Shern Min
 * @version 1.0 18/4/2023
 */
public class HumanPlayer extends Player {

    /**
     * Constructor for multiplayer where player is assigned a "colour"
     *
     * @param colour is the team that the current player is a part of
     */
    public HumanPlayer(Teams colour) {
        super(true, colour);
    }

    /**
     *  Constructor (lazy initialisation) where player's default colour is BLACK
     */
    public HumanPlayer() {
        super(false, Teams.GOOSE);
    }
}
