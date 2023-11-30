import java.util.Scanner;

public class Q1017 {
    public static class Cross{
        public int res;

        public Cross() { this.res = 0; }
        public int[] getCross(int[] nums, int low, int high) {
            if (low == high) return new int[]{nums[low]};

            int mid = (low + high) / 2;
            int[] lArr = getCross(nums, low, mid);
            int[] rArr = getCross(nums, mid + 1, high);

            int[] res = new int[lArr.length + rArr.length];
            int i = 0, j = 0, k = 0;
            int temp = 0;
            while (i < lArr.length && j < rArr.length) {
                if (lArr[i] > rArr[j]) {
                    res[k++] = rArr[j++];
                    temp++;
                } else {
                    res[k++] = lArr[i++];
                    this.res += temp;
                }
            }

            while (i < lArr.length) {
                res[k++] = lArr[i++];
                this.res += temp;
            }

            while (j < rArr.length) {
                res[k++] = rArr[j++];
            }

            return res;
        }
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int m = s.nextInt();
        for (int i = 0; i < m; i++) {
            int n = s.nextInt(); 
            int[] nums = new int[n];
            for (int j = 0; j < n; j++) nums[j] = s.nextInt();
            Cross c = new Cross();
            c.getCross(nums, 0, n - 1);
            System.out.println(c.res);

        }
    }
}
