package game.SaveFunction;

import com.google.gson.internal.LinkedTreeMap;
import game.GameRuleRegulation.MillCondition;
import game.Players.ComputerPlayer;
import game.Players.Player;
import game.UIComponents.Board;
import game.UIComponents.GamePage;
import game.UndoFunction.GameStateEditor;

public class SaveObj implements Saveable {
    private GamePage gamePage;
    private Board board;
    private Player player1;
    private Player player2;
    private MillCondition millCondition;
    private GameStateEditor gameStateEditor;
    public SaveObj(GamePage gamePage, Board board, Player player1, Player player2, MillCondition millCondition, GameStateEditor gameStateEditor) {
        this.gamePage = gamePage;
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
        this.millCondition = millCondition;
        this.gameStateEditor = gameStateEditor;
    }
    public Board getBoard() {return board;}
    public void setBoard(Board board) {this.board = board;}
    public Player getPlayer1() {return player1;}
    public void setPlayer1(Player player1) {this.player1 = player1;}
    public Player getPlayer2() {return player2;}
    public void setPlayer2(Player player2) {this.player2 = player2;}
    public MillCondition getMillCondition() {return millCondition;}
    public void setMillCondition(MillCondition millCondition) {this.millCondition = millCondition;}
    public GameStateEditor getGameStateEditor() {return gameStateEditor;}
    public void setGameStateEditor(GameStateEditor gameStateEditor) {this.gameStateEditor = gameStateEditor;}

    @Override
    public LinkedTreeMap<String, Object> shelve() {
        LinkedTreeMap<String,Object> data = new LinkedTreeMap<>();
        data.put("currentPlayerTeam",this.gamePage.getCurrentPlayer().getTeam());
        data.put("singleplayer",this.gamePage.getPlayer2() instanceof ComputerPlayer);
        data.put("board",this.board.shelve());
        data.put("player1",this.player1.shelve());
        data.put("player2",this.player2.shelve());
        data.put("millCondition",this.millCondition.shelve());
        data.put("gameStateEditor",this.gameStateEditor.shelve());
        return data;
    }

    @Override
    public void restore(LinkedTreeMap<String, Object> data) {
        this.gamePage.setSingleplayer((boolean) data.get("singleplayer"));
        this.gamePage.setCurrentPlayer(data.get("currentPlayerTeam").equals("DUCK") ? this.player1 : this.player2);
        this.board.restore((LinkedTreeMap<String, Object>) data.get("board"));
        this.player1.restore((LinkedTreeMap<String, Object>) data.get("player1"));
        this.player2.restore((LinkedTreeMap<String, Object>) data.get("player2"));
        this.millCondition.restore((LinkedTreeMap<String, Object>) data.get("millCondition"));
        this.gameStateEditor.restore((LinkedTreeMap<String, Object>) data.get("gameStateEditor"));
    }
}
