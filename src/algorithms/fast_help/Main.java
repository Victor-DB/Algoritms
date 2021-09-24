package algorithms.fast_help;

import java.util.Scanner;

/** Бригада скорой помощи приехала по вызову в один из отдалённых райнов
 * К сожалению, когда диспетчер получил вызов, он успел записать только
 * адрес дома и номер квартиры К1, а затем связь прервалась.
 * Однако он вспомнил, что поэтому же адресу некоторое время назад скорая помощь
 * выезжала в квартиру К2, которая расположена в подъезде Р2 на этаже N2.
 * Известно, что в доме M этажей и количество квартир на каждой лестничной площадке одинкаково.
 * Напишите программу, которая вычисляет номер подъезда P1 и номер этажа N1 квартиры K1.
 *  */
public class Main {

    static String findFloor(int min, int max, int findVal, int x, int m, int count) {
        for (int i = min; i <= max; i++) {
            if (findVal == i) {
                System.out.println("квартира n1 в подъезде P" + count);
                int floor = 0;
                for (int j = min; j <= max; j+=4) {
                    floor++;
                    if (findVal >= j && findVal <= j + 3) {
                        System.out.println("квартира n1 на этаже " + floor);
                        return "квартира n1 на этаже " + floor;
                    }
                }
                return String.format("значение %s не найдено", floor);
            }
        }
        if (min < 1 || max < 1) {
            throw new IllegalArgumentException("Номер квартиры не может быть меньше 1");
        }
        count--;
        return findFloor(min - x * m, max - x * m, findVal, x, m, count);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /** этажей в доме: */
        System.out.println("Введите кол-во этажей в доме m");
        int m = scanner.nextInt();

        /** этажей квартиры в подъезде P2: */
        System.out.println("Введите этаж n2 квартиры ");
        int n2 = scanner.nextInt();

        /** Номер квартиры в подъезде Р2 на этаже N2 */
        System.out.println("Введите номер квартиры k2");
        int k2 = scanner.nextInt();

        /** Пусть в подъезде на этаже всего х квартир */
        System.out.println("Введите х от 1 до 4 ");
        int x = scanner.nextInt();

        /** Квартиры выше текущей в подъзде P2
         *  x - k2 % x     - индекс квартиры на этаже (от 1 до 4)
         *  (m - n2) * x   - квартиры на верхних этажах в этом подъезде
         * */
        int upKs = (m - n2) * x + (x - k2 % x);

        /** Квартира с максимальным номером в подъзде P2 */
        int kP2Max = upKs + k2;

        /** Квартира с минимальным номером в подъзде P2 */
        int kP2Min = kP2Max - m * x + 1;


        /** Номер квартиры в подъезде Р2 на этаже N2 */
        System.out.println("Введите номер квартиры k1 (меньше k2) ");
        int k1 = scanner.nextInt();

        findFloor(kP2Min, kP2Max, k1, x, m, 2);
    }
}
