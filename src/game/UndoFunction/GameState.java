package game.UndoFunction;

import com.google.gson.internal.LinkedTreeMap;
import game.Drawables.Position;
import game.Drawables.Token;
import game.GameRuleRegulation.MillCondition;
import game.Players.Player;
import game.SaveFunction.Saveable;
import game.Teams;
import game.UIComponents.Board;
import game.UIComponents.GamePage;

import java.util.ArrayList;
import java.util.Optional;

/**
 * Class representing the current game's state
 *
 * @author Garret Yong Shern Min
 * @version 2.0 2/8/2023
 */
public class GameState {
    private MillCondition millCondition;
    private static GamePage gamePage;

    /**
     * Constructor for the Gamestate
     *
     * @param millCondition is whether a mill is in effect
     * @param gamePage the game page
     */
    public GameState(MillCondition millCondition, GamePage gamePage) {
        this.millCondition = millCondition;
        GameState.gamePage = gamePage;
    }

    /**
     * Method that updates the gamestate when a place action is done
     *
     * @param team is the team that is making the move
     * @param position is the position of all the pieces on the board
     */
    public void placePiece(Enum<Teams> team, Position position) {
        position.setToken(new Token(position.getPage(),position.getX(),position.getY(),team));
    }

    /**
     * Method that updates the gamestate when a move action is done
     *
     * @param startPos is the start position of the piece to be moved
     * @param endPos is the end position of the piece to be moved
     */
    public void movePiece(Position startPos, Position endPos) {
        startPos.getToken().moveSelf(startPos,endPos);
    }

    /**
     * Method that updates the gamestate when a remove action is done
     *
     * @param position is the position of the piece that is to be removed
     */
    public void removePiece(Position position) {
        position.getToken().delete();
        position.setToken(null);
    }

    /**
     * This method is used to take a snapshot of the current board condition
     *
     * @param player is the player whose turn it is
     * @param startPosition is the start position of the piece to be moved
     * @param endPosition is the end position of the piece to be moved
     * @return an instance of a memento that was just made
     */
    public Memento takeSnapshot(Player player, Position startPosition, Position endPosition) {
        return new Memento(player,startPosition,endPosition,this.millCondition);
    }

    /**
     * This method is used to ...
     *
     * @param memento
     */
    public void restore(Memento memento) {
        GamePage gamePage = (GamePage) (memento.getStartPosition() != null ? memento.getStartPosition().getPage() : memento.getEndPosition().getPage());
        if(memento.getStartPosition()==null && memento.getEndPosition()!=null) { // revert placing
            this.removePiece(memento.getEndPosition());
            memento.getPlayer().changePiecesInHand(1);
            if(gamePage.getMill()==null) {gamePage.nextTurn();}
            else {gamePage.setMill(null);}
        } else if (memento.getStartPosition()!=null && memento.getEndPosition()!=null) { // revert moving
            this.movePiece(memento.getEndPosition(),memento.getStartPosition());
            if(gamePage.getMill()==null) {gamePage.nextTurn();}
            else {gamePage.setMill(null);}
        } else if (memento.getStartPosition()!=null && memento.getEndPosition()==null) { // revert deleting
            this.placePiece(memento.getPlayer().getTeam()== Teams.DUCK ? Teams.GOOSE : Teams.DUCK,memento.getStartPosition());
        }
        this.millCondition.copyValues(memento.getMillCondition());
//      this.grid = memento.getSavedBoardState();
//      this.playerOnePieces = memento.getPlayerOnePieces();
//      this.playerTwoPieces = memento.getPlayerTwoPieces();
    }

    /**
     * This is the class that is used to store the gamestate per turn
     *
     * @author Garret Yong Shern Min
     * @version 2.2 2/6/2023
     */
    public static class Memento implements Saveable {
        private Player player;
        private Position startPosition;
        private Position endPosition;
        private MillCondition millCondition;
        private Memento (Player player,Position startPosition, Position endPosition, MillCondition millCondition) {
            this.player = player;
            this.startPosition = startPosition;
            this.endPosition = endPosition;
            this.millCondition = millCondition.clone();
        }
        private Memento() {

        }

        /**
         * Getter for the player
         *
         * @return the player
         */
        public Player getPlayer() {return player;}

        /**
         * Getter for the start position
         *
         * @return the start position of the piece moved
         */
        public Position getStartPosition() {return startPosition;}

        /**
         * Getter for the end position
         *
         * @return the end position of the piece moved
         */
        public Position getEndPosition() {return endPosition;}

        /**
         * Getter for the mill condition
         *
         * @return the current mill condition
         */
        public MillCondition getMillCondition() {return millCondition;}

        @Override
        public LinkedTreeMap<String, Object> shelve() {
            LinkedTreeMap<String,Object> data = new LinkedTreeMap<>();
            data.put("player",this.player.shelve());
            data.put("startPosition",startPosition!=null ? this.startPosition.shelve() : null);
            data.put("endPosition",endPosition!=null? this.endPosition.shelve() : null);
            data.put("millCondition",this.millCondition.shelve());
            return data;
        }

        @Override
        public void restore(LinkedTreeMap<String, Object> data) {
            Enum<Teams> teams = ((LinkedTreeMap<String, Object>) data.get("player")).get("team").equals("DUCK") ? Teams.DUCK : Teams.GOOSE;
            this.player = teams==Teams.DUCK ? GameState.gamePage.getPlayer1() : GameState.gamePage.getPlayer2();
            ArrayList<Position> posList = GameState.gamePage.getBoard().getPositionsCopy();
            this.startPosition = null;
            this.endPosition = null;
            double startX = -1; double startY = -1; double endX = -1; double endY = -1;
            boolean startIsNull = true; boolean endIsNull = true;
            if(data.get("startPosition") != null) {
                startX = (double) ((LinkedTreeMap<String, Object>) data.get("startPosition")).get("x");
                startY = (double) ((LinkedTreeMap<String, Object>) data.get("startPosition")).get("y");
                startIsNull = false;
            }
            if(data.get("endPosition") != null) {
                endX = (double) ((LinkedTreeMap<String, Object>) data.get("endPosition")).get("x");
                endY = (double) ((LinkedTreeMap<String, Object>) data.get("endPosition")).get("y");
                endIsNull = false;
            }
            for(Position position : posList) {
                if(!startIsNull && position.getX()==startX && position.getY()==startY) {
                    this.startPosition = position;
                }
                if(!endIsNull && position.getX()==endX && position.getY()==endY) {
                    this.endPosition = position;
                }
            }
            this.millCondition = new MillCondition(GameState.gamePage.getBoard());
            this.millCondition.restore((LinkedTreeMap<String, Object>) data.get("millCondition"));
        }
    }

    /**
     * This method is used to convert data retrieved from saveddata back as a memento
     *
     * @param data data retrieved from the saved data
     * @return the converted memento back
     */
    public static Memento getMementoFromData(LinkedTreeMap<String, Object> data) {
        Memento memento = new Memento();
        memento.restore(data);
        return memento;
    }
}
