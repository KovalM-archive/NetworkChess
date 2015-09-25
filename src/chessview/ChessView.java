package chessview;

import javax.swing.JDialog;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;

public class ChessView {
    public ChessView(){
        JDialog chooseConnectionDialog = new JDialog();
        chooseConnectionDialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        chooseConnectionDialog.setSize(200, 150);
        chooseConnectionDialog.setLocationRelativeTo(null);
        chooseConnectionDialog.setVisible(true);
        chooseConnectionDialog.setLayout(new BorderLayout());
        chooseConnectionDialog.setModal(true);
        chooseConnectionDialog.add(new ChooseWayToConnectPanel(chooseConnectionDialog));
    }
}
