import java.awt.*;
import javax.swing.*;

public class jj {
    public JComponent makeUI() {
        JProgressBar progress = new JProgressBar();
        // use JProgressBar#setUI(...) method
        progress.setUI(new ProgressCircleUI());
        progress.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
        progress.setStringPainted(true);
        progress.setFont(progress.getFont().deriveFont(25f));
        progress.setForeground(Color.blue);

        (new Timer(50, e -> {
            int iv = Math.min(100, progress.getValue() + 1);
            progress.setValue(iv);
        })).start();

        JPanel p = new JPanel();
        p.add(progress);
        return p;
    }
    public static void main(String... args) {
        EventQueue.invokeLater(() -> {
            JFrame f = new JFrame();
            f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            f.getContentPane().add(new jj().makeUI());
            f.setSize(500, 500);
            f.setLocationRelativeTo(null);
            f.setVisible(true);
        });
    }
}

