package algorithms.cherepahi;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

/** Широко известна задача для младших школьников. Три черепахи ползут по дороге.
 * Одна черепаха говорит: "Впереди меня две черепахи".
 * Другая черепаха говорит: "Позади меня две черепахи".
 * Третья черепаха говорит: "Впереди меня две черепахи и позади меня две черепахи".
 * Как такое может быть? Ответ: Третья черепаха врёт!
 * По дороге одна за другой движутся N черепах. Каждая черепаха говорит фразу вида:
 * "Впереди меня a черепах, а позади меня b черепах". Ваша задача определить сколько самое
 * большое количество черепах могут говорить правду.*/
public class Main {

    public static int[] initTurtles(int size) {
        int turtLength = new Random().nextInt(size);
        int[] turtles = new int[turtLength];
        System.out.println("turtLength: " + turtLength);
        for (int i = 0; i < turtles.length; i++) {
            turtles[i] = i + 1;
        }
        IntStream.of(turtles).forEach(System.out::println);
        return turtles;
    }
    public static int getTurtles(int size, int chooseTurt) {
        int before = 0;
        int after = 0;
        int index = 0;
        int[] turtles = initTurtles(size);
        for (int j = 0; j < turtles.length; j++) {
            /** для выбранной черепахи находим кол-во черепах сзади и спереди */
            if (j == chooseTurt) {
                System.out.println("turtles: " + turtles[j]);
                before = j;
                after = turtles.length - j - 1;
                index = j;
            }
        }

        int count = 0;
        for (int j = 0; j < turtles.length; j++) {
            int tempBefore = j;

            /** проверяем совпадение индексов задом наперёд */
            int tempAfter = turtles.length - j - 1;
            if (tempAfter == before && tempBefore == after) {
                /** исключаем первую черепаху во избежании повторений  */
                if (j != index ) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int count = getTurtles(50, 17);
        System.out.println("count: " + count);
        boolean ltFbr003Lot01Check = false;

    }
}
