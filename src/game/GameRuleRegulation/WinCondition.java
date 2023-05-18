package game.GameRuleRegulation;

import game.Players.Player;
import game.Teams;
import game.UIComponents.Board;

public class WinCondition {
    // find a winner if any
    /**
     *
     * @param player1
     * @param player2
     * @return
     */
    public Enum<Teams> getWinnerIfAny(Player player1, Player player2) {
        if(player1.checkPiecesLeft()<3 && player1.checkPiecesInHand()<=0) {
            return player2.getTeam();
        }
        else if(player2.checkPiecesLeft()<3 && player2.checkPiecesInHand()<=0) {
            return player1.getTeam();
        }
        else {
            return null;
        }
    }
    // check if a stalemate occurs
    /**
     *
     * @param currentPlayer
     * @param board
     * @param millFormed
     * @return
     */
    public boolean checkStalemate(Player currentPlayer, Board board, boolean millFormed) {
        return currentPlayer.getAllowableActions(board,millFormed).size()==0;
    }
}
