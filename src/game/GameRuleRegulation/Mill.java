package game.GameRuleRegulation;

import com.google.gson.internal.LinkedTreeMap;
import game.Drawables.Position;
import game.SaveFunction.Saveable;
import game.Teams;

import java.util.ArrayList;
import java.util.Optional;

public class Mill implements Saveable {
    ArrayList<Position> positions;
    private boolean hasBeenProcessed; // represents whether a token has already been deleted because of the mill

    /**
     * constructor
     * @param positions positions associated with the mill
     */
    public Mill(ArrayList<Position> positions) {
        this.positions = positions;
        this.setHasBeenProcessed(false);
    }
    /**
     * is this a valid mill? (aka all three positions are the same team)
     * @return whether this is a mill
     */
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
    /**
     * should an enemy piece be deleted because of this mill?
     * @return whether this is a mill and whether it hasn't been handled yet
     */
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
    /**
     * setter
     * @param hasBeenProcessed whether the mill has been processed yet
     */
    public void setHasBeenProcessed(boolean hasBeenProcessed) {
        this.hasBeenProcessed = hasBeenProcessed;
    }
    /**
     * getter
     * @return whether the mill has been processed yet
     */
    public boolean hasBeenProcessed() {
        return hasBeenProcessed;
    }
    /**
     * update the positions based on the mill's existence
     * @param millExists whether this mill exists
     */
    public void updatePositionMillExists(boolean millExists) {
        // update every position according to the state of this mill
        for(Position pos : this.positions) {
            pos.setMillExists(millExists);
        }
    }

    @Override
    public LinkedTreeMap<String, Object> shelve() {
        LinkedTreeMap<String,Object> data = new LinkedTreeMap<>();
        data.put("hasBeenProcessed",this.hasBeenProcessed);
        return data;
    }

    @Override
    public void restore(LinkedTreeMap<String, Object> data) {
        this.hasBeenProcessed = (boolean) data.get("hasBeenProcessed");
    }
}
