import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.function.Consumer;

public class MinimumSpanningTreeAlgorithmsView {
    public static void buildAndShowUI() {
        SwingUtilities.invokeLater(() -> {
            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(2, 1));

            addButton(panel, "Kruskal Algorithm", e -> KruskalAlgorithm.execute());
            addButton(panel, "Prim's Algorithm", e -> PrimAlgorithm.execute());

            FrameBuilder.build("Minimum Spanning Tree Algorithms", panel);
        });
    }

    private static void addButton(JPanel panel, String text, Consumer<ActionEvent> action) {
        JButton button = new JButton(text);
        button.addActionListener(action::accept);
        panel.add(button);
    }
}
