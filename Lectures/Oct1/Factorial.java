public class Factorial{
    public static void main(String[] args) {
        for(int i=0; i<=10; i++){
            System.out.printf("%10d %10d%n",recursiveFactorial(i),iterativeFactorial(i));
        }
    }
    public static int iterativeFactorial(int n){
        int fact=1;
        for(int i=1; i<=n; i++){
            fact*=i;
        }
        return fact;

    }
    public static int recursiveFactorial(int n){
        if(n==0){
            return 1;
        }
        return n*recursiveFactorial(n-1);
    }
}