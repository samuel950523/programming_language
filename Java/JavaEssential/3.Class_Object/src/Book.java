public class Book {
    String title;
    String author;

    public Book(String t) {
        title = t;
        author = "작자미상";
    }

    public Book(String t, String a) {
        title = t;
        author = a;
    }

    public static void main(String[] args) {
        Book javaBook = new Book("JAVA", "황기태");
        System.out.println(javaBook.title + " " + javaBook.author);
        Book bible = new Book("Bible");
        System.out.println(bible.title + " " + bible.author);
    }
}
