import java.util.Scanner;

public class Q1018 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int m = s.nextInt();
        for (int i = 0; i < m; i++) {
            int N = s.nextInt();
            int V = s.nextInt();
            int[] sizes = new int[N];
            int[] values = new int[N];
            for (int j = 0; j < N; j++) {
                sizes[j] = s.nextInt();
                values[j] = s.nextInt();
            }

            System.out.println(bag01(V, N, sizes, values));

        }
    }

    public static int bag01(int V, int N, int[] s, int[] v) {
        int[] dp = new int[V + 1];
        
        for (int i = 0; i < N; i++) {
            for (int j = V; j >= 0; j--) {
                if (j > s[i] && dp[j - s[i]] != 0) {
                    dp[j] = Math.max(dp[j], dp[j-s[i]] + v[i]);
                } else if (j == s[i]) {
                    dp[j] = Math.max(dp[j], v[i]);
                }
            }
        }

        return dp[V];
    }
}
