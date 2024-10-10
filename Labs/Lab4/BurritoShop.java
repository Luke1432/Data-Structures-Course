public class BurritoShop{
    Queue orders=new Queue();
    Queue transactions=new Queue();
    Stack dishes=new Stack();
    public static void main(String[] args) {
        
    }
    public void takeOrder(Burrito burrito){
        orders.enqueue(burrito);
    }
    public void makeOrder(){
        if(orders.isEmpty()){
            System.out.println("There are no orders to make. ");
        }else{
            transactions.enqueue(orders.dequeue());
            dishes.push("Plate");
        }
    }
    
    public void ringOutTransaction(){
        if(!transactions.isEmpty()){
            System.out.println(transactions.dequeue().toString());
        }else{
            System.out.println("There are no transactions, please take more orders.");
        }
    }
    public void washDish(){
        if(dishes.isEmpty()){
            System.out.println("No dishes to wash. ");
        }else{
            dishes.pop();
        }
    }
    public void washAllDishes(){
        while(!dishes.isEmpty()){
            washDish();
        }
        System.out.println("All dishes washed. ");
    }
    public boolean dishesInSink(){
        return dishes.isEmpty();
    }
    public int orderCount(){
        return orders.getSize();
    }
    public int transactionCount(){
        return transactions.getSize();
    }
}