package gameplay;

import chessmodel.CheckerboardPosition;
import chessview.DeskView;
import chessview.pieceview.PieceView;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ClickOnPieceListener implements MouseListener{
    private DeskView gameDesk;
    private PieceView choosePiece;

    public ClickOnPieceListener(DeskView gamesDesk, PieceView choosePiece){
        this.gameDesk = gamesDesk;
        this.choosePiece = choosePiece;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        PieceView currentPiece = gameDesk.getCurrentPiece();
        if (choosePiece.getColor().equals(gameDesk.getWalkethPlayer())){
            if (choosePiece.equals(currentPiece)){
                gameDesk.setCurrentPiece(null);
            } else {
                if (currentPiece != null && gameDesk.isLelagMove(choosePiece.getCurrentPosition())){
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
                    gameDesk.movePiece(currentPiece, new CheckerboardPosition(kingPosition.getRow(), newKingColumn));
                    gameDesk.movePiece(choosePiece, new CheckerboardPosition(kingPosition.getRow(), newRookColumn));
                    gameDesk.changePlayer();
                    currentPiece.notChoose();
                    gameDesk.setCurrentPiece(null);
                } else {
                    gameDesk.setCurrentPiece(choosePiece);
                }
            }
        } else{
            if (currentPiece != null && gameDesk.isLelagMove(choosePiece.getCurrentPosition())) {
                gameDesk.movePiece(currentPiece, choosePiece.getCurrentPosition());
                gameDesk.remove(choosePiece);
                gameDesk.changePlayer();
                currentPiece.notChoose();
                gameDesk.setCurrentPiece(null);
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
