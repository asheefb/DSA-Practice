package Arrays.PrefixSum;

public class BuildPrefixSum {

    private int[] prefixSum;

    public BuildPrefixSum(int[] nums) {
        prefixSum = new int[nums.length];

        prefixSum[0] = nums[0];

        for (int i = 1; i < nums.length; i++)
            prefixSum[i] = nums[i] + prefixSum[i - 1];
    }

    public int sumRange(int left, int right) {
        if (left == 0)
            return prefixSum[right];

        return prefixSum[right] - prefixSum[left - 1];
    }

    public static void main(String[] args) {
        BuildPrefixSum sum = new BuildPrefixSum(new int[]{1, 2, 3, 4, 5, 6});
        System.out.println(sum.sumRange(1, 4));

    }
}