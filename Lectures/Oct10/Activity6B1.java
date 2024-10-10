public class Activity6B1{
    public static void main(String[] args) {
        int[] test={6, 3, 4, 5, 9, 13, 17};
        System.out.println(findMin(test,0,test.length-1));
    }
    public static int findMin(int[] arr,int low, int high){
        if(low==high){
            return arr[low];
        }else{
            int midPoint=low+(high-low)/2;
            return Math.min(findMin(arr,low,midPoint),findMin(arr,midPoint+1,high));
        }
    }
}