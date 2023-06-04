package game.SaveFunction;

import game.UIComponents.GamePage;

/**
 * This class is the abstract class that will be used as a template for other save
 * strategies
 *
 * @author Garret Yong Shern Min
 * @version 1.0 2/6/2023
 */
public abstract class SaveStrategy {

    // The current gamepage
    private GamePage gamePage;

    /**
     * Constructor for the saveStrategy
     *
     * @param gamePage is the current gamepage
     */
    public void saveStrategy(GamePage gamePage) {
        this.gamePage = gamePage;
    }

    /**
     * Method used to restore progress of a saved 9MM game
     */
    public abstract GamePage restoreToProgress();

    /**
     * Method used to save progress of the current 9MM game
     */
    public abstract void saveProgress();

    /** Getter and setter for gamepage */
    public GamePage getGamePage() {
        return gamePage;
    }
    public void setGamePage(GamePage gamePage) {
        this.gamePage = gamePage;
    }
}