import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.function.Consumer;

public class GraphsAlgorithmsView {
    public static void buildAndShowUI() {
        SwingUtilities.invokeLater(() -> {
            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(3, 1));

            addButton(panel, "Breadth-First Search", e -> BFS.execute());
            addButton(panel, "Depth-First Search", e -> DFS.execute());
            addButton(panel, "Undirected Graph Cycle Detection", e -> UndirectedGraphCycleDetection.execute());

            FrameBuilder.build("Graphs Algorithms", panel);
        });
    }

    private static void addButton(JPanel panel, String text, Consumer<ActionEvent> action) {
        JButton button = new JButton(text);
        button.addActionListener(action::accept);
        panel.add(button);
    }
}
