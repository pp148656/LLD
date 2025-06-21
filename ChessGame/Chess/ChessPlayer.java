package ChessGame.Chess;

import ChessGame.Piece.ChessPiece;

import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public class ChessPlayer implements Player {
    private final String name;
    private final ChessBoard board;
    private final Map<PieceName, ChessPiece> pieces;


    public ChessPlayer(String name, ChessBoard board, Map<PieceName,ChessPiece> pieces) {
        this.name = name;
        this.board = board;
        this.pieces = pieces;
    }

    public String getName() {
        return name;
    }
    public ChessPiece getPiece(PieceName pieceName) {
        if (!this.pieces.containsKey(pieceName))
            throw new IllegalArgumentException("Invalid piece name");
        return this.pieces.get(pieceName);
    }

    public Map<PieceName, ChessPiece> getPieces() {
        return pieces;
    }

    public void setChessPiece(PieceName pieceName, ChessPiece chessPiece) {
        this.pieces.put(pieceName, chessPiece);
    }
    @Override
    public Move makeMove() {
        Pair source,destination;
        this.board.printBoard();
        int x, y;
        Scanner scanner = new Scanner(System.in);
        x = scanner.nextInt(); y = scanner.nextInt(); source = new Pair(x, y);
        Optional<ChessPiece> chessPiece = this.board.cells.get(source).getChessPiece();
        if(!this.board.cells.get(source).getChessPiece().isPresent()){
            throw new IllegalArgumentException("Invalid move: No piece at source cell.");
        }

        if(!(this.pieces.containsKey(chessPiece.get().getName()))) {
            throw new IllegalArgumentException("Not Your ChessGame.Chess ChessGame.Piece." + x + " " + y);
        }
        x = scanner.nextInt(); y = scanner.nextInt(); destination = new Pair(x, y);
        if(this.board.cells.get(destination) == null){
            throw new IllegalArgumentException("Invalid move: Destination cell does not exist.");
        }
        System.out.println(destination.getX() + " " + destination.getY());

        return new Move(source, destination);


    }
}
