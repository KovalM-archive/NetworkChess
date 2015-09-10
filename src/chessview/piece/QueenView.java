package chessview.piece;

import chessview.CheckerboardPosition;
import constants.PieceConstants;

public class QueenView extends PieceView{
    public QueenView(String color, CheckerboardPosition startingPosition){
        super();
        setColor(color);
        goToPosition(startingPosition);
        setPiecePicture(color.equals("black") ? PieceConstants.BLACK_QUEEN : PieceConstants.WHITE_QUEEN);
    }
}
