import java.util.Scanner;

public class Q1019 {
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

        int[][] dp = new int[N][V + 1];
        for (int i = 0; i < N; i++) {
            for (int j = V; j >=0; j--) {
                if (j >= s[i]) {
                    if (i == 0) {
                        dp[i][j] = v[i];
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - s[i]] + v[i]);
                    }
                } else {
                    if (i == 0) {
                        dp[i][j] = 0;
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        }

        return dp[N - 1][V];
    }
}