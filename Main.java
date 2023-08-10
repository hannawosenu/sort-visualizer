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

        // Start Sorting Button for different algorithms
        JButton bubble = new JButton("Bubble Sort");
        frame.add(bubble);

        JButton insertion = new JButton("Insertion Sort");
        frame.add(insertion);

        JButton selection = new JButton("Selection Sort");
        frame.add(selection);


        // Creating panel for sorting
        SortingVisualizerPanel panel = new SortingVisualizerPanel();
        panel.setPreferredSize(new Dimension(600, 300));
        frame.add(panel);
        frame.setVisible(true);

        bubble.addActionListener(e -> panel.startBubble());
        insertion.addActionListener(e -> panel.startInsertion());
        selection.addActionListener(e -> panel.startSelection());
    }
}
