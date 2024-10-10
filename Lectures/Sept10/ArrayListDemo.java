import java.util.*;

public class ArrayListDemo{
    public static void main(String[] args) {
        ArrayList<Double> arrList=new ArrayList<>();
        arrList.add(3.141592653589);
        arrList.add(2.718);
        arrList.add(69.0);
        arrList.add(420.1);

        System.out.println(arrList);
        arrList.add(3, -0.098765321);

        System.out.println(arrList);
        System.out.println(arrList.get(3));

        for(int i=0; i<arrList.size(); i++){
            arrList.set(i, (Math.random()*100)+1);
        }

        System.out.println(arrList);

        while(!arrList.isEmpty()){
            arrList.remove(0);
            System.out.println(arrList);
        }
        arrList.add(5.5);
        System.out.println(arrList);


        System.out.println("List contains 5.5? "+(arrList.contains(5.5)?"Yes":"No"));
    }
}