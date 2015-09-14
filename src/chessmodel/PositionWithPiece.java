package chessmodel;

import chessmodel.piecemodel.PieceModel;

public class PositionWithPiece extends CheckerboardPosition {
    private PieceModel piece;

    public PositionWithPiece(int row, int column, PieceModel piece) {
        super(row, column);
        setPiece(piece);
    }

    public PositionWithPiece(int row, int column){
        super(row, column);
        this.piece = null;
    }

    public PieceModel getPiece() {
        return piece;
    }

    public void setPiece(PieceModel piece) {
        this.piece = piece;
    }
}
