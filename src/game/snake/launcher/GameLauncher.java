package game.snake.launcher;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class GameLauncher extends JFrame {


    public static void main(String[] args) {
        new GameLauncher();
    }

    public GameLauncher() {
        // initialize launcher screen from image URL
        try {
            BufferedImage img = ImageIO.read(new URL("https://insertlauncherscreenhere.com"));
            JLabel image = new JLabel(new ImageIcon(img));
            getContentPane().add(image, BorderLayout.CENTER);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // keyboard listener to start game
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }
            @Override
            public void keyPressed(KeyEvent e) {
            }
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    setVisible(false);
                    //TODO create game window and initialize
                }
            }
        });

        // launcher window properties
        setSize(600, 600);
        setResizable(false);
        setLocationRelativeTo(null); // centers window on screen
        setVisible(true);
        setTitle("Snake Launcher");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        requestFocus();
    }
}
