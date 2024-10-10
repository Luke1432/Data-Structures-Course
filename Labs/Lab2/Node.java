public class Node<E>{
    Object value;
    Node previous;
    Node next;

    Node(Object value){
        this.value=value;
        this.previous=null;
        this.next=null;
    }

    public Object getValue(){
        return this.value;
    }
    public void setValue(Object value){
        this.value=value;
    }

    public Object getPrevious(){
        return this.previous;
    }

    public void setPrevious(Node newPrevious){
        this.previous=newPrevious;
    }

    public Object getNext(){
        return this.next;
    }

    public void setNext(Node newNext){
        this.next=newNext;
    }

}