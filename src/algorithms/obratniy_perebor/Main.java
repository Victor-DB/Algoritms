package algorithms.obratniy_perebor;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        int[] array = {1, 3, 4, 7, 2, 8, 9, 10};
        int center = array.length / 2;

        for (int i = 0;  i < center; i++ ) {
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }

        IntStream.of(array).forEach(System.out::println);
    }
}
