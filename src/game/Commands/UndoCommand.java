package game.Commands;

import game.UndoFunction.GameStateEditor;

public class UndoCommand implements Command {
    private GameStateEditor gameStateEditor;
    public UndoCommand(GameStateEditor gameStateEditor) {
        this.gameStateEditor = gameStateEditor;
    }
    @Override
    public void execute() {
        gameStateEditor.undo();
    } //TODO: account for robot turn
}

