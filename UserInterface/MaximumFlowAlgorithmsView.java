import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.function.Consumer;

public class MaximumFlowAlgorithmsView {
    public static void buildAndShowUI() {
        SwingUtilities.invokeLater(() -> {
            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(2, 1));

            addButton(panel, "Edmons Karp Algorithm", e -> EdmonsKarpAlgorithm.execute());
            addButton(panel, "Ford Fulkerson Algorithm", e -> FordFulkersonAlgorithm.execute());

            FrameBuilder.build("Maximum Flow Algorithms", panel);
        });
    }

    private static void addButton(JPanel panel, String text, Consumer<ActionEvent> action) {
        JButton button = new JButton(text);
        button.addActionListener(action::accept);
        panel.add(button);
    }
}
