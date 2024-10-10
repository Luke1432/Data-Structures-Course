
public class Test{
    public String Test(String str) {
    if(str.length()==0){
        return str;
    }else if(str.charAt(0)=='p' && str.charAt(1)=='i'){
        return "3.14"+str.substring(2,str.length());
    }
        return str.substring(1,str.length());
    }
    public static void main(String[] args){

    }
}
