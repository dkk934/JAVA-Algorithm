import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.function.Consumer;

public class ShortestPathAlgorithmsView {
    public static void buildAndShowUI() {
        SwingUtilities.invokeLater(() -> {
            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(4, 1));

            addButton(panel, "A Star", e -> AStar.execute());
            addButton(panel, "Bellman Ford", e -> BellmanFord.execute());
            addButton(panel, "Dijkstra Algorithm", e -> DijkstraAlgorithm.execute());
            addButton(panel, "Floyd Warshall", e -> FloydWarshall.execute());

            FrameBuilder.build("Shortest Path Algorithms", panel);
        });
    }

    private static void addButton(JPanel panel, String text, Consumer<ActionEvent> action) {
        JButton button = new JButton(text);
        button.addActionListener(action::accept);
        panel.add(button);
    }
}
