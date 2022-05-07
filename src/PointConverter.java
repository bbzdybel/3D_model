import java.awt.*;

public class PointConverter {
    public static Point convertPoint(MyPoint point3D){
        int x2d= (int)(Display.WIDTH / 2 + point3D.y);
        int y2d= (int)(Display.HEIGHT /2 - point3D.z);

        Point point2d = new Point(x2d, y2d);
        return point2d;
    }
}
