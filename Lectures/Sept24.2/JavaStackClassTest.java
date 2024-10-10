import java.util.Stack;

public class JavaStackClassTest{
    public static void main(String[] args){
        Stack s=new Stack();
        s.push(Math.PI);
        s.push("Hello");
        System.out.println(s.peek());
        while(s.empty()){
            s.pop();
        }
        for (int i = 0; i < 10; i++) {
            s.push(Math.random()%10000);
        }
    }
}