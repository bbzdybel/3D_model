import java.awt.*;

public class MyPoligon {
    private MyPoint[] points;

    public MyPoligon(MyPoint... points){
        this.points = new MyPoint[points.length];
        for(int i =0; i < points.length; i++){
            MyPoint p = points[i];
            this.points[i] = new MyPoint(p.x, p.y, p.z);
        }
    }

    public void render(Graphics g){
        Polygon poly = new Polygon();
        for (int i = 0; i < points.length; i++) {
            Point p = PointConverter.convertPoint(points[i]);
            poly.addPoint(p.x,p.y);
        }
        g.setColor(Color.BLACK);
        g.fillPolygon(poly);
    }
}
