import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.function.Consumer;

public class SortAlgorithmsView {
    public static void buildAndShowUI() {
        SwingUtilities.invokeLater(() -> {
            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(16, 1));

            addButton(panel, "Binomial Heap Sort", e -> {}/*BinomialHeapSort.execute()*/);
            addButton(panel, "Bubble Sort", e -> BubbleSort.execute());
            addButton(panel, "Cocktail Shaker Sort", e -> CocktailShakerSort.execute());
            addButton(panel, "Counting Sort", e -> CountingSort.execute());
            addButton(panel, "Flash Sort", e -> FlashSort.execute());
            addButton(panel, "Insertion Sort", e -> InsertionSort.execute());
            addButton(panel, "Merge Sort", e -> MergeSort.execute());
            addButton(panel, "Pigeonhole Sort", e -> PigeonholeSort.execute());
            addButton(panel, "Quick Sort", e -> QuickSort.execute());
            addButton(panel, "Radix Sort", e -> RadixSort.execute());
            addButton(panel, "Selection Sort", e -> SelectionSort.execute());
            addButton(panel, "Shell Sort", e -> ShellSort.execute());
            addButton(panel, "Sleep Sort", e -> {
                try {
                    SleepSort.execute();
                } catch (InterruptedException ex) {
                    System.out.println("Error");
                }
            });
            addButton(panel, "Strand Sort", e -> StrandSort.execute());
            addButton(panel, "Tim Sort", e -> TimSort.execute());
            addButton(panel, "Topological Sort", e -> TopologicalSort.execute());

            FrameBuilder.build("Sort Algorithms", panel);
        });
    }

    private static void addButton(JPanel panel, String text, Consumer<ActionEvent> action) {
        JButton button = new JButton(text);
        button.addActionListener(action::accept);
        panel.add(button);
    }
}
