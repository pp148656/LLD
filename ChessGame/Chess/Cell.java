package ChessGame.Chess;

import ChessGame.Piece.ChessPiece;

import java.util.Optional;

public class Cell {
    private int row;
    private int col;
    private boolean isOccupied;
    private Optional<ChessPiece> chessPiece;

    public Cell(int row, int col){
        this.chessPiece = Optional.empty();
        this.row = row;
        this.col = col;
    }
    public int getRow() {
        return this.row;
    }
    public int getCol() {
        return this.col;
    }
    public Optional<ChessPiece> getChessPiece() {
        return this.chessPiece;
    }
    public void setChessPiece(Optional<ChessPiece> chessPiece){
        this.chessPiece = chessPiece;
    }
}
