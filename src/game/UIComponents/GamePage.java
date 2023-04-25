package game.UIComponents;


import UndoFunction.GameState;
import game.Actions.Action;
import game.Teams;
import game.Drawables.Text;
import game.Players.HumanPlayer;
import game.Players.Player;

public class GamePage extends Page {
    public static final String ID = "game";
    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private boolean gameIsRunning;
    private GameState gameState;
    private Text turnText;
    private Text duckLeftText;
    private Text gooseLeftText;
    public void setTurnTextStr(String strVal) {this.turnText.setTextStr(strVal);}
    public void setDuckLeftStr(String strVal) {this.duckLeftText.setTextStr(strVal);}
    public void setGooseLeftStr(String strVal) {this.gooseLeftText.setTextStr(strVal);}
    public GamePage(Panel panel) {
        super(panel, ID);
        this.board = new Board(this);
        this.gameState = new GameState(board);
        this.player1 = new HumanPlayer(Teams.DUCK);
        this.player2 = new HumanPlayer(Teams.GOOSE);
        this.currentPlayer = this.player1;
        this.gameIsRunning = true;
        this.turnText = new Text(this,String.format("%s's turn",this.currentPlayer.getTeam()),20,20,false);
        this.duckLeftText = new Text(this,"unplaced ducks: NA",20,50,false);;
        this.gooseLeftText = new Text(this,"unplaced goose: NA",20,80,false);;
    }
    protected void nextTurn() {
        if(this.currentPlayer==this.player1) {
            this.currentPlayer = this.player2;
        }
        else {
            this.currentPlayer = this.player1;
        }
        this.setTurnTextStr(String.format("%s's turn",this.currentPlayer.getTeam()));
    }

    @Override
    public void tick() {
        super.tick();
        if(this.gameIsRunning) {
            Action playedMove = this.currentPlayer.playTurn(this.board);
            if(playedMove!=null) {
                playedMove.performAction(this.gameState);
                this.nextTurn();
            }
            this.checkForEndOfGame();
        }
        this.setDuckLeftStr(String.format("unplaced ducks: %s",this.player1.checkPiecesInHand()));
        this.setGooseLeftStr(String.format("unplaced geese: %s",this.player2.checkPiecesInHand()));

    }

    protected void checkForEndOfGame() {
        // TODO: game over screen
        if(this.player1.checkPiecesInHand()==0 && this.player1.checkPiecesLeft()<=2) { // player 2 wins
            System.out.println("team black wins gg"); // placeholder
            this.gameIsRunning = false;
        }
        else if(this.player2.checkPiecesInHand()==0 && this.player2.checkPiecesLeft()<=2) { // player 1 wins
            System.out.println("team white wins pog"); // placeholder
            this.gameIsRunning = false;
        }
        else if(false) { // TODO: check for stalemate
            System.out.println("nobody wins :("); // placeholder
            this.gameIsRunning = false;
        }
    }
}
