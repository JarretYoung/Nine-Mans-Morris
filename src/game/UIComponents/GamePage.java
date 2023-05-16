package game.UIComponents;


import game.Commands.GotoGameCommand;
import game.Commands.GotoMenuCommand;
import game.Commands.SaveCommand;
import game.Drawables.Button;
import game.Drawables.Sprite;
import game.Drawables.Token;
import game.GameRuleRegulation.WinCondition;
import game.UndoFunction.GameState;
import game.Actions.Action;
import game.GameRuleRegulation.Mill;
import game.GameRuleRegulation.MillCondition;
import game.Teams;
import game.Drawables.Text;
import game.Players.HumanPlayer;
import game.Players.Player;

import javax.swing.*;

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
    private Text gameEndText;
    private SpriteLine duckSpriteLine;
    private SpriteLine gooseSpriteLine;
    private MillCondition millCondition;
    private Mill mill;
    private WinCondition winCondition;
    public void setTurnTextStr(String strVal) {this.turnText.setTextStr(strVal);}
    public void setDuckLeftStr(String strVal) {this.duckLeftText.setTextStr(strVal);}
    public void setGooseLeftStr(String strVal) {this.gooseLeftText.setTextStr(strVal);}
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
        this.duckSpriteLine = new SpriteLine(this,50,220, Token.SIZE, Token.SIZE,
                (new ImageIcon(Token.IMG_PATH_DUCK)).getImage(),20,this.player1.checkPiecesInHand(),0,1);
        this.gooseSpriteLine = new SpriteLine(this,550,220, Token.SIZE, Token.SIZE,
                (new ImageIcon(Token.IMG_PATH_GOOSE)).getImage(),20,this.player2.checkPiecesInHand(),0,1);
        new Button(this,100,560,180,60,"MAIN MENU",new GotoMenuCommand(this.getPanel()));
        new Button(this,500,560,180,60,"SAVE",new SaveCommand(this.getPanel()));

    }
    protected void nextTurn() {
        // set current player
        if(this.currentPlayer==this.player1) {
            this.currentPlayer = this.player2;
        }
        else {
            this.currentPlayer = this.player1;
        }
        // set UI elements
        this.board.updateBoardFromCurrentTeam(this.currentPlayer.getTeam());
        this.updateTurnText();

        // check if a stalemate is occurring
        if(this.winCondition.checkStalemate(currentPlayer,this.board,this.mill!=null)) {
            this.setGameEndTextStr("game over! stalemate occurred");
            this.gameIsRunning = false;
        }
        // check if either side has won
        Enum<Teams> winner = this.winCondition.getWinnerIfAny(player1,player2);
        if(winner!=null) {
            this.setGameEndTextStr(String.format("game over! %s wins!",winner));
            this.gameIsRunning = false;
        }
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
        // set allowable positions to false by default
        this.board.resetPositionAllowed();
        if(this.gameIsRunning) {
            // get action if any
            Action playedMove = this.currentPlayer.playTurn(this.board,this.mill!=null);
            // if an action is selected
            if(playedMove!=null) {
                // do the action
                playedMove.performAction(this.gameState);
                // update player tokens accordingly
                player1.updateTokenCount(this.board);
                player2.updateTokenCount(this.board);
                // update mills accordingly
                this.millCondition.updatePositionsViaMills();
                // if a mill has just been processed, update accordingly
                if(this.mill!=null) {
                    this.mill.setHasBeenProcessed(true);
                }
                // get mills if any
                this.mill = this.millCondition.findFormedMill();
                // go to the next turn
                if(this.mill==null) {
                    this.nextTurn();
                }
            }
        }
        // update UI
        this.setDuckLeftStr(String.format("unplaced ducks: %s",this.player1.checkPiecesInHand()));
        this.setGooseLeftStr(String.format("unplaced geese: %s",this.player2.checkPiecesInHand()));
        this.duckSpriteLine.setSpriteCount(this.player1.checkPiecesInHand());
        this.gooseSpriteLine.setSpriteCount(this.player2.checkPiecesInHand());
        this.updateTurnText();
        super.tick();
//        this.setMillFormedTextStr(this.mill==null ? "no mills formed" : "mill formed!");
    }

}
