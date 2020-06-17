package game.snake.main;

import game.snake.main.game.EntityManager.Entity;
import game.snake.main.game.Panel.GridPanel;
import game.snake.main.game.GameHandler.KeyListener;
import game.snake.main.game.GameHandler.GameManager;

import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.*;

public class Window extends JFrame {


    public static ArrayList<ArrayList<Entity>> entity;
    public static int width = 20;
    public static int height = 20;

    /**
     * Constructor
     * pre: assign game threads
     * post: initialize game and objects,
     * wait for keyboard input
     */
    public Window() {
        // create ArrayList that contains game Threads
        entity = new ArrayList<ArrayList<Entity>>();
        ArrayList<Entity> data;

        // add game Threads to ArrayList
        for (int i = 0; i < width; i++) {
            data = new ArrayList<Entity>();
            for (int j = 0; j < height; j++) {
                Entity c = new Entity(2);
                data.add(c);
            }
            entity.add(data);
        }

        // start and pause game Threads
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                getContentPane().add(entity.get(i).get(j).square);
            }
        }

        // initial position of Snake
        getContentPane().setLayout(new GridLayout(20, 20, 0, 0));
        GridPanel position = new GridPanel(10, 10);
        GameManager snake = new GameManager(position);

        // start game
        this.addKeyListener(new KeyListener());
        snake.start();
    }
}
