package ChessGame.Chess;

import ChessGame.Piece.ChessPiece;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ChessBoard implements Board{

    protected Map<Pair, Cell> cells;
    private final int rowCount=8;
    private final int colCount=8;

      public ChessBoard(){
          this.cells = new HashMap<>();
            for(int i=0;i<rowCount;i++){
                for(int j=0;j<colCount;j++){
                    this.cells.put(new Pair(i,j),new Cell(i,j) );
                }

            }
      }

    @Override
    public void initializeBoard() {
        // Implementation for initializing the chess board
        System.out.println("Initializing chess board...");
    }
    @Override
    public void applyMove(Move move) {
        Cell src = this.cells.get(move.getSource());
        Cell dest = this.cells.get(move.getDestination());
        if(src == null || dest == null) {
            throw new IllegalArgumentException("Invalid move: Source or destination cell does not exist.");
        }
        dest.setChessPiece(src.getChessPiece()); // ChessGame.Chess.Move piece to destination cell
        src.setChessPiece(Optional.empty()); // Remove piece from source cell

    }
    @Override
    public void printBoard() {
        System.out.println("Printing chess board...");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Cell cell = this.cells.get(new Pair(i, j));
                if (cell != null && cell.getChessPiece().isPresent()) {
                    System.out.print(cell.getChessPiece().get().getName() + " ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }
    public void putChessPiece(Pair pair, ChessPiece chessPiece) {

        System.out.println(pair.getX() + " " + pair.getY());
        if(!this.cells.containsKey(pair)) {
            throw new IllegalArgumentException("Invalid cell position: " + pair.getX() + " " + pair.getY());
        }
        this.cells.get(pair).setChessPiece(Optional.ofNullable(chessPiece));
    }

}
