package game.snake.main.game.GameHandler;

import game.snake.main.Window;
import game.snake.main.game.EntityManager.Entity;
import game.snake.main.game.Panel.GridPanel;
import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Game logic using Threads
 */
public class GameManager extends Thread {


    // entity manager variables
    ArrayList<ArrayList<Entity>> squares = new ArrayList<ArrayList<Entity>>();
    ArrayList<GridPanel> positions = new ArrayList<GridPanel>();
    GridPanel headSnakePos;
    GridPanel foodPosition;

    // game variables
    public static int directionOfSnake;
    public int score; // default game score
    int snakeSize = 3; // default rendered snake size
    long speed = 75; // default snake speed

    /**
     * Constructor
     * pre: check snake direction
     * post: assign position and spawn consumable food
     * @param position
     */
    public GameManager(GridPanel position) {
        squares = Window.entity;
        directionOfSnake = 1;
        foodPosition = new GridPanel(Window.height - 1, Window.width - 1);
        spawnFood(foodPosition);

        // direction of snake (pointer)
        headSnakePos = new GridPanel(position.x, position.y);
        GridPanel headPos = new GridPanel(headSnakePos.getX(), headSnakePos.getY());
        positions.add(headPos);
    }

    /**
     * Helper method
     * pre: check game condition
     * post: run game methods
     */
    public void run() {
        while (true) {
            moveInternal(directionOfSnake);
            try {
                checkCollision();
            } catch (IOException e) {
                e.printStackTrace();
            }
            moveExternal();
            deleteTail();
            pauseGame();
        }
    }

    /**
     * Helper method
     * pre: none
     * post: delay snake movement
     */
    private void pauseGame() {
        try {
            sleep(speed);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Helper method
     * pre: get snake position and direction
     * post: verify snake is biting or consuming
     */
    private void checkCollision() throws IOException {
        GridPanel criticalPosition = positions.get(positions.size() - 1);
        for (int i = 0; i <= positions.size() - 2; i++) {
            boolean biteItself = criticalPosition.getX() == positions.get(i).getX() && criticalPosition.getY() == positions.get(i).getY();
            if (biteItself) {
                System.out.print("\nEntity collided with itself");

                JOptionPane.showMessageDialog(null, "Game Over!\n\nYou can't eat your own tail!\nTry again...","Snake", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
                stopTheGame();
            }
        }
        boolean eatingFood = criticalPosition.getX() == foodPosition.y && criticalPosition.getY() == foodPosition.x;
        if (eatingFood) {
            System.out.print("\nEntity consumed food");
            snakeSize = snakeSize + 1;

            // score handler
            score++;
            System.out.print("\nScore is: " + getScore(score));

            foodPosition = getOpenArea();
            spawnFood(foodPosition);
        }
    }

    /**
     * Helper method
     * pre: check snake condition
     * post: stop game if collision detected
     */
    private void stopTheGame() {
        System.out.println("\nEntity collision detected");
        while (true) {
            pauseGame();
        }
    }

    /**
     * Helper method
     * pre: none
     * post: assign consumable food in position
     * @param foodPositionIn
     */
    private void spawnFood(GridPanel foodPositionIn) {
        squares.get(foodPositionIn.x).get(foodPositionIn.y).changeColor(1);
    }

    /**
     * Accessor method
     * pre: assign random consumable spawn postiion
     * post: return position not occupied by snake
     * @return
     */
    private GridPanel getOpenArea() {
        GridPanel p;
        int ranX = 0 + (int) (Math.random() * 19);
        int ranY = 0 + (int) (Math.random() * 19);
        p = new GridPanel(ranX, ranY);
        for (int i = 0; i <= positions.size() - 1; i++) {
            if (p.getY() == positions.get(i).getX() && p.getX() == positions.get(i).getY()) {
                ranX = 0 + (int) (Math.random() * 19);
                ranY = 0 + (int) (Math.random() * 19);
                p = new GridPanel(ranX, ranY);
                i = 0;
            }
        }
        return p;
    }

    /**
     * Modifier method
     * pre: check snake position and direction
     * post: move snake position based on ArrayList
     * @param dir
     */
    private void moveInternal(int dir) {
        switch (dir) {
            case 4: // moving down
                headSnakePos.setPosition(headSnakePos.x, (headSnakePos.y + 1) % 20);
                positions.add(new GridPanel(headSnakePos.x, headSnakePos.y));
                break;
            case 3: // moving up
                if (headSnakePos.y - 1 < 0) {
                    headSnakePos.setPosition(headSnakePos.x, 19);
                } else {
                    headSnakePos.setPosition(headSnakePos.x, Math.abs(headSnakePos.y - 1) % 20);
                }
                positions.add(new GridPanel(headSnakePos.x, headSnakePos.y));
                break;
            case 2: // moving left
                if (headSnakePos.x - 1 < 0) {
                    headSnakePos.setPosition(19, headSnakePos.y);
                } else {
                    headSnakePos.setPosition(Math.abs(headSnakePos.x - 1) % 20, headSnakePos.y);
                }
                positions.add(new GridPanel(headSnakePos.x, headSnakePos.y));
                break;
            case 1: // moving right
                headSnakePos.setPosition(Math.abs(headSnakePos.x + 1) % 20, headSnakePos.y);
                positions.add(new GridPanel(headSnakePos.x, headSnakePos.y));
                break;
        }
    }

    /**
     * Modifier method
     * pre: get all positions of panel
     * post: refresh squares used by consumables and snake
     */
    private void moveExternal() {
        for (GridPanel t : positions) {
            int y = t.getX();
            int x = t.getY();
            squares.get(x).get(y).changeColor(0);
        }
    }

    /**
     * Modifier method
     * pre: none
     * post: refresh snake tail by removing ArrayList data
     * source/credit: https://www.geeksforgeeks.org/remove-element-arraylist-java/
     */
    private void deleteTail() {
        int tail = snakeSize;
        for (int i = positions.size() - 1; i >= 0; i--) {
            if (tail == 0) {
                GridPanel t = positions.get(i);
                squares.get(t.y).get(t.x).changeColor(2);
            } else {
                tail--;
            }
        }
        tail = snakeSize;
        for (int i = positions.size() - 1; i >= 0; i--) {
            if (tail == 0) {
                positions.remove(i);
            } else {
                tail--;
            }
        }
    }

    /**
     * Accessor method
     * pre: none
     * post: score returned
     * @param snakeScore
     * @return
     */
    public int getScore(int snakeScore) {
        this.score = snakeScore;
        return snakeScore;
    }
}
