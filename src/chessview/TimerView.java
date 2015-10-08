package chessview;

import javax.swing.JLabel;
import java.awt.Font;

public class TimerView extends JLabel implements Runnable {
    private boolean isRun;
    private int hour = 0, minute1 = 0, minute2 = 0, second1 = 0, second2 = 0, milliSec1 = 0, milliSec2 = 0;

    public TimerView(){
        setBounds(1050, 0, 300, 100);
        setFont(new Font(null, Font.ITALIC, 25));
        setText(hour + ":" + minute1 + "" + minute2 + ":" + second1 + ""
                + second2 + "." + milliSec1 + "" + milliSec2);
        begin();
    }

    public void begin() {
        isRun = true;
        Thread t = new Thread(this);
        t.start();
    }
    public void end(){
        isRun = false;
    }

    @Override
    public void run() {
        while (isRun) {
            milliSec2++;

            if (milliSec1 == 5 && milliSec2 == 9) {
                second2++;
                milliSec1 = 0;
                milliSec2 = 0;
            }

            if (milliSec2 == 9) {
                milliSec1++;
                milliSec2 = 0;
            }

            if (second2 == 10) {
                second1++;
                second2 = 0;
            }
            if (second1 == 6 && second2 == 0) {
                minute2++;
                milliSec1 = 0;
                milliSec2 = 0;
                second1 = 0;
                second2 = 0;
            }
            if (minute2 == 9) {
                minute1++;
                minute2 = 0;
            }
            if (minute1 == 6 && minute2 == 0) {
                hour++;
                milliSec1 = 0;
                milliSec2 = 0;
                second1 = 0;
                second2 = 0;
                minute1 = 0;
                minute2 = 0;
            }
            try {
                Thread.sleep(18);
            } catch (Exception e) {
                e.printStackTrace();
            }
            setText(hour + ":" + minute1 + "" + minute2 + ":" + second1 + "" + second2 + "." + milliSec1 + "" + milliSec2);
        }
    }
}