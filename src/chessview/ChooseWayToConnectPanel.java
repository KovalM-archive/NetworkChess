package chessview;

import chessview.DeskView;
import clientserver.ConnectListener;
import clientserver.WaitForConnectionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;


public class ChooseWayToConnectPanel extends JPanel {
    public ChooseWayToConnectPanel(JDialog chooseConnectionDialog){
        setLayout(new GridBagLayout());
        JButton connect = new JButton("Connect");
        connect.addActionListener(new ConnectListener(chooseConnectionDialog));
        JButton waitForConnection = new JButton("Wait for connection");
        waitForConnection.addActionListener(new WaitForConnectionListener(chooseConnectionDialog));

        add(connect, new GridBagConstraints(0, 0, 1, 1, 0, 0,
                GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(
                1, 1, 1, 1), 0, 0));
        add(waitForConnection, new GridBagConstraints(0, 1, 1, 1, 0, 0,
                GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(
                1, 1, 1, 1), 0, 0));
    }
}
