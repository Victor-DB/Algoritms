package algorithms.test;

public class Main {

    public static int someFunc(int i) {
        int j = i * i + 1;
        return j;
    }
    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            if (i == 10) {
                i = i + someFunc(2);
                System.out.println(i);
            } else if (i == 17) {
                i = i - 1;
                System.out.println(i);
            }
        }
    }
}
