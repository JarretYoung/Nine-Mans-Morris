package game.GameRuleRegulation;

import game.Drawables.Position;
import game.Teams;

import java.util.ArrayList;
import java.util.Optional;

public class Mill {
    ArrayList<Position> positions;
    private boolean hasBeenProcessed; // represents whether a token has already been deleted because of the mill
    public Mill(ArrayList<Position> positions) {
        this.positions = positions;
        this.setHasBeenProcessed(false);
    }
    // is this a valid mill? (aka all three positions are the same)
    public boolean millExists() {
        if(positions.get(0).getToken()!=null) {
            Enum<Teams> team = positions.get(0).getToken().getPlayer();
            // return false if the team of a position in the mill differs
            for(Position pos : positions) {
                if(pos.getToken()==null || !pos.getToken().getPlayer().equals(team)) {
                    return false;
                }
            }
            // no differences, return true
            return true;
        }
        else {
            return false;
        }
    }
    public boolean isMillFormed() {
        boolean exists = this.millExists();
        if(exists) {
            return !this.hasBeenProcessed; // only return true if the mill hasn't been handled yet
        }
        else {
            this.setHasBeenProcessed(false);
            return false;
        }
    }
    
    public void setHasBeenProcessed(boolean hasBeenProcessed) {
        this.hasBeenProcessed = hasBeenProcessed;
    }
    public boolean hasBeenProcessed() {
        return hasBeenProcessed;
    }
    public void updatePositionMillExists(boolean millExists) {
        // update every position according to the state of this mill
        for(Position pos : this.positions) {
            pos.setMillExists(millExists);
        }
    }
}
