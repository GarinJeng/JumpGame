import java.awt.Rectangle;

public class Steve {
    private Rectangle rectangle;
    private boolean movingUp;
    private boolean movingDown;
    private boolean movingLeft;
    private boolean movingRight;
    private int momentumX;
    private int momentumY;
    private int nHight = 0;
    private int cHight = 0;

    public Steve(int x, int y, int width, int height) {
        rectangle = new Rectangle(x, y, width, height);
        movingUp = false;
        movingDown = false;
        movingLeft = false;
        movingRight = false;
        momentumX = 0;
        momentumY = 0;
        nHight = height;
        cHight = (height-7);
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void move(int dx, int dy) {
        rectangle.setLocation(rectangle.x + dx + momentumX, rectangle.y + dy + momentumY);
    }

    public void fix(int dx, int dy) {
        rectangle.setLocation(rectangle.x + dx, rectangle.y + dy);
    }

    public boolean isMovingUp() {
        return movingUp;
    }

    public void setMovingUp(boolean movingUp) {
        this.movingUp = movingUp;
    }

    public boolean isMovingDown() {
        return movingDown;
    }

    public void setMovingDown(boolean movingDown) {
        this.movingDown = movingDown;
    }

    public boolean isMovingLeft() {
        return movingLeft;
    }

    public void setMovingLeft(boolean movingLeft) {
        this.movingLeft = movingLeft;
    }

    public boolean isMovingRight() {
        return movingRight;
    }

    public void setMovingRight(boolean movingRight) {
        this.movingRight = movingRight;
    }
    public void AddMomentum(int x, int y){
        momentumX += x;
        momentumY += y;
    }
    public void SetMomentum(int x, int y){
        momentumX = x;
        momentumY = y;
    }
    public void zeroY(){
        momentumY = 0;
    }
    public int getMomentumY(){
        return momentumY;
    }
    public void home(int offsetx, int offsety){
        rectangle.setLocation(100+offsetx,400+offsety);
    }
    public void addMomentumX(int x){
        momentumX += x;
    }

    public int getMomentumX() {
        return momentumX;
    }
    public void zeroX(){
        momentumX = 0;
    }
    public void crouch(){
        rectangle.setSize(rectangle.width,cHight);
        rectangle.setLocation(rectangle.x,rectangle.y+7);
    }
    public void stand(){
        rectangle.setSize(rectangle.width,nHight);
        rectangle.setLocation(rectangle.x,rectangle.y-7);
    }

    public void setMomentumY(int momentumY) {
        this.momentumY = momentumY;
    }
}