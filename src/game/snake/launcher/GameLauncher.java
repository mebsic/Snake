package game.snake.launcher;

import game.snake.main.Main;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

/**
* Mr Vittorio
* Final Culminating
*/

public class GameLauncher extends JFrame {


    /**
     * Main method
     * @param args
     */
    public static void main(String[] args) {
        new GameLauncher();
    }

    /**
     * Constructor
     * pre: initialize launcher screen and keyboard input
     * post: display game after input
     */
    public GameLauncher() {
        // initialize launcher screen from image URL
        try {
            BufferedImage img = ImageIO.read(new URL("https://i.imgur.com/LOCqoO3.png"));
            JLabel image = new JLabel(new ImageIcon(img));
            getContentPane().add(image, BorderLayout.CENTER);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // launcher window properties
        setSize(600, 500);
        setResizable(false);
        setLocationRelativeTo(null); // centers window on screen
        setVisible(true);
        setTitle("Snake Launcher");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        requestFocus();

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
                    new Main();
                }
            }
        });
    }
}
