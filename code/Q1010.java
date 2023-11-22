import java.util.Scanner;

public class Q1010 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int m = s.nextInt();
        for (int i = 0; i < m; i++) {
            int n = s.nextInt();
            int x = s.nextInt();
            int[] nums = new int[n];
            for (int j = 0; j < n; j++) nums[j] = s.nextInt();

            System.out.println(biSearch(nums, x, 0, n - 1));
        }
    }

    public static String biSearch(int[] nums, int x, int low, int high) {
        int mid = 0;
        int pre = mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (nums[mid] == x) {
                return "success, father is " + pre;
            } else if (nums[mid] > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
            pre = nums[mid];
        }
        return "not found, father is " + pre;
    }
}