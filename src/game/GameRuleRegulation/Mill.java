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
        this.hasBeenProcessed = false;
    }

    public boolean isMillFormed() {
        if(positions.get(0).getToken()!=null) {
            Enum<Teams> team = positions.get(0).getToken().getPlayer();
            for(Position pos : positions) {
                if(pos.getToken()==null || !pos.getToken().getPlayer().equals(team)) {
                    this.hasBeenProcessed = false;
                    return false;
                }
            }
            return !this.hasBeenProcessed; // only return true if the mill hasn't been handled yet
        }
        else {
            this.hasBeenProcessed = false;
            return false;
        }
    }
    
    public void setHasBeenProcessed(boolean hasBeenProcessed) {
        this.hasBeenProcessed = hasBeenProcessed;
    }
    public boolean hasBeenProcessed() {
        return hasBeenProcessed;
    }
}
