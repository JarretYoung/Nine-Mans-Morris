package game.Commands;

import game.UIComponents.GamePage;
import game.UndoFunction.GameStateEditor;

public class UndoCommand implements Command {
    private GameStateEditor gameStateEditor;
    private GamePage gamePage;
    public UndoCommand(GameStateEditor gameStateEditor, GamePage gamePage) {
        this.gameStateEditor = gameStateEditor;
        this.gamePage = gamePage;
    }
    @Override
    public void execute() {
        gameStateEditor.undo(gamePage.isSingleplayer());
    }
}

