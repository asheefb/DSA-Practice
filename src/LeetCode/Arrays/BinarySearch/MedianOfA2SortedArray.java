package LeetCode.Arrays.BinarySearch;

/*
https://leetcode.com/problems/median-of-two-sorted-arrays/
 */

public class MedianOfA2SortedArray {

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merge = new int[nums1.length + nums2.length];
        int i = 0, j = 0, k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] <= nums2[j]) {
                merge[k++] = nums1[i++];
            } else
                merge[k++] = nums2[j++];
        }

        while (i < nums1.length)
            merge[k++] = nums1[i++];

        while (j < nums2.length)
            merge[k++] = nums2[j++];

        int mid = merge.length / 2;

        if (merge.length % 2 == 1)
            return merge[mid];
        else
            return (double) (merge[mid] + merge[mid - 1]) / 2;
    }

    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;

        if (n1 > n2)
            return findMedianSortedArrays2(nums2, nums1);

        int left = (n1 + n2 + 1) / 2;
        int low = 0, high = n1;

        while (low <= high) {
            int mid1 = (low + high) / 2;
            int mid2 = left - mid1;

            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE, r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;

            if (mid1 < n1)
                r1 = nums1[mid1];
            if (mid2 < n2)
                r2 = nums2[mid2];

            if (mid1 - 1 >= 0)
                l1 = nums1[mid1 - 1];
            if (mid2 - 1 >= 0)
                l2 = nums2[mid2 - 1];

            if (l1 <= r2 && l2 <= r1) {
                if ((n1 + n2) % 2 == 1)
                    return Math.max(l1, l2);
                else
                    return (double) (Math.max(l1, l2) + Math.min(r1, r2)) / 2;
            } else if (l1 > r2)
                high = mid1 - 1;
            else
                low = mid1 + 1;
        }
        return 0;
    }
}
