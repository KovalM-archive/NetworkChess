package chessview.piece;

import chessview.CheckerboardPosition;
import constants.PieceConstants;

public class PawnView extends PieceView {
    public PawnView(String color, CheckerboardPosition startingPosition){
        super();
        setColor(color);
        goToPosition(startingPosition);
        setPiecePicture(color.equals("black") ? PieceConstants.BLACK_PAWN : PieceConstants.WHITE_PAWN);
    }
}
