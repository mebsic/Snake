package game.snake.main;

import game.snake.main.game.GridController;
import java.awt.GridLayout;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JFrame;

public class Window extends JFrame {


    private static final long serialVersionUID = -2542001418764869760L;
    public static ArrayList<ArrayList<GridController>> Grid;
    public static int width = 20;
    public static int height = 20;

    public Window() {
        // create an ArrayList, containing the threads for animation
        Grid = new ArrayList<ArrayList<GridController>>();
        ArrayList<GridController> data;

        // create Threads and adds to the ArrayList
        for (int i = 0; i < width; i++) {
            data = new ArrayList<GridController>();
            for (int j = 0; j < height; j++){
                GridController c = new GridController(2);
                data.add(c);
            }
            Grid.add(data);
        }
        getContentPane().setLayout(new GridLayout(20,20,0,0));

        // initialize all Threads and add every square of each Thread to the panel
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                getContentPane().add(Grid.get(i).get(j).square);
            }
        }
    }
}
