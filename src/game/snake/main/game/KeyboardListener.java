package game.snake.main.game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyboardListener extends KeyAdapter {


    /**
     * Helper method
     * pre: checks for keyboard press
     * post: returns direction after press
     * @param e
     */
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case 39: // right key
                // check for opposite direction
                if (ThreadControl.directionSnake != 2) {
                    ThreadControl.directionSnake = 1;
                }
                break;
            case 38: // up key
                if (ThreadControl.directionSnake != 4) {
                    ThreadControl.directionSnake = 3;
                }
                break;
            case 37: // left key
                if (ThreadControl.directionSnake != 1) {
                    ThreadControl.directionSnake = 2;
                }
                break;
            case 40: // down key
                if (ThreadControl.directionSnake != 3) {
                    ThreadControl.directionSnake = 4;
                }
                break;
            default:
                break;
        }
    }
}
