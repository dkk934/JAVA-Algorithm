import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.function.Consumer;

public class CPMathAlgorithmsView {
    public static void buildAndShowUI() {
        SwingUtilities.invokeLater(() -> {
            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(7, 1));

            addButton(panel, "Binary Indexed Tree", e -> BinaryIndexedTree.execute());
            addButton(panel, "Euclidean Algorithm", e -> EuclideanAlgorithm.execute());
            addButton(panel, "Fermat's Little Theorem", e -> FermatsLittleTheorem.execute());
            addButton(panel, "Knuth-Morris-Pratt Algorithm", e -> KMP.execute());
            addButton(panel, "Modular Exponentiation", e -> ModularExponentiation.execute());
            addButton(panel, "Modular Inverse", e -> ModularInverse.execute());
            addButton(panel, "Sieve of Eratosthenes", e -> SieveOfEratosthenes.execute());

            FrameBuilder.build("CP Math Algorithms", panel);
        });
    }

    private static void addButton(JPanel panel, String text, Consumer<ActionEvent> action) {
        JButton button = new JButton(text);
        button.addActionListener(action::accept);
        panel.add(button);
    }
}
