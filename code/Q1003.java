import java.util.Scanner;

public class Q1003 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int m = s.nextInt();
        for (int i = 0; i < m; i++) {
            int n = s.nextInt();
            int[] nums = new int[n];
            for (int j = 0; j < n; j++) nums[j] = s.nextInt();

            popOnce(nums, n);
            for (int num : nums) {
                System.out.print(num + " ");
            }
            System.out.println("");
        }
    }

    public static void popOnce(int[] nums, int n) {
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                int temp = nums[i+1];
                nums[i+1] = nums[i];
                nums[i] = temp;
            }
        }
    }
}
