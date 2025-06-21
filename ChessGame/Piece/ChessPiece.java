package ChessGame.Piece;
import ChessGame.Chess.*;

public interface ChessPiece {

    void move(Cell currentCell, Cell destCell, ChessBoard chessBoard);

    public PieceName getName();

    public boolean isDead();

    public void setDead(boolean dead);

}