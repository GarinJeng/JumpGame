import java.util.ArrayList;

public class Level5 extends Level{
    private ArrayList<Floor> F = new ArrayList<>();
    private ArrayList<GrappleBlocks> G = new ArrayList<>();
    private ArrayList<DeathBarrier> D = new ArrayList<>();
    public Level5(int x, int y){
        super(x,y);
        F.add(new Floor(998 + x, -1000 + y, 1000, 2616));
        F.add(new Floor(-108 + x, 598 + y, 600, 1000));
        F.add(new Floor(700 + x, 490 + y, 1000, 1000));
        F.add(new Floor(-8 + x, -1008 + y, 1016, 1010));
        F.add(new Floor(-1008 + x, -1008 + y, 1010, 2616));
        setE(new End(900 + x,450 + y,30,30));
        D.add(new DeathBarrier(492+x,650+y,208,1000));
        setFloors(F);
        setDB(D);
        setGB(G);
    }
}
