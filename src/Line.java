import java.awt.*;

import static java.lang.Math.*;

public class Line {

    private MyPoint a;
    private MyPoint b;
    private static double step = 0.5;
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;

    public Line(MyPoint a, MyPoint b){
        this.a = a;
        this.b = b;
    }

    public void paint(Graphics g, int xAngle, int yAngle) {
        double aX, aY, bX, bY;
        double xTan = tan(Math.toRadians(xAngle / 2.0));
        double yTan = tan(Math.toRadians(yAngle / 2.0));

        if (a.getZ() > 0 && b.getZ() > 0) {
            aX = ((WIDTH/2) * a.getX()) / (a.getZ() * xTan);
            aY = ((WIDTH/2) * a.getY()) / (a.getZ() * yTan);
            bX = ((WIDTH/2) * b.getX()) / (b.getZ() * xTan);
            bY = ((WIDTH/2) * b.getY()) / (b.getZ() * yTan);
        } else if (a.getZ() > 0 || b.getZ() > 0) {
            if (a.getZ() > 0) {
                if (pointInSight(a, xAngle, yAngle)) {
                    aX = ((WIDTH/2) * a.getX()) / (a.getZ() * xTan);
                    aY = ((WIDTH/2) * a.getY()) / (a.getZ() * yTan);
                    bX = ((WIDTH/2) * b.getX()) / xTan;
                    bY = ((WIDTH/2) * b.getY()) / yTan;
                } else {
                    return;
                }
            } else {
                if (pointInSight(b, xAngle, yAngle)) {
                    aX = ((WIDTH/2) * a.getX()) / (1 * xTan);
                    aY = ((WIDTH/2) * a.getY()) / (1 * yTan);
                    bX = ((WIDTH/2) * b.getX()) / (b.getZ() * xTan);
                    bY = ((WIDTH/2) * b.getY()) / (b.getZ() * yTan);
                } else {
                    return;
                }
            }
        } else {
            return;
        }
        g.drawLine((int) aX + (WIDTH/2), (int) -aY + (HEIGHT/2), (int) bX + (WIDTH/2), (int) -bY + (HEIGHT/2));
    }

    private boolean pointInSight(MyPoint a, int xAngle, int yAngle) {
        boolean xInView = tan(Math.abs(a.getX()) / a.getZ()) < xAngle / 2.;
        boolean yInView = tan(Math.abs(a.getY()) / a.getZ()) < yAngle / 2.;
        return xInView && yInView;
    }

    public void moveDown() {
        a.setY(a.getY() - Math.toRadians(0.5));
        b.setY(b.getY() - Math.toRadians(0.5));
    }

    public void moveUp() {
        a.setY(a.getY() + Math.toRadians(0.5));
        b.setY(b.getY() + Math.toRadians(0.5));
    }

    public void moveRight() {
        a.setX(a.getX() + Math.toRadians(0.5));
        b.setX(b.getX() + Math.toRadians(0.5));
    }

    public void moveLeft() {
        a.setX(a.getX() - Math.toRadians(0.5));
        b.setX(b.getX() - Math.toRadians(0.5));
    }

    public void rotateLeftZ() {
        rotateZ(a, Math.toRadians(0.5));
        rotateZ(b, Math.toRadians(0.5));
    }

    public void rotateRightZ() {
        rotateZ(a, -Math.toRadians(0.5));
        rotateZ(b, -Math.toRadians(0.5));
    }

    private void rotateZ(MyPoint myPoint, double rotateAngle) {
        double oldX = myPoint.getX();
        double oldY = myPoint.getY();
        myPoint.setX((float) (oldX * cos(rotateAngle) - oldY * sin(rotateAngle)));
        myPoint.setY((float) (oldX * sin(rotateAngle) + oldY * cos(rotateAngle)));
    }

    public void rotateLeftY() {
        rotateY(a, Math.toRadians(0.5));
        rotateY(b, Math.toRadians(0.5));
    }

    public void rotateRightY() {
        rotateY(a, -Math.toRadians(0.5));
        rotateY(b, -Math.toRadians(0.5));
    }

    private void rotateY(MyPoint myPoint, double rotateAngle) {
        double oldX = myPoint.getX();
        double oldZ = myPoint.getZ();
        myPoint.setX((float) (oldX * cos(rotateAngle) - oldZ * sin(rotateAngle)));
        myPoint.setZ((float) (oldX * sin(rotateAngle) + oldZ * cos(rotateAngle)));
    }

    public void rotateUpX() {
        rotateX(a, -Math.toRadians(0.5));
        rotateX(b, -Math.toRadians(0.5));
    }

    public void rotateDownX() {
        rotateX(a, Math.toRadians(0.5));
        rotateX(b, Math.toRadians(0.5));
    }

    private void rotateX(MyPoint myPoint, double rotateAngle) {
        double oldY = myPoint.getY();
        double oldZ = myPoint.getZ();
        myPoint.setY((float) (oldY * cos(rotateAngle) - oldZ * sin(rotateAngle)));
        myPoint.setZ((float) (oldY * sin(rotateAngle) + oldZ * cos(rotateAngle)));
    }

    public void moveBackward() {
        a.setZ(a.getZ() - step);
        b.setZ(b.getZ() - step);
    }

    public void moveForward() {
        a.setZ(a.getZ() + step);
        b.setZ(b.getZ() + step);
    }



}
