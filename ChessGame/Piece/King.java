package ChessGame.Piece;

import ChessGame.Chess.Cell;
import ChessGame.Chess.ChessBoard;
import ChessGame.Chess.Color;
import ChessGame.Chess.PieceName;

public class King implements ChessPiece {
    private PieceName pieceName;
    private Color color;
    private boolean isDead;
    public King(PieceName pieceName, Color color, boolean isDead) {
        this.pieceName = pieceName;
        this.color = color;
        this.isDead = isDead;
    }
    @Override
    public void move(Cell currentCell, Cell destCell, ChessBoard chessBoard) {

    }
    @Override
    public PieceName getName() {
        return this.pieceName;
    }
    public Color getColor() {
        return this.color;
    }
    @Override
    public boolean isDead() {
        return this.isDead;
    }
    @Override
    public void setDead(boolean dead) {
        isDead = dead;
    }
}
