package game.snake.main.game.GameHandler;

import game.snake.main.game.GameHandler.GameManager;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter {


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
                if (GameManager.directionOfSnake != 2) {
                    GameManager.directionOfSnake = 1;
                }
                break;
            case 38: // up key
                if (GameManager.directionOfSnake != 4) {
                    GameManager.directionOfSnake = 3;
                }
                break;
            case 37: // left key
                if (GameManager.directionOfSnake != 1) {
                    GameManager.directionOfSnake = 2;
                }
                break;
            case 40: // down key
                if (GameManager.directionOfSnake != 3) {
                    GameManager.directionOfSnake = 4;
                }
                break;
            default:
                break;
        }
    }
}
