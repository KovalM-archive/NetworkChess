package chessmodel.piecemodel;

import chessmodel.DeskModel;
import chessmodel.PositionWithPiece;
import chessmodel.CheckerboardPosition;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class KingModel extends PieceModel {
    public KingModel(String color, CheckerboardPosition piecePosition) {
        super(color, piecePosition);
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
            if (!using){
                PositionWithPiece rookPosition = checkRokirovka(deskModel, color.equals("white")?7:0, 0);
                if (rookPosition!=null) allCandidate.add(rookPosition);
                rookPosition = checkRokirovka(deskModel, color.equals("white")?7:0, 7);
                if (rookPosition!=null) allCandidate.add(rookPosition);
            }
        }
        return allCandidate;
    }

    @Override
    public List<PositionWithPiece> getAtackPositions(DeskModel deskModel) {
        return getAllCandidate(deskModel);
    }

    private void removeBrokenCells(DeskModel deskModel, List<PositionWithPiece> allCandidate){
        List<PositionWithPiece> allPosition = deskModel.getAllPosition();
        List<PositionWithPiece> aliensCandidate;
        int n = allPosition.size();
        PieceModel currentPiece;
        for (int i = 0; i < n; i++) {
            currentPiece = allPosition.get(i).getPiece();
            if (currentPiece != null && !currentPiece.getColor().equals(color)){
                aliensCandidate = currentPiece.getAtackPositions(deskModel);
                for (PositionWithPiece currentPosition : aliensCandidate){
                    if (allCandidate.contains(currentPosition)){
                        allCandidate.remove(currentPosition);
                    }
                }
            }
        }
    }

    public PositionWithPiece checkRokirovka(DeskModel deskModel, int row, int column){
        List<PositionWithPiece> allPosition = deskModel.getAllPosition();
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
