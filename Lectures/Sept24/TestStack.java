public class TestStack{
    public static void main(String[] args) {
        Stack myStack=new Stack<Double>();
        myStack.push(Math.PI);
        myStack.push(100.7);
        myStack.push(-69.420);
        System.out.println(myStack.size());
        System.out.println(myStack.peek());
        System.out.println(myStack.peek());

        while(!myStack.empty()){
            System.out.println(myStack.pop());
        }
    }
}