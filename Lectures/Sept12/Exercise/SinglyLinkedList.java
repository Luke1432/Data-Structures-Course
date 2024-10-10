public class SinglyLinkedList<E> {

    Node<E> head;
    int size;

    public SinglyLinkedList() {
      this.head = null;
      size = 0;
    }

    public void add(E val){
      Node add=new Node(val);
      if(size==0){
        this.head=add;
      }else{
        Node temp=this.head;
        while(temp.next!=null){
          temp=temp.next;
        }
        temp.next = add;
      }
      size++;
    }

    public E get(int ind){
      int temp=0;
      if(ind>this.size-1 || this.size==0){
        return null;
      }else if (ind==0) {
          return this.head.value;
      }else{
        Node<E> ptr=this.head;
        while(temp<ind && ptr.next!=null){
          temp++;
          ptr=ptr.next;
        }
        return ptr.getValue();
      }
    }
    public void set(int ind, E val){
      Node<E> ptr = this.head;
      int i = 0;

      while (i < ind) {
          ptr = ptr.next;
          i++;
      }

      ptr.value = val;
    }

    public E remove(int ind){
      if (ind == 0) { // Removing the head
        E value = head.value;
        head = head.next;
        size--;
        return value;
      }

      Node<E> ptr=head;
      for(int i=0; i<ind-1; i++){
        ptr=ptr.next;
      }

      Node<E> nodeToRemove=ptr.next;
      ptr.next=nodeToRemove.next;
      size--;

      return nodeToRemove.value;

    }

    public int size(){
      return size;
    }

    public boolean contains(E val){
      return false;
    }

    public int indexOf(E val){
      return -1;
    }

    public void clear(){

    }

    @Override
    public String toString() {
      String result="[";
      
      Node temp=this.head;
      if(this.size!=0){
        while(temp.next!=null){
          result+=temp.value+", ";
          temp=temp.next;
        }
        result+=temp.value;
      }
      
      
      result+="]";
      return  result;
    }
    public static void main(String[] args) {
        SinglyLinkedList<Integer> list=new SinglyLinkedList<>();
        list.add(1);
        System.out.println(list.toString());
        list.add(200);
        System.out.println(list.toString());
        list.add(30);
        System.out.println(list.toString());
        list.add(4000);
        System.out.println(list.toString());
        list.remove(0);
        System.out.println(list.toString());
        list.set(1, 15);
        System.out.println(list.toString());
        list.clear();
        System.out.println(list.toString());

    }

}