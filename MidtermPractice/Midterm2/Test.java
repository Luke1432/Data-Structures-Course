public class Test{
    public static void main(String[] args) {
        System.out.println(countCharacter("applepppp1324septic",'p',0));
    }

    public static int sumOfDigits(int n){
        if(n<10){
            return n;	
        }
        return n%10+sumOfDigits(n/10);
    }
    public static int countCharacter(String str, char target, int index) {
        int count=0;
        if(str.length()==1){
            return str.charAt(0)==target?++count:count;
        }
        if(str.charAt(0)==target){
            count++;
        }
        return count+countCharacter(str.substring(1), target, index);
    }
}