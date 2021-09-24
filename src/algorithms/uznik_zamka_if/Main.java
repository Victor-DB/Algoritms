package algorithms.uznik_zamka_if;

import java.util.Random;

/**
 * За многие годы заточения узник замка Иф проделал в стене прямоугольное отверстие размером D x E.
 * Замок Иф сложен из кирпичей размером A x B x C. Определите, сможет ли узник выбрасывать кирпичи в море через это отверстие,
 * если стороны кирпича должны быть параллельны сторонам отверстия.
 */
public class Main {

    static void decision1(int a, int b, int c, int d, int e) {
        System.out.printf("\n a : %d\n b : %d\n c : %d\n d : %d\n e : %d\n", a, b, c, d, e);
        int[] kirpich = {a, b, c};
        for (int i = 1; i < kirpich.length; i++) {
            if (kirpich[i - 1] > kirpich[i]) {
                int temp = kirpich[i - 1];
                kirpich[i - 1] = kirpich[i];
                kirpich[i] = temp;
            }
        }

        if (d >= kirpich[0] && e >= kirpich[1] ||
            e >= kirpich[0] && d >= kirpich[1]) {
                System.out.println("\nСможет");
        } else {
            System.out.println("\nНе сможет");
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        int a = random.nextInt(5) + 1;
        int b = random.nextInt(5) + 1;
        int c = random.nextInt(5) + 1;
        int d = random.nextInt(7) + 1;
        int e = random.nextInt(7) + 1;

        decision1(a, b, c, d, e);

    }
}
