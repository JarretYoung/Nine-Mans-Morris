package game.GameRuleRegulation;

import game.Drawables.Position;
import game.UIComponents.Board;

import java.util.ArrayList;

public class MillCondition {
    public static final int MILL_SIZE = 3;
    private ArrayList<Mill> millList = new ArrayList<>();
    private Board board;

    /**
     * constructor
     * @param board board of the game
     */
    public MillCondition(Board board) {
        this.board = board;
        this.genMillCombos();
    }
    /**
     * is there an activated mill that hasn't been handled yet?
     * @return activated mill
     */
    public Mill findFormedMill() {
        for(Mill mill : millList) {
            if(mill.isMillFormed()) {
                return mill;
            }
        }
        return null;
    }
    /**
     * set all positions with activated mills as true, and everything else as false
     */
    public void updatePositionsViaMills() {
        for(Mill mill : millList) {
            mill.updatePositionMillExists(false);
        }
        for(Mill mill : millList) {
            if(mill.millExists()) {
                mill.updatePositionMillExists(true);
            }
        }
    }

    /**
     * go through the board to find all possible mills
     */
    private void genMillCombos() {
        this.millList = new ArrayList<>();
        for(Position pos : board.getPositionsCopy()) {
            ArrayList<Position> rightSet = pos.getPointsToRight(MILL_SIZE);
            ArrayList<Position> bottomSet = pos.getPointsToBottom(MILL_SIZE);
            if(rightSet.size()==MILL_SIZE) {
                millList.add(new Mill(rightSet));
            }
            if(bottomSet.size()==MILL_SIZE) {
                millList.add(new Mill(bottomSet));
            }
        }
    }
    public MillCondition clone() {
        MillCondition millCondition = new MillCondition(this.board);
        for(int i = 0; i < this.millList.size(); i++) {
            Mill mill = this.millList.get(i);
            Mill millCopy = millCondition.millList.get(i);
            millCopy.setHasBeenProcessed(mill.hasBeenProcessed());
        }
        return millCondition;
    }
    public void copyValues(MillCondition millCondition) {
        for(int i = 0; i < this.millList.size(); i++) {
            Mill mill = this.millList.get(i);
            Mill millCopy = millCondition.millList.get(i);
            mill.setHasBeenProcessed(millCopy.hasBeenProcessed());
        }
    }
}
