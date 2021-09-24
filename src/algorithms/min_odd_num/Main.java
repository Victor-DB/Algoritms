package algorithms.min_odd_num;

/** Найти минимальное четное число в последовательности N чисел
 или вывести -1, если такое число не существует: */
public class Main {

    public static int returnMinVal(int[] arr) {
        int min = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0 && min == -1) {
                min = arr[i];
            }

            if (arr[i] % 2 == 0 && arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] arr = {10, 42, 3, 2,  7, 45, 32, 9, 79};
        System.out.println(returnMinVal(arr));
        String str = "aaaa ddd fff gggg ddddd";
        String[] s = str.split(" ");
    }
}
