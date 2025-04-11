package Stage1_110225_040425.Lesson4.Task3_LL;

//LinkedList. Это связный список, состоящий из узлов, где каждый узел содержит данные и ссылку на следующий элемент.
//Значит, нужно создать класс Node с полями data и next.
//Каждый узел содержит ссылку на следующий, и таким образом формируется цепочка.

public class RealizationLinkedList<T> {
    private Node<T> head; //первый узел
    private Node<T> tail; //последний узел
    private int size; // количество элементов

    //вложенный класс, предназначен для
    private static class Node<T> {
        private T data; // хранимое значение
        private Node<T> next; //ссылка на следующий узел
        private Node<T> prev; //ссылка на предыдущий узел

        Node(T data){
            this.data = data;
        }

        Node(T data, Node<T> next, Node<T> prev){
            this.data = data;
            this.next = next;
            this.prev = next;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }
    }

    public Node<T> getHead() {
        return head;
    }

    public void add (T element){
        Node<T> newNode = new Node<>(element);
        if (head == null) { // Если список пустой, оба указателя указывают на новый узел
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode; // Если список не пустой, добавляем в конец
            newNode.prev = tail; // Устанавливаем ссылку на предыдущий элемент
            tail = newNode; // Обновляем tail
        }
        size++;
    }

    public void removeFirst (){
        if (head == null){ // Если список пуст, ничего не делаем
            return;
        }

        if (head == tail){ // Если это единственный элемент в списке
            head = null;
            tail = null;
        } else { // Если элементов больше одного
            head = head.next;
            head.prev = null; // Обновляем ссылку на предыдущий элемент
        }
        size--;
    }

    public void removeLast (){
        if (tail == null) {
            return;
        }

        if (head == tail){
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
    }

    public void remove (int index){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        if (index == 0){
            removeFirst();
            return;
        }

        if (index == size - 1){
            removeLast();
            return;
        }

        Node<T> current;
        if (index < size / 2){ // Если индекс ближе к началу списка
            current = head;
            for (int i = 0; i < index; i++){
                current = current.next;
            }
        } else { // Если индекс ближе к концу списка
            current = tail;
            for (int i = size -1; i > index; i--){
                current = current.prev;
            }
        }

        // Обновляем ссылки для предыдущего и следующего узлов
        //После того, как ссылки соседей обновлены, элемент фактически удаляется, потому что больше на него нет ссылок в других узлах.
        //Используется сборщик мусора, он позаботится об освобождении памяти.
        current.prev.next = current.next;
        current.next.prev = current.prev;
        size--;
    }

    public T get (int index){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        Node<T> current;
        if (index < size / 2){
            current = head;
            for (int i = 0; i < index; i++){
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size -1; i > index; i--){
                current = current.prev;
            }
        }
        return current.data;
    }

    public void addAll(RealizationLinkedList<T> newList){
        if (newList == null){
            throw new IllegalArgumentException("List is null");
        }

        Node<T> current = newList.getHead();
        while (current != null){
            add(current.data);
            current = current.next;
        }
    }

    public void clear() {
        head = tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public void bubbleSort(){
        if (head == null || head.next == null) {
            return; //Список пуст или состоит из одного элемента
        }

        boolean swapped; // Флаг, который отслеживает, были ли изменения

        do {
            swapped = false; // Сначала считаем, что изменений нет
            Node<T> current = head;

            while (current != null && current.next != null) {
                // Сравниваем текущий элемент с следующим
                if (((Comparable<T>)current.data).compareTo(current.next.data) > 0) {
                    // Если порядок неправильный, меняем их местами
                    T temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;

                    swapped = true; // Мы сделали изменение, флаг в true
                }

                current = current.next; // Переходим к следующему элементу
            }
        } while (swapped); // Если изменений не было, завершить сортировку
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> current = head;
        while (current != null) {
            sb.append(current.getData()).append(" ");
            current = current.next;
        }
        return sb.toString().trim();
    }
}

//Далее, класс MyLinkedList должен содержать ссылку на голову списка (head) и, возможно, размер списка (size) для удобства.
// Метод add может быть реализован добавлением элемента в конец списка.
// Нужно проверить, пуст ли список. Если да, то новый узел становится головой. Если нет, то проходим до последнего узла и добавляем новый.
// Также можно предусмотреть добавление по индексу, но в задании указаны основные методы, так что, возможно, достаточно add в конец.


//Метод get требует прохода по узлам до указанного индекса. Нужно убедиться, что индекс в пределах от 0 до size-1, иначе исключение.
// Для метода remove нужно найти узел по индексу, перекинуть ссылки предыдущего узла на следующий, чтобы исключить удаляемый узел из цепочки.
// Важно не забыть обработать случаи удаления головы или хвоста.
// Метод addAll(Collection<? extends T> collection) можно реализовать, добавляя все элементы коллекции поочередно через add.
// Здесь стоит обратить внимание на эффективность — если коллекция большая, но, возможно, для учебного примера это допустимо.