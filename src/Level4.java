import java.util.ArrayList;

public class Level4 extends Level{
    private ArrayList<Floor> F = new ArrayList<>();
    private ArrayList<GrappleBlocks> G = new ArrayList<>();
    private ArrayList<DeathBarrier> D = new ArrayList<>();
    public Level4(int x, int y){
        super(x,y);
        F.add(new Floor(998 + x, -1000 + y, 1000, 2616));
        F.add(new Floor(-1008 + x, -1008 + y, 1010, 2616));
        F.add(new Floor(-8 + x, -1008 + y, 1016, 1010));
        F.add(new Floor(-108 + x, 598 + y, 258, 1000));
        F.add(new Floor(300+x,30+y,80,2000));
        F.add(new Floor(150+x,-100+y,80,500));
        F.add(new Floor(280+x,500+y,30,10));
        F.add(new Floor(150+x,400+y, 100,10));
        F.add(new Floor(280+x,300+y,30,10));
        F.add(new Floor(150+x,200+y, 100,10));
        F.add(new Floor(280+x,100+y,30,10));
        F.add(new Floor(300+x,30+y, 500,20));
        D.add(new DeathBarrier(380+x, 650+y, 618,1000));
        D.add(new DeathBarrier(150+x, 650+y, 150,1000));
        setE(new End(938+x,100+y,60,400));
        setFloors(F);
        setDB(D);
        setGB(G);
    }
}
