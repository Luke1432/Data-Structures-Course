public class SumDigits{
    public static void main(String[] args) {
        sumDigits(17);
    }

    public static int sumDigits(int n){
        if(n>=0 && n<10){
            return n;
        }
        return n%10+sumDigits(n/10);
    }
}