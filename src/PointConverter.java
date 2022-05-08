import java.awt.*;
import java.util.ArrayList;

public class PointConverter extends MyPoint{
    private ArrayList<Line> lines;
    private int xPosition = 100;
    private int yPosition = 100;

    public PointConverter(double x, double y, double z, ArrayList<Line> lines){
        super(x,y,z);
        this.lines = lines;
    }

    public void paint(Graphics g){
        for (Line line : lines) {
            line.paint(g, xPosition, yPosition);
        }
    }

    public void linesDown() {
        for (Line line : lines) {
            line.moveDown();
        }
    }

    public void linesUp() {
        for (Line line : lines) {
            line.moveUp();
        }
    }

    public void linesRight() {
        for (Line line : lines) {
            line.moveRight();
        }
    }

    public void linesLeft() {
        for (Line line : lines) {
            line.moveLeft();
        }
    }

    public void zoomOut() {
        if (xPosition < 150 && yPosition < 150) {
            xPosition += 2;
            yPosition += 2;
        }
    }

    public void zoomIn() {
        if (xPosition > 20 && yPosition > 20) {
            xPosition -= 2;
            yPosition -= 2;
        }
    }

    public void turnLeftZ() {
        for (Line line : lines) {
            line.rotateLeftZ();
        }
    }

    public void turnRightZ() {
        for (Line line : lines) {
            line.rotateRightZ();
        }
    }

    public void turnLeftY() {
        for (Line line : lines) {
            line.rotateLeftY();
        }
    }

    public void turnRightY() {
        for (Line line : lines) {
            line.rotateRightY();
        }
    }

    public void turnUpX() {
        for (Line line : lines) {
            line.rotateUpX();
        }
    }

    public void turnDownX() {
        for (Line line : lines) {
            line.rotateDownX();
        }
    }

    public void linesBackward() {
        for (Line line : lines) {
            line.moveBackward();
        }
    }

    public void linesForward() {
        for (Line line : lines) {
            line.moveForward();
        }
    }
}
