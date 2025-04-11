package Stage1_110225_040425.Lesson4.Task3_LL;

public class Main {
    public static void main(String[] args) {
        RealizationLinkedList<Integer> list1 = new RealizationLinkedList<>();
        list1.add(1);
        list1.add(5);
        list1.add(3);
        list1.add(6);
        list1.add(1);
        System.out.println("Before sorting LIST1: " + list1);
        list1.bubbleSort();
        System.out.println("After sorting LIST1: " + list1);
        System.out.println();

        RealizationLinkedList<Integer> list2 = new RealizationLinkedList<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(4);
        list2.add(5);
        System.out.println("Before sorting LIST2: " + list2);
        list2.bubbleSort();
        System.out.println("After sorting LIST2: " + list2);
        System.out.println();

        RealizationLinkedList<Integer> list3 = new RealizationLinkedList<>();
        list3.add(1);
        list3.add(1);
        list3.add(1);
        list3.add(1);
        list3.add(1);
        System.out.println("Before sorting LIST3: " + list3);
        list3.bubbleSort();
        System.out.println("After sorting LIST3: " + list3);
        System.out.println();

        RealizationLinkedList<Integer> list4 = new RealizationLinkedList<>();
        System.out.println("Before sorting LIST4: " + list4);
        list4.bubbleSort();
        System.out.println("After sorting LIST4: " + list4);
        System.out.println();

        RealizationLinkedList<Integer> list5 = new RealizationLinkedList<>();
        list5.add(1000);
        list5.add(144);
        list5.add(31111);
        list5.add(3148);
        list5.add(148136);
        System.out.println("Before LIST5: " + list5);

        list5.removeFirst();
        list5.removeLast();
        list5.remove(2);
        System.out.println(list5.get(1));
        System.out.println(list5.size());

        System.out.println("After LIST5: " + list5);
    }
}
