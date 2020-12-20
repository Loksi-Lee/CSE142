// Yazzy Latif
// 07/10/2019
// CSE142
// TA: Grace Hopper
// To Days lecture example

// This program animates a ball moving at a particular angle and with
// a particular velocity.
import java.awt.*;

public class Ball {
    public static void main(String[] args) {
        double velocity = 38.4;  // pixels per second
        double angle = 45.0;
        int seconds = 15;
        
        double xVelocity = velocity * Math.cos(Math.toRadians(angle));
        
        // yVelocity is negative b/c on the DrawingPanel
        // as we move down in the DrawingPanel the y-coordinate
        // gets larger. If we want it to move towards the top right
        // we need to flip the sign of the velocity so y
        // gets smaller
        double yVelocity = -velocity * Math.sin(Math.toRadians(angle));
                
        DrawingPanel panel = new DrawingPanel(600, 600);
        panel.setBackground(Color.CYAN);
        Graphics g = panel.getGraphics();
                
        // draw initial ball
        // we want the center of the ball to be at 300, 300 we need
        // to subtract 5 from x and y since fillOval is relative to
        // the top right corner of the box that encapsulate the oval
        g.fillOval(295, 295, 10, 10);
        panel.sleep(1000);

        double x = 300.0;
        double y = 300.0;
        for (int i = 1; i <= 10 * seconds; i++) {
            // Draw a white ball over previous black ball location
            // to create a trajectory line
            g.setColor(Color.WHITE);
            g.fillOval((int) x - 5, (int) y - 5, 10, 10);

            // draw next frame
            x = x + xVelocity / 10.0;
            y = y + yVelocity / 10.0;
            // x = 715.325
            g.setColor(Color.BLACK);
            g.fillOval((int) x - 5, (int) y - 5, 10, 10);
            panel.sleep(100);
        }
    }
}
