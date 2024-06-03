import java.util.ArrayList;

public class Level3 extends Level{
    private ArrayList<Floor> F = new ArrayList<>();
    private ArrayList<GrappleBlocks> G = new ArrayList<>();
    private ArrayList<DeathBarrier> D = new ArrayList<>();
    public Level3(int x, int y){
        super(x,y);
        F.add(new Floor(998 + x, -1000 + y, 1000, 2616));
        F.add(new Floor(-1008 + x, -1008 + y, 1010, 2616));
        F.add(new Floor(-8 + x, -1008 + y, 1016, 1010));
        F.add(new Floor(-108 + x, 598 + y, 240, 1000));
        F.add(new Floor(187 + x, 598 + y, 20, 10));
        F.add(new Floor(267 + x, 598 + y, 20, 10));
        F.add(new Floor(347 + x, 598 + y, 20, 10));
        F.add(new Floor(427 + x, 598 + y, 20, 10));
        F.add(new Floor(507 + x, 598 + y, 20, 10));
        F.add(new Floor(587 + x, 598 + y, 20, 10));
        F.add(new Floor(667 + x, 598 + y, 20, 10));
        F.add(new Floor(747 + x, 598 + y, 20, 10));
        F.add(new Floor(827 + x, 598 + y, 20, 10));
        F.add(new Floor(907 + x, 598 + y, 20, 10));
        F.add(new Floor(987 + x, 598 + y, 20, 10));
        D.add(new DeathBarrier(132 + x,650 + y, 866,1000));
        setE(new End(938+x,500+y,30,30));
        setFloors(F);
        setDB(D);
        setGB(G);
    }
}
