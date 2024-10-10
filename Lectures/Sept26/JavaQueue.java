import java.util.Queue;
import java.util.Stack;

public class JavaQueue{
    public static void main(String[] args) {
        Stack s=new Stack();
        String book1="The Hobbit";
        String book2="Fellowship of the Ring";
        String book3="The Two Towers";
        String book4="Return of the King";
        String[] books={book1,book2,book3,book4};
        s.add(book1);
        s.add(book2);
        s.add(book3);
        s.add(book4);
        Queue<Integer> ratings = null;
        ratings.add(Integer.valueOf(String.valueOf(Math.round(Math.random()%10))));

        for(int i=1; i<4; i++){
            ratings.add(Integer.valueOf(String.valueOf(Math.round(Math.random()%10))));
        }
        
        for(int i=0; i<4; i++){
            System.out.println(books[i]+" is rated a "+ratings.peek());
        }

    }
}