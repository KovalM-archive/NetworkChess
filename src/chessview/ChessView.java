package chessview;

import constants.PieceConstants;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

public class ChessView {
    public ChessView(){
        JFrame mainWindow = new JFrame("Chess");
        mainWindow.setLayout(new BorderLayout());
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setLocationRelativeTo(null);
        Dimension sSize = Toolkit.getDefaultToolkit().getScreenSize ();
        mainWindow.setSize(sSize);
        mainWindow.setVisible(true);
        mainWindow.setExtendedState(Frame.MAXIMIZED_BOTH);

        mainWindow.add(new DeskView());
        //mainWindow.add(new JLabel(PieceConstants.BLACK_KING));
    }
}
