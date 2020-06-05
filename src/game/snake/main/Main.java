package game.snake.main;

import javax.swing.*;

public class Main {


    public static void main(String[] args) {
        Window game = new Window();
        game.setTitle("Snake");
        game.setSize(300,300);
        game.setVisible(true);
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
