import javax.swing.*;
import java.awt.*;

public class DrowLine extends JPanel {

    private PointConverter pointConverter;

    public void paint(Graphics g){
        pointConverter.paint(g);
        repaint();
    }
}
