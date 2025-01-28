import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.function.Consumer;

public class TreesAlgorithmsView {
    public static void buildAndShowUI() {
        SwingUtilities.invokeLater(() -> {
            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(6, 1));

            addButton(panel, "AVL Tree", e -> AVLTree.execute());
            addButton(panel, "Binary Search Tree", e -> BinarySearchTree.execute());
            addButton(panel, "Binary Tree", e -> BinaryTree.execute());
            addButton(panel, "Decision Tree", e -> DecisionTree.execute());
            addButton(panel,  "Tree In Array", e -> TreeInArray.execute());
            addButton(panel, "Tree Linked List", e -> TreeLinkedList.execute());

            FrameBuilder.build("Trees Algorithms", panel);
        });
    }

    private static void addButton(JPanel panel, String text, Consumer<ActionEvent> action) {
        JButton button = new JButton(text);
        button.addActionListener(action::accept);
        panel.add(button);
    }
}
