package chessmodel.piecemodel;

import chessmodel.DeskModel;
import chessmodel.PositionWithPiece;
import chessmodel.CheckerboardPosition;

import java.util.ArrayList;
import java.util.List;

public class KingModel extends PieceModel {
    public KingModel(String color, CheckerboardPosition piecePosition) {
        super(color, piecePosition);
        setTitle(PieceModelConstants.KING_TITLE);
    }

    @Override
    public List<PositionWithPiece> getAllCandidate(DeskModel deskModel) {
        List<PositionWithPiece> allCandidate = new ArrayList<>();
        passNeighboringCells(1, 0, deskModel, allCandidate);
        passNeighboringCells(0, 1, deskModel, allCandidate);
        passNeighboringCells(-1, 0, deskModel, allCandidate);
        passNeighboringCells(0, -1, deskModel, allCandidate);
        passNeighboringCells(1, 1, deskModel, allCandidate);
        passNeighboringCells(-1, -1, deskModel, allCandidate);
        passNeighboringCells(-1, 1, deskModel, allCandidate);
        passNeighboringCells(1, -1, deskModel, allCandidate);
        if (deskModel.getWalkethPlayer().equals(color)){
            removeBrokenCells(deskModel, allCandidate);
            checkForOccurrenceShah(deskModel, allCandidate);
            if (!using){
                PositionWithPiece rookPosition = checkCasting(deskModel, color.equals("white") ? 7 : 0, 0);
                if (rookPosition!=null) allCandidate.add(rookPosition);
                rookPosition = checkCasting(deskModel, color.equals("white") ? 7 : 0, 7);
                if (rookPosition!=null) allCandidate.add(rookPosition);
            }
        }
        return allCandidate;
    }

    @Override
    public List<PositionWithPiece> getAttackedPositions(DeskModel deskModel) {
        return getAllCandidate(deskModel);
    }

    private void removeBrokenCells(DeskModel deskModel, List<PositionWithPiece> allCandidate){
        List<PositionWithPiece> allPosition = deskModel.getAllPosition();
        List<PositionWithPiece> aliensCandidate;
        PieceModel currentPiece;

        int n = allPosition.size();
        for (int i = 0; i < n; i++) {
            currentPiece = allPosition.get(i).getPiece();
            if (currentPiece != null && !currentPiece.getColor().equals(color)){
                aliensCandidate = currentPiece.getAttackedPositions(deskModel);
                for (PositionWithPiece currentPosition : aliensCandidate){
                    if (allCandidate.contains(currentPosition)){
                        allCandidate.remove(currentPosition);
                    }
                }
            }
        }
    }

    public PositionWithPiece checkCasting(DeskModel deskModel, int row, int column){
        PositionWithPiece rookPosition = deskModel.getEqualElement(new CheckerboardPosition(row, column));
        PieceModel rook = rookPosition.getPiece();
        PositionWithPiece answer = null;
        int kingColumn = piecePosition.getColumn();
        if (rook != null && rook instanceof RookModel && !rook.isUsing()){
            List<PositionWithPiece> allCandidate = new ArrayList<PositionWithPiece>();
            allCandidate.add(rookPosition);
            allCandidate.add(deskModel.getEqualElement(piecePosition));
            for (int i = Math.min(column, kingColumn)+1; i < Math.max(column, kingColumn); i++) {
                PositionWithPiece currentPosition = deskModel.getEqualElement(new CheckerboardPosition(row, i));
                if (currentPosition.getPiece()!=null){
                    return answer;
                }
                allCandidate.add(currentPosition);
            }
            int sizeBefore = allCandidate.size();
            removeBrokenCells(deskModel, allCandidate);
            if (sizeBefore == allCandidate.size()){
                answer = rookPosition;
            }
        }
        return answer;
    }

}
