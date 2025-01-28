import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.function.Consumer;

public class HomeView {
    public static void buildAndShowUI(){
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(8, 1));

        addButton(panel, "CP Math Algorithms", e -> CPMathAlgorithmsView.buildAndShowUI());
        addButton(panel, "Graphs Algorithms", e -> GraphsAlgorithmsView.buildAndShowUI());
        addButton(panel, "Maximum Flow Algorithms", e -> MaximumFlowAlgorithmsView.buildAndShowUI());
        addButton(panel, "Minimum Spanning Tree Algorithms", e -> MinimumSpanningTreeAlgorithmsView.buildAndShowUI());
        addButton(panel, "Search Algorithms", e -> SearchAlgorithmsView.buildAndShowUI());
        addButton(panel, "Shortest Path Algorithm", e -> ShortestPathAlgorithmsView.buildAndShowUI());
        addButton(panel, "Sort Algorithms", e -> SortAlgorithmsView.buildAndShowUI());
        addButton(panel, "Trees Algorithms", e -> TreesAlgorithmsView.buildAndShowUI());

        FrameBuilder.build("JAVA-Algorithm", panel);
    }

    private static void addButton(JPanel panel, String text, Consumer<ActionEvent> action) {
        JButton button = new JButton(text);
        button.addActionListener(action::accept);
        panel.add(button);
    }
}
