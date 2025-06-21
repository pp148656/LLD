package ChessGame.Chess;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ChessGame extends Game {
    private ChessPlayer player1;
    private ChessPlayer player2;
    public ChessGame(ChessBoard chessBoard, ChessPlayer player1, ChessPlayer player2) {
        this.board = chessBoard;
        this.player1 = player1;
        this.player2 = player2;
        Queue<Player> players = new LinkedList<>();
        this.players = players;
        this.players.add(player1);
        this.players.add(player2);
        prepareBoard(player1, player2, chessBoard);
    }

    @Override
    public boolean isOver() {

        if(player1.getPieces().get(PieceName.KING).isDead() || player2.getPieces().get(PieceName.KING).isDead()) {
            return true; // ChessGame.Chess.Game over if any player's piece is dead
        }
        return false; // Placeholder return value
    }
    public void prepareBoard(ChessPlayer firstPlayer, ChessPlayer secondPlayer, ChessBoard chessBoard) {

        placePawns(1, board, firstPlayer);
        placePawns(6, board, secondPlayer);
        placeRooks(0, board, firstPlayer);
        placeRooks(7, board, secondPlayer);
        placeKnights(0, board, firstPlayer);
        placeKnights(7, board, secondPlayer);
        placeBishops(0, board, firstPlayer);
        placeBishops(7, board, secondPlayer);
        placeKing(0, board, firstPlayer);
        placeKing(7, board, secondPlayer);
        placeQueen(0, board, firstPlayer);
        placeQueen(7, board, secondPlayer);

    }
    private void placeBishops(int ro ,ChessBoard chessBoard, ChessPlayer player) {
       this.board.putChessPiece(new Pair(ro,2),(player.getPiece(PieceName.BISHOP1)));
       this.board.putChessPiece(new Pair(ro,5),(player.getPiece(PieceName.BISHOP2)));
    }

    private void placeRooks(int ro ,ChessBoard chessBoard, ChessPlayer player) {
        this.board.putChessPiece(new Pair(ro,0),(player.getPiece(PieceName.ROOK1)));
        this.board.putChessPiece(new Pair(ro,7),(player.getPiece(PieceName.ROOK2)));
    }

    private void placePawns(int ro ,ChessBoard chessBoard, ChessPlayer player) {
        List<PieceName> pieceNames =
                Arrays.asList(PieceName.PAWN1, PieceName.PAWN2, PieceName.PAWN3, PieceName.PAWN4,
                        PieceName.PAWN5, PieceName.PAWN6, PieceName.PAWN7, PieceName.PAWN8);

        for(int i = 0; i < 8; i++) {
            this.board.putChessPiece(new Pair(ro,i),(player.getPiece(pieceNames.get(i))));
         }
    }
    private void placeQueen(int ro ,ChessBoard chessBoard, ChessPlayer player) {
        this.board.putChessPiece(new Pair(ro,3),(player.getPiece(PieceName.QUEEN)));
    }
    private void placeKing(int ro ,ChessBoard chessBoard, ChessPlayer player) {
        this.board.putChessPiece(new Pair(ro,4),(player.getPiece(PieceName.KING)));
    }
    private void placeKnights(int ro ,ChessBoard chessBoard, ChessPlayer player) {
        this.board.putChessPiece(new Pair(ro,6),(player.getPiece(PieceName.KNIGHT1)));
        this.board.putChessPiece(new Pair(ro,1),(player.getPiece(PieceName.KNIGHT2)));
    }

}
