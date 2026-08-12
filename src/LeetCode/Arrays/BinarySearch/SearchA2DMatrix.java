package LeetCode.Arrays.BinarySearch;

/*
./src/LeetCode/Arrays/BinarySearch/SplitArrayLargestSum.java
 */
public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int noOfRows = matrix.length, noOfColums = matrix[0].length;
        int start = 0, end = (noOfRows * noOfColums) - 1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            int row = mid / noOfColums, column = mid % noOfColums;
            int value = matrix[row][column];

            if (value == target)
                return true;
            else if (value <= target)
                start = mid + 1;
            else
                end = mid - 1;
        }

        return false;
    }
}
