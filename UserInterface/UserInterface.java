import javax.swing.*;

public class UserInterface {
    public static void GenerateAndShowUI(){
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame ui = new JFrame("JAVA-Algorithm");
        ui.setSize(500, 700);
        ui.setVisible(true);

        JLabel text = new JLabel("Hola");
        ui.getContentPane().add(text);
    }
}
