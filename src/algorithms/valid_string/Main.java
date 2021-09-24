package algorithms.valid_string;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** Дана строка (возможно, пустая), состоящая из букв A-Z:
 AAAABBBCCXYZDDDEEEFFFAAAAAAAABBBBBBBBBBBB
 Нужно написать функцию RLE, которая на выходе даст строку вида:
 A4B3C2XYZD3E3F3A8. И сгенериррует ошибку, если на вход пришла невалидная строка.
 Пояснения: Если символ встречается 1 раз, он остаётся без изменений;
 Если символ повторяется более одного раза, то к нему добавляется количество повторений.
 */
public class Main {

    public static String concat(String res, String lastStr, int count) {
        return res += count == 1 ? lastStr : lastStr + count;
    }

    public static String getValidString(String str){
        String res = "";
        String patern = "(.*)[A-Z](.*)";
        if (!str.matches(patern)) {
            return res = "На вход дана невалидная строка";
        }

        String lastStr = str.substring(0, 1);
        int count = 1;
        for (int i = 1; i < str.length(); i++) {

            String currentStr = str.substring(i, i + 1);

            if (lastStr.equals(currentStr)) {
                count++;
                if (i == str.length() - 1) {
                    res = concat(res, lastStr, count);
                }
            } else {
                res = concat(res, lastStr, count);
                lastStr = currentStr;
                count = 1;
            }
            System.out.println(currentStr);
        }
        return res;
    }

    public static void main(String[] args) {
        String str = "AAAABBBCCXYZDDDEEEFFFAAAAAAAABBBBBBBBBB";
        String result = getValidString(str);
        System.out.println("result: " + result);

    }
}
