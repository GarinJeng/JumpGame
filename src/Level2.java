import java.util.ArrayList;

public class Level2 extends Level{
    private ArrayList<Floor> F = new ArrayList<>();
    private ArrayList<GrappleBlocks> G = new ArrayList<>();
    private ArrayList<DeathBarrier> D = new ArrayList<>();
    public Level2(int x, int y){
        super(x,y);
        F.add(new Floor(998 + x, -1000 + y, 1000, 2616));
        F.add(new Floor(-1008 + x, -1008 + y, 1010, 2616));
        F.add(new Floor(-8 + x, -1008 + y, 1016, 1010));
        F.add(new Floor(-108 + x, 598 + y, 258, 1000));
        F.add(new Floor(600+x, 598 + y, 100, 1000));
        D.add(new DeathBarrier(700+x,650+y,298,1000));
        D.add(new DeathBarrier(150+x,650+y,450,1000));
        G.add(new GrappleBlocks(988+x,400+y,10,20));
        setE(new End(620+x, 588+y, 60, 10));
        setFloors(F);
        setDB(D);
        setGB(G);
    }
}
