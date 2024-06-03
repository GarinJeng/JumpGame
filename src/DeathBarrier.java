import java.awt.*;

public class DeathBarrier {
    public Rectangle D;
    public DeathBarrier(int x, int y, int w, int h){
        D = new Rectangle(x,y,w,h);
    }
    public Rectangle GetDB(){
        return D;
    }
}
