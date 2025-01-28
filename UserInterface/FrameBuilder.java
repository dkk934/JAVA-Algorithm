import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class FrameBuilder {
    public static void build(String subtitle, JPanel panel){
        JFrame frame = new JFrame("Java-Algorithm");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JLabel titleLabel = new JLabel(subtitle, SwingConstants.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 24));
        contentPanel.add(titleLabel, BorderLayout.NORTH);

        contentPanel.add(panel, BorderLayout.CENTER);
        frame.add(contentPanel);

        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }
}
