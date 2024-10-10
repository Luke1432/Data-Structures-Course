public class Recursion{
    public static void main(String[] args) {
        // System.out.println(oddOdd(0));
        // System.out.println(oddOdd(3));
        // System.out.println(oddOdd(7));
        // System.out.println(oddOdd(37));
        // System.out.println(oddOdd(505));
        System.out.println(oddOdd(1234567));
    }
    public static boolean oddOdd(int n){
        System.out.println(n);
        if (n>=0 && n<10){
            return (n%2==1);
        }else{
            return oddOdd(n/10) ^ (n%10%2==1);
        }
    }
}