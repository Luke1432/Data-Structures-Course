import java.util.Scanner;

public class NumbersGame{
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(true){
            System.out.println("Welcome to the Numbers Game \n 1. Factorials \n 2. Fibonacci Numbers \n 3. Powers \n 0. Exit");
            System.out.println("Which option would you like to select?");
            int input=in.nextInt();
            switch (input) {
                case 0:
                    System.out.println("Goodbye!");
                    System.exit(0);
                case 1:
                    {
                        System.out.println("Which number would you like the factorial of?");
                        int number=in.nextInt();
                        System.out.println("The factorial of "+number+" is: "+factorial(number));
                        break;
                    }
                case 2:
                    {
                        System.out.println("Which fibonacci number would you like? ");
                        int number=in.nextInt();
                        System.out.println("The "+number+". fibonacci number is: "+fibonacci(number));
                        break;
                    }
                case 3:
                    {
                        System.out.println("Which number do you want the power of? ");
                        int number=in.nextInt();
                        System.out.println("Which power of "+number+" do you want?");
                        int power=in.nextInt();
                        System.out.println("The "+power+". power of "+number+" is "+pow(number, power));
                        break;
                    }
                default:
                    break;
            }
        }
    
    }
    public static int factorial(int number){
        if(number==0){
            return 1;
        }
        else{
            return number*factorial(number-1);
        }
    }
    public static int fibonacci(int number){
        if(number==0||number==1){
            return number;
        }else{
            return fibonacci(number-1)+fibonacci(number-2);
        }
    }
    public static int pow(int number, int power){
        if(power==0){
            return 1;
        }
        else{
            return number*pow(number, power-1);
        }
    }
}