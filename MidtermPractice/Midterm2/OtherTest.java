import java.util.Arrays;

public class OtherTest {

    public static void mergeSort(int[] array) {
        if (array.length < 2) {
            return; // Base case: array is already sorted if it has 1 or 0 elements
        }

        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);

        // Recursively split and sort both halves
        mergeSort(left);
        mergeSort(right);

        // Merge the sorted halves
        merge(array, left, right);
    }

    public static void merge(int[] array, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        // Merge the two halves into the original array
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }

        // Copy any remaining elements from the left half
        while (i < left.length) {
            array[k++] = left[i++];
        }

        // Copy any remaining elements from the right half
        while (j < right.length) {
            array[k++] = right[j++];
        }
    }

    public static void main(String[] args) {
        int[] array = {38, 27, 43, 3, 9, 82, 10};
        System.out.println("Original Array: " + Arrays.toString(array));

        mergeSort(array);

        System.out.println("Sorted Array: " + Arrays.toString(array));
    }
}
