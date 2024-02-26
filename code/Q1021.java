import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Q1021 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        for (int i = 0; i < n; i++) {
            int len = s.nextInt();
            int m = s.nextInt();
            Map<Integer, Integer> list =  new HashMap<Integer, Integer>();
            for (int j = 0; j < m; j++) {
                list.put(s.nextInt(), s.nextInt());
            }
            
            System.out.println(profits(len, m, list));
        }
    }
    // 给定一根长度为n(n<=10000)的钢条以及一张价格表, 请计算这根钢条能卖出的最大总收益. 价格表表示为(li,pi), 1<=i<=k. 不在价格表中的钢条可卖出价格为0.
    /*
     * 第一行输入m(m<=10)表示有M组数据。每组数据第一行输入两个int型整数n和k，分别表示钢条长度以及价格表中不同价格数量. 接下来一行输入k个价格的表示(li,pi), 均为整数, li可能大于n。
     * 输出m行整数，第i行表示第i组数据的最大总收益。
     * 2
27 3
35 41 61 49 73 74
94 2
21 55 88 64 
     */
    public static int profits(int len, int n, Map<Integer, Integer> list) {
        int[] prices = new int[len + 1];
        for (int i = 1; i < len + 1; i++) {
            prices[i] = list.getOrDefault(i, 0);
            for (int j = 1; j < i / 2 + 1; j++) {
                prices[i] = Math.max(prices[i], prices[j] + prices[i-j]);    
            }
        }
        return prices[len];
    }

}
