package game.snake.main.game;

import game.snake.launcher.GameLauncher;
import game.snake.main.Main;
import game.snake.main.Window;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Game logic using Threads
 */
public class ThreadControl extends Thread {


    ArrayList<ArrayList<EntityRenderData>> squares = new ArrayList<ArrayList<EntityRenderData>>();
    GridPanel headSnakePos;
    int sizeSnake = 3; // default rendered snake size
    long speed = 70; // default snake speed
    public static int directionSnake;
    ArrayList<GridPanel> positions = new ArrayList<GridPanel>();
    GridPanel foodPosition;
    public int score; // default game score

    /**
     * Constructor
     * pre: check snake direction
     * post: assign position and spawn consumable food
     * @param positionDepart
     */
    public ThreadControl(GridPanel positionDepart) {
        squares = Window.Grid;
        headSnakePos = new GridPanel(positionDepart.x, positionDepart.y);
        directionSnake = 1;
        // direction of snake (pointer)
        GridPanel headPos = new GridPanel(headSnakePos.getX(), headSnakePos.getY());
        positions.add(headPos);
        foodPosition = new GridPanel(Window.height - 1, Window.width - 1);
        spawnFood(foodPosition);
    }

    /**
     * Helper method
     * pre: check game condition
     * post: run game methods
     */
    public void run() {
        while (true) {
            moveInternal(directionSnake);
            try {
                checkCollision();
            } catch (IOException e) {
                e.printStackTrace();
            }
            moveExternal();
            deleteTail();
            pause();
            this.score = 0;
        }
    }

    /**
     * Helper method
     * pre: none
     * post: delay snake movement
     */
    private void pause() {
        try {
            sleep(speed);
        } catch (InterruptedException e) {
            e.printStackTrace();
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
        return score;
    }

    /**
     * Modifier method
     * pre: none
     * post: none
     * @param snakeScore
     */
    public void setScore(int snakeScore) {
        this.score = snakeScore;
        snakeScore += 1;
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
                JOptionPane.showMessageDialog(null, "Game Over...\nTry again!","Snake", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
                stopTheGame();
            }
        }
        boolean eatingFood = criticalPosition.getX() == foodPosition.y && criticalPosition.getY() == foodPosition.x;
        if (eatingFood) {
            System.out.print("\nEntity consumed food");
            sizeSnake = sizeSnake + 1;
            setScore(score);
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
            pause();
            setScore(0);
        }
    }

    /**
     * Helper method
     * pre: none
     * post: assign consumable food in position
     * @param foodPositionIn
     */
    private void spawnFood(GridPanel foodPositionIn) {
        squares.get(foodPositionIn.x).get(foodPositionIn.y).colorOrganizer(1);
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
                headSnakePos.setPostion(headSnakePos.x, (headSnakePos.y + 1) % 20);
                positions.add(new GridPanel(headSnakePos.x, headSnakePos.y));
                break;
            case 3: // moving up
                if (headSnakePos.y - 1 < 0) {
                    headSnakePos.setPostion(headSnakePos.x, 19);
                } else {
                    headSnakePos.setPostion(headSnakePos.x, Math.abs(headSnakePos.y - 1) % 20);
                }
                positions.add(new GridPanel(headSnakePos.x, headSnakePos.y));
                break;
            case 2: // moving left
                if (headSnakePos.x - 1 < 0) {
                    headSnakePos.setPostion(19, headSnakePos.y);
                } else {
                    headSnakePos.setPostion(Math.abs(headSnakePos.x - 1) % 20, headSnakePos.y);
                }
                positions.add(new GridPanel(headSnakePos.x, headSnakePos.y));

                break;
            case 1: // moving right
                headSnakePos.setPostion(Math.abs(headSnakePos.x + 1) % 20, headSnakePos.y);
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
            squares.get(x).get(y).colorOrganizer(0);
        }
    }

    /**
     * Modifier method
     * pre: none
     * post: refresh snake tail by removing ArrayList data
     * source/credit: https://www.geeksforgeeks.org/remove-element-arraylist-java/
     */
    private void deleteTail() {
        int tail = sizeSnake;
        for (int i = positions.size() - 1; i >= 0; i--) {
            if (tail == 0) {
                GridPanel t = positions.get(i);
                squares.get(t.y).get(t.x).colorOrganizer(2);
            } else {
                tail--;
            }
        }
        tail = sizeSnake;
        for (int i = positions.size() - 1; i >= 0; i--) {
            if (tail == 0) {
                positions.remove(i);
            } else {
                tail--;
            }
        }
    }
}
