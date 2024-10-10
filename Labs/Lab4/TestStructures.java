
public class TestStructures{
    public static void main(String[] args) {
        Stack s=new Stack();
        Queue q=new Queue();
        for(int i=0; i<5; i++){
            int value=(int)Math.round(Math.random()*10)%20;
            s.push(value);
        }
        while(!s.isEmpty()){
            System.out.println("Stack first pop: "+s.pop());
        }

        for(int i=0; i<3; i++){
            int value=(int)Math.round(Math.random()*10)%30;
            s.push(value);
        }
        while(!s.isEmpty()){
            System.out.println("Stack peek: "+ s.peek());
            q.enqueue(s.pop());
        }
        
        while(!q.isEmpty()){
            System.out.println("Queue first dequeue: "+q.dequeue());
        }
        System.out.println("Stack empty pop: "+s.pop());
        System.out.println("Queue empty dequeue: "+q.dequeue());
    }
}