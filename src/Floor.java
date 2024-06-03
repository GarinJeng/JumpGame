import java.awt.*;

public class Floor {
    public Rectangle f = new Rectangle();

    public Floor (int x,int y,int w,int h){
        f.setBounds(x,y,w,h);
    }
    public Rectangle getFloor(){
        return f;
    }
    public String findEdge(Steve s){
       Rectangle r =  s.getRectangle();
       String out = "";
       int d = 0;
       d = (int) (r.getX() - f.getX() - f.getWidth());
       out = "R";
       if (Math.abs((int)(f.getX() - r.getX() - r.getWidth()))<Math.abs(d)){
           d = (int)(f.getX() - r.getX() - r.getWidth());
           out = "L";
       }
       if (Math.abs((int)(f.getY() - r.getY() - r.getHeight()))<Math.abs(d)){
           d = (int)(f.getY() - r.getY() - r.getHeight());
           out = "D";
       }
       if (Math.abs((int)(r.getY() - f.getY() - f.getHeight()))<Math.abs(d)){
           d = (int)(r.getY() - f.getY() - f.getHeight());
           out = "U";
       }
        out += d;
        return out;
    }

    public String findE(Steve s){
        String out = "";
        int d = 1000;
        Rectangle r =  s.getRectangle();
        //d = (int) (r.getX() - f.getX() - f.getWidth());
        //out = "R";
        int mY = s.getMomentumY();
        int mX = 0;
        if(s.isMovingDown()){
            mY+=5;
        }
        if(s.isMovingUp()){
            mY-=5;
        }
        if(s.isMovingLeft()){
            mX-=5;
        }
        if(s.isMovingRight()){
            mX+=5;
        }
        if (Math.abs((int)((f.getX() + f.getWidth()) - r.getX()))<=Math.abs(mX)&&Math.abs((int)(f.getX() - r.getX() - r.getWidth()))<Math.abs(d)){
            d = (int)(f.getX() - r.getX() - r.getWidth());
            out = "L";
        }
        if(Math.abs((int)(f.getY() - (r.getY() + r.getHeight())))<=Math.abs(mY)&&Math.abs((int)(f.getY() - r.getY() - r.getHeight()))<Math.abs(d)){
            out = "D";
            d = (int)(f.getY() - r.getY() - r.getHeight());
        }
        System.out.println((f.getY() - (r.getY() + r.getHeight())));
        System.out.println(Math.abs(mY));
        if(Math.abs((int)(r.getY() - (f.getY() + f.getHeight())))<=Math.abs(mY)&&Math.abs((int)(r.getY() - f.getY() - f.getHeight()))<Math.abs(d)){
            out = "U";
            d = (int)(r.getY() - f.getY() - f.getHeight());
        }
        if(Math.abs((int)((r.getX() + r.getWidth()) - f.getX()))<=Math.abs(mX)&&Math.abs((int) (r.getX() - f.getX() - f.getWidth()))<Math.abs(d)) {
            d = (int) (r.getX() - f.getX() - f.getWidth());
            out = "R";
        }
        out += d;
        System.out.println(out);
        return out;
    }
    public String findEd(Steve s) {
        String in = findEdge(s);
        String out = "";
        int mY = s.getMomentumY();
        int mX = 0;
        if(s.isMovingDown()){
            mY+=10;
        }
        if(s.isMovingUp()){
            mY-=5;
        }
        if(s.isMovingLeft()){
            mX-=5;
        }
        if(s.isMovingRight()){
            mX+=5;
        }
        Rectangle r = s.getRectangle();
        //System.out.println(in +", "+ mY);
        if (Math.abs((int)(f.getY() - r.getY() - r.getHeight())) <= mY*3){
            out = "D" + (int)(f.getY() - r.getY() - r.getHeight());
        }else{
            out = in;
        }


        return out;
    }
}
