package gameplay;

import chessview.CheckerboardPosition;
import chessview.DeskView;
import chessview.piece.PieceView;
import sun.security.krb5.internal.crypto.Des;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ClickOnDeskListener implements MouseListener {
    private DeskView deskView;

    public ClickOnDeskListener(DeskView deskView){
        this.deskView = deskView;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        PieceView currentPiece = deskView.getCurrentPiece();
        if (currentPiece != null) {
            if (300 < x && x <= 1020 && 0 < y && y <= 720) {
                x -= 300;
                currentPiece.goToPosition(new CheckerboardPosition(y /= 90, x /= 90));
                deskView.changePlayer();
                currentPiece.notChoose();
                deskView.setCurrentPiece(null);
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
