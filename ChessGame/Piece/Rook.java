package ChessGame.Piece;
import ChessGame.Chess.*;
import ChessGame.Chess.PieceName;

public class Rook implements ChessPiece {
    private PieceName pieceName;
    private Color color;
    private boolean isDead;
    public Rook(PieceName pieceName, Color color, boolean isDead) {
        this.pieceName = pieceName;
        this.color = color;
        this.isDead = isDead;
    }
    @Override
    public void move(Cell currentCell, Cell destCell, ChessBoard chessBoard) {
        // Implement the logic for moving the rook
        // Rooks can move horizontally or vertically any number of squares
        // Check if the path is clear and if the destination cell is valid
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
