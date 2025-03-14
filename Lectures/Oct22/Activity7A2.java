public class Activity7A2 {
    static void mergeSort(String arr[], int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;

            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            int n1 = m - l + 1;
            int n2 = r - m;

            String L[] = new String[n1];
            String R[] = new String[n2];

            for (int i = 0; i < n1; ++i) {
                L[i] = arr[l + i];
            }
            for (int j = 0; j < n2; ++j) {
                R[j] = arr[m + 1 + j];
            }

            int i = 0, j = 0, k = l;
            while (i < n1 && j < n2) {
                if (L[i].compareTo(R[j]) <= 0) {
                    arr[k] = L[i];
                    i++;
                } else {
                    arr[k] = R[j];
                    j++;
                }
                k++;
            }

            while (i < n1) {
                arr[k] = L[i];
                i++;
                k++;
            }

            while (j < n2) {
                arr[k] = R[j];
                j++;
                k++;
            }
        }
    }

    public static void main(String[] args) {
        String arr[] = {"banana", "apple", "cherry", "date"};
        int n = arr.length;

        mergeSort(arr, 0, n - 1);

        System.out.println("Sorted array:");
        for (String str : arr) {
            System.out.print(str + " ");
        }
    }
}
