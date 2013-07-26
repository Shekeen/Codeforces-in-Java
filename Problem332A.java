import java.io.IOException;
import java.util.Scanner;

public class Problem332A {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        s.nextLine();
        String game = s.nextLine();
        int ans = 0;
        int len = game.length();
        for (int i = n; i < len; i += n) {
            if (i < 3) continue;
            if (game.charAt(i-1) == game.charAt(i-2) &&
                game.charAt(i-1) == game.charAt(i-3)) {
                ans++;
            }
        }

        System.out.println(ans);
    }
}
