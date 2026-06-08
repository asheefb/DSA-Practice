package Arrays;

public class ShuffleTheArray {
    public static int[] shuffle(int[] nums, int n) {
        int[] res = new int[2 * n];
        int k = 0;

        for (int i = 0, j = n; i < n; i++, j++) {
            res[k++] = nums[i];
            res[k++] = nums[j];
        }
        return res;
    }

}
