public class Activity2A1{
    public static void main(String[] args){
        int[] values=new int[25];
        for(int i=0; i<values.length; i++){
            values[i]=(int)(Math.pow(2,i));
            System.out.print(values[i]+((i==values.length-1)?".":", "));
        }
    }
}