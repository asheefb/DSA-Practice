//package LeetCode.Arrays.BinarySearch;
//
///*
//https://leetcode.com/problems/first-bad-version/description/
// */
//public class FirstBadVersion {
//    /* The isBadVersion API is defined in the parent class VersionControl.
//      boolean isBadVersion(int version); */
//    public int firstBadVersion(int n) {
//        int start = 0, end = n, ans = -1;
//
//        while (start <= end) {
//            int mid = start + (end - start) / 2;
//
//            if (isBadVersion(mid)) {
//                ans = mid;
//                end = mid - 1;
//            } else
//                start = mid + 1;
//        }
//        return ans;
//    }
//
//}
