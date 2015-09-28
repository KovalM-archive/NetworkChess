package gameplay;

import chessmodel.CheckerboardPosition;
import chessview.DeskView;
import chessview.pieceview.PieceView;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ClickOnPieceListener implements MouseListener{
    private DeskView deskView;
    private PieceView choosePiece;

    public ClickOnPieceListener(DeskView deskView, PieceView choosePiece){
        this.deskView = deskView;
        this.choosePiece = choosePiece;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        PieceView currentPiece = deskView.getCurrentPiece();
        if (choosePiece.getColor().equals(deskView.getWalkethPlayer())){
            if (choosePiece.equals(currentPiece)){
                deskView.setCurrentPiece(null);
            } else {
                if (currentPiece != null){
                    CheckerboardPosition kingPosition = currentPiece.getCurrentPosition();
                    CheckerboardPosition rookPosition = choosePiece.getCurrentPosition();
                    int newKingColumn;
                    int newRookColumn;
                    if (kingPosition.getColumn() > rookPosition.getColumn()){
                        newKingColumn = kingPosition.getColumn() - 2;
                        newRookColumn = newKingColumn + 1;
                    }else{
                        newKingColumn = kingPosition.getColumn() + 2;
                        newRookColumn = newKingColumn - 1;
                    }
                    deskView.sendTypeMove("castling");
                    deskView.movePiece(currentPiece, new CheckerboardPosition(kingPosition.getRow(), newKingColumn));
                    deskView.movePiece(choosePiece, new CheckerboardPosition(kingPosition.getRow(), newRookColumn));
                } else {
                    deskView.setCurrentPiece(choosePiece);
                }
            }
        } else{
            if (currentPiece != null) {
                deskView.remove(choosePiece);
                deskView.sendTypeMove("simple");
                deskView.movePiece(currentPiece, choosePiece.getCurrentPosition());
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
