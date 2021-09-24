package algorithms.words_without_symbols;

import java.util.*;

public class Main {

    /** Временная сложность O(N) */
    public static void isWordInDict(Map<Integer, String> badWordsArr, Map<Integer, String> goodWordsArr) {

        /** Проходим по мапе с дырявыми словами */
        for (Map.Entry<Integer, String> word : badWordsArr.entrySet()) {
            /** вытаскиваем из мапы слова и их ключи */
            String badValue = word.getValue();
            int badKey = word.getKey();

            /** по ключу находим в мапе с целыми словами соответстсвующее слово */
            String goodValue = goodWordsArr.get(badKey);

            /** если слово содержит слово из списка дырявых, то оно либо совпадает,
             * либо пробел в дырявом слове находится на границе слова */
            if (goodValue.contains(badValue.trim())) {
                System.out.printf("value %s is in the map\n", badValue);

            /** если слово не совпадает со словом из списка дырявых, то дырявое слово либо содержит пробел в центре слова,
             * либо не совпадает вовсе,
             * поэтому дробим дырявое слово на две части и проверим вхождение частей в слово */
            } else  {
                String[] wordsPart = badValue.split(" ");
                if (goodValue.contains(wordsPart[0]) && goodValue.contains(wordsPart[1])) {
                    System.out.printf("value %s is in the map\n", badValue);
                }
            }
        }
    }


    public static void main(String[] args) {

        Map<Integer, String>  goodWordsArr = new HashMap<Integer, String>() {{
            put(1, "raf4s");
            put(2, "Tfrgrg");
            put(3, "gddefT4gd");
            put(4, "5yetgT");
            put(5, "bdgh3");
            put(6, "myk8k");
            put(7, "ghTj5");
            put(8, "7gjT");
            put(9, "gdfb");
        }};

        Map<Integer, String> badWordsArr = new HashMap<Integer, String>() {{
            put(1, "raf4s");
            put(2, " frgrg");
            put(3, "gddef 4gd");
            put(4, "5yetg ");
            put(5, "bdgh3");
            put(6, "myk8k");
            put(7, "gh j5");
            put(8, "7gj ");
            put(9, "gdfb");
        }};

        isWordInDict(badWordsArr, goodWordsArr);
    }
}
