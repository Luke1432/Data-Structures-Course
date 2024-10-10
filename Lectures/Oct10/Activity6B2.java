import java.util.Arrays;
public class Activity6B2{
    public static void main(String[] args) {
        int[] test={1, 34, 6, 4};
        System.out.println(sumElements(test));
    }
    public static int sumElements(int[] arr){
        if(arr.length==0){
            return 0;
        }
        else if(arr.length==1){
            return arr[0];
        }
        else if(arr.length==2){
            return arr[0]+arr[1];
        }
        else{
            int midPoint=arr.length/2;
            return (sumElements(Arrays.copyOfRange(arr, 0, midPoint))+sumElements(Arrays.copyOfRange(arr, midPoint, arr.length)));
        }
    }
}