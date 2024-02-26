import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Q1025 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        for (int i = 0; i < n; i++) {
            int m = s.nextInt();
            int[] arr = new int[m];
            for (int j = 0; j < m; j++) {
                arr[j] = s.nextInt();
            }

             System.out.println(lns(m, arr));
        }
    }

     public static int lns(int n, int[] arr) {
        int[] dp = new int[n];
        int ans = -1;
        for (int i = 0; i < n; i++) {
            if (i == 0) dp[i] = 1;
            else {
                dp[i] = 1;
                for (int j = i - 1; j >= 0; j--) {
                    if (arr[i] >= arr[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        
        return ans;
    }
}
