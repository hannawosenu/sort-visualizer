import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        // Creating user form frame
        JFrame frame = new JFrame("Sorting Visualizer");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 400); // width and height

        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        // Displaying Title in Center
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new FlowLayout());
        JLabel title = new JLabel("Sorting Algorithm Visualizer");
        titlePanel.add(title);
        titlePanel.setAlignmentX(Component.CENTER_ALIGNMENT); // Center align the title
        frame.add(titlePanel);

        // Start Sorting Button for different algorithms
        JPanel buttons = new JPanel();
        buttons.setLayout(new FlowLayout());
        JButton bubble = new JButton("Bubble Sort");
        buttons.add(bubble);

        JButton insertion = new JButton("Insertion Sort");
        buttons.add(insertion);

        JButton selection = new JButton("Selection Sort");
        buttons.add(selection);

        frame.add(buttons);

        // Slider for animation speed
        JPanel slider = new JPanel();
        slider.setLayout(new FlowLayout());
        JSlider speed = new JSlider(JSlider.HORIZONTAL,
                1, 10, 5);
        slider.add(speed);
        frame.add(slider);

        // Creating panel for sorting
        SortingVisualizerPanel panel = new SortingVisualizerPanel();
        panel.setPreferredSize(new Dimension(600, 300));
        frame.add(panel);

        frame.setVisible(true);

        bubble.addActionListener(e -> panel.startBubble());
        insertion.addActionListener(e -> panel.startInsertion());
        selection.addActionListener(e -> panel.startSelection());

        speed.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                int newSleepInterval = speed.getValue() * 50;
                panel.setSleepInterval(newSleepInterval);
            }
        });
    }
}
