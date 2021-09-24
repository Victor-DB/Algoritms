package algorithms.sout_all_small_words;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void getAllSmallWords(String str){

        Map<Integer, String> map = new HashMap<>();
        String[] arr = str.split(" ");

        String min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (min.length() >= arr[i].length()) {
                min = arr[i];
                map.put(i, min);
            }
        }

        for (Map.Entry<Integer, String> pair : map.entrySet()) {
            int minLength = min.length();
            if  (pair.getValue().length() == minLength) {
                System.out.print(pair.getValue() + " ");
            }
        }
    }

    public static void main(String[] args) {
        String arr = "aaa bbbbb 11 cc 333 444 55 gf lg";
        getAllSmallWords(arr);
    }
}
