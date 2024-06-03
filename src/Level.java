import java.util.ArrayList;

public class Level {
    private ArrayList<Floor> floors = new ArrayList<>();
    private ArrayList<GrappleBlocks> GB = new ArrayList<>();
    private ArrayList<DeathBarrier> DB = new ArrayList<>();
    private End e = new End(1000,100,100,600);
    private int offsetX;
    private int offsetY;
    public Level(int OX, int OY){
        offsetX = OX;
        offsetY = OY;
    }
    public ArrayList rFloors(){
        return floors;
    }
    public ArrayList rGblocks(){
        return GB;
    }
    public ArrayList RDB(){
        return DB;
    }

    public End getE() {
        return e;
    }

    public void setFloors(ArrayList<Floor> floors) {
        this.floors = floors;
    }

    public void setDB(ArrayList<DeathBarrier> DB) {
        this.DB = DB;
    }

    public void setGB(ArrayList<GrappleBlocks> GB) {
        this.GB = GB;
    }

    public void setE(End e) {
        this.e = e;
    }
}
