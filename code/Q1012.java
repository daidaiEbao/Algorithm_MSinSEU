import java.util.*;
public class Q1012 {
    public static class Point{
        public int X;
        public int Y;
        public Double cos;
        public Double dis;

        public Point(int x, int y) {
            this.X = x;
            this.Y = y;
        }

        public void setCos(Point O) {
            this.dis = Math.sqrt(Math.pow(this.X - O.X, 2) + Math.pow(this.Y - O.Y, 2));
            // == 0 是否可取
            this.cos = this.dis == 0 ? 1.00 : (double)(this.X - O.X) / this.dis;
        }
    }

    // **该问题并未AC**
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int m = s.nextInt();

        for (int i = 0; i < m; i++) {
            int n = s.nextInt();
            Point[] points = new Point[n];
            for (int j = 0; j < n; j++) {
                points[j] = new Point(s.nextInt(), s.nextInt());
            }

            List<Point> res = getConvexHull(points);

            int count = res.size();
            for (int j = count - 1; j >= 0; j--) {
                System.out.println(res.get(j).X + " " + res.get(j).Y);
            }
        }
    }

    public static List<Point> getConvexHull(Point[] points) {
        Deque<Point> dq = new ArrayDeque<Point>();

        Point lowest = points[0];
        for (int i = 1; i < points.length; i++) {
            if (lowest.Y > points[i].Y) lowest = points[i];
        }

        for (int i = 0; i < points.length; i++) {
            points[i].setCos(lowest);
        }

        // 怀疑此处排序存在问题
        Arrays.sort(points, (A, B) -> (Math.abs(B.cos - A.cos) <= 0.000001 ? A.dis.compareTo(B.dis) : B.cos.compareTo(A.cos)));

        
        for (int i = 0; i < points.length; i++) {
            if (dq.size() < 2) {
                dq.offerFirst(points[i]);
            } else {
                Point B = dq.pollFirst();
                if (points[i].X != B.X || points[i].Y != B.Y) {
                    Point A = dq.pollFirst();
                    int posi = getPosi(A, B, points[i]);
                    while (posi < 0) {
                        B = A;
                        A = dq.pollFirst();
                        posi = getPosi(A, B, points[i]);
                    }

                    dq.offerFirst(A);
                    dq.offerFirst(B);
                    dq.offerFirst(points[i]);
                } else dq.offerFirst(B);
            }
        }
        List<Point> res = new ArrayList<Point>();

        while (dq.size() > 2) {
            Point C = dq.pollFirst();
            Point B = dq.pollFirst();
            Point A = dq.pollFirst();

            
            dq.offerFirst(A);
            if (getPosi(A, B, C) != 0) {
                dq.offerFirst(B);
                res.add(C);
            } else dq.offerFirst(C);
            
        }

        while (dq.size() > 0) {
            res.add(dq.pollFirst());
        }

        return res;
    }

    public static int getPosi(Point A, Point B, Point C) {
        // AB * AC
        return (B.X - A.X) * (C.Y - A.Y) - (B.Y - A.Y) * (C.X - A.X);
    }
}
