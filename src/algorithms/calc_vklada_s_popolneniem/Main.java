package algorithms.calc_vklada_s_popolneniem;

public class Main {

    public static double calcDepo(double rate, int term, int startDepo, int regularDepo) {
        double sum = (startDepo ) * (1 + rate / 12);
        for (int i = 2; i <= term; i++) {
            sum = (sum + regularDepo) * (1 + rate / 12);
        }
        return sum;
    }

    public static void main(String[] args) {
        int sum = (int) calcDepo(0.045, 12, 700000, 70000);
        System.out.println("sum: " + sum);
    }
}
