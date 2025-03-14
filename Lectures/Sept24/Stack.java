public class Stack<E>{
    private Node<E> top;
    private int size;
    public Stack(){
        this.top=null;
        this.size=0;
    }

    public int size(){
        return this.size;
    }

    public boolean empty(){
        return this.size==0;
    }

    public E peek(){
        return empty()?null:this.top.value;
    }

    public void push(E e){
        Node<E> newNode=new Node(e);
        if(!empty()){
            newNode.next=this.top;
        }
        this.top=newNode;
        this.size++;
    }

    public E top(){
        return top.value;
    }
    public E pop(){
        if(empty()){
            System.out.println("Stack is empty, cannot pop.");
            return null;
        }
        else{
            E value=this.top.value;
            this.top=this.top.next;
            this.size--;
            return value;
        }
    }

    private class Node<E>{
        E value;
        Node<E> next;
        Node(E value){
            this.value=value;
            this.next=null;
        }
    }
}