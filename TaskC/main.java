import java.util.List;
import java.util.Scanner;

public final class main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String pattern = sc.nextLine();
            String text = sc.nextLine();

            KMP kmp = new KMP(pattern);
            List<Integer> matches = kmp.search(text);

            for (int i = 0; i < matches.size(); ++i) {
                if (i > 0) System.out.print(" ");
                System.out.print(matches.get(i));
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
