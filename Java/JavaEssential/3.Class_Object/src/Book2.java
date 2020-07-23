public class Book2 {
    String title;
    String author;

    void show() {
        System.out.println(title + " " + author);
    }

    public Book2() {
        this("", "");
        System.out.println("생성자 호출됨");
    }

    public Book2(String title) {
        this(title, "작자미상");
    }

    public Book2(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public static void main(String[] args) {
        Book2 javaBook = new Book2("JAVA", "황기태");
        Book2 bible = new Book2("Bible");
        Book2 emptyBook = new Book2();

        javaBook.show();
        bible.show();
        emptyBook.show();
    }


}
