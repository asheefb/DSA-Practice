package Arrays;

public class HowManyEvenDigitCounts {
    private static int evenDigitsCount(int[] nums) {

        int eveCount = 0;
        for (int j : nums) {
            int num = j;
            int count = 0;
            //With while
            while (num != 0) {
                count++;
                num = num / 10;
            }
            //without while
            int digits = (int) Math.log(num);
            if (count % 2 == 0)
                eveCount++;
        }
        return eveCount;
    }
}
