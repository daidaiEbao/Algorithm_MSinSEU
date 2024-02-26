import java.util.Scanner;

public class Q1020 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        for (int i = 0; i < n; i++) {
            int m = s.nextInt();
            int[][] mat =  new int[m][2];
            for (int j = 0; j < m; j++) {
                mat[j][0] = s.nextInt();
                mat[j][1] = s.nextInt();
            }
            
            System.out.println(times(m, mat));

                     
        }
    }
// 两个矩阵A(r行s列)和B(s行t列)相乘, 乘法代价为r*s*t. 现给定N(N<=500)个矩阵连乘问题, 请计算最小乘法代价。
/*
2
3
1 2 2 3 3 4
3
4 3 3 2 2 1 
 */
    public static int times(int n, int[][] mat) {
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 0;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j + i < n; j++) {
                if (i == 1) dp[j][j + i] = mat[j][0] * mat[j][1] * mat[j + 1][1];
                // else if (i == 2) dp[j][j + i] = dp[j][j + i - 1] + mat[j][0] * mat[j + i - 1][1] * mat[j + i][1];
                else {
                    dp[j][j + i] = Integer.MAX_VALUE;
                    for (int k = j; k < j + i; k++) {
                        dp[j][j + i] = Math.min(dp[j][j + i], dp[j][k] + dp[k + 1][j + i] + mat[j][0] * mat[k][1] * mat[j+i][1]);
                    }
                }
            }
        }

        return dp[0][n-1];
    }                                                                                                                 
}
