package algorithms.saper;

public class Kletka {
    private boolean bomb;
    private int i;
    private int j;

    private boolean isLeftUp;
    private boolean isUp;
    private boolean isRightUp;
    private boolean isLeft;
    private boolean isRight;
    private boolean isLeftDown;
    private boolean isDown;
    private boolean isRightDown;

    public Kletka() {}

    public Kletka(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public boolean isBomb() {
        return bomb;
    }

    public void setBomb(boolean bomb) {
        this.bomb = bomb;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }

    public boolean isLeftUp() {
        return isLeftUp;
    }

    public void setLeftUp(boolean leftUp) {
        isLeftUp = leftUp;
    }

    public boolean isUp() {
        return isUp;
    }

    public void setUp(boolean up) {
        isUp = up;
    }

    public boolean isRightUp() {
        return isRightUp;
    }

    public void setRightUp(boolean rightUp) {
        isRightUp = rightUp;
    }

    public boolean isLeft() {
        return isLeft;
    }

    public void setLeft(boolean left) {
        isLeft = left;
    }

    public boolean isRight() {
        return isRight;
    }

    public void setRight(boolean right) {
        isRight = right;
    }

    public boolean isLeftDown() {
        return isLeftDown;
    }

    public void setLeftDown(boolean leftDown) {
        isLeftDown = leftDown;
    }

    public boolean isDown() {
        return isDown;
    }

    public void setDown(boolean down) {
        isDown = down;
    }

    public boolean isRightDown() {
        return isRightDown;
    }

    public void setRightDown(boolean rightDown) {
        isRightDown = rightDown;
    }
}
