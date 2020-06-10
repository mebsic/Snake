package game.snake.main.game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyboardListener extends KeyAdapter {


    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()) {
            case 39: // right key
                // check for opposite direction
                if (ThreadsController.directionSnake != 2) {
                    ThreadsController.directionSnake = 1;
                }
                break;
            case 38: // up key
                if (ThreadsController.directionSnake != 4) {
                    ThreadsController.directionSnake = 3;
                }
                break;
            case 37: // left key
                if (ThreadsController.directionSnake != 1) {
                    ThreadsController.directionSnake = 2;
                }
                break;
            case 40: // down key
                if (ThreadsController.directionSnake != 3) {
                    ThreadsController.directionSnake = 4;
                }
                break;
            default: break;
        }
    }
}
