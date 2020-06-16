package game.snake.main.game.EntityManager;

import game.snake.main.game.Panel.SquarePanel;

import java.awt.*;
import java.util.ArrayList;

public class Entity {


    ArrayList<Color> C = new ArrayList<Color>();
    int color;
    public SquarePanel square;

    /**
     * Constructor
     * pre: colors from index assigned to game objects
     * post: return colors from index
     * @param col
     */
    public Entity(int col) {
        C.add(Color.GREEN); // index value 0: snake
        C.add(Color.RED);     // index value 1: food for snake
        C.add(Color.BLACK);    // index value 2: background color
        color = col;
        square = new SquarePanel(C.get(color));
    }

    /**
     * Modifier method
     * pre: none
     * post: color of game object is changed
     * @param c
     */
    public void changeColor(int c) {
        square.changeColor(C.get(c));
    }
}
