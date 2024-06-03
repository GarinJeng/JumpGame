import java.awt.*;

public class Grapple {
    private Point target;
    private Rectangle player;
    public Grapple(Point t, Rectangle p){
        target = t;
        player = p;
    }
    public int dX(){
        return (int) (target.getX() - (player.getWidth()/2) - player.getX());
    }
    public int dY(){
        return (int)(target.getY() - (player.getHeight()/2) - player.getY());
    }
    public void refresh (Point t, Rectangle p) {
        target = t;
        player = p;
    }
    public boolean checkValid (GrappleBlocks g){
        boolean c = true;
        if (!g.getFloor().contains(target)){
            c = false;
        }
        return c;
    }
}
