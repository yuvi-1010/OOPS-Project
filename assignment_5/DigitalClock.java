/* 
1. Write an applet to display the date and time .the time is to be shown like a digital clock.
Requirements:
 Create a JLabel to display the current time.
 Use java.util.Timer or javax.swing.Timer to update the time every second.
 Format the time using SimpleDateFormat.
 The clock should start as soon as the application launches and update in real-time.
*/
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;

public class DigitalClock extends JFrame {
    private JLabel timeLabel;
    public DigitalClock() {
        setTitle("Digital Clock");
        setSize(700, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        timeLabel = new JLabel("", SwingConstants.CENTER);
        timeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(timeLabel, BorderLayout.CENTER);

        Timer timer = new Timer(1000, e -> updateClock());
        timer.start();

        updateClock();
    }

    private void updateClock() {
        // Format and display the current time
        String timePattern = "EEEE, MMMM d, yyyy - hh:mm:ss a";
        SimpleDateFormat sdf = new SimpleDateFormat(timePattern);
        String currentTime = sdf.format(new Date());
        timeLabel.setText(currentTime);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DigitalClock clock = new DigitalClock();
            clock.setVisible(true);
        });
    }
}