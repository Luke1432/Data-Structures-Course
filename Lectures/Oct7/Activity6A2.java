import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Activity6A2 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        int[][] results = generateSubsets(nums);
        
        for (int[] subset : results) {
            System.out.println(Arrays.toString(subset));
        }
    }

    public static int[][] generateSubsets(int[] numbers) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());

        for (int num : numbers) {
            int size = subsets.size();
            for (int i = 0; i < size; i++) {
                List<Integer> newSubset = new ArrayList<>(subsets.get(i));
                newSubset.add(num);
                subsets.add(newSubset);
            }
        }

        int[][] result = new int[subsets.size()][];
        for (int i = 0; i < subsets.size(); i++) {
            List<Integer> subset = subsets.get(i);
            int[] subsetArray = new int[subset.size()];
            for (int j = 0; j < subset.size(); j++) {
                subsetArray[j] = subset.get(j);
            }
            result[i] = subsetArray;
        }
        return result;
    }
}