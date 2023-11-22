import java.util.*;
public class Q1001 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        String line = s.nextLine();
        for (int i = 0; i < n; i++) {
            int count = 0;
            line = s.nextLine();
            
            for (int j = 0; j < line.length(); j++) {
                if (line.charAt(j) >= '0' && line.charAt(j) <= '9') count++;
            }
            System.out.println(count); 
        }
    }
}