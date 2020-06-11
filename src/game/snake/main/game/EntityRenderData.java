package game.snake.main.game;

import java.awt.*;
import java.util.ArrayList;

public class EntityRenderData {


    ArrayList<Color> C = new ArrayList<Color>();
    int color;
    public SquarePanel square;

    public EntityRenderData(int col) {
        C.add(Color.DARK_GRAY); // index value 0: empty
        C.add(Color.ORANGE);     // index value 1: food for snake
        C.add(Color.WHITE);    // index value 2: snake object
        color = col;
        square = new SquarePanel(C.get(color));
    }

    public void colorOrganizer(int c) {
        square.ChangeColor(C.get(c));
    }
}
