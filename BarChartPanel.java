import javax.swing.*;
import java.awt.*;

public class BarChartPanel extends JPanel {
    private int[] dataArray; // Array of values for bar heights

    public BarChartPanel(int[] dataArray) {
        this.dataArray = dataArray;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int width = getWidth();
        int height = getHeight();
        int barWidth = width / dataArray.length; // Width of each bar

        for (int i = 0; i < dataArray.length; i++) {
            int barHeight = dataArray[i];
            int x = i * barWidth;
            int y = height - barHeight;

            g.setColor(Color.BLUE); // Set bar color
            g.fillRect(x, y, barWidth, barHeight);
        }
    }
}
