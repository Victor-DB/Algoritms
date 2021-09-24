package algorithms.max_length_char_seq;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Main {

    /** Сложность алгоритма О(N^2)
     * Вывод самой длинной последовательности */
    static void o_n2(String s) {
        int countMax = 0;
        char chMax = 0;
        for (int i = 0; i < s.length(); i++) {
            int count = 0;
            char ch = 0;

            if (s.charAt(i) == chMax) continue;

            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    count++;
                    ch = s.charAt(i);
                }
            }

            if (count > countMax) {
                countMax = count;
                chMax = ch;
            }
        }
        System.out.println(String.format("Символ %s повторяется %d раз", chMax, countMax));
    }

    /** Сложность алгоритма О(N)
     * Вывод мапы букв и их количества в искомой строке
     **/
    static void o_n(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                int index = map.get(ch);
                map.put(ch, ++index);
            } else {
                map.put(ch, 1);
            }
        }
        Stream stream = map.entrySet().stream();
        stream.forEach(System.out::println);
    }

    public static void main(String[] args) {
        String s = "abcbcbccccccccccccccbccfdddddddddd";

        o_n2(s);
        o_n(s);
    }
}
