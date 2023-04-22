package game.Players;
import game.Colours;

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
     * @param colour
     */
    public HumanPlayer(Colours colour) {
        super(true, colour);
    }

    /**
     *  Constructor (lazy initialisation) where player's default colour is BLACK
     */
    public HumanPlayer() {
        super(false, Colours.BLACK);
    }
}
