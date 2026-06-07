package Arrays;

public class ConcatenationOfArray {
    public static int[] getConcatenation(int[] nums) {
        int[] result = new int[nums.length * 2];
        int k = 0;

        for (int j : nums) {
            result[k++] = j;
        }

        for (int num : nums) {
            result[k++] = num;
        }
        return result;
    }
}
