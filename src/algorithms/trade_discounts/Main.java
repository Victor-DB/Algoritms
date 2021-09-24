package algorithms.trade_discounts;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** Торговые скидки Для привлечения покупателей магазин ввел скидки: наборы товаров (одинаковых или разных) продаются по пониженной цене.
 Например, цена одного цветка равна 20 руб.,, а цена одной вазы равна 50 руб.
 Пусть предлагается следующая система скидок:
    1) Три цветка продаются за 50 руб. (вместо 60)..
    2) Набор из двух ваз и одного цветка стоит 100 руб. (вместо 120).
 Предположим, покупатель хочет приобрести две вазы и три цветка.
 Тогда он может выбрать один из двух вариантов скидок:
    1) Две вазы по полной стоимости (100 руб.) и три цветка со скидкой (50 руб.); итого 150 руб.
    2) Набор из двух ваз и одного цветка (100 руб.) и два цветка по полной стоимости (40 руб.); итого 140 руб.
 Напишите программу, вычисляющую оптимальный вариант скидок, обеспечивающий наименьшую цену заданного набора покупок.
 Входные данные содержатся в двух файлах: INPUT.TXT и OFFER.TXT.
 Первый файл описывает покупки («корзину с покупками»).
 Второй файл описывает скидки. В обоих файлах содержатся только целые числа.
 Первая строка файла INPUT.TXT содержит количество b различных видов товара в корзине (0 <= b <= 5).
 Каждая из следующих b строк содержит значения с, k и р.
 Значение с — уникальный код товара (1 <= с <= 999).
 Значение k задает, сколько единиц товара находится в корзине (1 <= k <= 5).
 Значение р задает полную (без скидок) цену единицы товара (1<=р<=999).

 Первая строка файла OFFER.TXT содержит количество s возможных скидок (0 <= s <= 99).
 Каждая из следующих s строк описывает одну скидку, определяя набор товаров и общую стоимость набора.
 Первое число п в такой строке определяет количество различных видов товара в наборе (1 <= п <= 5).
 Следующие п пар чисел (с, k) указывают, что k единиц товара с кодом с включены в набор для скидки (1<=k<=5, 1<=с<= 999).
 Последнее число в строке р определяет уцененную стоимость набора (1 <=р<=9999).
 Стоимость набора меньше суммарной стоимости отдельных единиц товаров в наборе.
 Выходные данные. Запишите в выходной файл OUTPUT.TXT одну строку с наименьшей возможной суммарной стоимостью покупок, заданных во входном файле.
 Для приведенного выше примера входные и выходной файлы будут содержать следующие строки (здесь 7 -код -цветка, 8 - код вазы):

 Файл INPUT.TXT:
 2
 7 3 20
 8 2 50

 Файл OFFER.TXT:
 2
 1 7 3 50
 2 7 1 8 2 100

 Файл OUTPUT. TXT: 140 */

public class Main {

    public static void method1 () throws IOException {
        String inputFile = "src/algorithms/trade_discounts/INPUT.txt";
        String offerFile = "src/algorithms/trade_discounts/OFFER.txt";
        int minCost = 0;

        /** Читаем файл INPUT.txt */
        try(BufferedReader readerOffer = new BufferedReader(new FileReader(offerFile))) {
            String line1;
            int count1 = 1;

            String b = "";
            int s = 0;
            /** проход по строкам файла OFFER.txt */
            while ( (line1 = readerOffer.readLine()) != null ) {

                /** вытаскиваем первое число s первой строки из файла OFFER.txt */
                if (count1 == 1) {
                    s = Integer.parseInt(line1);
                    count1++;
                } else {

                    /** проход по остальным строкам файла OFFER.txt */

                    String[] arrLine1 = line1.split(" ");

                    /** достаём n - количество различных видов товара в наборе */
                    int n = Integer.parseInt(arrLine1[0]);

                    /** проход по парам чисел (с, k), т.е. за вычетом 1го и последнего элемента из строки */
                    for (int i = 1; i < arrLine1.length - 1; i++) {
                        // System.out.println("i: " + i);

                        /** если индекс нечётный, то это код товара "с" */
                        if (i % 2 != 0) {
                            System.out.println("код товара с1: " + arrLine1[i]);
                            /** если индекс чётный, то это кол-во "k" единиц товара с кодом "с" */
                        } else {
                            System.out.println("кол-во единиц товара k1: " + arrLine1[i]);
                        }
                    }

                    /** Читаем файл OFFER.txt */
                    try( BufferedReader readerInput = new BufferedReader(new FileReader(inputFile)) ) {

                        String line2;
                        int count2 = 1;

                        /** проход по строкам файла INPUT.txt */
                        while ( (line2 = readerInput.readLine()) != null ) {

                            /** вытаскиваем первое число b первой строки из файла INPUT.txt*/
                            if (count2 == 1) {
                                b = line2;
                                System.out.println(b);
                                count2++;
                            } else {
                                /** получение чисел внутри строки файла INPUT.txt */
                                System.out.println(line2);
                                String[] arrLine2 = line2.split(" ");
                                String c2 = arrLine2[0];
                                String k2 = arrLine2[1];
                                String p2 = arrLine2[2];
                            }
                        }
                    } catch (IOException e) { e.printStackTrace(); }
                }

            }
        } catch (FileNotFoundException e) { e.printStackTrace(); }
    }


    public static Map<Integer, List<Integer>> getOffer() { /// void
        System.out.println("start getOffer...");
        String offerFile = "src/algorithms/trade_discounts/OFFER.txt";
        int minCost = 0;
        Map<Integer, List<Integer>> result = new HashMap<>();///

        try(BufferedReader reader = new BufferedReader(new FileReader(offerFile))) {
            String line;
            int count = 1;
            int s = 0;

            /** проход по строкам файла OFFER.txt */
            while ((line = reader.readLine()) != null) {
                System.out.println("line: " + line);
                /** вытаскиваем первое число s первой строки из файла OFFER.txt */
                if (count == 1) {
                    s = Integer.parseInt(line);
                    count++;
                } else {

                    /** проход по остальным строкам файла OFFER.txt */
                    String[] arrLine1 = line.split(" ");

                    /** достаём n - количество различных видов товара в наборе */
                    int n = Integer.parseInt(arrLine1[0]);

                    /** достаём n - количество различных видов товара в наборе */
                    int p1 = Integer.parseInt(arrLine1[arrLine1.length - 1]); // определяет уцененную стоимость набора
                    System.out.println("p: " + p1);

                    /** проход по парам чисел (с, k), т.е. за вычетом 1го и последнего элемента из строки */
                    int c1 = 0;
                    int k1 = 0;
                    int countPair = 1; /// ?
                    List<Integer> offerList = new ArrayList<>();///
                    for (int i = 1; i < arrLine1.length - 1;  i +=2) {
                        c1 = Integer.parseInt(arrLine1[i]);      // код товара
                        k1 = Integer.parseInt(arrLine1[i + 1]);  // единицы товара с кодом "с", включеные в набор для скидки

                        System.out.println("i: " + i);
                        System.out.println("проверка код товара countPair: " + countPair);
                        System.out.println("проверка код товара с1: " + c1);
                        System.out.println("проверка кол-во единиц товара k1: " + k1);
                        offerList.add(c1);///
                        offerList.add(k1);///
                        offerList.add(p1);///
                        result.put(++countPair, offerList);///

//                        int onePairCost = 0; // одна пара скидок
//                        /** если только одна пара (кол-во, скидка) */
//                        if (n == 1) {
//                            minCost = getCost(c1 ,k1, p1);  // расчёт стоимости корзины товаров с учётом скидки
//
//                        /** если несколько пар (кол-во, скидка) */
                      //  } else {
                            ///** посчитали скидку с нескольких пар, сохранили, обнулили */
//                            if (countPair > 2) {
//                                minCost = onePairCost;
//                                onePairCost = 0;
//                                count = 0;
//                            }
//                            // метод должен запонминать результат прошлой итерации по количеству товара под акцию чтобы просуммировать его и сделать общую скидку!!!!
//                            onePairCost += getCost(c1 ,k1, p1);   // расчёт стоимости корзины товаров с учётом скидки
//                            countPair++;
                       // }
//                        System.out.println("minCost: " + minCost);
                    }

                }
            }

        } catch (IOException e) { e.printStackTrace(); }
        System.out.println("finished getOffer...");
        return result;
    }

    // настроить множественную скидку для товаров !!!
    private static int getCost(int c1, int k1, int p1) {
        String inputFile = "src/algorithms/trade_discounts/INPUT.txt";
        int cost = 0;

        try(BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            int count = 1;

            while ( (line = reader.readLine()) != null) {
                /** вытаскиваем первое число b первой строки из файла INPUT.txt*/

                if (count == 1) {
                    String b = line;
//                    System.out.println("b: " + b);
                    count++;
                } else {
                    /** получение чисел внутри строки файла INPUT.txt */
                    String[] arrLine2 = line.split(" ");
                    int c2 = Integer.parseInt(arrLine2[0]); // уникальный код товара
                    int k2 = Integer.parseInt(arrLine2[1]);; // сколько единиц товара находится в корзине
                    int p2 = Integer.parseInt(arrLine2[2]);; // цена единицы товара без скидок
//                    System.out.println("line: " + line);

                    /** если код товара в корзине = коду товара по скидке */
                    if (c2 == c1) {
                        /** если количество товара в корзине >= количества товара по скидке */
                        if (k2 >= k1) {
                            int k_nabor = k2 / k1; // целое кол-во наборов товара по скидке
                            int k_sale = k_nabor * k2; // кол-во единиц товара по скидке
                            int k_remain = k2 - k_sale; // остальное кол-во единиц товара по обычной цене

                            /** расчитываем стоимость корзины с товаром*/
                            cost += k_sale * p1 / k1 + k_remain * p2;  // p1/k1 - цена единицы товара со скидкой
                        }

                    /** если код товара в корзине != коду товара по скидке */
                    } else {
                        cost += k2 * p2;
                    }
                }
            }
        } catch (IOException e) { e.printStackTrace(); }

        return cost;
    }

    private static Map<Integer, List<Integer>> getProduct()  {
        System.out.println("start getProduct...");
        String inputFile = "src/algorithms/trade_discounts/INPUT.txt";
        Map<Integer, List<Integer>> result = new HashMap<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            int count = 1;

            while ( (line = reader.readLine()) != null) {
                /** вытаскиваем первое число b первой строки из файла INPUT.txt*/
                List<Integer> productList = new ArrayList<>();
                if (count == 1) {
                    String b = line;
                    System.out.println("b: " + b);
                    count++;
                } else {
                    /** получение чисел внутри строки файла INPUT.txt */
                    String[] arrLine2 = line.split(" ");
                    int c2 = Integer.parseInt(arrLine2[0]); // уникальный код товара
                    int k2 = Integer.parseInt(arrLine2[1]); // сколько единиц товара находится в корзине
                    int p2 = Integer.parseInt(arrLine2[2]); // цена единицы товара без скидок
                    System.out.println("line: " + line);
                    productList.add(k2);
                    productList.add(p2);
                    result.put(c2, productList);
                }
            }
        } catch (IOException e) { e.printStackTrace(); }
        System.out.println("finished getProduct...");
        return result;
    }

    public static void calculateCost() {
        //Map<Integer, List<Integer>> products = getProduct();
        Map<Integer, List<Integer>> offers = getOffer();

        for (Map.Entry pair : offers.entrySet()) {
            System.out.println("key: "  + pair.getKey());
            System.out.println("value: "  + pair.getValue());
        }
    }

    public static void main(String[] args)  {
       // getOffer();
        // getCost(1, 2, 3);
       // getProduct();
        calculateCost();
    }
}
