import java.util.Scanner;
public class StringsGame{
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        System.out.println("Welcome to Word World\n 1. String Reversal\n 2. Palindrome Checker\n 3. Letter Count\n 0. Exit");
        System.out.println("Which option would you like to select?");
        int input=in.nextInt();
        in.nextLine();

        while(true){
            switch (input) {
                case 0:
                    System.out.println("Goodbye!");
                    System.exit(0);
                case 1:
                    {
                        System.out.println("Which string would you like to reverse?");
                        String word=in.nextLine();
                        System.out.println(word+" reversed is "+reverse(word));
                        break;
                    }
                case 2:
                    {
                        System.out.println("Which string would you like to check? ");
                        String word=in.nextLine();
                        System.out.println("The word "+word+" is "+(isPalindrome(word)?"a Palindrome. ":"not a palindrome. "));
                        break;
                    }
                case 3:
                    {
                        System.out.println("Which word do you want to count the letters of? ");
                        String word=in.nextLine();
                        System.out.println("Which letter would you like to count in "+word+"?");
                        String letter=in.nextLine();
                        System.out.println("There "+((count(word,letter.charAt(0))==1)?"is ":"are ")+count(word,letter.charAt(0))+" "+letter+"'s in "+word);
                        break;
                    }
                default:
                    break;
            }
            System.out.println("Welcome to Word World\n 1. String Reversal\n 2. Palindrome Checker\n 3. Letter Count\n 0. Exit");
            System.out.println("Which option would you like to select?");
            input=in.nextInt();
            in.nextLine();
        }
    }
    public static String reverse(String str){
        if(str.length()==0){
            return "";
        }
        if(str.length()==1){
            return str;
        }else{
            return reverse(str.substring(1,str.length()))+str.charAt(0);
        }
    }
    public static boolean isPalindrome(String str){
        if(str.length()==1){
            return true;
        }else{
            if(str.charAt(0)==str.charAt(str.length()-1)){
                return isPalindrome(str.substring(1,str.length()-1));
            }
        }
        return false;
    }

    public static int count(String str, char ch){
        if(str.length()==0){
            return 0;
        }
        else if(str.charAt(0)==ch){
            return 1+count(str.substring(1,str.length()),ch);
        }
        else{
            return count(str.substring(1,str.length()),ch);
        }
    }
}