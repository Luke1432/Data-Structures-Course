import java.util.HashMap;
import java.util.Objects;

class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return title + " by " + author;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Book book = (Book) obj;
        return title.equals(book.title) && author.equals(book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author);
    }
}

interface BookMapInterface {
    void add(Book book);
    void remove(Book book);
    boolean contains(Book book);
    int size();
}

class BookMap implements BookMapInterface {
    private HashMap<Book, Integer> bookMap;

    public BookMap() {
        bookMap = new HashMap<>();
    }

    @Override
    public void add(Book book) {
        bookMap.put(book, 1);
    }

    @Override
    public void remove(Book book) {
        bookMap.remove(book);
    }

    @Override
    public boolean contains(Book book) {
        return bookMap.containsKey(book);
    }

    @Override
    public int size() {
        return bookMap.size();
    }

    public static void main(String[] args) {
        BookMap bookCollection = new BookMap();

        Book book1 = new Book("1984", "George Orwell");
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee");

        bookCollection.add(book1);
        bookCollection.add(book2);

        System.out.println("Contains 1984? " + bookCollection.contains(book1));
        System.out.println("Contains To Kill a Mockingbird? " + bookCollection.contains(book2));

        bookCollection.remove(book1);
        System.out.println("Contains 1984? " + bookCollection.contains(book1));

        System.out.println("Size of book collection: " + bookCollection.size());
    }
}
