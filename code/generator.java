import java.util.Random;

public class generator {
    
    public static void main(String[] args) {
        Random r = new Random();
        int m = 1 + r.nextInt(3);
        System.out.println(m);
        for (int i = 0; i < m; i++) {
            int n = r.nextInt(20);
            System.out.print(n);
            for (int j = 0; j < n; j++) {
                System.out.print(" " + r.nextInt(100) + " " + r.nextInt(100));
            }
            System.out.println();
        }
    }
}
