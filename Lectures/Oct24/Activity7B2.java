
public class Activity7B2 {

    // Merge Sort function
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            // Find the middle point
            int middle = (left + right) / 2;

            // Recursively sort the two halves
            mergeSort(arr, left, middle);
            mergeSort(arr, middle + 1, right);

            // Merge the sorted halves
            merge(arr, left, middle, right);
        }
    }

    // Merge two sorted halves
    public static void merge(int[] arr, int left, int middle, int right) {
        // Find the sizes of the two subarrays to be merged
        int n1 = middle - left + 1;
        int n2 = right - middle;

        // Create temporary arrays
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; i++) {
            leftArray[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = arr[middle + 1 + j];
        }

        // Merge the temp arrays back into the original array
        int i = 0, j = 0;
        int k = left; // Initial index of merged subarray

        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copy the remaining elements of leftArray (if any)
        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy the remaining elements of rightArray (if any)
        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    // Quick Sort function
    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            // Partition the array and get the pivot index
            int partitionIndex = partition(arr, left, right);

            // Recursively sort elements before and after partition
            quickSort(arr, left, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, right);
        }
    }

    // Partition function for Quick Sort
    public static int partition(int[] arr, int left, int right) {
        // Choose the pivot (last element in this case)
        int pivot = arr[right];
        int i = left - 1; // index of the smaller element

        for (int j = left; j < right; j++) {
            // If the current element is smaller than or equal to the pivot
            if (arr[j] <= pivot) {
                i++;

                // Swap arr[i] and arr[j]
                swap(arr, i, j);
            }
        }

        // Swap the pivot element with the element at i+1
        swap(arr, i + 1, right);

        return i + 1; // Return the index of the pivot
    }

    // Utility function to swap two elements in an array
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int size=100000;
        int[] arr1=new int[size];
        int[] arr2=new int[size];
        for(int i=0; i<size; i++){
            arr1[i]=Integer.parseInt(String.valueOf(Math.round(Math.random()*100)));
            arr2[i]=Integer.parseInt(String.valueOf(Math.round(Math.random()*100)));
        }
        System.out.println("Arrays size: "+size);
        // Test Merge Sort
        // System.out.println("Original array (for Merge Sort): " + Arrays.toString(arr1));
        long mergeSortStartTime=System.nanoTime();
        mergeSort(arr1, 0, arr1.length - 1);
        long mergeSortEndTime=System.nanoTime();
        long mergeSortDuration=mergeSortEndTime-mergeSortStartTime;
        // System.out.println("Sorted array (Merge Sort): " + Arrays.toString(arr1));
        System.out.println("Mergesort execution time: "+mergeSortDuration+" ns");

        // Test Quick Sort
        // System.out.println("\nOriginal array (for Quick Sort): " + Arrays.toString(arr2));
        long quickSortStartTime=System.nanoTime();
        quickSort(arr2, 0, arr2.length - 1);
        long quickSortEndTime=System.nanoTime();
        long quickSortDuration=quickSortEndTime-quickSortStartTime;
        // System.out.println("Sorted array (Quick Sort): " + Arrays.toString(arr2));
        System.out.println("Quicksort execution time: "+quickSortDuration+" ns");
    }
}
