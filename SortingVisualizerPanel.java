import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class SortingVisualizerPanel extends JPanel {
    private int[] array;
    private static final int ARRAY_SIZE = 10;

    public SortingVisualizerPanel() {
        generateRandomArray();

    }

    private void generateRandomArray() {
        array = new int[ARRAY_SIZE];
        Random random = new Random();

        // Calculate maxHeight based on ARRAY_SIZE
        int maxValue = 100;

        for (int i = 0; i < ARRAY_SIZE; i++) {
            array[i] = random.nextInt(maxValue) + 1;
            System.out.println(array[i]);
        }
    }

    public void startBubble() {
        Thread sortingThread = new Thread(() -> {
            BubbleSort.sort(array, this);
        });

        sortingThread.start();
    }

    public void startInsertion() {
        Thread sortingThread = new Thread(() -> {
            InsertionSort.sort(array, this);
        });

        sortingThread.start();
    }

    public void startSelection() {
        Thread sortingThread = new Thread(() -> {
            SelectionSort.sort(array, this);
        });

        sortingThread.start();
    }


    public void updateArray(int[] newArray) {
        array = newArray;
    }

    private int getMaxValue(int[] array) {
        int max = array[0];
        for (int i = 1; i < ARRAY_SIZE; i++) {
            if (array[i] > max) {
                System.out.println("Current max: " + max);
                max = array[i];
            }
        }
        return max;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int panelWidth = getWidth();
        int panelHeight = getHeight();

        int barWidth = panelWidth / ARRAY_SIZE; // Calculate the width of each bar
        int maxHeight = panelHeight - 20; // Max height of bars (leave some space at the top)

        int maxValue = getMaxValue(array);

        for (int i = 0; i < ARRAY_SIZE; i++) {
            int barHeight = maxHeight * array[i] / maxValue;
            int x = i * barWidth;
            int y = panelHeight - barHeight;

            g.setColor(Color.BLUE);
            g.fillRect(x, y, barWidth, barHeight);
        }
    }
}
