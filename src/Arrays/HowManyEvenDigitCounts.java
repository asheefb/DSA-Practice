package Arrays;

public class HowManyEvenDigitCounts {
    private static int evenDigitsCount(int[] nums) {

        int eveCount = 0;

        for (int j : nums) {
            int num = j;
            int count = 0;
            //123
            while (num != 0) {
                count++;
                num = num / 10;
            }
            if (count % 2 == 0)
                eveCount++;
        }
        return eveCount;
    }
}
