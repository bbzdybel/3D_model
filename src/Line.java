import java.awt.*;

import static java.lang.Math.*;

public class Line {

    private MyPoint a;
    private MyPoint b;
    private static double step = 0.5;

    public Line(MyPoint a, MyPoint b){
        this.a = a;
        this.b = b;
    }

    public void paint(Graphics g, int xPosition, int yPosition){
        double aX, aY, bX, bY;
        double xTan = tan(Math.toRadians(xPosition / 2.0));
        double yTan = tan(Math.toRadians(yPosition / 2.0));

        if (a.getZ() > 0 && b.getZ() > 0) {
            aX = (500 * a.getX()) / (a.getZ() * xTan);
            aY = (500 * a.getY()) / (a.getZ() * yTan);
            bX = (500 * b.getX()) / (b.getZ() * xTan);
            bY = (500 * b.getY()) / (b.getZ() * yTan);
        } else if (a.getZ() > 0 || b.getZ() > 0) {
            if (a.getZ() > 0) {
                if (pointInSight(a, xPosition, yPosition)) {
                    aX = (500 * a.getX()) / (a.getZ() * xTan);
                    aY = (500 * a.getY()) / (a.getZ() * yTan);
                    bX = (500 * b.getX()) / xTan;
                    bY = (500 * b.getY()) / yTan;
                } else {
                    return;
                }
            } else {
                if (pointInSight(b, xPosition, yPosition)) {
                    aX = (500 * a.getX()) / (1 * xTan);
                    aY = (500 * a.getY()) / (1 * yTan);
                    bX = (500 * b.getX()) / (b.getZ() * xTan);
                    bY = (500 * b.getY()) / (b.getZ() * yTan);
                } else {
                    return;
                }
            }
        } else {
            return;
        }
        g.drawLine((int) aX + 500, (int) -aY + 350, (int) bX + 500, (int) -bY + 350);
    }

    private boolean pointInSight(MyPoint a, int xAngle, int yAngle) {
        boolean xInView = tan(Math.abs(a.getX()) / a.getZ()) < xAngle / 2.;
        boolean yInView = tan(Math.abs(a.getY()) / a.getZ()) < yAngle / 2.;
        return xInView && yInView;
    }



}
