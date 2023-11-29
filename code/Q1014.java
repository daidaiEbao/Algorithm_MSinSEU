import java.util.Scanner;

public class Q1014 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        int m = s.nextInt();
        for (int i = 0; i < m; i++) {
            int n = s.nextInt();
            int[] nums = new int[n];
            for (int j = 0; j < n; j++) nums[j] = s.nextInt();

            System.out.println(maxSum(nums));

        }
    }

    public static int maxSum(int[] nums) {
        int[] dp = new int[nums.length];
        int res = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) dp[i] = nums[i];
            else {
                dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            }

            res = Math.max(res, dp[i]);
        }

        return res;
    }
}
