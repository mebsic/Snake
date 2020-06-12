package game.snake.main.game;

import java.awt.Color;
import javax.swing.JPanel;

public class SquarePanel extends JPanel {


    private static final long serialVersionUID = 1L;  // default serial version ID

    /**
     * Constructor
     * pre: none
     * post: change background of game panel
     * @param d
     */
    public SquarePanel(Color d) {
        this.setBackground(d);
    }

    /**
     * Modifier method
     * pre: none
     * post: repaints background to specific color
     * @param d
     */
    public void changeColor(Color d) {
        this.setBackground(d);
        this.repaint();
    }
}
