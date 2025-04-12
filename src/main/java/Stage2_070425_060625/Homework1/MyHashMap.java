package Stage2_070425_060625.Homework1;

public class MyHashMap<K, V> {

    // массив для хранения пар «ключ-значение» в виде узлов. Здесь хранятся наши Node
    private Node<K, V>[] buckets;
    private int capacity = 16; // емкость хеш-таблицы по умолчанию (16) с коэффициентом загруженности (load factor) = 0.75

    @SuppressWarnings("unchecked") // аннотация нужна, тк Java не позволяет напрямую создавать generic-массивы (то есть ругается)
    public MyHashMap() {
        buckets = (Node<K, V>[]) new Node[capacity]; // Создаем массив Node (бакеты)
    }

    // вложенный класс для создания Node, в котором хранится ключ/значение/ссылка на след узел при создании цепочки в бакете
    private static class Node<K, V>{
        private final K key;
        private V value;
        private Node<K, V> next;

        // конструктор для параметризации
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private int indexOf(K key) {
        int index = Math.abs(key.hashCode() % capacity); // 1. Вычисляем индекс бакета (от 0 до 15)
        return index;
    }

    public void put(K key, V value) {
        // 1. Вычисли индекс: hashCode() % capacity
        // 2. Проверь: если по этому индексу null — добавь Node
        // 3. Иначе — пройдись по цепочке:
        //    - если key уже есть — обнови value
        //    - иначе — добавь новый Node в конец
        int index = indexOf(key);

        Node<K, V> current = buckets[index]; // 2. Получаем начало цепочки в этом бакете
        if (current == null) { // 3. Если бакет пустой по найденному индексу — просто вставляем новый узел
            buckets[index] = new Node<>(key, value);
            return;
        }

        Node<K, V> prev = null; // 4. Иначе — ищем существующий ключ или конец цепочки
        while (current != null) {
            if (current.key.equals(key)) { // Если ключ уже есть — обновляем значение
                current.value = value;
                return;
            }
            prev = current;
            current = current.next; // Каждый Node — это как элемент связанного списка, и у него есть поле .next, указывающее на следующий узел. Проходимся по всем Node в цепи.
        }

        prev.next = new Node<>(key, value); // 5. Ключа не было — добавляем новый узел в конец цепочки
    }

    public V get(K key) {
        // 1. Вычисли индекс
        // 2. Пройдись по цепочке:
        //    - если key найден — верни value
        //    - если нет — верни null

        int index = indexOf(key);

        Node<K, V> current = buckets[index];
        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return current.value;
    }

    public void remove(K key){
        // 1. Вычисли индекс
        // 2. Пройдись по цепочке:
        //    - если key найден — удали Node (правильно обойтись с next)

        int index = indexOf(key);

        Node<K, V> current = buckets[index];
        Node<K, V> prev = null;
        while (current != null) {
            if (current.key.equals(key)) {
                if (prev == null) {
                    buckets[index] = current.next; // Это значит, удаляемый элемент — самый первый в цепочке
                } else {
                    prev.next = current.next; // Пропускаем текущий элемент в цепочке
                }            }
            prev = current;
            current = current.next;
        }
        System.out.println("Removed key: " + key);
    }

    public boolean replace(K key, V oldValue, V newValue) {

        int index = indexOf(key);

        Node<K, V> current = buckets[index];
        while (current != null) {
            if (current.key.equals(key)) {
                V v = current.value;
                if (v == oldValue || (v != null && v.equals(oldValue))) {
                    current.value = newValue;
                    return true;
                } else {
                    return false;
                }
            }
            current = current.next;
        }
        return false;
    }

    public void print() {
        for (int i = 0; i < capacity; i++) {
            Node<K, V> current = buckets[i];
            System.out.print("[" + i + "]: ");
            while (current != null) {
                System.out.print(current.key + "=" + current.value + " → ");
                current = current.next;
            }
            System.out.println("null");
        }
    }
}
