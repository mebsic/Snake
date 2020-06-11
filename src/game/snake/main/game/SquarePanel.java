package game.snake.main.game;

import java.awt.Color;
import javax.swing.JPanel;

public class SquarePanel extends JPanel {


    private static final long serialVersionUID = 1L;  // default serial version ID

    public SquarePanel(Color d) {
        this.setBackground(d);
    }

    public void ChangeColor(Color d) {
        this.setBackground(d);
        this.repaint();
    }
}
