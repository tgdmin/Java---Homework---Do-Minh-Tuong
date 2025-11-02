import java.util.ArrayList;
import java.util.List;

public class KMP {
    private String pattern;
    private int[] lps; 

    public KMP(String pattern) {
        this.pattern = pattern;
        this.lps = buildLps(pattern);
    }

//lps
    private int[] buildLps(String pattern) {
        int m = pattern.length();
        int[] lps = new int[m];
        int length = 0; 
        int i = 1;

        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = lps[length - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

// kmp
    public List<Integer> search(String text) {
        List<Integer> result = new ArrayList<>();
        int n = text.length();
        int m = pattern.length();

        int i = 0; 
        int j = 0; 

        while (i < n) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;

                if (j == m) {
                    result.add(i - j);
                    j = lps[j - 1];
                }
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return result;
    }
}
