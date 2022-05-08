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
                pointConverter.linesBackward();
                break;
            case KeyEvent.VK_DOWN:
                pointConverter.linesForward();
                break;
            case KeyEvent.VK_RIGHT:
                pointConverter.linesLeft();
                break;
            case KeyEvent.VK_LEFT:
                pointConverter.linesRight();
                break;
            case KeyEvent.VK_U:
                pointConverter.linesDown();
                break;
            case KeyEvent.VK_D:
                pointConverter.linesUp();
                break;
            case KeyEvent.VK_I:
                pointConverter.zoomIn();
                break;
            case KeyEvent.VK_O:
                pointConverter.zoomOut();
                break;
            case KeyEvent.VK_N:
                pointConverter.turnRightZ();
                break;
            case KeyEvent.VK_M:
                pointConverter.turnLeftZ();
                break;
            case KeyEvent.VK_R:
                pointConverter.turnLeftY();
                break;
            case KeyEvent.VK_L:
                pointConverter.turnRightY();
                break;
            case KeyEvent.VK_F:
                pointConverter.turnUpX();
                break;
            case KeyEvent.VK_B:
                pointConverter.turnDownX();
                break;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
