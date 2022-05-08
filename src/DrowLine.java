import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrowLine extends JPanel implements ActionListener {

    private PointConverter pointConverter;

    public void paint(Graphics g){
        g.setColor(Color.WHITE);
        g.fillRect(0,0,WIDTH, HEIGHT);
        g.setColor(Color.BLACK);
        pointConverter.paint(g);
        repaint();
    }

    public void setPointConverter(PointConverter pointConverter) {
        this.pointConverter = pointConverter;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
