package game.snake.main;

import javax.swing.*;

public class Main {


    /**
     * Main method
     * @param args
     */
    public static void main(String[] args) {
        new Main();
    }

    /**
     * Constructor
     */
    public Main() {
        // game window properties
        Window window = new Window();
        window.setTitle("Snake");
        window.setSize(300, 300);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
