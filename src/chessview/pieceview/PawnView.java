package chessview.pieceview;

import chessmodel.piecemodel.PawnModel;
import chessmodel.CheckerboardPosition;

public class PawnView extends PieceView {
    public PawnView(String color, CheckerboardPosition startingPosition){
        super();
        pieceModel = new PawnModel(color, startingPosition);
        setColor(color);
        goToPosition(startingPosition);
        setPiecePicture(color.equals("black") ? PieceConstants.BLACK_PAWN : PieceConstants.WHITE_PAWN);
    }
}
