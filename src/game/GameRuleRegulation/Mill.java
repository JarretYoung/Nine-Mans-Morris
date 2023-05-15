package game.GameRuleRegulation;

import game.Drawables.Position;
import game.Teams;

import java.util.ArrayList;
import java.util.Optional;

public class Mill {
    ArrayList<Position> positions;
    private boolean hasBeenProcessed;
    public Mill(ArrayList<Position> positions) {
        this.positions = positions;
        this.setHasBeenProcessed(false);
    }
    public boolean millExists() {
        if(positions.get(0).getToken()!=null) {
            Enum<Teams> team = positions.get(0).getToken().getPlayer();
            for(Position pos : positions) {
                if(pos.getToken()==null || !pos.getToken().getPlayer().equals(team)) {
                    return false;
                }
            }
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
        for(Position pos : this.positions) {
            pos.setMillExists(millExists);
        }
    }
}
