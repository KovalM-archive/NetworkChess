package chessview.pieceview;

import chessmodel.piecemodel.BishopModel;
import chessmodel.CheckerboardPosition;

public class BishopView extends PieceView{
    public BishopView(String color, CheckerboardPosition startingPosition){
        super();
        pieceModel = new BishopModel(color, startingPosition);
        setColor(color);
        goToPosition(startingPosition);
        setPiecePicture(color.equals("black") ? PieceViewConstants.BLACK_BISHOP : PieceViewConstants.WHITE_BISHOP);
    }
}
