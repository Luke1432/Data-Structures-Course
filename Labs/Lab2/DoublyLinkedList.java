

public class DoublyLinkedList<E>{
    int length;
    Node<E> head=new Node(0);
    Node<E> tail=new Node(0);

    void addToFront(E value){
        Node newNode=new Node(value);
       
        if(length==0){
            head=tail=newNode;
        }else{
            newNode.next=head;
            head.previous=newNode;
            head=newNode;
        }

        length++;
    }

    public int getLength(){
        return this.length;
    }

    public void removeFromFront(){
        head.setValue(head.next.getValue());
        head.previous=null;
        head=head.next;
        length--;   
    }

    public void addToEnd(E value){
        Node newNode=new Node(value);
        if(length==0){
            head=tail=newNode;
        }else{
            newNode.previous=tail;
            tail.next=newNode;
            tail=newNode;
        }
        length++;
    }
    public void removeFromEnd(){
        tail.setValue(tail.previous.getValue());
        tail=tail.previous;
        tail.next=null;
        length--;   
    }

    public void clear(){
        head = tail = null; // Reset head and tail to null
        length = 0;         // Set length to 0
    }
    
    @Override
     public String toString() {
       StringBuilder sb = new StringBuilder();
       sb.append("[");
       Node current = head;
       while (current != null) {
           sb.append(current.value);
           if (current.next != null) {
               sb.append(", ");
           }
           current = current.next;
       }
       sb.append("]");
       return sb.toString();
   }

}