import java.util.Scanner;

public class Q1005 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int m = s.nextInt();
        for (int i = 0; i < m; i++) {
            int n = s.nextInt();
            int[] nums = new int[n];
            for (int j = 0; j < n; j++) nums[j] = s.nextInt();
        

            quickSort(nums, 0, n - 1, 1);


            for (int num : nums) {
                System.out.print(num + " ");
            }
            System.out.println("");
        }
    }

    public static void quickSort(int[] nums, int start, int end, int times) {
        if (start < end) {
            int base = nums[start];
            int p = start;
            
            for (int i = start + 1; i <= end; i++) {
                if (nums[i] < base) {
                    int temp = nums[++p];
                    nums[p] = nums[i];
                    nums[i] = temp; 
                }
            }
            nums[start] = nums[p];
            nums[p] = base;
            if (times < 2) {
                quickSort(nums, start, p - 1, times + 1);
                quickSort(nums, p + 1, end, times + 1);
            }
        }
    }
}
