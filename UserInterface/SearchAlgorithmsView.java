import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.function.Consumer;

public class SearchAlgorithmsView {
    public static void buildAndShowUI() {
        SwingUtilities.invokeLater(() -> {
            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(5, 1));

            addButton(panel, "Binary Search", e -> BinarySearch.execute());
            addButton(panel, "Exponential Search", e -> ExponentialSearch.execute());
            addButton(panel, "Jump Search", e -> JumpSearch.execute());
            addButton(panel, "Linear Search", e -> LinearSearch.execute());
            addButton(panel, "Ternary Search", e -> TernarySearch.execute());

            FrameBuilder.build("Search Algorithms", panel);
        });
    }

    private static void addButton(JPanel panel, String text, Consumer<ActionEvent> action) {
        JButton button = new JButton(text);
        button.addActionListener(action::accept);
        panel.add(button);
    }
}
