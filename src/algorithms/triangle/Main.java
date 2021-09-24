package algorithms.triangle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите три числа");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        if (a <= b + c && a >= b - c && b <= a + c && b >= a - c && c <= a + b && c >= a - b) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        System.out.println( a + " " + b + " " + c);
    }
}
