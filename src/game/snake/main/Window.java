package game.snake.main;

import game.snake.main.game.EntityRenderData;
import game.snake.main.game.KeyboardListener;
import java.awt.GridLayout;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JFrame;

public class Window extends JFrame {


    private static final long serialVersionUID = -2542001418764869760L; // randomly-generated serial ID
    public static ArrayList<ArrayList<EntityRenderData>> Grid;
    public static int width = 20;
    public static int height = 20;

    public Window() {
        // create ArrayList that contains game Threads
        Grid = new ArrayList<ArrayList<EntityRenderData>>();
        ArrayList<EntityRenderData> data;

        // add game Threads to ArrayList
        for (int i = 0; i < width; i++) {
            data = new ArrayList<EntityRenderData>();
            for (int j = 0; j < height; j++) {
                EntityRenderData c = new EntityRenderData(2);
                data.add(c);
            }
            Grid.add(data);
        }
        getContentPane().setLayout(new GridLayout(20, 20, 0, 0));

        // start and pause game Threads
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                getContentPane().add(Grid.get(i).get(j).square);
            }
        }

        // initial position of Snake
        Tuple position = new Tuple(10, 10);
        ThreadsController c = new ThreadsController(position);
        c.start();
        this.addKeyListener((KeyListener) new KeyboardListener());
    }
}
