import java.text.DecimalFormat;
import java.util.*;

public class Q1011 {
    public static class Point {
        public int X;
        public int Y;

        public Point(int X, int Y) {
            this.X = X;
            this.Y = Y;
        }
    }
    public static void main(String[] args) {
        Scanner s =  new Scanner(System.in);

        int m = s.nextInt();
        int n;
        for (int i = 0; i < m; i++) {
            n = s.nextInt();
            Point[] points = new Point[n];
            for (int j = 0; j < n; j++) {
                points[j] = new Point(s.nextInt(), s.nextInt());
            }

            Arrays.sort(points, (A, B) -> (A.X - B.X == 0 ? B.Y - A.Y : A.X - B.X));
            DecimalFormat df = new DecimalFormat("#.00");
            System.out.println(df.format(closestPoints(points, 0, n - 1)));
        }
    }

    public static double closestPoints(Point[] points, int low, int high) {
        int mid = (low + high) / 2;
        if (low + 1 == high) return getDistance(points[low], points[high]);
        
        double lDis = closestPoints(points, low, mid);
        double rDis = closestPoints(points, mid, high);
        double minDis = Math.min(lDis, rDis);

        
        List<Point> horiClosest = new ArrayList<Point>();

        for (int i = low; i <= high; i++) {
            if (Math.abs(points[i].X - points[mid].X) < minDis) {
                horiClosest.add(points[i]);
            }
        }

        Collections.sort(horiClosest, (A, B) -> (B.Y - A.Y));

        for (int i = 0; i < horiClosest.size(); i++) {
            for (int j = i + 1; j < horiClosest.size(); j++) {
                if ((horiClosest.get(j).Y > (horiClosest.get(i).Y - minDis)) && (horiClosest.get(j).Y < horiClosest.get(i).Y)) {
                    minDis = Math.min(minDis, getDistance(horiClosest.get(i), horiClosest.get(j)));      
                }
            }
        }

        return minDis;
    }

    public static double getDistance(Point A, Point B) {
        return Math.sqrt(Math.pow(A.X - B.X, 2) + Math.pow(A.Y - B.Y, 2));
    }
}
