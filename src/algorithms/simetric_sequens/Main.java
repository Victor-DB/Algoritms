package algorithms.simetric_sequens;

import java.util.*;

/** Последовательность чисел назовём симетричной, если она одинаково читается
 * как слева направо, так и справа налево. Например, следующие последовательности
 * являются симметричными: 123454321  и 12122121. Вашей программе будет
 * дана последовательность. Требуется определить, какое минимальное количество
 * и каких чисел надо приписать в конец этой последовательности, чтобы она стала симметричной
 * Длина последовательности до 100 */
public class Main {

    public static List<Integer> returnSequenceIndexes(Map<Integer, List<Integer>> mapLeft, String cursor) {
        List<Integer> sequence = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> pair : mapLeft.entrySet()) {
            int key = pair.getKey();
            sequence = new ArrayList<>(pair.getValue());

                for (int j = pair.getValue().size() - 1; j >= 0; j--) {
                    if (key == pair.getValue().get(j)) continue;
                    if (cursor.equals("left")) {
                        /** добавляем элементы в конец */
                        sequence.add(pair.getValue().get(j));
                    } else if (cursor.equals("right")) {
                        /** добавляем элементы в начало */
                        sequence.add(0, pair.getValue().get(j));
                    }
                }
        }
        return sequence;
    }


    static void showMap(Map<Integer, List<Integer>> map) {
        for (Map.Entry<Integer, List<Integer>> m : map.entrySet()) {
            System.out.println("key: " + m.getKey());
            for (Integer x : m.getValue()) {
                System.out.print("value: " + x + " ");
            }
            System.out.println("\n\n");
        }
    }


    public static void saveIndexes(int j, int k, List<Integer> list, Map<Integer, List<Integer>> sequences) {
        List<Integer> indexList = new ArrayList<>();
        while (true) {
            j++;
            k--;
            if (k < 0) break;
            if (j >= list.size()) break;

            if (list.get(k) == list.get(j)) {
                indexList.add(k);
                indexList.add(j);
                if (k == 0 || j == list.size() - 1) {
                    Collections.sort(indexList);
                    sequences.put(sequences.size(), indexList);
                }
            } else {
                indexList = new ArrayList<>();
                break;
            }
        }
    }

    public static Map<Integer, List<Integer>> findSeq(List<Integer> inputList) {
        Map<Integer, List<Integer>> sequencesBorders = new HashMap<>();

        for (int i = 2; i < inputList.size(); i++) {
            int j = 0;
            int k = i - 1;   // левый опорный элемент

            // 1 2 2 1 3 5 5 3
            /** если соседние элементы равны, то проверим равенство эл-в справа и слева от них */
            if (inputList.get(i - 1) == inputList.get(i)) {
                j = i;       // правый опорный элемент
                saveIndexes(j, k, inputList, sequencesBorders);

            // 1 2 1 3 5 3
            } else  {
                if (i + 1 >= inputList.size()) break;
                if (inputList.get(i - 1) == inputList.get(i + 1)) {
                    j = i + 1;       // правый опорный элемент
                    saveIndexes(j, k, inputList, sequencesBorders);
                }
            }
        }
        return sequencesBorders;
    }

    public static Map<String, Integer> returnMinSequence(Map<Integer, List<Integer>> sequencesBorders, List<Integer> inputList) {
        Map<String, Integer> result = new HashMap<>();
        /** количество символов которое надо добавить */
        int minSymbols  = 0;
        /** слева добавить символы (isLeft == 1) или справа? */
        int isLeft = 0;
        int resTo = 0;
        int resFrom = 0;

        for (Map.Entry<Integer, List<Integer>> seq : sequencesBorders.entrySet()) {
            List<Integer> values = seq.getValue();
            int from = values.get(0);
            int to = values.get(1);

            int interval = to - from;
            int temp = inputList.size() - interval;
            if (temp < minSymbols) {
                minSymbols = temp;
                resTo = to;
                resFrom = from;
                isLeft = (to == inputList.size() - 1) ? 1 : 0;
            }
        }
        result.put("isLeft", isLeft);
        result.put("from", resFrom);
        result.put("to", resTo);
        return result;
    }


    public static List<Integer> buildMinSequence(List<Integer> inputList) {
        Map<Integer, List<Integer>> sequencesBorders = findSeq(inputList);
        Map<String, Integer> sequence = returnMinSequence(sequencesBorders, inputList);
        int isLeft = sequence.get("isLeft");
        int from = sequence.get("from");
        int to = sequence.get("to");

        List<Integer> result = new ArrayList<>(inputList);
        /** если симметричная последовательность находится справа
         * то переносим левую часть направо по убыванию */
        if (isLeft == 1) {
            for (int i = from - 1; i >= 0; i--) {
                int num = inputList.get(i);
                /** добавить элемент в конец */
                result.add(num);
            }

        /** если симметричная последовательность находится слева
         * то переносим правую часть в начало по возрастанию */
        } else if (isLeft == 0) {
            for (int i = to + 1; i < inputList.size(); i++) {
                int num = inputList.get(i);
                result.add(0, num);
            }
        }
        return result;
    }


    public static void main(String[] args) {

        List<Integer> list = new ArrayList();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String s = scanner.next();
            if (s.equals("stop")) {
                break;
            } else {
                int n = Integer.parseInt(s);
                list.add(n);
            }
        }

        List<Integer> result = buildMinSequence(list);
        result.forEach(System.out::println);

    }
}
