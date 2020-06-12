package game.snake.main.game;

public class GridPanel {


    public int x;
    public int y;
    public int xf;
    public int yf;

    /**
     * Constructor
     * @param x
     * @param y
     */
    public GridPanel(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Accessor methods
     * pre: none
     * post: returns x and y and floating coordinate
     * @param x
     * @param y
     */
    public void getPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getXf() {
        return xf;
    }

    public int getYf() {
        return yf;
    }
}
