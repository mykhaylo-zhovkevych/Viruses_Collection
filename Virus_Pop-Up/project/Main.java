import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main  {

    private static List<Frame> frames = new ArrayList<>();
    private static Dimension screenSize;
    private static int closedPopUpCount = 0;
    private static boolean threadStarted = false;

    // print zufälige Zahl zwischen 0 und input(bound)
    private static int random(int bound) {
        Random random = new Random();
        return random.nextInt(bound);
    }

    public static void main(String[] args)  {

    // Get the screen size (resolution)
    Toolkit toolkit = Toolkit.getDefaultToolkit();
    screenSize = toolkit.getScreenSize();

        // Initially create 3 pop-ups
        for (int i = 0; i < 3; i++) {
            createNewFrame();
        }
    }
    // Function to create a new Frame
    private static void createNewFrame() {
        Frame frame = new Frame();
        
        // Calculate frame size based on screen size
        int frameWidth = (int) (screenSize.width * 0.1); 
        int frameHeight = (int) (screenSize.height * 0.1); 
        
        // Set bounds to random position within the screen
        frame.setBounds(random(screenSize.width - frameWidth), random(screenSize.height - frameHeight), frameWidth, frameHeight);
        frames.add(frame);

        // Add WindowListener to handle window closing
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                frame.dispose(); // Close the window
            }

            @Override
            public void windowClosed(WindowEvent e) {
                System.out.println("Closed a pop-up");

                // Increment the closed pop-up counter
                closedPopUpCount++;

                // Check if 3 pop-ups have been closed
                if (closedPopUpCount >= 3 && !threadStarted) {
                    threadStarted = true; // Start the thread only once
                    startAddingPopUpsEverySecond(); // Start adding 5 pop-ups every second
                }

                // Create 10 new pop-ups when one is closed
                for (int i = 0; i < 10; i++) {
                    createNewFrame();
                }
            }
        });

        frame.setVisible(true); 
    }

    private static void startAddingPopUpsEverySecond() {
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000); // Wait 1 second

                    // Add 5 new pop-ups
                    for (int i = 0; i < 5; i++) {
                        createNewFrame();
                    }
                    
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}