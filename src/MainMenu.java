import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MainMenu extends JPanel implements ActionListener, KeyListener {
    private JFrame frame2 = new JFrame("Menu");
    private Game g1;
    public MainMenu(){
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Cursor cursor1 = new Cursor(Cursor.HAND_CURSOR); // HAND CURSOR
        frame2.setCursor(cursor1);
        MouseClickDetector clickDetector1 = new MouseClickDetector();
        frame2.addMouseListener(clickDetector1);
        frame2.setUndecorated(true);
        frame2.add(this);
        setFocusable(true);
        JButton s = new JButton("Start");
        s.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame2.dispose();
                g1.resume();
            }
        });
        frame2.add(s);
        JButton e = new JButton("Exit");
        e.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame2.dispose();
                System.exit(0);
            }
        });
        JLabel R = new JLabel("press W to jump, A and D for left and right, and W in the air for double jump, pressing Shift will allow you to move through walls for a short time and escape will pause the game.\n Your goal is to reach the green block without touching any red. Yellow squares act as grappling points and can be clicked on to drag you towards them.", SwingConstants.CENTER);
        R.setText("<html>" + R.getText().replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>");
        //R.setHorizontalAlignment(0);
        frame2.add(R);
        frame2.add(e);
        frame2.pack();
        frame2.setLayout(null);
        frame2.setLocationRelativeTo(null);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setPreferredSize(new Dimension(screenSize));
        R.setBounds(0,600, screenSize.width, 40);
        frame2.setSize((int) screenSize.getWidth(), (int) screenSize.getHeight());
        frame2.setLocation(0,0);
        frame2.setVisible(true);
        s.setBounds((int) ((screenSize.getWidth()/2)-50),(int)(screenSize.getHeight()/2)-15,100,30);
        e.setBounds((int) ((screenSize.getWidth()/2)-50),(int)(screenSize.getHeight()/2)+40,100,30);
        g1 = new Game();
        g1.start();
    }
    public void r(){
        g1 = null;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
