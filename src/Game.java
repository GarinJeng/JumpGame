import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.Line2D;
import java.net.URL;
import java.util.ArrayList;

public class Game extends JPanel implements ActionListener, KeyListener {
    boolean menu = true;
    private double a = 0;
    private static MainMenu m;
    private ArrayList<Floor> floors = new ArrayList<>();
    public End e;
    public static Game game;
    private boolean touchingFloor;
    private int ejump = 1;
    private Line2D l;
    private int ln = 0;
    private Point lastClickedPoint = null;
    public ArrayList<GrappleBlocks> GBlocks = new ArrayList<>();
    private ArrayList<DeathBarrier> DB = new ArrayList<>();
    private Steve steve;
    private Timer timer;
    private boolean relesed = true;
    private static MouseClickDetector clickDetector = new MouseClickDetector();
    private Grapple G;
    private int offsetX;
    private int offsetY;
    private int fr = 0;
    private boolean grappling = false;
    private Point Gpoint;
    private Point pclicked = null;
    private int Gx = 0;
    private int Gy = 0;
    private static JFrame frame = new JFrame("Game");
    private int blinking = 0;
    private Sound s = new Sound();
    private Sound s2 = new Sound();
    private int gDistance = 0;
    private int[] keys = {KeyEvent.VK_W,KeyEvent.VK_A,KeyEvent.VK_S,KeyEvent.VK_D,KeyEvent.VK_SHIFT};
    private String[] KeyN = {"W","A","S","D","Shift"};
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    public Game() {
        setPreferredSize(new Dimension(screenSize));
        offsetY = (int)((screenSize.getHeight()-600)/2);
        offsetX = (int)((screenSize.getWidth()-1000)/2);
        addKeyListener(this);
        setFocusable(true);
        //MainMenu m = new MainMenu(this);
        initGame();
        //MainMenu m = new MainMenu((int) screenSize.getWidth(), (int) screenSize.getHeight(),offsetX,offsetY,game);
    }
    public void Start(){
        initGame();
    }

    public void initGame() {
        URL soundurl = getClass().getResource("Music.wav");
        s.setFile(soundurl);
        s.play(soundurl);
        s.loop(soundurl);
        s.setVolume(.5f);
        floors.add(new Floor(998 + offsetX, -1000 + offsetY, 1000, 2616));
        floors.add(new Floor(-108 + offsetX, 598 + offsetY, 600, 1000));
        floors.add(new Floor(700 + offsetX, 598 + offsetY, 1000, 1000));
        floors.add(new Floor(700 + offsetX, 498 + offsetY, 1000, 30));
        floors.add(new Floor(-8 + offsetX, -1008 + offsetY, 1016, 1010));
        floors.add(new Floor(-1008 + offsetX, -1008 + offsetY, 1010, 2616));
        floors.add(new Floor(400+offsetX,-8+offsetY,19,616));
        GBlocks.add(new GrappleBlocks(485 + offsetX, 285 + offsetY, 30,30));
        e = new End(900 + offsetX,450 + offsetY,30,30);
        DB.add(new DeathBarrier(492+offsetX,650+offsetY,208,1000));
        setLevel(ln);
        steve = new Steve(100 + offsetX, 100 + offsetY, 10, 20);
        G = new Grapple(null,steve.getRectangle());
        timer = new Timer(16, this);
        timer.start();
    }
    public void resume(){
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        update();
        repaint();
    }

    private void update() {
        int dx = 0;
        int dy = 0;
        int gx = 0;
        int gy = 0;

        if (steve.isMovingUp()) {
            dy -= 5;
        }
        if (steve.isMovingDown()) {
            dy += 10;
        }
        if (steve.isMovingLeft()) {
            dx -= 5;
        }
        if (steve.isMovingRight()) {
            dx += 5;
        }
        for(DeathBarrier d: DB){
            if(steve.getRectangle().intersects(d.GetDB())){
                steve.home(offsetX,offsetY);
                steve.zeroY();
            }
        }
        if(steve.getRectangle().intersects(e.GetEnd())){
            steve.home(offsetX,offsetY);
            ln++;
            timer.stop();
            floors.clear();
            GBlocks.clear();
            DB.clear();
            e = null;
            repaint();
            initGame();
        }
        pclicked = lastClickedPoint;
        lastClickedPoint = clickDetector.getLastClickedPoint();
        if (lastClickedPoint != null) {
            Gpoint = lastClickedPoint;
            G.refresh(lastClickedPoint, steve.getRectangle());
            if (checkGrapples()) {
                if (G.dX() != 0 && G.dY() != 0){
                    if(Math.sqrt((G.dX() * G.dX() + G.dY() * G.dY())) >= 100) {
                        gx = (50 * G.dX() / (Math.abs(G.dX()) + Math.abs(G.dY())));
                        gy = (30 * G.dY() / (Math.abs(G.dX()) + Math.abs(G.dY())));
                    }else if (Math.sqrt((G.dX() * G.dX() + G.dY() * G.dY())) >= 10){
                        gx = (10 * G.dX() / (Math.abs(G.dX()) + Math.abs(G.dY())));
                        gy = (10 * G.dY() / (Math.abs(G.dX()) + Math.abs(G.dY())));
                    }else if (Math.sqrt((G.dX() * G.dX() + G.dY() * G.dY())) >= 5){
                        gx = (5 * G.dX() / (Math.abs(G.dX()) + Math.abs(G.dY())));
                        gy = (5 * G.dY() / (Math.abs(G.dX()) + Math.abs(G.dY())));
                    }else{
                        gx = G.dX();
                        gy = G.dY();
                    }
                    steve.zeroY();
                    grappling = true;
                    //gx = G.dX() / 10;
                    //gy = G.dY() / 10;
                }
            }
            if(pclicked != lastClickedPoint && pclicked == null){
                gDistance = (int)(Math.abs(Math.sqrt((G.dX()*G.dX()) + (G.dY()*G.dY()))));
                Gy = G.dY();
                Gx = G.dX();
                //a = Math.tan(G.dX()/G.dY());
                //System.out.println("change");
            }
            /*if(checkGrapples()){
                a+=1;
                int d = (int)(lastClickedPoint.getX() + Gx*Math.cos(a)) - steve.getRectangle().width/2;
                int d1 = (int)(lastClickedPoint.getY() + Gy*Math.sin(a)) - steve.getRectangle().height/2;
                gx = (int) (steve.getRectangle().getX()+d);
                gy = (int) (steve.getRectangle().getY() + d1);
                steve.zeroY();
                grappling = true;
            }
            if (checkGrapples()) {
                if((int)(Math.abs(Math.sqrt((G.dX()*G.dX()) + (G.dY()*G.dY())))) != gDistance){
                    int c = 0;
                    int c1 = 0;
                    int d1 = 0;
                    int d2 = 0;
                    while((int)(Math.abs(Math.sqrt((G.dX()+c*G.dX()+c) + (G.dY()*G.dY())))) != gDistance){
                        c++;
                    }
                    d1 = (int)(Math.abs(Math.sqrt((G.dX()+c*G.dX()+c) + (G.dY()*G.dY()))));
                    while((int)(Math.abs(Math.sqrt((G.dX()*G.dX()) + (G.dY()+c1*G.dY()+c1)))) != gDistance){
                        c1++;
                    }
                    d2 = (int)(Math.abs(Math.sqrt((G.dX()*G.dX()) + (G.dY()+c1*G.dY()+c1))));
                    if(d1>d2) {
                        gx = c;
                        gy = 0;
                    }else{
                        gx = 0;
                        gy = c1;
                    }
                }
            }
            steve.zeroY();*/
            //int x = (int) lastClickedPoint.getX();
            //int y = (int) lastClickedPoint.getY();
            //System.out.println("Last clicked point: X=" + x + ", Y=" + y);
        }else{
            grappling = false;
        }

        steve.move(dx + gx, dy + gy);
        if(blinking  <= 10) {
            checkCollision();
        }else{
            steve.zeroY();
        }
        touchingFloor = false;
        steve.move(0,1);
        for(Floor f: floors){
            Rectangle s = steve.getRectangle();
            Rectangle fs = f.getFloor();
            if (s.intersects(fs)
                    //&&s.getY() <fs.getY()+50
                    && !(s.getY() > fs.getY()+fs.getHeight()-11 &&s.getY() < fs.getY()+fs.getHeight())
                    && s.getX()+s.getWidth() > fs.getX()-10
                    && s.getX()-10 < fs.getX()+fs.getWidth()){
                touchingFloor = true;
                ejump = 1;
            }
        }

        /*if(steve.getMomentumX() > 0 && fr == 1){
            steve.addMomentumX(-1);
        }
        if(steve.getMomentumX() < 0 && fr == 1){
            steve.addMomentumX(1);
        }*/
        steve.move(0,-1);
        //System.out.println(tuchingFloor);
        if (!touchingFloor && steve.getMomentumY() < 50 && fr == 0) {
            steve.AddMomentum(0, 1);
            fr++;
        }else if(!touchingFloor && steve.getMomentumY() < 50 && fr == 1){
            fr--;
        }else{
            if(blinking  <= 10) {
                checkCollision();
            }else{
                steve.zeroY();
                steve.setMovingUp(false);
                steve.setMovingDown(false);
            }
            //steve.zeroY();
        }
        if (blinking > 0){
            blinking--;
        }

    }

    private void checkCollision() {
        for (Floor floor : floors) {
            if (steve.getRectangle().intersects(floor.getFloor())) {
                String move = floor.findEd(steve);
                if(move.startsWith("U")){
                    touchingFloor = true;
                }
                if (move.startsWith("U")) {
                    steve.setMomentumY(-steve.getMomentumY());
                    steve.fix(0, -Integer.parseInt(move.substring(1)));
                    //steve.zeroY();
                } else if (move.startsWith("D")) {
                    steve.fix(0, Integer.parseInt(move.substring(1)));
                } else if (move.startsWith("L")) {
                    steve.fix(Integer.parseInt(move.substring(1)), 0);
                } else if (move.startsWith("R")) {
                    steve.fix(-Integer.parseInt(move.substring(1)), 0);
                }
            }
        }
        for (GrappleBlocks floor : GBlocks) {
            if (steve.getRectangle().intersects(floor.getFloor())) {
                String move = floor.findEdge(steve);
                if (move.startsWith("U")) {
                    steve.fix(0, -Integer.parseInt(move.substring(1)));
                } else if (move.startsWith("D")) {
                    steve.fix(0, Integer.parseInt(move.substring(1)));
                } else if (move.startsWith("L")) {
                    steve.fix(Integer.parseInt(move.substring(1)), 0);
                } else if (move.startsWith("R")) {
                    steve.fix(-Integer.parseInt(move.substring(1)), 0);
                }
            }
        }
        if (steve.getRectangle().getY()>800+offsetY) {
            steve.home(offsetX,offsetY);
        }

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, getWidth(), getHeight());
        g2d.setColor(Color.BLACK);
        for (Floor floor : floors) {
            g2d.fill(floor.getFloor());
        }
        g2d.setColor(Color.BLACK);
        if(grappling&&blinking <= 10){
            g2d.drawLine((int) l.getX1(), (int) l.getY1(), (int) l.getX2(), (int) l.getY2());
        }
        g2d.setColor(Color.GREEN);
        g2d.fill(e.GetEnd());
        g2d.setColor(Color.ORANGE);
        for (GrappleBlocks floor : GBlocks) {
            g2d.fill(floor.getFloor());
        }
        if(blinking  <= 10) {
            checkCollision();
        }
        g2d.setColor(Color.BLUE);
        if(blinking <= 10) {
            g2d.fill(steve.getRectangle());
        }
        g2d.setColor(Color.RED);
        for (DeathBarrier floor : DB) {
            g2d.fill(floor.GetDB());
        }
        //JFrame frame1 = new JFrame();
        //frame1.setVisible(true);
        //frame1.setAlwaysOnTop(true);
        //frame1.setBounds(0,0,screenSize.width,screenSize.height);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == keys[0]) {
            if(relesed) {

                if (touchingFloor) {
                    steve.SetMomentum(0, -3);
                    steve.setMovingUp(true);
                } else if (ejump != 0) {
                    ejump--;
                    steve.setMovingUp(true);
                    steve.SetMomentum(0, -3);
                    if (touchingFloor){
                        ejump = 1;
                    }
                }
            }
            if (!relesed && steve.getMomentumY() >= 0){
                steve.setMovingUp(false);
            }
            relesed = false;
        }
        if (e.getKeyCode() == keys[2]) {
            steve.setMovingDown(true);
            //if (!relesed && steve.getMomentumY() >= 0){
                steve.setMovingUp(false);
                steve.crouch();
            //}
        }
        if (e.getKeyCode() == keys[1]) {
            steve.setMovingLeft(true);
            steve.zeroX();
            if (!relesed && steve.getMomentumY() >= 0){
                steve.setMovingUp(false);
            }
        }
        if (e.getKeyCode() == keys[3]) {
            steve.setMovingRight(true);
            steve.zeroX();
            if (!relesed && steve.getMomentumY() >= 0){
                steve.setMovingUp(false);
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            //frame. dispose();
                UI ui = new UI(game, s, s2);
            frame.add(ui);
                timer.stop();

            //System.exit(0);

        }
        if (e.getKeyCode() == keys[4]){
            if (blinking ==0) {blinking = 15;}
            if (!relesed&& steve.getMomentumY() >= 0){
                steve.setMovingUp(false);
            }
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == keys[0]) {
            steve.setMovingUp(false);
            relesed = true;
        }
        if (e.getKeyCode() == keys[2]) {
            steve.setMovingDown(false);
            steve.stand();
        }
        if (e.getKeyCode() == keys[1]) {
            steve.setMovingLeft(false);
            //steve.addMomentumX(-2);
        }
        if (e.getKeyCode() == keys[3]) {
            steve.setMovingRight(false);
            //steve.addMomentumX(2);
        }
    }

    public static void main(String[] args) {
        m = new MainMenu();
    }
    public boolean checkGrapples(){
        boolean gr = false;
        boolean fl = true;
        for(GrappleBlocks g: GBlocks){
            if(G.checkValid(g)){
                gr =  true;
                break;
            }
        }
        for(Floor f : floors){
            l = new Line2D.Float((int) (steve.getRectangle().getX()+5), (int) (steve.getRectangle().getY()+10), Gpoint.x, Gpoint.y);
            if (l.intersects(f.getFloor())){
                fl = false;
                break;
            }
        }
        return gr && fl;
    }
    public boolean setLevel(int x) {
        Level l = null;
        if (x == 0) {
            l = new LevelT(offsetX, offsetY);

        } else if (x == 1) {
            l = new Level1(offsetX, offsetY);
        } else if (x == 2) {
            l = new Level2(offsetX, offsetY);
        } else if (x == 3) {
            l = new Level3(offsetX, offsetY);
        } else if (x == 4) {
            l = new Level4(offsetX, offsetY);
        } else if (x == 5) {
            l = new Level5(offsetX, offsetY);
        }else if (x == 6){
            frame.dispose();
            ShowCredits();
            timer.stop();
            return false;
        }else{
            return true;
        }
        floors = l.rFloors();
        GBlocks = l.rGblocks();
        DB = l.RDB();
        e = l.getE();
        return false;
    }
    public void startTimer(){
        timer.restart();
    }
    public void setKey(int keyp, int key){
        keys[keyp] = key;
    }
    public int getKey(int k){
        return keys[k];
    }
    public String[] getKeyNames(){
        return KeyN;
    }
    public void setKeyNames(String[] s){
        KeyN = s;
    }
    public void start(){
        SwingUtilities.invokeLater(() -> {

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            game = new Game();
            frame.add(game);
            frame.setUndecorated(true);
            Cursor cursor = new Cursor(Cursor.CROSSHAIR_CURSOR); // HAND CURSOR
            frame.setCursor(cursor);
            clickDetector = new MouseClickDetector();
            frame.addMouseListener(clickDetector);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(false);
        });
    }
    public void ShowCredits(){
        JFrame frame1 = new JFrame();
        JButton b = new JButton("Play again");
        JButton e1 = new JButton("Exit");
        JPanel p = new JPanel();
        JLabel Header = new JLabel("Thanks For Playing!");
        p.setLayout(null);
        p.add(Header);
        Header.setBounds(0,0, (int) screenSize.getWidth(),200);
        Header.setFont(new Font("Serif", Font.PLAIN, 100));
        Header.setHorizontalAlignment(0);
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame1.dispose();
                frame.dispose();
                timer = null;
                //frame.hide();
                //frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                frame =  new JFrame("Game");
                //frame1.dispatchEvent(new WindowEvent(frame1, WindowEvent.WINDOW_CLOSING));
                //steve = new Steve(100 + offsetX, 100 + offsetY, 10, 20);
                ln = 0;
                game = null;
                m.r();
                System.gc();
                MainMenu m1 = new MainMenu();
            }
        });
        e1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame1.dispose();
                System.exit(0);
            }
        });
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Cursor cursor1 = new Cursor(Cursor.HAND_CURSOR); // HAND CURSOR
        frame1.setCursor(cursor1);
        frame1.setUndecorated(true);
        frame1.setPreferredSize(new Dimension(screenSize));
        frame1.setBackground(Color.BLACK);
        frame1.add(b);
        frame1.add(e1);
        frame1.add(p);
        p.setBounds(0,0, (int) screenSize.getWidth(), (int) screenSize.getHeight());
        frame1.pack();
        frame1.setPreferredSize(new Dimension(screenSize));
        frame1.setSize((int) screenSize.getWidth(), (int) screenSize.getHeight());
        frame1.setLocation(0,0);
        frame1.setVisible(true);
        b.setBounds((int)(screenSize.getWidth()/2)-50,(int)(screenSize.getHeight()/2)-15,100,30);
        e1.setBounds((int)(screenSize.getWidth()/2)-50,(int)(screenSize.getHeight()/2)+40,100,30);
        frame1.requestFocus();
    }
}