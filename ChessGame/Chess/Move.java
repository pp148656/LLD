package ChessGame.Chess;

public class Move {
    private Pair source;
    private Pair destination;
    public Move(Pair source, Pair destination) {
        this.source = source;
        this.destination = destination;
    }
    public Pair getSource() {
        return source;
    }
    public Pair getDestination() {
        return destination;
    }
}
