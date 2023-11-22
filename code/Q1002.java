import java.util.*;
public class Q1002 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int m = s.nextInt();
        int n;
        for (int i = 0; i < m; i++) {
            n = s.nextInt();
            int[] nums = new int[n];
            for (int j = 0; j < n; j++) {
                nums[j] = s.nextInt();
            }
            quickSort(nums, 0, n - 1);
            System.out.println(nums[1]);
        }
    }

    public static void quickSort(int[] nums, int start, int end) {
        if (start < end) {
            int base = nums[start];
            int l = start;
            int r = end;
            while (l < r) {
                while (l < r && nums[r] >= base) r--;
                nums[l] = nums[r];
                while (l < r && nums[l] <= base) l++;
                nums[r] = nums[l];
            }
            nums[l] = base;
            quickSort(nums, start, l - 1);
            quickSort(nums, r + 1, end);
        }
    }
}
