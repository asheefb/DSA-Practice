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
}
