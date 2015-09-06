import chessview.ChessView;

import javax.swing.*;
import java.awt.BorderLayout;

public class Runner{
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ChessView();
            }
        });
    }
}
