public class Activity1B2{
    public static void main(String[] args){
        System.out.println("Test");
        Activity1B2 a=new Activity1B2();
        System.out.println(a.sum(1,2));
    }
    private int sum(int first, int second){
        return first+second;
    }
}