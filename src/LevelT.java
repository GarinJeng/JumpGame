import java.util.ArrayList;

public class LevelT extends Level{
    private ArrayList<Floor> F = new ArrayList<>();
    private ArrayList<GrappleBlocks> G = new ArrayList<>();
    private ArrayList<DeathBarrier> D = new ArrayList<>();
    public LevelT(int x, int y){
        super(x,y);
        F.add(new Floor(998 + x, -1000 + y, 1000, 2616));
        F.add(new Floor(-1008 + x, -1008 + y, 1010, 2616));
        F.add(new Floor(-8 + x, -1008 + y, 1016, 1010));
        F.add(new Floor(-108 + x, 598 + y, 1216, 1000));
        F.add(new Floor(200+x,500+y,260,1000));
        F.add(new Floor(610+x,500+y,100,1000));
        F.add(new Floor(810+x,500+y,1000,1000));
        D.add(new DeathBarrier(710+x,550+y,100,30));
        F.add(new Floor(710+x,580+y,100,1000));
        F.add(new Floor(460+x,580+y,150,1000));
        F.add(new Floor(300+x,-100+y,30,2000));
        F.add(new Floor(400+x,150+y,60,2000));
        G.add(new GrappleBlocks(340+x,100+y,20,20));
        D.add(new DeathBarrier(460+x,550+y,150,30));
        setE(new End(950+x,450+y,30,30));
        setFloors(F);
        setDB(D);
        setGB(G);
    }
}
