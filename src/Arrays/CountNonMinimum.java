package Arrays;

import java.util.Arrays;

public class CountNonMinimum {
    public int countNonMinimum(int[] nums) {
        // write your code here
        Arrays.sort(nums);
        int count = 0,minVal = nums[0];

        for(int i =1;i<nums.length;i++){
            if (nums[i] != minVal)
                count++;
        }
        return count;

    }
}
