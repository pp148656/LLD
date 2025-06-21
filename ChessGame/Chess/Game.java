package ChessGame.Chess;

import java.util.Queue;

public abstract class Game {
    protected ChessBoard board;
    protected Queue<Player> players;

    public void playGame(){

        while(true){
            Player currentPlayer = players.poll();
            Move move = currentPlayer.makeMove();
            board.applyMove(move);
            if(isOver()){
                System.out.println("ChessGame.Chess.Game Over! " + currentPlayer.getName() + " wins!");
                break;
            }
            players.add(currentPlayer);
        }
    }
    public abstract boolean isOver();
}

