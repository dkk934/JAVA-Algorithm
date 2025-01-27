import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        // Crear el marco (ventana)
        JFrame frame = new JFrame("Java-Algorithm");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        // Crear la sección de título
        JLabel titleLabel = new JLabel("Java-Algorithm", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 24));
        frame.add(titleLabel, BorderLayout.NORTH);

        // Crear el subtítulo
        JLabel subtitleLabel = new JLabel("Sorting algorithms", SwingConstants.CENTER);
        subtitleLabel.setFont(new Font("Serif", Font.PLAIN, 18));
        frame.add(subtitleLabel, BorderLayout.CENTER);

        // Crear el panel para las filas de etiquetas y botones
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        // Añadir las filas con etiquetas y botones
        for (int i = 1; i <= 5; i++) {
            JLabel label = new JLabel("Label " + i);
            JButton button = new JButton("Button " + i);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Botón presionado");
                    BubbleSort.execute();
                }
            });
            panel.add(label);
            panel.add(button);
        }

        frame.add(panel, BorderLayout.SOUTH);

        // Hacer visible la ventana
        frame.setVisible(true);
    }
}