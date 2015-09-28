package clientserver;

import chessview.DeskView;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class WaitForConnectionListener implements ActionListener{
    private JDialog chooseConnectionDialog;
    private Socket socket;

    public WaitForConnectionListener(JDialog chooseConnectionDialog){
        this.chooseConnectionDialog = chooseConnectionDialog;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        chooseConnectionDialog.setVisible(false);
        JFrame mainWindow = new JFrame("Chess");
        mainWindow.setLayout(new BorderLayout());
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setLocationRelativeTo(null);
        Dimension sSize = Toolkit.getDefaultToolkit().getScreenSize ();
        mainWindow.setSize(sSize);
        mainWindow.setVisible(true);
        mainWindow.setExtendedState(Frame.MAXIMIZED_BOTH);
        mainWindow.setBackground(Color.gray);
        try {
            ServerSocket serverSocket = new ServerSocket(4569);
            socket = serverSocket.accept();
            mainWindow.add(new DeskView(socket, "white"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
