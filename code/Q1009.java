import java.util.*;

public class Q1009 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int m = s.nextInt();
        int n;
        for (int i = 0; i < m; i++) {
            n = s.nextInt();
            int[] nums = new int[n];
            for (int j = 0; j < n; j++) nums[j] = s.nextInt();

            System.out.println(getSum(nums));

        }
    }

    public static int getSum(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int res = Integer.MIN_VALUE;

        Arrays.fill(dp, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] <= nums[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            res = Math.max(res, dp[i]);
        }
        
        return res;
    }
}
