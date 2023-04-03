import java.awt.*;
import java.awt.event.MouseEvent;

public class Ball {
    private int size;
    private int xPosition;
    private int yPosition;
    private int xSpeed;
    private Color color;
    private String direction = "right";

    public Ball(int size, int xPosition, int yPosition, int xSpeed , Color color) {
        this.size = size;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.xSpeed = xSpeed;
        this.color = color;
    }

    public void drawBall(Graphics g) {
        g.setColor(this.color);
        g.fillOval(xPosition, yPosition, size, size);

    }

    public void moveBall(String direction) {
        if(direction.equals("right")) {
            this.xPosition = this.xPosition + this.xSpeed;
        } else {
            this.xPosition = this.xPosition - this.xSpeed;
        }
    }

    public void changeDirection() {
        if(direction.equals( "right")) {
            direction = "left";
        } else {
            direction = "right";
        }
        moveBall(direction);
    }

    public int getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(int xSpeed) {
        this.xSpeed = xSpeed;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection() {
        this.direction = direction;
    }

    public int getSize() {
        return size;
    }

    public int getxPosition() {
        return xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }
}
