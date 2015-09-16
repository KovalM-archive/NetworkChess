package chessmodel.piecemodel;

import chessmodel.DeskModel;
import chessmodel.PositionWithPiece;
import chessmodel.CheckerboardPosition;

import java.util.ArrayList;
import java.util.List;

public class KnightModel extends PieceModel {
    public KnightModel(String color, CheckerboardPosition piecePosition) {
        super(color, piecePosition);
    }

    @Override
    public List<PositionWithPiece> getAllCandidate(DeskModel deskModel) {
        List<PositionWithPiece> allCandidate = new ArrayList<>();
        passDirectionForKnight(1, 2, deskModel, allCandidate);
        passDirectionForKnight(1, -2, deskModel, allCandidate);
        passDirectionForKnight(-1, 2, deskModel, allCandidate);
        passDirectionForKnight(-1, -2, deskModel, allCandidate);
        passDirectionForKnight(2, 1, deskModel, allCandidate);
        passDirectionForKnight(2, -1, deskModel, allCandidate);
        passDirectionForKnight(-2, 1, deskModel, allCandidate);
        passDirectionForKnight(-2, -1, deskModel, allCandidate);
        return allCandidate;
    }
    protected void passDirectionForKnight(int factor1, int factor2, DeskModel deskModel,
                                          List<PositionWithPiece> allCandidate){
        int row = piecePosition.getRow();
        int column = piecePosition.getColumn();
        PositionWithPiece currentPosition;
        if (deskModel.checkDeskBorder(row+factor1,column+factor2)){
            currentPosition = deskModel.getEqualElement(new CheckerboardPosition(row+factor1, column+factor2));
            if (currentPosition != null){
                if (currentPosition.getPiece() != null){
                    if (!currentPosition.getPiece().getColor().equals(color)){
                        allCandidate.add(currentPosition);
                    }

                } else {
                    allCandidate.add(currentPosition);
                }
            }
        }

    }
}
