package LeetCode.Arrays.PrefixSum;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualN {

    //prefix 5%
    public int subarraySum2(int[] nums, int k) {

        int n = nums.length;
        int[] prefix = new int[n];
        prefix[0] = nums[0];

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = i == 0 ? prefix[j] : prefix[j] - prefix[i - 1];

                if (sum == k)
                    count++;
            }
        }

        return count;
    }

    public int subarraySum(int[] nums, int k) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;

            for (int j = i; j < nums.length; j++) {
                sum += nums[j];

                if (sum == k)
                    count++;
            }
        }

        return count;
    }

    //optimised
    public int subarraySum3(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int prefix = 0;
        int count = 0;

        for (int num : nums) {
            prefix += num;

            count += map.getOrDefault(prefix - k, 0);

            map.put(prefix, map.getOrDefault(prefix, 0) + 1);
        }

        return count;
    }

    //optimised 98%
    public int subarraySum4(int[] nums, int k) {
        int n = nums.length;

        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for (int i = 1; i < n; i++)
            prefix[i] = prefix[i - 1] + nums[i];

        //prefix, frequency
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (prefix[i] == k)
                count++;


            count += map.getOrDefault(prefix[i] - k, 0);

            map.put(prefix[i], map.getOrDefault(prefix[i], 0) + 1);
        }

        return count;
    }
}
