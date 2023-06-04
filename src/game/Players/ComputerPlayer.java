package game.Players;

import game.Actions.Action;
import game.Teams;
import game.UIComponents.Board;

import java.util.Random;

/**
 *  Class representing an AI player
 *
 * @author Garret Yong Shern Min
 * @version 1.0 18/4/2023
 */
public class ComputerPlayer extends Player {
    public final static int COOLDOWN_TIME = 20;
    private int cooldown;
    /**
     * Constructor
     */
    public ComputerPlayer(Teams colour) {
        super(false, colour);
        this.cooldown = COOLDOWN_TIME;
    }

    public Action playTurn(Board board, boolean millFormed) {
        if(this.cooldown<=0) {
            this.cooldown = ComputerPlayer.COOLDOWN_TIME;
            this.setAllowableActions(this.generateAllowableActions(board, millFormed));
            Random random = new Random();
            int randIndex = random.nextInt(this.getAllowableActions().size());
            return this.getAllowableActions().get(randIndex);
        }
        else {
            this.cooldown -= 1;
            return null;
        }
    }
}