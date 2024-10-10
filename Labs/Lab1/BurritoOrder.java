
public class BurritoOrder{
    public static void main(String[] args){
        Burrito b1=new Burrito();
        Burrito b2=new Burrito("large", "sofritas");
        Burrito b3=new Burrito("large", "steak", "white", "black", "salsa", true);
        Burrito b4=new Burrito("small", "chicken", "brown", "black", "cheese, lettuce, ", false);
        Burrito b5=new Burrito("small", "beef", "white", "brown", "tomatoes, olives, ", false);
        Burrito b6=new Burrito("large", "steak", "brown", "black", "ranch", false);
        System.out.println("Burrito 1: "+b1.toString());
        System.out.println("Burrito 2: "+b2.toString());
        System.out.println("Burrito 3: "+b3.toString());
        System.out.println("Burrito 4: "+b4.toString());
        System.out.println("Burrito 5: "+b5.toString());
        System.out.println("Burrito 6: "+b6.toString());

    }
}