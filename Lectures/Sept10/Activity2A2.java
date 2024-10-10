import java.util.ArrayList;

public class Activity2A2{
    public static void main(String[] args){
        ArrayList<Integer> values=new ArrayList<>();
        for(int i=0; i<values.size(); i++){
            values.add((int)Math.pow(2,i));
            System.out.print(values.get(i)+((i==values.size()-1)?".":", "));
        }
    }
}