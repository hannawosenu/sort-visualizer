import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        // Creating user form frame
        JFrame frame = new JFrame("Sorting Visualizer");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 400); // width and height


        // Displaying Title in Center
        frame.setLayout(new FlowLayout());
        JLabel title = new JLabel("Sorting Algorithm Visualizer");
        frame.add(title);

        // Start Sorting Button
        JButton startButton = new JButton("Start Sorting");
        frame.add(startButton);

        // Creating panel for sorting
        SortingVisualizerPanel panel = new SortingVisualizerPanel();
        panel.setPreferredSize(new Dimension(600, 300));
        frame.add(panel);
        frame.setVisible(true);

        startButton.addActionListener(e -> panel.startSorting());
    }
}
