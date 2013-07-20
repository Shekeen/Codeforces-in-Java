import java.util.Scanner;

public class Problem327B {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = 2 * n + i;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(a[i]);
            sb.append(' ');
        }

        System.out.println(sb.toString());
    }
}
