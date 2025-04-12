package Stage1_110225_040425.Lesson2.reference;

class DemoClassRef {
    public static void main(String[] args) throws ClassNotFoundException {

        Cat murka = new Cat("Murka");
        String type = Cat.type;
        Cat vasya = new Cat("Vasya");
        Cat.print();



        var murkaNew = new Cat("Murka");

        if (murka != murkaNew) {
            System.out.println("Коты разные");
        } else if (murka == murkaNew){
            System.out.println("Кот один");
        }
//
//
//
//
//        murkaNew = murka;
//
//        if (murka != murkaNew) {
//            System.out.println("Коты разные");
//        } else {
//            System.out.println("Кот один");
//        }

    }
}
