package game.UIComponents;


import game.Actions.Action;
import game.Colours;
import game.Players.HumanPlayer;
import game.Players.Player;

public class GamePage extends Page {
    public static final String ID = "game";
    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private boolean gameIsRunning;
    public GamePage(Panel panel) {
        super(panel, ID);
        this.board = new Board(this);
        this.player1 = new HumanPlayer(Colours.WHITE);
        this.player2 = new HumanPlayer(Colours.BLACK);
        this.currentPlayer = this.player1;
        this.gameIsRunning = true;
    }
    protected void nextTurn() {
        if(this.currentPlayer==this.player1) {
            this.currentPlayer = this.player2;
        }
        else {
            this.currentPlayer = this.player1;
        }
    }

    @Override
    public void tick() {
        super.tick();
        if(this.gameIsRunning) {
            Action playedMove = this.currentPlayer.playTurn(this.board);
            if(playedMove!=null) {
                //this.nextTurn();
            }
            this.checkForEndOfGame();
        }
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
