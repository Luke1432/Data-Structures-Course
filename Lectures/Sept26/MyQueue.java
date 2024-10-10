public class MyQueue<E>{
    Node<E> front;
    Node<E> back;
    int size;

    public MyQueue(){
        this.front=null;
        this.back=null;
        this.size=0;
    }
    
    public int size(){
        return this.size;
    }

    public boolean empty(){
        return this.size==0;
    }

    public E peek(){
        if(empty()){
            return null;
        }else{
            return this.front.value;
        }
    }

    public void enqueue(E element){
        Node<E> toAdd=new Node<>(element);
        if(this.size==0){
            this.front=this.back=toAdd;
        }
        else{
            this.back.next=toAdd;
            this.back=toAdd;
        }
        this.size++;
    }

    public E dequeue(){
        Node<E> frontNode=this.front;
        if(empty()){
            return null;
        }else{
            if(size==1){
                this.front=null;
            }else{
                this.front=this.front.next;
            }
            this.size--;
            return frontNode.value;
        }
    }

    private class Node<E>{
        private E value;
        private Node<E> next;
        Node(E value){
            this.value=value;
            this.next=null;
        }
    }
}