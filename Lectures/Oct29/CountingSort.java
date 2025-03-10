public class CountingSort {

  public static int findMin(int[] arr){
    int minValue=Integer.MAX_VALUE;
    for(int i=0; i<arr.length; i++){
      minValue=Math.min(arr[i],minValue);
    }
    return minValue;
  }

  public static int findMax(int[] arr){
    int maxValue=Integer.MIN_VALUE;
    for(int i=0; i<arr.length; i++){
      maxValue=Math.max(arr[i],maxValue);
    }
    return maxValue;
  }

  // Stable Counting Sort with max value as parameter
  public static void countingSort(int[] arr, int maxValue) {
    int minValue=findMin(arr);
    shiftArray(arr,minValue);
    maxValue-=minValue;

    // create a count array and sorted array
    int[] count = new int[maxValue+1];
    int[] sorted = new int[arr.length];

    // Step 1: Store the count of each element
    for (int i : arr) {
      count[i]++;
    }

    // Step 2: Calculate the running total (cumulative count)
    for (int i = 1; i < count.length; i++) {
      count[i] += count[i-1];
    }

    // Step 3: Build the sorted array in reverse for stability
    for(int i=arr.length-1; i>=0; i--){
      int value=arr[i];
      count[value]--;
      int index=count[value];
      sorted[index]=value;
    }

    shiftArray(sorted, -minValue);
    // Step 4: Copy sorted array back to original array
    System.arraycopy(sorted, 0, arr, 0, arr.length);
  }

  public static void shiftArray(int[] arr, int shift) {
    for (int i = 0; i < arr.length; i++) {
      arr[i]+= -shift;
    }
  }

  public static int findShift(int[] arr) {
    int min = Integer.MAX_VALUE;
    for (int i : arr) {
      min = Math.min(min, i);
    }
    return min;
  }

  // Test method
  public static void main(String[] args) {
    int[] arr = {4, 2, -1, 6, 5, 2, 4, 1};
    int maxValue = 6;

    System.out.println("Original array:");
    printArray(arr);

    countingSort(arr, maxValue);

    System.out.println("Sorted array:");
    printArray(arr);
  }

  // Helper method to print an array
  private static void printArray(int[] arr) {
    for (int num : arr) {
      System.out.print(num + " ");
    }
    System.out.println();
  }
}
