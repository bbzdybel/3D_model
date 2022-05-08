import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Rotate implements KeyListener {
    private PointConverter pointConverter;

    public Rotate(PointConverter pointConverter){
        this.pointConverter = pointConverter;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_UP:
                pointConverter.linesDown();
                break;
            case KeyEvent.VK_DOWN:
                pointConverter.linesUp();
                break;
            case KeyEvent.VK_RIGHT:
                pointConverter.linesLeft();
                break;
            case KeyEvent.VK_LEFT:
                pointConverter.linesRight();
                break;
            case KeyEvent.VK_W:
                pointConverter.zoomIn();
                break;
            case KeyEvent.VK_S:
                pointConverter.zoomOut();
                break;
            case KeyEvent.VK_1:
                pointConverter.turnUpX();
                break;
            case KeyEvent.VK_2:
                pointConverter.turnDownX();
                break;
            case KeyEvent.VK_3:
                pointConverter.turnLeftY();
                break;
            case KeyEvent.VK_4:
                pointConverter.turnRightY();
                break;
            case KeyEvent.VK_5:
                pointConverter.turnRightZ();
                break;
            case KeyEvent.VK_6:
                pointConverter.turnLeftZ();
                break;

        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
