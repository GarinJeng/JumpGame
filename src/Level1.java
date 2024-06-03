import java.util.ArrayList;

public class Level1 extends Level{
    private ArrayList<Floor> F = new ArrayList<>();
    private ArrayList<GrappleBlocks> G = new ArrayList<>();
    private ArrayList<DeathBarrier> D = new ArrayList<>();
    public Level1(int x, int y){
        super(x,y);
        F.add(new Floor(998 + x, -1000 + y, 1000, 2616));
        F.add(new Floor(-1008 + x, -1008 + y, 1010, 2616));
        F.add(new Floor(-8 + x, -1008 + y, 1016, 1010));
        F.add(new Floor(-108 + x, 598 + y, 508, 1000));
        F.add(new Floor(550+x, 598+y,558,1000));
        F.add(new Floor(460+x, -100+y,20,690));
        D.add(new DeathBarrier(400+x,650+y,150,1000));
        setE(new End(900+x,500+y,30,30));
        setFloors(F);
        setDB(D);
        setGB(G);
    }
}
