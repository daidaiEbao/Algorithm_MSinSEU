import java.util.Scanner;

public class Q1004 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int m = s.nextInt();
        for (int i = 0; i < m; i++) {
            int n = s.nextInt();
            int[] nums = new int[n];
            for (int j = 0; j < n; j++) nums[j] = s.nextInt();
        

            int[] res = mergeSort(nums, 0, n - 1, 1);


            for (int num : res) {
                System.out.print(num + " ");
            }
            System.out.println("");
        }
    }

    public static int[] mergeSort(int[] nums, int start, int end, int times) {
        if (start == end) {
            return new int[] {nums[start]};
        }
        
        int mid = start + (end - start) / 2;
        int[] lArr = mergeSort(nums, start, mid, times + 1);
        int[] rArr = mergeSort(nums, mid + 1, end, times + 1);
        int[] res = new int[lArr.length + rArr.length];

        int i = 0, j = 0, k = 0;
        if (times >= 3) {
            while (i < lArr.length && j < rArr.length) {
                res[k++] = lArr[i] < rArr[j] ? lArr[i++] : rArr[j++];
            }
        }
        

        while (i < lArr.length) res[k++] = lArr[i++];
        while (j < rArr.length) res[k++] = rArr[j++];

        return res;
    }
}
