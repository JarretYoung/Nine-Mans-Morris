package game.SaveFunction;

import game.GameRuleRegulation.Mill;
import game.GameRuleRegulation.MillCondition;
import game.Players.Player;
import game.Teams;
import game.UIComponents.Board;
import game.UIComponents.GamePage;
import game.UndoFunction.GameStateEditor;

/**
 * This class is the abstract class that will be used as a template for other save
 * strategies
 *
 * @author Garret Yong Shern Min
 * @version 1.0 2/6/2023
 */
public abstract class SaveStrategy {

    // The current gamepage
    private SaveObj saveObj;

    /**
     * Constructor for the saveStrategy
     *
     */
    public void saveStrategy(SaveObj saveObj) {
        this.saveObj = saveObj;
    }

    /**
     * Method used to restore progress of a saved 9MM game
     */
    public abstract SaveObj restoreToProgress();

    /**
     * Method used to save progress of the current 9MM game
     */
    public abstract void saveProgress();

    public SaveObj getSaveObj() {
        return saveObj;
    }
}