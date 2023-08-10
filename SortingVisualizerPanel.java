import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class SortingVisualizerPanel extends JPanel {
    private int[] array;
    private static final int ARRAY_SIZE = 10;
    private static final int BAR_WIDTH = 4;
    private static final int BAR_HEIGHT_SCALE = 3;

    public SortingVisualizerPanel() {
        generateRandomArray();

    }

    private void generateRandomArray() {
        array = new int[ARRAY_SIZE];
        Random random = new Random();

        // Calculate maxHeight based on ARRAY_SIZE
        int maxHeight = Math.max(1, (getHeight() - 20) / BAR_HEIGHT_SCALE);

        for (int i = 0; i < ARRAY_SIZE; i++) {
            array[i] = random.nextInt(maxHeight + 1);
            System.out.println(array[i]);
        }
    }

    public void startSorting() {
        // Call the sorting algorithm of your choice
        BubbleSort.sort(array, this); // Pass the panel instance to the sorting algorithm
    }

    public void updateArray(int[] newArray) {
        array = newArray;
        repaint(); // Trigger the panel to repaint
        try {
            Thread.sleep(10); // Add a small delay to see the animation
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int panelWidth = getWidth();
        int panelHeight = getHeight();

        int barWidth = panelWidth / ARRAY_SIZE; // Calculate the width of each bar
        int maxHeight = panelHeight - 20; // Max height of bars (leave some space at the top)

        for (int i = 0; i < ARRAY_SIZE; i++) {
            int barHeight = array[i] * (maxHeight / ARRAY_SIZE);
            int x = i * barWidth;
            int y = panelHeight - barHeight;

            // Set the color for the bar
            g.setColor(Color.BLUE);

            g.fillRect(x, y, barWidth, barHeight);
        }
    }
}
