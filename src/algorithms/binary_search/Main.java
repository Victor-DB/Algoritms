package algorithms.binary_search;

import java.util.Random;

public class Main {

    static int i = 0;
    public static void bynarySearch(int[] arr, int findValue, int leftInd, int rightInd) {
        System.out.println(++i);
        if (i > 5000) {
            System.out.println("Эффективность поиска стремиться к линейной, поэтому прерываем процесс...");
            return;
        }

        int center = (leftInd + rightInd) / 2;

        if (findValue < arr[center]) {
            bynarySearch(arr, findValue, leftInd, center);

        } else if (findValue > arr[center]) {
            bynarySearch(arr, findValue, center, rightInd);

        } else if (findValue == arr[center]) {
            System.out.println(String.format(" num is found, its index is %d", center));
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[200000];
        for (int i = 1; i <= 200000; i++) {
            arr[i - 1] = i;
        }

        int findValue = new Random().nextInt(200000 - 1 + 1) + 1;
        System.out.println("findValue: " + findValue + "\n");

        bynarySearch(arr, findValue, 0, arr.length);
    }
}
