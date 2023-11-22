import java.util.*;

public class Q1008 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int m = s.nextInt();
        for (int i = 0; i < m; i++) {
            int n = s.nextInt();
            int[] nums = new int[n];
            for (int j = 0; j < n; j++) {
                nums[j] = s.nextInt();
            }

            System.out.println(getSum(nums) + " " + getNums(nums));

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

    public static int getNums(int[] nums) {
        PriorityQueue<Integer> res = new PriorityQueue<Integer>();
        boolean flag = true;

        for (int num : nums) {
            if (res.isEmpty()) {
                res.add(num);
            } else {
                flag = true;
                Iterator it = res.iterator();
                while (it.hasNext()) {
                    int temp = (Integer)it.next();
                    if (temp >= num) {
                        res.remove(temp);
                        res.add(num);
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    res.add(num);
                }
                
            }
        }

        return res.size();
    }
}
