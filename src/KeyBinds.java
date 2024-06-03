import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyBinds extends JPanel implements ActionListener, KeyListener{
    private Game g;
    private boolean Set1 = false;
    private boolean Set2 = false;
    private boolean Set3 = false;
    private boolean Set4 = false;
    private boolean Set5 = false;
    private JButton k1 = new JButton("W");
    private JButton k2 = new JButton("A");
    private JButton k3 = new JButton("S");
    private JButton k4 = new JButton("D");
    private JButton k5 = new JButton("Shift");
    private String pk1 = "W";
    private String pk2 = "A";
    private String pk3 = "S";
    private String pk4 = "D";
    private String pk5 = "Shift";
    private String[] keyNames;
    private JFrame KeyFrame = new JFrame("Keys");
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        public KeyBinds(Game game, JFrame frame1, ActionListener u) {
            g = game;
            keyNames = g.getKeyNames();
            k1.setLabel(keyNames[0]);
            pk1 = keyNames[0];
            k2.setLabel(keyNames[1]);
            pk2 = keyNames[1];
            k3.setLabel(keyNames[2]);
            pk3 = keyNames[2];
            k4.setLabel(keyNames[3]);
            pk4 = keyNames[3];
            k5.setLabel(keyNames[4]);
            pk5 = keyNames[4];
            KeyFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Cursor cursor1 = new Cursor(Cursor.HAND_CURSOR); // HAND CURSOR
            KeyFrame.setCursor(cursor1);
            //KeyFrame.addMouseListener(clickDetector1);
            KeyFrame.setUndecorated(true);
            KeyFrame.setBounds((int) (screenSize.getWidth()/2-250), (int) (screenSize.getHeight()/2-175), 500,300);
            //UI ui1 = new UI();
            //KeyFrame.add(this);
            KeyFrame.setAutoRequestFocus(true);
            KeyFrame.add(this);
            addKeyListener(this);
            KeyFrame.addKeyListener(this);
            setFocusable(true);
            JButton E = new JButton("Back");
            E.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    frame1.setVisible(true);
                    frame1.requestFocus();
                    UI.setCloseable(true);
                    String[] t;
                    g.setKeyNames(t = new String[]{pk1, pk2, pk3, pk4, pk5});
                    KeyFrame.setVisible(false);
                    KeyFrame.dispose();
                    //Keys.setEnabled(false);
                    //music.setEnabled(false);
                    //sEffects.setEnabled(false);
                    //B.setEnabled(false);
                    //Keys.isDefaultButton();

                }

            });
            E.setBounds(400+(int) (screenSize.getWidth()/2-250),260+ (int) (screenSize.getHeight()/2-175),70,30);
            KeyFrame.add(E);
            k1.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    int p = 0;
                    if (Set1){p = 1;}
                    Set1 = true;
                    Set2 = false;
                    Set3 = false;
                    Set4 = false;
                    Set5 = false;
                    if (p == 1){
                        p = 0;
                        Set1 = false;
                        k1.setLabel(pk1);
                    }else{
                        pk1 = k1.getText();
                        k1.setLabel("...");
                    }
                    KeyFrame.requestFocus();
                    if(k2.getText()!=pk2){
                        k2.setLabel(pk2);
                    }
                    if(k3.getText()!=pk3){
                        k3.setLabel(pk3);
                    }
                    if(k4.getText()!=pk4){
                        k4.setLabel(pk4);
                    }
                    if(k5.getText()!=pk5){
                        k5.setLabel(pk5);
                    }
                }
            });
            k1.setBounds(400+(int) (screenSize.getWidth()/2-250),10+ (int) (screenSize.getHeight()/2-175),70,30);
            KeyFrame.add(k1);
            k2.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    int p = 0;
                    if (Set2){p = 1;}
                    Set2 = true;
                    Set3 = false;
                    Set4 = false;
                    Set5 = false;
                    Set1 = false;
                    if (p == 1){
                        p = 0;
                        Set2 = false;
                        k2.setLabel(pk2);
                    }else{
                        pk2 = k2.getText();
                        k2.setLabel("...");
                    }
                    KeyFrame.requestFocus();
                    if(k1.getText()!=pk1){
                        k1.setLabel(pk1);
                    }
                    if(k3.getText()!=pk3){
                        k3.setLabel(pk3);
                    }
                    if(k4.getText()!=pk4){
                        k4.setLabel(pk4);
                    }
                    if(k5.getText()!=pk5){
                        k5.setLabel(pk5);
                    }
                }
            });
            k2.setBounds(400+(int) (screenSize.getWidth()/2-250),60+ (int) (screenSize.getHeight()/2-175),70,30);
            KeyFrame.add(k2);
            k3.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    int p = 0;
                    if (Set3){p = 1;}
                    Set3 = true;
                    Set1 = false;
                    Set4 = false;
                    Set5 = false;
                    Set2 = false;
                    if (p == 1){
                        p = 0;
                        Set3 = false;
                        k3.setLabel(pk3);
                    }else{
                        pk3 = k3.getText();
                        k3.setLabel("...");
                    }
                    KeyFrame.requestFocus();
                    if(k1.getText()!=pk1){
                        k1.setLabel(pk1);
                    }
                    if(k2.getText()!=pk2){
                        k2.setLabel(pk2);
                    }
                    if(k4.getText()!=pk4){
                        k4.setLabel(pk4);
                    }
                    if(k5.getText()!=pk5){
                        k5.setLabel(pk5);
                    }
                }
            });
            k3.setBounds(400+(int) (screenSize.getWidth()/2-250),110+ (int) (screenSize.getHeight()/2-175),70,30);
            KeyFrame.add(k3);
            k4.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    int p = 0;
                    if (Set4){p = 1;}
                    Set4 = true;
                    Set1 = false;
                    Set3 = false;
                    Set5 = false;
                    Set2 = false;
                    if (p == 1){
                        p = 0;
                        Set4 = false;
                        k4.setLabel(pk4);
                    }else{
                        pk4 = k4.getText();
                        k4.setLabel("...");
                    }
                    KeyFrame.requestFocus();
                    if(k1.getText()!=pk1){
                        k1.setLabel(pk1);
                    }
                    if(k2.getText()!=pk2){
                        k2.setLabel(pk2);
                    }
                    if(k3.getText()!=pk3){
                        k3.setLabel(pk3);
                    }
                    if(k5.getText()!=pk5){
                        k5.setLabel(pk5);
                    }
                }
            });
            k4.setBounds(400+(int) (screenSize.getWidth()/2-250),160+ (int) (screenSize.getHeight()/2-175),70,30);
            KeyFrame.add(k4);
            k5.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    int p = 0;
                    if (Set5){p = 1;}
                    Set5 = true;
                    Set1 = false;
                    Set4 = false;
                    Set3 = false;
                    Set2 = false;
                    if (p == 1){
                        p = 0;
                        Set5 = false;
                        k5.setLabel(pk5);
                    }else{
                        pk5 = k5.getText();
                        k5.setLabel("...");
                    }
                    frame1.requestFocus();
                    if(k1.getText()!=pk1){
                        k1.setLabel(pk1);
                    }
                    if(k2.getText()!=pk2){
                        k2.setLabel(pk2);
                    }
                    if(k3.getText()!=pk3){
                        k3.setLabel(pk3);
                    }
                    if(k4.getText()!=pk4){
                        k4.setLabel(pk4);
                    }
                    KeyFrame.requestFocus();
                }
            });
            k5.setBounds(400+(int) (screenSize.getWidth()/2-250),210+ (int) (screenSize.getHeight()/2-175),70,30);
            KeyFrame.add(k5);
            JPanel p = new JPanel();
            JLabel l = new JLabel("Jump");
            JLabel l6 = new JLabel("Left");
            JLabel l7 = new JLabel("Down");
            JLabel l8 = new JLabel("Right");
            JLabel l9 = new JLabel("Blink");
            JLabel l1 = new JLabel("___________________________________________________________________________");
            JLabel l2 = new JLabel("___________________________________________________________________________");
            JLabel l3 = new JLabel("___________________________________________________________________________");
            JLabel l4 = new JLabel("___________________________________________________________________________");
            JLabel l5 = new JLabel("___________________________________________________________________________");

            p.setLayout(null);
            p.add(l);p.add(l6);p.add(l7);p.add(l8);p.add(l9);
            p.add(l1);p.add(l2);p.add(l3);p.add(l4);p.add(l5);
            p.setBounds(0+(int) (screenSize.getWidth()/2-250),0 + (int) (screenSize.getHeight()/2-175),500,300);
            l.setBounds(100,10,100,30);
            l1.setBounds(0,28,500,30);
            l2.setBounds(0,78,500,30);
            l3.setBounds(0,128,500,30);
            l4.setBounds(0,178,500,30);
            l5.setBounds(0,228,500,30);
            l6.setBounds(100,60,100,30);
            l7.setBounds(100,110,100,30);
            l8.setBounds(100,160,100,30);
            l9.setBounds(100,210,100,30);
            KeyFrame.add(p);
            KeyFrame.setLayout(null);
            KeyFrame.setLocationRelativeTo(null);
            //KeyFrame.setBounds((int) (screenSize.getWidth()/2-250), (int) (screenSize.getHeight()/2-175), 500,300);
            KeyFrame.setBounds(0,0, (int) screenSize.getWidth(), (int) screenSize.getHeight());
            KeyFrame.setOpacity(.9f);
            KeyFrame.setBackground(new Color(1.0f,1.0f,1.0f,0.01f));
            KeyFrame.setVisible(true);
        }

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            //System.out.println("set Jump to " + e.getKeyCode());
            //System.out.println(Set1);
            if(Set1){
                Set1 = false;
                //System.out.print("set Jump to " + e.getKeyCode());
                g.setKey(0,e.getKeyCode());
                KeyFrame.requestFocus();
                if(Keys(e.getKeyCode())==null) {
                    k1.setLabel(String.valueOf(e.getKeyChar()).toUpperCase());
                }else{
                    k1.setLabel(Keys(e.getKeyCode()));
                }
                pk1 = k1.getText();
            }
            if(Set2){
                g.setKey(1,e.getKeyCode());
                KeyFrame.requestFocus();
                Set2 = false;
                if(Keys(e.getKeyCode())==null) {
                    k2.setLabel(String.valueOf(e.getKeyChar()).toUpperCase());
                }else{
                    k2.setLabel(Keys(e.getKeyCode()));
                }
                pk2 = k2.getText();
            }
            if(Set3){
                g.setKey(2,e.getKeyCode());
                KeyFrame.requestFocus();
                Set3 = false;
                if(Keys(e.getKeyCode())==null) {
                    k3.setLabel(String.valueOf(e.getKeyChar()).toUpperCase());
                }else{
                    k3.setLabel(Keys(e.getKeyCode()));
                }
                pk3 = k3.getText();
            }
            if(Set4){
                g.setKey(3,e.getKeyCode());
                KeyFrame.requestFocus();
                Set4 = false;
                if(Keys(e.getKeyCode())==null) {
                    k4.setLabel(String.valueOf(e.getKeyChar()).toUpperCase());
                }else{
                    k4.setLabel(Keys(e.getKeyCode()));
                }
                pk4 = k4.getText();
            }
            if(Set5){
                g.setKey(4,e.getKeyCode());
                KeyFrame.requestFocus();
                Set5 = false;
                if(Keys(e.getKeyCode())==null) {
                    k5.setLabel(String.valueOf(e.getKeyChar()).toUpperCase());
                }else{
                    k5.setLabel(Keys(e.getKeyCode()));
                }
                pk5 = k5.getText();
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            KeyFrame.requestFocus();
        }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
    public String Keys(int key){
            String out = "";
            if(key == KeyEvent.VK_CAPS_LOCK){
                out = "Caps";
            }else if(key == KeyEvent.VK_SHIFT){
                out = "Shift";
            }else if(key == KeyEvent.VK_CONTROL){
                out = "Ctrl";
            }else if(key == KeyEvent.VK_ALT){
                out = "Alt";
            }else if(key == KeyEvent.VK_SPACE){
                out = "Space";
            }else if(key == KeyEvent.VK_BACK_SPACE){
                out = "Back";
            }else if(key == KeyEvent.VK_DELETE){
                out = "Delete";
            }else if(key == KeyEvent.VK_UP){
                out = "Up";
            }else if(key == KeyEvent.VK_LEFT){
                out = "Left";
            }else if(key == KeyEvent.VK_RIGHT){
                out = "Right";
            }else if(key == KeyEvent.VK_DOWN){
                out = "Down";
            }else{
                out = null;
            }
            return out;
    }
}


