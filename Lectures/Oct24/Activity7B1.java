import java.util.Arrays;

public class Activity7B1 {

  public static void quickSort(int[] arr, int left, int right) {
    // make sure there is something still to sort
    if (left < right) {
      // partition the array
      int partitionValue = partition(arr, left, right);

      // recursively sort two partitions
      quickSort(arr, left, partitionValue - 1);
      quickSort(arr, partitionValue + 1, right);
    }
  }

public static int partition(int[] arr, int left, int right) {
    // Select a random index between left and right as the pivot
    int randomIndex = left + (int)(Math.random() * (right - left + 1));
    
    // Swap the pivot element with the first element (at 'left') so it can be treated as a pivot
    swap(arr, left, randomIndex);
    
    // Now the pivot is at the 'left' position
    int pivotValue = arr[left];
    int i = left + 1;
    int j = right;

    // Partition the array around the pivot
    while (i <= j) {
        while (i <= right && arr[i] < pivotValue) {
            i++;
        }
        while (j >= left && arr[j] > pivotValue) {
            j--;
        }

        if (i <= j) {
            swap(arr, i, j);
            i++;
            j--;
        }
    }

    // Move the pivot to its final place
    swap(arr, left, j);
    
    // Return the final position of the pivot
    return j;
}


  // Utility function to swap two elements in an array
  public static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void main(String[] args) {
    int[] arr = new int[]{3, 6, 4, 5, 7, 1, 2};
    System.out.println("Original array: " + Arrays.toString(arr));
    quickSort(arr, 0, arr.length - 1);
    System.out.println("Sorted array: " + Arrays.toString(arr));
  }
}
