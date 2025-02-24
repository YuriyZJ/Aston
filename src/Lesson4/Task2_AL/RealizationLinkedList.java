package Lesson4.Task2_AL;

import java.util.Arrays;
import java.util.Collection;

public class RealizationLinkedList<T> {
    private Object[] elements;
    private int size;

    public RealizationLinkedList() {
        elements = new Object[10]; // Стартовый размер массива
        size = 0;
    }

    // Добавление элемента
    public void add(T element) {
        ensureCapacity();
        elements[size++] = element;
    }

    // Получение элемента по индексу
    public T get(int index) {
        checkIndex(index);
        return (T) elements[index];
    }

    // Удаление элемента по индексу
    public void remove(int index) {
        checkIndex(index);
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        elements[--size] = null; // Убираем ссылку на объект
    }

    // Добавление коллекции
    public void addAll(Collection<? extends T> collection) {
        for (T item : collection) {
            add(item);
        }
    }

    // Сортировка пузырьком с флагом (только для Comparable)
    public void bubbleSort() {
        if (size <= 1) {
            return;
        }

        boolean swapped;
        for (int i = 0; i < size - 1; i++) {
            swapped = false;
            for (int j = 0; j < size - 1 - i; j++) {
                Comparable<T> a = (Comparable<T>) elements[j];
                Comparable<T> b = (Comparable<T>) elements[j + 1];
                if (a.compareTo((T) b) > 0) {
                    swap(j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    private void swap(int i, int j) {
        Object temp = elements[i];
        elements[i] = elements[j];
        elements[j] = temp;
    }

    // Увеличение емкости массива
    private void ensureCapacity() {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 2);
        }
    }

    // Проверка индекса
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    // Вывод списка
    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(elements, size));
    }
}
