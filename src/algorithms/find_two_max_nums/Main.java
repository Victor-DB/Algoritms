package algorithms.find_two_max_nums;

public class Main {

    /** O(N) сложность */
    public static void findTwoMaxNums(int[] arr){
        int one = Math.max(arr[0], arr[1]);
        int two = Math.min(arr[0], arr[1]);
        for (int i = 1; i < arr.length; i++) {
            /**  Сортируем первый максимум и меняем его значения с меньшими соседями */
            if (arr[i] > one) {
                arr[i] = arr[i] - one;
                one = one + arr[i];
                arr[i] = one - arr[i];
            }
            /** изменённое значение элемента массива, которое меньше первого максимума,
             * но больше второго, сохраняем во второй максимум */
            if (two < arr[i] && arr[i] < one) {
                two = arr[i];
            }
        }
        System.out.println(String.format("Первый максимальный элемент %d", one));
        System.out.println(String.format("Второй максимальный элемент %d", two));
    }

    public static void main(String[] args) {
        int[] arr = {82, 1, 5, 3, 4, 2, 89, 7, 6, 8, 2, 9, 5};
        findTwoMaxNums(arr);
    }
}
