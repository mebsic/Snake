package game.snake.main;

import javax.swing.*;

public class Main {


    /**
     * Constructor
     * pre: none
     * post: set window properties
     */
    public Main() {
        // game window properties
        Window window = new Window();
        window.setSize(500, 500);
        window.setVisible(true);
        window.setTitle("Snake");
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
