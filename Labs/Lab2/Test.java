public class Test{
    public static void main(String[] args) {
        DoublyLinkedList<Object> d=new DoublyLinkedList();
        d.addToFront(14);
        d.addToFront(15);
        d.addToFront(78);
        System.out.println(d.toString());
        d.removeFromFront();
        System.out.println(d.toString());
        d.addToEnd(41);
        System.out.println(d.toString());
        d.addToEnd(3431);
        System.out.println(d.toString());
        d.removeFromEnd();
        System.out.println(d.toString());
        d.clear();
        System.out.println(d.toString());
        d.addToEnd(9980);
        System.out.println(d.toString());
        d.addToEnd(Math.PI);
        System.out.println(d.toString());
        d.addToEnd(3);
        System.out.println(d.toString());
    }
}