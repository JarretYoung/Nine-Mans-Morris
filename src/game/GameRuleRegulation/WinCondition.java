package game.GameRuleRegulation;

import game.Players.Player;
import game.Teams;
import game.UIComponents.Board;

public class WinCondition {
    public Enum<Teams> getWinnerIfAny(Player player1, Player player2) {
        if(player1.checkPiecesLeft()<3 && player1.checkPiecesInHand()<=0) {
            return player1.getTeam();
        }
        else if(player2.checkPiecesLeft()<3 && player2.checkPiecesInHand()<=0) {
            return player2.getTeam();
        }
        else {
            return null;
        }
    }

    public boolean checkStalemate(Player currentPlayer, Board board, boolean millFormed) {
        return currentPlayer.getAllowableActions(board,millFormed).size()==0;
    }
}
