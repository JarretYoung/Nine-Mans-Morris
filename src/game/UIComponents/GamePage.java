package game.UIComponents;


import game.GameRuleRegulation.WinCondition;
import game.UndoFunction.GameState;
import game.Actions.Action;
import game.GameRuleRegulation.Mill;
import game.GameRuleRegulation.MillCondition;
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
    private Text millFormedText;
    private Text gameEndText;
    private MillCondition millCondition;
    private Mill mill;
    private WinCondition winCondition;
    public void setTurnTextStr(String strVal) {this.turnText.setTextStr(strVal);}
    public void setDuckLeftStr(String strVal) {this.duckLeftText.setTextStr(strVal);}
    public void setGooseLeftStr(String strVal) {this.gooseLeftText.setTextStr(strVal);}
    public void setMillFormedTextStr(String strVal) {this.millFormedText.setTextStr(strVal);}
    public void setGameEndTextStr(String strVal) {this.gameEndText.setTextStr(strVal);}
    public GamePage(Panel panel) {
        super(panel, ID);
        this.board = new Board(this);
        this.gameState = new GameState();
        this.player1 = new HumanPlayer(Teams.DUCK);
        this.player2 = new HumanPlayer(Teams.GOOSE);
        this.currentPlayer = this.player1;
        this.gameIsRunning = true;
        this.turnText = new Text(this,String.format("%s's turn",this.currentPlayer.getTeam()),300,50,true);
        this.duckLeftText = new Text(this,"unplaced ducks: NA",100,20,true);
        this.gooseLeftText = new Text(this,"unplaced goose: NA",500,20,true);
//        this.millFormedText = new Text(this,"no mills formed",400,50,false);
        this.gameEndText = new Text(this,"",300,560,true);

        this.millCondition = new MillCondition(board);
        this.winCondition = new WinCondition();
    }
    protected void nextTurn() {
        if(this.currentPlayer==this.player1) {
            this.currentPlayer = this.player2;
        }
        else {
            this.currentPlayer = this.player1;
        }
        this.board.updateBoardFromCurrentTeam(this.currentPlayer.getTeam());
        this.updateTurnText();
    }
    protected void updateTurnText() {
        if(this.mill==null) {
            this.setTurnTextStr(String.format("%s's turn",this.currentPlayer.getTeam()));
        }
        else {
            this.setTurnTextStr(String.format("%s has formed a mill!",this.currentPlayer.getTeam()));

        }
    }

    @Override
    public void tick() {
        this.board.resetPositionAllowed();
        if(this.gameIsRunning) {
            Action playedMove = this.currentPlayer.playTurn(this.board,this.mill!=null);
            if(playedMove!=null) {
                playedMove.performAction(this.gameState);
                if(this.mill!=null) {
                    this.mill.setHasBeenProcessed(true);
                }
                this.mill = this.millCondition.findFormedMill();
                if(this.mill==null) {
                    this.nextTurn();
                    if(this.winCondition.checkStalemate(currentPlayer,this.board,this.mill!=null)) {
                        this.setGameEndTextStr("game over! stalemate occurred");
                        this.gameIsRunning = false;
                    }
                    Enum<Teams> winner = this.winCondition.getWinnerIfAny(player1,player2);
                    if(winner!=null) {
                        this.setGameEndTextStr(String.format("game over! %s wins!",winner));
                        this.gameIsRunning = false;
                    }
                }
            }
        }
        this.setDuckLeftStr(String.format("unplaced ducks: %s",this.player1.checkPiecesInHand()));
        this.setGooseLeftStr(String.format("unplaced geese: %s",this.player2.checkPiecesInHand()));
        this.updateTurnText();
        super.tick();
//        this.setMillFormedTextStr(this.mill==null ? "no mills formed" : "mill formed!");
    }

}
