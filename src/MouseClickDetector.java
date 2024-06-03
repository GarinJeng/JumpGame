import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;

public class MouseClickDetector extends MouseAdapter {
    private Point lastClickedPoint;
    @Override
    public void mousePressed(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        lastClickedPoint = new Point(x, y);
    }
    @Override
    public void mouseReleased(MouseEvent e){
        lastClickedPoint = null;


    }
    public Point getLastClickedPoint() {
        return lastClickedPoint;
    }
    public void reSetPoint(){
        lastClickedPoint = null;
    }
}