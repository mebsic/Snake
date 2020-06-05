package game.snake.main.game;

import java.awt.*;
import java.util.ArrayList;

public class GridController {


    ArrayList<Color> C =new ArrayList<Color>();
    int color; // 2: snake , 1: food, 0: empty
    SquarePanel square;

    public GridController(int col) {
        C.add(Color.darkGray);//0
        C.add(Color.BLUE);    //1
        C.add(Color.white);   //2
        color = col;
        square = new SquarePanel(C.get(color));
    }

    public void light(int c) {
        square.ChangeColor(C.get(c));
    }
}
