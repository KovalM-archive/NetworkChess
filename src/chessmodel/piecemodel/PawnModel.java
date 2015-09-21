package chessmodel.piecemodel;

import chessmodel.DeskModel;
import chessmodel.PositionWithPiece;
import chessmodel.CheckerboardPosition;

import java.util.ArrayList;
import java.util.List;

public class PawnModel extends PieceModel {
    public PawnModel(String color, CheckerboardPosition piecePosition) {
        super(color, piecePosition);
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
        if ((color.equals("white") && row==6) || (color.equals("black") && row==1)){
            if (deskModel.checkDeskBorder(row + 2*factor1, column)) {
                currentPosition = deskModel.getEqualElement(new CheckerboardPosition(row + 2*factor1, column));
                if (currentPosition != null && currentPosition.getPiece()==null){
                    allCandidate.add(currentPosition);
                }
            }
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

    @Override
    public List<PositionWithPiece> getAtackPositions(DeskModel deskModel) {
        List<PositionWithPiece> allCandidate = new ArrayList<>();
        int row = piecePosition.getRow();
        int column = piecePosition.getColumn();
        PositionWithPiece currentPosition;
        int factor1 = color.equals("white")?-1:1;

        if (deskModel.checkDeskBorder(row + factor1, column + 1)) {
            currentPosition = deskModel.getEqualElement(new CheckerboardPosition(row + factor1, column + 1));
            allCandidate.add(currentPosition);
        }

        if (deskModel.checkDeskBorder(row + factor1, column - 1)) {
            currentPosition = deskModel.getEqualElement(new CheckerboardPosition(row + factor1, column - 1));
            allCandidate.add(currentPosition);
        }
        return allCandidate;
    }
}
