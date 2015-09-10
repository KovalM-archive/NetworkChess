package chessview.piece;

import chessview.CheckerboardPosition;
import constants.PieceConstants;

public class RookView extends PieceView{
    public RookView(String color, CheckerboardPosition startingPosition){
        super();
        setColor(color);
        goToPosition(startingPosition);
        setPiecePicture(color.equals("black") ? PieceConstants.BLACK_ROOK : PieceConstants.WHITE_ROOK);
    }
}
