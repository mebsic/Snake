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
     * Modifier method
     * pre: change x and y positions
     * post: returns x and y and floating coordinate
     * @param x
     * @param y
     */
    public void setPostion(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
