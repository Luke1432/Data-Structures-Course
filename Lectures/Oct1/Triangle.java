public class Triangle{
    public static void main(String[] args) {
        
    }
    public int triangle(int rows){
        if(rows==0 || rows==1){
            return rows;
        }
        else{
            return rows+triangle(rows-1);
        }
    }
}