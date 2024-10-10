
public class LibraryCheckoutTest{
    public static void main(String[] args) {
        LibraryCheckoutSystem c=new LibraryCheckoutSystem();
        System.out.println(c.isCheckoutEmpty());
        c.checkoutBook(1738);
        System.out.println(c.isCheckoutEmpty());
        c.checkoutBook(69);
        System.out.println(c.isCheckoutEmpty());
        c.checkoutBook(420);
        System.out.println(c.isCheckoutEmpty());
        System.out.println(c.returnBook());
        System.out.println(c.peekLastCheckedOut());
    }
}