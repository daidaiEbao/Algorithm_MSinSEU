import java.util.*;

public class Q1013 {
    public static class Count {
        public int count;

        public Count() {
            this.count = 0;
        }

        public int[] mergeSort(int[] nums, int low, int high) {
            if (low == high)
                return new int[] { nums[low] };
            int mid = (low + high) / 2;
            int[] lArr = mergeSort(nums, low, mid);
            int[] rArr = mergeSort(nums, mid + 1, high);

            int[] res = new int[lArr.length + rArr.length];
            int i = 0, j = 0, k = 0;
            while (i < lArr.length && j < rArr.length) {
                if (lArr[i] <= rArr[j])
                    res[k++] = lArr[i++];
                else {
                    this.count += lArr.length - i;
                    res[k++] = rArr[j++];
                }
            }

            while (i < lArr.length)
                res[k++] = lArr[i++];
            while (j < rArr.length)
                res[k++] = rArr[j++];
            return res;
        }

    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int m = s.nextInt();

        for (int i = 0; i < m; i++) {
            int n = s.nextInt();
            int[] nums = new int[n];
            for (int j = 0; j < n; j++)
                nums[j] = s.nextInt();
            Count c = new Count();
            c.mergeSort(nums, 0, n - 1);
            System.out.println(c.count);
        }
    }
}
