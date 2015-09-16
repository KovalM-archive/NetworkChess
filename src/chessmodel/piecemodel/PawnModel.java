package chessmodel.piecemodel;

import chessmodel.DeskModel;
import chessmodel.PositionWithPiece;
import chessmodel.CheckerboardPosition;

import java.util.ArrayList;
import java.util.List;

public class PawnModel extends PieceModel {
    private boolean using;

    public PawnModel(String color, CheckerboardPosition piecePosition) {
        super(color, piecePosition);
        using = false;
    }

    @Override
    public List<PositionWithPiece> getAllCandidate(DeskModel deskModel) {
        List<PositionWithPiece> allCandidate = new ArrayList<>();
        int row = piecePosition.getRow();
        int column = piecePosition.getColumn();
        PositionWithPiece currentPosition;
        int factor1 = color.equals("white")?-1:1;

        if (deskModel.checkDeskBorder(row + factor1, column)) {
            currentPosition = deskModel.getEqualElement(new CheckerboardPosition(row + factor1, column));
            if (currentPosition != null && currentPosition.getPiece()==null){
                allCandidate.add(currentPosition);
            }
        }
        if (!using && deskModel.checkDeskBorder(row + 2*factor1, column)) {
            currentPosition = deskModel.getEqualElement(new CheckerboardPosition(row + 2*factor1, column));
            if (currentPosition != null && currentPosition.getPiece()==null){
                allCandidate.add(currentPosition);
            }
            using = true;
        }
        if (deskModel.checkDeskBorder(row + factor1, column + 1)) {
            currentPosition = deskModel.getEqualElement(new CheckerboardPosition(row + factor1, column + 1));
            if (currentPosition != null && currentPosition.getPiece()!=null &&
                    !currentPosition.getPiece().getColor().equals(color)){
                allCandidate.add(currentPosition);
            }
        }

        if (deskModel.checkDeskBorder(row + factor1, column - 1)) {
            currentPosition = deskModel.getEqualElement(new CheckerboardPosition(row + factor1, column - 1));
            if (currentPosition != null && currentPosition.getPiece()!=null &&
                    !currentPosition.getPiece().getColor().equals(color)){
                allCandidate.add(currentPosition);
            }
        }
        return allCandidate;
    }
}
