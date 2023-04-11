import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.*;

public class DrawingPanel extends JPanel {	//This JPanel will serve as our drawing board, our canvas.

    //Declare a timer, used to move the car
    //Set to fire every 1/10th of a second, since the delay parameter is in milliseconds
    private Timer timer = new Timer(50,  new TimerAction());
    private Ball ball;

    //Constructor
    public DrawingPanel() {


        ball = new Ball(30, 500, 300, 10, Color.BLUE );
        timer.start();

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //When mouse is clicked on panel, call our start/stop timer method
                System.out.println(e.getLocationOnScreen());
                System.out.println(e.getX());
                System.out.println(e.getY());
                System.out.println(ball.getxPosition());
                System.out.println(ball.getyPosition());
                if(ball.getxPosition() - e.getX() <= 30 && ball.getyPosition() - e.getY() <= 30) {
                    ball.changeDirection();
                }
            }
        });
    }

    //A private class we declared for use with the Timer object. A Timer's constructor needs an ActionListener, so
    //we made one for our own use. Since it implements ActionListener, it IS an ActionListener.
    private class TimerAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //Whenever the timer fires a tick event, this method is called, which in turn calls our "drive" method.
            ball.moveBall(ball.getDirection());
            checkForWallHit(ball);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);	//Tell the parent JPanel to repaint ie redraw
        //Avoids a couple of potential issues

        //Draw each vehicle from the array on panel
            ball.drawBall(g);
            this.repaint();

        //myCar.drawVehicle(g);		//Original code, when we only had one car
    }

    public void checkForWallHit(Ball ball) {
        //What if it hits the edge of window?
        //Compare current position of car to current panel width (ie. the "furthest right" x position of window
        //Note that we add the car's width to get the car's right edge.
        if ((ball.getxPosition() + ball.getSize()/2) >= this.getWidth() || ball.getxPosition() < 0) {
            //Multiply by -1 to reverse the direction
            JOptionPane.showMessageDialog(null, "Game Over");
            timer.stop();
        }
    }
}
