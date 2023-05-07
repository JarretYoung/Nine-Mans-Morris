package game.GameRuleRegulation;

import game.Drawables.Position;
import game.UIComponents.Board;
import javafx.geometry.Pos;

import java.util.ArrayList;
import java.util.ArrayList;

public class MillCondition extends GameRules {
    public static final int MILL_SIZE = 3;
    private ArrayList<Mill> millList = new ArrayList<>();
    private Board board;
    public MillCondition(Board board) {
        this.board = board;
        this.genMillCombos();
    }

    public Mill findFormedMill() {
        for(Mill mill : millList) {
            if(mill.isMillFormed()) {
                return mill;
            }
            else {
                mill.setHasBeenProcessed(false);
            }
        }
        return null;
    }
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
}
