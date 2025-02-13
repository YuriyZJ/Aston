package Lesson2.interfaces;


class Book implements BookPrintable, Searchable {

    String name;
    String author;

    Book(String name, String author) {

        this.name = name;
        this.author = author;
    }

    @Override
    public void print() {
        System.out.printf("%s (%s) \n", name, author);
    }


    @Override
    public void paint() {
        System.out.printf("Paint title for %s (%s) \n", name, author);
    }
}