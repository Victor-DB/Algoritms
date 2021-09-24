package algorithms.mnozhestvo;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        MySet set = new MySet();


        set.add(1);
        System.out.println("after add: " + set.isValueInList(1));
        set.delete(1);
        System.out.println("after delete: " + set.isValueInList(1));


    }
}



class MySet {
    MySet mySet;
    private Node[] nodes = new Node[10];

    {
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node(i, new LinkedList<Node.Element>());
        }
    }

    public MySet() {}

    private int calcHash(int value) {
        return value % 10;
    }

    static class Node {
        /** хэш ноды, он же хеш функция значения сохраняемого элемента в ноде */
        private int hash;

        /** */
        private List<Element> elements = new LinkedList<>();

        private Node() {
        }

        public Node(int hash, List<Element> elements) {
            this.hash = hash;
            this.elements = elements;
        }

        private int getHash() {
            return hash;
        }

        private void setHash(int hash) {
            this.hash = hash;
        }

        private List<Element> getElements() {
            return elements;
        }

        private void setElements(List<Element> elements) {
            this.elements = elements;
        }

        static class Element {
            /** Индекс сохраняемого элемента в списке List<Element> */
            private int indexElement;

            /** Значение сохраняемого элемента*/
            private int valueElement;

            private Element() { }

            private int getIndexElement() {
                return indexElement;
            }

            private void setIndexElement(int indexElement) {
                this.indexElement = indexElement;
            }

            private int getValueElement() {
                return valueElement;
            }

            private void setValueElement(int valueElement) {
                this.valueElement = valueElement;
            }
        }
    }

    public boolean isValueInList(int value) {

        int hash = calcHash(value);

        for (int i = 0; i < this.nodes.length; i++) {
            if (nodes[i].getHash() == hash) {
                for (int j = 0; j < nodes[i].getElements().size(); j++) {
                    Node.Element element = nodes[i].getElements().get(j);
                    if (element.getValueElement() == value) {
                       return true;
                    }
                }
            }
        }
        return false;
    }

    public void add(int value) {
        if (!isValueInList(value)) {

            /** находим ноду с нужным хэшем */
            Node node = Arrays.stream(this.nodes)
                    .filter(e -> e.getHash() == calcHash(value))
                    .findFirst()
                    .get();

            /** добавляем в конец списка */
            List<Node.Element> elementList =  node.getElements();
            Node.Element element = new Node.Element();
            element.setValueElement(value);                 // сохраняем значение добавляемого элемента в element
            element.setIndexElement(elementList.size());    // сохраняем индекс (он на 1 больше чем последний индекс списка elementList) добавляемого элемента в element
            elementList.add(element);                       // добавляем элемент в ноду, а эта нода уже есть в списке всех нод
        }
    }

    public void delete(int value){
        if (isValueInList(value)) {

            /** находим ноду с нужным хэшем */
            List<Node.Element> elements = Arrays.stream(nodes)
                    .filter(node -> node.getHash() == calcHash(value))
                    .findFirst()
                    .get()
                    .getElements();

            /** в ноде находим нужный элемент */
            Node.Element element = elements.stream().findFirst().
                    filter(el -> el.getValueElement() == value).
                    get();

            /** удаляем элемент из ноды */
            elements.remove(element);
        }
    }
}
