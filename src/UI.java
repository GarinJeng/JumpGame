import javax.sound.sampled.Line;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Line2D;

import static java.awt.Color.*;

public class UI extends JPanel implements ActionListener, KeyListener{
    private Float valuem = 0f;
    private Game g;
    private JButton Keys = new JButton("Keybinds");
    private JButton B = new JButton("Exit");
    private JSlider sEffects = new JSlider(0,100,100);
    private JSlider music = new JSlider(-1,100,50);
    private Sound s;
    private Sound SFX;
    private static boolean closeable = true;
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public UI(Game game, Sound sin, Sound sin2){
        s = sin;
        SFX = sin2;
        g = game;
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Cursor cursor1 = new Cursor(Cursor.HAND_CURSOR); // HAND CURSOR
        frame1.setCursor(cursor1);
        MouseClickDetector clickDetector1 = new MouseClickDetector();
        frame1.addMouseListener(clickDetector1);
        frame1.setUndecorated(true);
        //UI ui1 = new UI();
        frame1.add(this);
        addKeyListener(this);
        setFocusable(true);
        frame1.addKeyListener(this);
        //B.setSize(100,10);
        //B.setLocation(0,20);
        B.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame1.dispose();
                System.exit(0);
            }

        });
        Keys.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame1.setVisible(false);
                //S1.disable();
                //music.disable();
                //sEffects.disable();
                //B.disable();
                closeable = false;
                //Keybinds();
                KeyBinds k = new KeyBinds(g, frame1,this);
            }

        });
        music.addChangeListener(new ChangeListener(){

            public void stateChanged(ChangeEvent e) {
                valuem = (float) music.getValue()/100;
                sin.setVolume(valuem);
                frame1.requestFocus();
                //music.disable();
                //sEffects.disable();
                //B.disable();
            }
        });
        sEffects.addChangeListener(new ChangeListener(){
            public void stateChanged(ChangeEvent e) {
                int valuee = sEffects.getValue();

                frame1.requestFocus();
                //sEffects.disable();
                //B.disable();
            }
        });
        JLabel m = new JLabel("Music");
        JLabel Sfx = new JLabel("SFX");
        JPanel p = new JPanel();
        p.setLayout(null);
        p.add(m);
        p.add(Sfx);
        m.setBounds(10,100,33,20);
        Sfx.setBounds(10,130,23,20);
        frame1.add(B);
        frame1.add(Keys);
        frame1.add(music);
        frame1.add(sEffects);
        frame1.add(p);
        frame1.pack();
        frame1.setLayout(null);
        frame1.setLocationRelativeTo(null);
        frame1.setSize((int) screenSize.getWidth(), (int) screenSize.getHeight());
        //frame1.setSize(200,350);
        //Rectangle r = new Rectangle((int) (screenSize.getWidth()/2-100),(int) (screenSize.getHeight()/2-175),200,350);
        frame1.setOpacity(.9f);
        frame1.setVisible(true);
        frame1.setBackground(new Color(1.0f,1.0f,1.0f,0.01f));
        frame1.setAutoRequestFocus(true);
        p.setBounds(0+(int) (screenSize.getWidth()/2-100),0+(int) (screenSize.getHeight()/2-175),200,350);
        B.setBounds(50+(int) (screenSize.getWidth()/2-100),300+(int) (screenSize.getHeight()/2-175),100,30);
        m.setBounds((200-m.getWidth())/2,100,m.getWidth(),20);
        Sfx.setBounds((200-Sfx.getWidth())/2,150,Sfx.getWidth(),20);
        Keys.setBounds(50+(int) (screenSize.getWidth()/2-100),50+(int) (screenSize.getHeight()/2-175),100,30);
        music.setBounds(20+(int) (screenSize.getWidth()/2-100),120+(int) (screenSize.getHeight()/2-175),160,20);
        sEffects.setBounds(20+(int) (screenSize.getWidth()/2-100),170+(int) (screenSize.getHeight()/2-175),160,20);
        frame1.setLocation(0,0);
        //p.setOpaque(true);
        //B.setOpaque(true);
        //m.setOpaque(true);
        //Sfx.setOpaque(true);
        //Keys.setOpaque(true);
        //music.setOpaque(true);
        //sEffects.setOpaque(true);
        //frame1.setBackground(new Color(1.0f,1.0f,1.0f,0.5f));
        //frame1.setLocation((int) (screenSize.getWidth()/2-100), (int) (screenSize.getHeight()/2-175));
        frame1.requestFocus();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE && closeable){
            frame1.dispose();
            g.startTimer();

        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    private JFrame frame1 = new JFrame("MainMenu");

    public static void setCloseable(boolean c){
        closeable = c;
    }
}

