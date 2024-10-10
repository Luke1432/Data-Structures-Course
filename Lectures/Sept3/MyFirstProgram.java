public class MyFirstProgram{
    public static void main(String[] args){
        int age=getAge(2004, true);
        System.out.println("I am "+age+" years old.");
    }
    public static int getAge(int year, boolean hadBirthday){
        int age=2024-year;
        if(!hadBirthday){
            age--;
        }
        return age;
    }
}