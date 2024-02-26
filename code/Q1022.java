import java.util.Scanner;

public class Q1022 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        s.nextLine();
        for (int i = 0; i < n; i++) {
            String a = s.nextLine();
            String b = s.nextLine();
            System.out.println(lcs(a,b));
        }
    }

    // 给定两个字符串A和B, 请计算这两人个字符串的最长公共子序列长度。
    /*
     * 第一行输入M(M<=10)表示有M组数据。每组数据输入两行字符串, 字符串的长度不长于500。
     * 输出M行正整数，第i行表示第i组数据的最长公共子序列长度。
     * 2
abcdefg
cemg
abcdefgh
ceaaegh
     */

    public static int lcs(String a, String b) {
        int m = a.length();
        int n = b.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }
}
