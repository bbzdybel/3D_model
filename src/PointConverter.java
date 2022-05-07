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
}
