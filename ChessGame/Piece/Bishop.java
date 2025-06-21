package ChessGame.Piece;
import ChessGame.Chess.*;


public class Bishop implements ChessPiece {
    private final PieceName pieceName;
    private final Color color;
    private boolean isDead;


    public Bishop(PieceName pieceName, Color color, boolean isDead) {
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
