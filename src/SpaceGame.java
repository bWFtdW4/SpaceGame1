import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class SpaceGame extends JPanel implements ActionListener {


    private Image spaceShip;
    private int spaceWidth, spaceHeight;
    private int shipWidth = 100, shipHeight = 60;
    private int shipX, shipY;
    public SpaceGame(Image i, int w, int h) {

        spaceWidth = w;
        spaceHeight = h;
        spaceShip = i;
        shipX = 30;
        shipY = 30;
        setBackground(Color.black);

        //Set focus to the panel
        requestFocusInWindow();

        // Set panel to be focusable rather than the JFrame
        setFocusable(true);


    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the spaceship with the image, x, y, width, and height
        g.drawImage(spaceShip, shipX, shipY, shipWidth, shipHeight, this);

        g.setColor(Color.YELLOW);
        g.fillOval(70, 70, 100, 100);

        g.setColor(Color.RED);
        g.fillOval(600, 500, 100, 100);

        g.setColor(Color.WHITE);
        g.drawString("Points", 5,15);

        g.setColor(Color.GREEN);
        g.fillRect(300, 300, 100, 100);

        g.setColor(Color.WHITE);
        //g.fillPolygon(int[], int[], int);
        int[] x = {100, 200, 300, 100, 300, 145};
        int[] y = {100, 200, 300, 100, 150, 234 };
        g.fillPolygon(x, y, 4);

    }

    @Override
    public void actionPerformed(ActionEvent e) {



    }
}
