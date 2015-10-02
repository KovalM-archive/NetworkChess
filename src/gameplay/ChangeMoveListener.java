package gameplay;

import clientserver.ConnectionWithOpponent;

import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangeMoveListener implements ActionListener {
    private ConnectionWithOpponent connectionWithOpponent;
    private JButton changeMove;

    public ChangeMoveListener(ConnectionWithOpponent connectionWithOpponent, JButton changeMove){
        this.connectionWithOpponent = connectionWithOpponent;
        this.changeMove = changeMove;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (connectionWithOpponent.isEndMove()){
            connectionWithOpponent.sendEnd();
        }
    }
}
