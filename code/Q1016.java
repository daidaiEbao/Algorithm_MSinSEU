import java.util.Arrays;
import java.util.Scanner;

public class Q1016 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int m = s.nextInt();

        for (int i = 0; i < m; i++) {
            int n = s.nextInt();
            int tar = s.nextInt();
            int[] nums = new int[n];
            for (int j = 0; j < n; j++) {
                nums[j] = s.nextInt();
            }

            System.out.println(twoSum(nums, tar));

        }
    }

    public static String twoSum(int[] nums, int tar) {
        Arrays.sort(nums);

        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            if (nums[i] + nums[j] == tar) return "yes";
            else if (nums[i] + nums[j] < tar) i++;
            else j--;
        }

        return "no";
    }
}
