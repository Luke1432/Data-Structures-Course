import java.util.Stack;

public class LibraryCheckoutSystem {
   final private Stack<Integer> books = new Stack<>();
   public void checkoutBook(int bookId) {
     books.push(bookId);
   }
   public int returnBook() {
     return books.pop();
   }
   public int peekLastCheckedOut() {
     return books.peek();
   }
   public boolean isCheckoutEmpty() {
     return books.isEmpty();
   }
}