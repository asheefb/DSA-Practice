package CodeChef.Arrays;

public class TakeDiscountOrNot {
    public String checkCoupon(int n, int x, int y, int[] prices) {
        // write your code here
        int totalCost = 0, buyingWithCoupon = 0;

        for (int i = 0; i < n; i++) {
            totalCost += prices[i];
            int dis = prices[i] - y;
            buyingWithCoupon += Math.max(dis, 0);
        }
        buyingWithCoupon += x;

        return totalCost < buyingWithCoupon ? "NO COUPON" : "COUPON";
    }
}
