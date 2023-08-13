import javax.swing.*;
import java.awt.*;

public class SettingsWindow extends JFrame {
    public SettingsWindow() {
        setTitle("Settings");
        setSize(300, 200);
        setVisible(false);

        JPanel sliders = new JPanel();
        sliders.setLayout(new FlowLayout());

        JLabel sliderOne = new JLabel("Speed");
        JLabel sliderTwo = new JLabel("Size");

        JSlider speed = new JSlider(JSlider.HORIZONTAL,
                1, 20, 10);
        JSlider size = new JSlider(JSlider.HORIZONTAL,
                1, 10, 5);

        sliders.add(speed);
        sliders.add(sliderOne);

        sliders.add(size);
        sliders.add(sliderTwo);
    }
}
