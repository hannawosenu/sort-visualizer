import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class SortingVisualizerPanel extends JPanel {
    private int[] array;
    private static final int ARRAY_SIZE = 10;
    private int sleepInterval = 100;
    private Map<Integer, Color> initialPositionColors = new HashMap<>();
    Random random = new Random();


    public SortingVisualizerPanel() {
        generateRandomArray();
        generateInitialPositionColors();
    }

    private void generateRandomArray() {
        array = new int[ARRAY_SIZE];

        // Calculate maxHeight based on ARRAY_SIZE
        int maxValue = 100;

        for (int i = 0; i < ARRAY_SIZE; i++) {
            array[i] = random.nextInt(maxValue) + 1;
            System.out.println(array[i]);
        }
    }

    private void generateInitialPositionColors() {
        for (int i = 0; i < ARRAY_SIZE; i++) {
            int red = random.nextInt(256);
            int green = random.nextInt(256);
            int blue = random.nextInt(256);

            Color randomColor = new Color(red, green, blue);
            initialPositionColors.put(array[i], randomColor);
        }
    }

    public void startBubble() {
        Thread sortingThread = new Thread(() -> {
            BubbleSort.sort(array, this, sleepInterval);
        });

        sortingThread.start();
    }

    public void startInsertion() {
        Thread sortingThread = new Thread(() -> {
            InsertionSort.sort(array, this, sleepInterval);
        });

        sortingThread.start();
    }

    public void startSelection() {
        Thread sortingThread = new Thread(() -> {
            SelectionSort.sort(array, this, sleepInterval);
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

    public void setSleepInterval(int interval) {
        this.sleepInterval = interval;
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

            g.setColor(initialPositionColors.get(array[i]));
            g.fillRect(x, y, barWidth, barHeight);
        }
    }
}
