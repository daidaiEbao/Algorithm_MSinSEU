import java.util.Scanner;

public class Q1006 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int m = s.nextInt();
        for (int i = 0; i < m; i++) {
            int n = s.nextInt();
            int[] nums = new int[n];
            for (int j = 0; j < n; j++) {
                nums[j] = s.nextInt();
            }

            heapSort(nums);

            for (int num : nums) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static void heapSort(int[] nums) {
        for (int i = nums.length -  1; i >= 0; i--) {
            check(nums, i);
        }
    }

    public static void check(int[] nums, int i) {
        int l = i * 2 + 1, r = i * 2 + 2;
        if (l < nums.length && r < nums.length) {
            if (nums[l] < nums[r]) {
                if (nums[l] < nums[i]) {
                    int temp = nums[l];
                    nums[l] = nums[i];
                    nums[i] = temp;
                    check(nums, l);
                }
            } else {
                if (nums[r] < nums[i]) {
                    int temp = nums[r];
                    nums[r] = nums[i];
                    nums[i] = temp;
                    check(nums, r);
                }
            }
        } else if (l < nums.length) {
            if (nums[l] < nums[i]) {
                    int temp = nums[l];
                    nums[l] = nums[i];
                    nums[i] = temp;
                    check(nums, l);
                }
        }
    }
}
