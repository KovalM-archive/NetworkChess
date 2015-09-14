package chessview;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;

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
    }
}
