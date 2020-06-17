package game.snake.main.game.Panel;

public class GridPanel {


    public int x;
    public int y;

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
    public void setPosition(int x, int y) {
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
