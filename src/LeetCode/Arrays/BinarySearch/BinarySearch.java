package LeetCode.Arrays.BinarySearch;

public class BinarySearch {

    public static void main(String[] args) {
        System.out.println(search(new int[]{1, 0, 3, 5, 9, 12}, 9));
    }

    public static int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            // this one is to avoid overflow
            // int mid = start + (end - start) / 2;


            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                start = mid + 1;
            else
                end = mid - 1;
        }

        return -1;
    }

}
