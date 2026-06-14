package Arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DeleteNumberInArray {
    public static List<Object> delete(int[] arr, int num) {

        int[] res = new int[arr.length - 1];
        int k = 0;

        boolean numPresent = false;

        for (int a : arr) {
            if (a == num) {
                numPresent = true;
                break;
            }
        }

        List<Object> finalRes = new ArrayList<>();

        if (!numPresent) {
            finalRes.add("Deletion number is not present : ");
            finalRes.add(arr);
            return finalRes;
        }

        for (int a : arr) {
            if (a == num)
                break;

            res[k++] = a;
        }

        for (int i = k + 1; i < arr.length; i++) {
            res[k++] = arr[i];
        }
        finalRes.add("Deleted Success: ");
        finalRes.add(res);
        return finalRes;
    }
}
