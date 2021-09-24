package algorithms.saper;

import java.util.Random;

/** Вам необходимо построить поле для игры "Сапёр" по его конфигурации -
 * размерам и координатам расставленных на нём мин.
 *  Поле состоит из клеток с минами и пустых клеток
 *  Клетки с минами обозначаются символом *
 *  Пустые клетки содержат число Kj, 0 <= Kj <= 8 - количество мин на соседних клетках
 *  Соседними клетками яляются 8 клеток, имеющих смежный угол или сторону. */
public class Main {

    public static void changeNumberOfKletki(Kletka kletka, String[][] arr) {
        /** если клетка бомба, то инкрементируем клетки вокруг на 1 */
        /** если же клетка не бомба, то игнорируем это условие */
        if (kletka.isBomb()) {
            int i = kletka.getI();
            int j = kletka.getJ();

            if (i == 0) {
                kletka.setLeft(false);
                kletka.setLeftUp(false);
                kletka.setLeftDown(false);
            } else if (i == arr.length - 1) {
                kletka.setRightUp(false);
                kletka.setRight(false);
                kletka.setRightDown(false);
            }

            if (j == 0) {
                kletka.setLeftUp(false);
                kletka.setUp(false);
                kletka.setRightUp(false);
            } else if (j == arr.length - 1) {
                kletka.setLeftDown(false);
                kletka.setDown(false);
                kletka.setRightDown(false);
            }


            if (kletka.isLeft()) {
                inkrementKletkiAround(arr, i - 1, j);
            }

            if (kletka.isLeftUp()) {
                inkrementKletkiAround(arr, i - 1, j - 1);
            }

            if (kletka.isUp()) {
                inkrementKletkiAround(arr, i, j - 1);
            }

            if (kletka.isRightUp()) {
                inkrementKletkiAround(arr, i + 1, j - 1);
            }

            if (kletka.isRight()) {
                inkrementKletkiAround(arr, i + 1, j);
            }

            if (kletka.isRightDown()) {
                inkrementKletkiAround(arr, i + 1, j + 1);
            }

            if (kletka.isDown()) {
                inkrementKletkiAround(arr, i, j + 1);
            }

            if (kletka.isLeftDown()) {
                inkrementKletkiAround(arr, i - 1, j + 1);
            }

        }
    }

    public static void markKletkaAsBomb(String[][] arr, boolean isBomb, int i, int j) {
        if (isBomb) {
            arr[i][j] = "*";
        }
    }

    public static void initKletka(Kletka kletka){
        kletka.setDown(true);
        kletka.setRightDown(true);
        kletka.setRight(true);
        kletka.setRightUp(true);
        kletka.setLeft(true);
        kletka.setLeftDown(true);
        kletka.setLeftUp(true);
        kletka.setUp(true);
    }

    public static void inkrementKletkiAround(String[][] arr, int i, int j) {
        String newLoc = arr[i][j];

        /** если мы собираемся изменить ячейку- не_мину, то увеличиваем её число на 1 */
        /** если мы попали в ячейку- мину, то ничего не делаем */
        if (!newLoc.equals("*")) {
            int num = Integer.parseInt(newLoc) + 1;
            arr[i][j] = String.valueOf(num);
        }
    }

    /** первичная инициализация ячеек нулём "0" */
    public static String[][] initFillArr(int size) {
        String[][] arr = new String[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                arr[i][j] = "0";
            }
        }
        return arr;
    }

    public static String[][] fillArrByBombs(String[][] arr) {
       // System.out.println("Первичный вывод данных: ");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {

                Kletka kletka = new Kletka(i, j);
                /** первичная установка значений для перемещения ячеек */
                initKletka(kletka);

                /** расстановка мин */
                Random random = new Random();
                boolean isBomb = random.nextBoolean();
                markKletkaAsBomb(arr, isBomb, i, j);

                /** сохраняем в клетку флаг "бомба"  */
                kletka.setBomb(isBomb);
                changeNumberOfKletki(kletka, arr);

               // System.out.print(arr[i][j] + " ");
            }
           // System.out.println();
        }
        return arr;
    }

    public static void main(String[] args) {
        String[][] arr = initFillArr(10);
        String[][] result = fillArrByBombs(arr);

        System.out.println("\nОкончательный вариант: ");
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

    }
}
