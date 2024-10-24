import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    Frame() {
        ImageIcon imageIcon = new ImageIcon("logo_lock.png");

        JLabel label = new JLabel();
        label.setText("Your Computer Has VIRUS");
        label.setBounds(15, 4, 350, 100);
        label.setIcon(imageIcon);
        label.setOpaque(true);
        label.setVisible(true);

        // This allows each frame to be closed independently.
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("WARNING");
        this.setResizable(false);
        this.setLayout(null);
        // Set a size for the frame
        this.setSize(300, 140); 

        this.setVisible(true);

        this.add(label);
    }
}
