import java.io.IOException;
import java.util.Scanner;

public class Problem325A {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int xmin = s.nextInt();
        int ymin = s.nextInt();
        int xmax = s.nextInt();
        int ymax = s.nextInt();
        int curarea = (ymax - ymin) * (xmax - xmin);

        for (int i = 1; i < n; i++) {
            int x1 = s.nextInt();
            int y1 = s.nextInt();
            int x2 = s.nextInt();
            int y2 = s.nextInt();
            if (xmin > x1) xmin = x1;
            if (xmax < x2) xmax = x2;
            if (ymin > y1) ymin = y1;
            if (ymax < y2) ymax = y2;
            curarea += (x2 - x1) * (y2 - y1);
        }

        if ((xmax - xmin) == (ymax - ymin) && curarea == (xmax - xmin) * (ymax - ymin))
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}
