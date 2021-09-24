package algorithms.has_two_nums;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Random;

/** Дана последовательность положительных чисел длиной N и число X
 * Нужно найти два различных числа A и B из последовательности,
 * таких что  A + B = X или вернуть пару 0,0, если такой пары чисел нет
 * */
public class Main {

    public static String getTwoNums(LinkedHashMap map) {
        int[] arr = (int[]) map.get("arr");
        int x = (int) map.get("x");
        for (int i = 0; i < arr.length ; i++) {
            int a = arr[i];
            int b = x - a;
            if (a <= x) {
                if (b < arr[arr.length - 1] && 0 < b && a!=b){
                    return "a: " + a + "\n" + "b: " + b + "\n";
                }
            }
        }

        return "a: " + 0 + "\n" + "b: " + 0 + "\n";
    }

    public static LinkedHashMap initArr() {

        int n = new Random().nextInt(101);
        System.out.println("n: " + n);
        int x = new Random().nextInt(n + 1);
        System.out.println("x: " + x);

        int[] arr = new int[n];
        for (int i = 1; i <= n; i++ ) {
            arr[i-1] = i;
        }
        LinkedHashMap map = new LinkedHashMap();
        map.put("n", n);
        map.put("x", x);
        map.put("arr", arr);
        return map;
    }

    public static void main(String[] args) {
        LinkedHashMap map = initArr();
        String result = getTwoNums(map);
        System.out.println(result);


    }
}
