package Arrays;

public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, lastNum = 0;
        for (int num : nums) {
            if (num == 1)
                lastNum++;
            else
                lastNum = 0;

            if (max < lastNum)
                max = lastNum;
        }
        return max;
    }
}
