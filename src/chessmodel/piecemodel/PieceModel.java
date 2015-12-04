package chessmodel.piecemodel;

import chessmodel.DeskModel;
import chessmodel.PositionWithPiece;
import chessmodel.CheckerboardPosition;

import java.util.ArrayList;
import java.util.List;

public abstract class PieceModel {
    protected String color;
    protected CheckerboardPosition piecePosition;
    protected boolean using;
    protected int title;

    public void setTitle(int title) {
        this.title = title;
    }

    public int getTitle() {
        return title;
    }

    public PieceModel(String color, CheckerboardPosition piecePosition){
        setColor(color);
        setPiecePosition(piecePosition);
        setUsing(false);
    }

    protected void checkForOccurrenceShah(DeskModel deskModel, List<PositionWithPiece> allCandidate){
        List<PositionWithPiece> allPosition = deskModel.getAllPosition();
        List<PositionWithPiece> allCandidateCopy = new ArrayList<>(allCandidate);
        PieceModel oldPiece;

        for (PositionWithPiece currentPosition : allCandidateCopy){
            deskModel.getEqualElement(piecePosition).setPiece(null);
            oldPiece = deskModel.getEqualElement(currentPosition).getPiece();
            deskModel.getEqualElement(currentPosition).setPiece(this);
            if (deskModel.checkShahThreat(color, allPosition)) {
                allCandidate.remove(currentPosition);
            }
            deskModel.getEqualElement(piecePosition).setPiece(this);
            deskModel.getEqualElement(currentPosition).setPiece(oldPiece);
        }
    }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public CheckerboardPosition getPiecePosition() {
        return piecePosition;
    }
    public abstract List<PositionWithPiece> getAllCandidate(DeskModel deskModel);
    public abstract List<PositionWithPiece> getAttackedPositions(DeskModel deskModel);
    public void setPiecePosition(CheckerboardPosition piecePosition) {
        this.piecePosition = piecePosition;
    }
    protected void passDirection(int factor1, int factor2, DeskModel deskModel, List<PositionWithPiece> allCandidate){
        int row = piecePosition.getRow();
        int column = piecePosition.getColumn();
        PositionWithPiece currentPosition;
        for (int i = 1; i < 8; i++) {
            if (deskModel.checkDeskBorder(row+factor1*i,column+factor2*i)){
                currentPosition = deskModel.getEqualElement(new CheckerboardPosition(row+factor1*i, column+factor2*i));
                if (currentPosition != null){
                    if (currentPosition.getPiece() != null){
                        if (!currentPosition.getPiece().getColor().equals(color)){
                            allCandidate.add(currentPosition);
                        }
                        break;
                    } else {
                        allCandidate.add(currentPosition);
                    }
                }
            }
        }
    }
    protected void passNeighboringCells(int factor1, int factor2, DeskModel deskModel,
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
    public boolean isUsing(){
        return using;
    }
    public void setUsing(boolean using){
        this.using = using;
    }
}
