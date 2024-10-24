import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main  {

    public static List<Frame> frames = new ArrayList<>();

    public static int random(int bound) {
        Random random = new Random();
        return random.nextInt(bound);
    }

    public static void main(String[] args)  {

    

        for (int i=0; i<=20; i++) {
            // Create a new Frame instance
            Frame frame = new Frame();  
            frame.setBounds(random(1600),random(900),300,140);
            // Add to the list of frames
            frames.add(frame); 

          //  JOptionPane.showMessageDialog(frame,"Your computer has VIRUS", "Warning",JOptionPane.WARNING_MESSAGE);

        }


        // Add a WindowListener to each frame
        for (Frame frame : frames) {
            frame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    System.out.println("Closed a pop-up");
                }
            });
        }
    }

}
