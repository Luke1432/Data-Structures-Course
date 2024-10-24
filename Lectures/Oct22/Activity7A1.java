import java.util.Arrays;

public class Activity7A1{
    public static void main(String[] args){
        int[] test={4, 2, 6, 1, 8, 9};
        test=selectionSort(test);
        System.out.println(Arrays.toString(test));
    }
    public static int[] selectionSort(int[] arrayToSort){
        for (int currentIndex = 0; currentIndex < arrayToSort.length - 1; currentIndex++) {
            int minIndex=currentIndex;
            for (int i = currentIndex + 1; i < arrayToSort.length; i++) {
                if(arrayToSort[minIndex]>arrayToSort[i]){
                    minIndex=i;
                }
            }
            int temp=arrayToSort[minIndex];
            arrayToSort[minIndex]=arrayToSort[currentIndex];
            arrayToSort[currentIndex]=temp; 
        }
        return arrayToSort;
    }
}