import java.util.Scanner;

public class Q1007 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int m = s.nextInt();

        int n, k;
        String num;
        for (int i = 0; i < m; i++) {
            n = s.nextInt();
            k = s.nextInt() + 1;
            num = s.next();
            

            System.out.println(getProduct(num, k, n));
        }
    }

    public static long getNum(String num, int i, int j) {
        long res = 0;
        String subNum = num.substring(i, j);
        res = Long.valueOf(subNum);

        return res;
    }

    public static long getProduct(String num, int k, int n) {
        long[][] dp = new long[k][n];

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) dp[i][j] = getNum(num, i, j + 1);
                else if (i > j) dp[i][j] = 0;
                else {
                    dp[i][j] = Long.MIN_VALUE;
                    for (int x = i - 1; x < j; x++) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][x] * getNum(num, x + 1, j + 1));
                    }
                }
            }
        }

        return dp[k - 1][n - 1];
    }
}
