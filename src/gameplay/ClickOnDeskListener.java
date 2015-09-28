package gameplay;

import chessmodel.CheckerboardPosition;
import chessview.DeskView;
import chessview.pieceview.PieceView;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ClickOnDeskListener implements MouseListener {
    private DeskView deskView;

    public ClickOnDeskListener(DeskView deskView){
        this.deskView = deskView;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX()-300;
        int y = e.getY();
        PieceView currentPiece = deskView.getCurrentPiece();
        CheckerboardPosition newPosition;
        if (currentPiece != null) {
            if (0 < x && x <= 720 && 0 < y && y <= 720) {
                newPosition = new CheckerboardPosition(y/=90, x /= 90);
                if (deskView.isLegalMove(newPosition)){
                    deskView.sendTypeMove("simple");
                    deskView.movePiece(currentPiece, newPosition);
                }
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
