package game.Commands;

import game.GameRuleRegulation.MillCondition;
import game.Players.Player;
import game.SaveFunction.SaveObj;
import game.SaveFunction.SaveStrategy;
import game.SaveFunction.txtSaveStrategy;
import game.UIComponents.Board;
import game.UIComponents.GamePage;
import game.UIComponents.Panel;
import game.UndoFunction.GameStateEditor;

public class SaveCommand implements Command{
    private SaveStrategy saveStrategy;

    public SaveCommand(GamePage gamePage) {
        this.saveStrategy = new txtSaveStrategy(gamePage.genSaveObj());
    }
    /**
     * run the command
     */
    @Override
    public void execute() {
        this.saveStrategy.saveProgress();
    }
}
