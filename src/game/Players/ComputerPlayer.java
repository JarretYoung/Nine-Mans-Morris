package game.Players;

import game.Teams;

/**
 *  Class representing an AI player
 *
 * @author Garret Yong Shern Min
 * @version 1.0 18/4/2023
 */
public class ComputerPlayer extends Player{

    /**
     *  Constructor
     */
    public ComputerPlayer() {
        super(false, Teams.DUCK);
    }
}
