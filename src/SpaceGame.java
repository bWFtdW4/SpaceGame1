import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class SpaceGame extends JPanel implements ActionListener {


    private Image spaceShip;
    private int spaceWidth, spaceHeight;
    private int shipWidth = 100, shipHeight = 60;
    private int shipX, shipY;
    private int speed = 10;
    private boolean isLeftPressed, isRightPressed, isUpPressed, isDownPressed;
    private int delay = 40;
    private Timer timer = new Timer(delay, this);
    private int newStarCounter = 0;
    private Color starColor = Color.RED;
    private int starWidth = 15, starHeight = 15;
    private int starX, starY;

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

        fly();

        // Start the timer
        timer.start();

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the spaceship with the image, x, y, width, and height
        g.drawImage(spaceShip, shipX, shipY, shipWidth, shipHeight, this);

        g.setColor(starColor);
        g.fillOval(starX, starY, starWidth, starHeight);

    }

    private void fly() {

        //add a key listener to the panel + override the key listener methods + set the pressedkey booleans
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);

                int action = e.getKeyCode();
                switch (action) {
                    case KeyEvent.VK_RIGHT:
                        isRightPressed = true;
                        break;
                    case KeyEvent.VK_LEFT:
                        isLeftPressed = true;
                        break;
                    case KeyEvent.VK_UP:
                        isUpPressed = true;
                        break;
                    case KeyEvent.VK_DOWN:
                        isDownPressed = true;
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);

                int action = e.getKeyCode();
                switch (action) {
                    case KeyEvent.VK_RIGHT:
                        isRightPressed = false;
                        break;
                    case KeyEvent.VK_LEFT:
                        isLeftPressed = false;
                        break;
                    case KeyEvent.VK_UP:
                        isUpPressed = false;
                        break;
                    case KeyEvent.VK_DOWN:
                        isDownPressed = false;
                        break;
                }
            }


        });
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        //drawRandomStar();

        newStarCounter -= 1;

        if (newStarCounter < 0){

            // Create a random star
            Random randomStar = new Random();
            starX = randomStar.nextInt(spaceWidth - starWidth);
            starY = randomStar.nextInt(spaceHeight - starHeight);

            repaint();
            newStarCounter = 100;
        }

        timerUpdate();


    }

    private void timerUpdate() {

        if(isLeftPressed){
            shipX -= speed;
        }
        if(isRightPressed){
            shipX += speed;
        }
        if(isUpPressed){
            shipY -= speed;
        }
        if(isDownPressed){
            shipY += speed;
        }

        // Check if the ship is out of bounds and reset
        if (shipX > spaceWidth) {
            shipX = -shipWidth;
        }
        if (shipY > spaceHeight){
            shipY = -shipHeight;
        }
        if (shipX < -shipWidth){
            shipX = spaceWidth;
        }
        if (shipY < -shipHeight){
            shipY = spaceHeight;
        }
        //System.out.println("X: " + shipX + " Y: " + shipY);

        repaint();






    }

    private void drawRandomStar() {

        Random random = new Random();
        // Generate a random number between shipX and shipWidth
        int x = random.nextInt(shipWidth) + shipX;
        System.out.println("random X: " + x);
        int y = random.nextInt(shipHeight) + shipY;
        System.out.println("random Y: " + y);
        starY = y;
        starX = x;

    }

}
