import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

/**
 * Class to analyze time complexity of sorting algorithms.
 */
public class ComplexityLab {

    public static void main(String[] args) {
        LinkedList<Integer> l1=new LinkedList<>();
        LinkedList<Integer> l2=new LinkedList<>();
        LinkedList<Integer> l3=new LinkedList<>();
        LinkedList<Integer> l4=new LinkedList<>();
        int[] a1=new int[10000];
        int[] a2=new int[10000];
        int[] a3=new int[10000];
        int[] a4=new int[10000];
        for(int i=0; i<a1.length; i++){
            Integer value=Integer.valueOf(String.valueOf(Math.round(Math.random()%100000)));
            l1.add(value);
            l2.add(value);
            l3.add(value);
            l4.add(value);
            a1[i]=value;
            a2[i]=value;
            a3[i]=value;
            a4[i]=value;
        }
        
        long startTime=System.nanoTime();
        long operations=quickSortArray(a1, 0, a1.length-1, 0);
        long endTime=System.nanoTime();
        long timeTaken=endTime-startTime;

        System.out.printf("%-16s %-15s %-15s %-15s\n","Sort Type","Data Structure", "Operations", "Runtime (ns)");
        System.out.printf("""
                          ---------------------------------------------------------------------
                          """);
        System.out.printf("%-16s %-15s %-15s %-15s\n","Quick Sort","Array", operations, timeTaken);
        
        startTime=System.nanoTime();
        operations=mergeSortArray(a2);
        endTime=System.nanoTime();
        timeTaken=endTime-startTime;
        
        System.out.printf("%-16s %-15s %-15s %-15s\n","Merge Sort","Array", operations, timeTaken);
        
        startTime=System.nanoTime();
        operations=insertionSortArray(a3);
        endTime=System.nanoTime();
        timeTaken=endTime-startTime;
        
        System.out.printf("%-16s %-15s %-15s %-15s\n","Insertion Sort","Array", operations, timeTaken);

        startTime=System.nanoTime();
        operations=selectionSortArray(a4);
        endTime=System.nanoTime();
        timeTaken=endTime-startTime;
        
        System.out.printf("%-16s %-15s %-15s %-15s\n","Selection Sort","Array", operations, timeTaken);

        startTime=System.nanoTime();
        operations=quickSortList(l1);
        endTime=System.nanoTime();
        timeTaken=endTime-startTime;
        
        System.out.printf("%-16s %-15s %-15s %-15s\n","Quick Sort","List", operations, timeTaken);

        startTime=System.nanoTime();
        operations=mergeSortList(l2);
        endTime=System.nanoTime();
        timeTaken=endTime-startTime;
        
        System.out.printf("%-16s %-15s %-15s %-15s\n","Merge Sort","List", operations, timeTaken);

        startTime=System.nanoTime();
        operations=insertionSortList(l3);
        endTime=System.nanoTime();
        timeTaken=endTime-startTime;
        
        System.out.printf("%-16s %-15s %-15s %-15s\n","Insertion Sort","List", operations, timeTaken);

        startTime=System.nanoTime();
        operations=selectionSortList(l4);
        endTime=System.nanoTime();
        timeTaken=endTime-startTime;
        
        System.out.printf("%-16s %-15s %-15s %-15s\n","Selection Sort","List", operations, timeTaken);

    }

    /**
     * Sorts an array using the quicksort algorithm.
     *
     * @param arr        The array to be sorted.
     * @param low        The index of the first element in the array.
     * @param high       The index of the last element in the array.
     * @param operations The number of operations performed during the sort.
     * @return The total number of operations performed during the sort.
     */
    public static long quickSortArray(int[] arr, int low, int high, long operations) {
        if (low < high) {
            PartitionResult result = partition(arr, low, high, operations);
            operations = quickSortArray(arr, low, result.pi - 1, result.operations);
            operations = quickSortArray(arr, result.pi + 1, high, operations);
        }
        return operations;
    }

    /**
     * Partitions the array for the quicksort algorithm.
     *
     * @param arr        The array to be partitioned.
     * @param low        The index of the first element in the array.
     * @param high       The index of the last element in the array.
     * @param operations The number of operations performed during the partition.
     * @return The partition index and the total number of operations performed during the partition.
     */
    private static PartitionResult partition(int[] arr, int low, int high, long operations) {
        operations +=2;
        int pivotIndex = ThreadLocalRandom.current().nextInt(low, high + 1);
        int pivot = arr[pivotIndex];

        int temp = arr[high];
        arr[high] = pivot;
        arr[pivotIndex] = temp;

        int i = low - 1;
        for (int j = low; j < high; j++) {
            operations++;
            if (arr[j] < pivot) {
                i++;
                operations++;
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return new PartitionResult(i + 1, operations);
    }

    /**
     * Sorts a linked list using the quicksort algorithm.
     *
     * @param list       The linked list to be sorted.
     * @return The total number of operations performed during the sort.
     */
    public static long quickSortList(LinkedList<Integer> list) {
        long operations = 0;
        if (list.size() <= 1) {
            return 0; // Already sorted or empty list
        }

        int pivotIndex = ThreadLocalRandom.current().nextInt(list.size());
        int pivot = list.remove(pivotIndex);

        LinkedList<Integer> left = new LinkedList<>();
        LinkedList<Integer> equal = new LinkedList<>();
        LinkedList<Integer> right = new LinkedList<>();

        for (Integer element : list) {
            operations++; // Counting comparison operation
            if (element < pivot) {
                left.add(element);
            } else if (element == pivot) {
                equal.add(element);
            } else {
                right.add(element);
            }
        }

        operations += (quickSortList(left)); // Counting recursive call operation
        operations += (quickSortList(right)); // Counting recursive call operation

        list.clear(); // This operation is not counted
        list.addAll(left); // This operation is not counted
        list.addAll(equal); // This operation is not counted
        list.add(pivot); // This operation is not counted
        list.addAll(right); // This operation is not counted

        return operations;
    }

    /**
     * Sorts an array using the merge sort algorithm.
     *
     * @param array The array to be sorted.
     * @return The total number of operations performed during the sort.
     */
    public static long mergeSortArray(int[] array) {
        if (array.length <= 1) {
            return 0;
        }

        int mid = array.length / 2;
        int[] leftHalf = Arrays.copyOfRange(array, 0, mid);
        int[] rightHalf = Arrays.copyOfRange(array, mid, array.length);

        long leftOperations = mergeSortArray(leftHalf);
        long rightOperations = mergeSortArray(rightHalf);
        long mergeOperations = mergeArrays(array, leftHalf, rightHalf);

        return leftOperations + rightOperations + mergeOperations;
    }

    /**
     * Merges two arrays for the merge sort algorithm.
     *
     * @param array     The array to be sorted.
     * @param leftHalf  The left half of the array.
     * @param rightHalf The right half of the array.
     * @return The total number of operations performed during the merge.
     */
    private static long mergeArrays(int[] array, int[] leftHalf, int[] rightHalf) {
        long operations = 0;
        int i = 0, j = 0, k = 0;

        while (i < leftHalf.length && j < rightHalf.length) {
            operations++;
            if (leftHalf[i] <= rightHalf[j]) {
                array[k++] = leftHalf[i++];
            } else {
                array[k++] = rightHalf[j++];
            }
        }

        while (i < leftHalf.length) {
            array[k++] = leftHalf[i++];
        }

        while (j < rightHalf.length) {
            array[k++] = rightHalf[j++];
        }

        return operations;
    }

    /**
     * Sorts a linked list using the merge sort algorithm.
     *
     * @param list The linked list to be sorted.
     * @return The total number of operations performed during the sort.
     */
    public static long mergeSortList(LinkedList<Integer> list) {
        if (list.size() <= 1) {
            return 0;
        }

        int mid = list.size() / 2;
        LinkedList<Integer> leftHalf = new LinkedList<>(list.stream().limit(mid).collect(Collectors.toList()));
        LinkedList<Integer> rightHalf = new LinkedList<>(list.stream().skip(mid).collect(Collectors.toList()));

        long leftOperations = mergeSortList(leftHalf);
        long rightOperations = mergeSortList(rightHalf);

        list.clear();
        long mergeOperations = mergeListsTail(list, leftHalf, rightHalf);

        return leftOperations + rightOperations + mergeOperations;
    }

    /**
     * Merges two linked lists for the merge sort algorithm.
     *
     * @param list      The destination linked list.
     * @param leftHalf  The left half of the list.
     * @param rightHalf The right half of the list.
     * @return The total number of operations performed during the merge.
     */
    private static long mergeListsTail(LinkedList<Integer> list, LinkedList<Integer> leftHalf, LinkedList<Integer> rightHalf) {
        long operations = 0;
        while (!leftHalf.isEmpty() && !rightHalf.isEmpty()) {
            operations++;
            if (leftHalf.peek() <= rightHalf.peek()) {
                list.add(leftHalf.poll());
            } else {
                list.add(rightHalf.poll());
            }
        }

        list.addAll(leftHalf);
        list.addAll(rightHalf);

        return operations;
    }

    /**
     * Sorts an array using the insertion sort algorithm.
     *
     * @param arr The array to be sorted.
     * @return The total number of comparisons performed during the sort.
     */
    public static long insertionSortArray(int[] arr) {
        long comparisons = 0;
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            comparisons++;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
                comparisons++;
            }
            arr[j + 1] = key;
        }
        return comparisons;
    }

    /**
     * Sorts a linked list using the insertion sort algorithm.
     *
     * @param list The linked list to be sorted.
     * @return The total number of comparisons performed during the sort.
     */
    public static long insertionSortList(LinkedList<Integer> list) {
        long comparisons = 0;
        int n = list.size();
        if (n <= 1) {
            return 0; // Already sorted or empty list
        }

        // Create a new sorted list
        LinkedList<Integer> sortedList = new LinkedList<>();

        // Iterate over the original list
        for (Integer current : list) {
            // Find the correct position to insert the current element in the sorted list
            ListIterator<Integer> sortedIterator = sortedList.listIterator();
            int index = 0;
            while (sortedIterator.hasNext()) {
                int sortedValue = sortedIterator.next();
                comparisons++;
                if (sortedValue > current) {
                    // Insert the current element into the sorted list
                    sortedList.add(index, current);
                    break;
                }
                index++;
            }

            if (!sortedIterator.hasNext()) {
                // If the current element is the largest, add it to the end
                sortedList.addLast(current);
            }
        }

        // Update the original list with the sorted copy
        list.clear();
        list.addAll(sortedList);

        return comparisons;
    }

    /**
     * Sorts an array using the selection sort algorithm.
     *
     * @param arr The array to be sorted.
     * @return The total number of comparisons performed during the sort.
     */
    public static long selectionSortArray(int[] arr) {
        long comparisons = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < arr.length; j++) {
                comparisons++;
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
        return comparisons;
    }

    /**
     * Sorts a linked list using the selection sort algorithm.
     *
     * @param list The linked list to be sorted.
     * @return The total number of comparisons performed during the sort.
     */
    public static long selectionSortList(LinkedList<Integer> list) {
        if (list.isEmpty()) {
            return 0;
        }

        long cost = 0;
        int n = list.size();

        for (int i = 0; i < n - 1; i++) {
            ListIterator<Integer> curr = list.listIterator(i);
            int minIndex = i;
            int minVal = curr.next();

            while (curr.hasNext()) {
                cost++;
                int tempVal = curr.next();
                if (tempVal < minVal) {
                    minIndex = curr.previousIndex();
                    minVal = tempVal;
                }
            }

            if (minIndex != i) {
                int temp = list.get(minIndex);
                list.set(minIndex, list.get(i));
                list.set(i, temp);
                cost++;
            }
        }
        return cost;
    }


    /**
     * Represents the result of partitioning an array for quick sort.
     */
    static class PartitionResult {
        int pi;
        long operations;

        /**
         * Constructs a PartitionResult object.
         *
         * @param pi         The partition index.
         * @param operations The total number of operations performed during partitioning.
         */
        PartitionResult(int pi, long operations) {
            this.pi = pi;
            this.operations = operations;
        }
    }
}

