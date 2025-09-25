import java.util.Scanner;

public class main { 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String pattern = sc.nextLine();  
        String text = sc.nextLine();
        char[] pArray = pattern.toCharArray();
        char[] tArray = text.toCharArray();

        int[] lpc = new int[pArray.length];

        int j = 0;
        int i = 1;
        while (i < pArray.length) {
            if (pArray[i] == pArray[j]) {
                j++;
                lpc[i] = j;
                i++;
            } else {
                if (j != 0) {
                    j = lpc[j - 1];
                } else {
                    lpc[i] = 0;
                    i++;
                }
            }
        }

        int k = 0;
        int l = 0;
        while (k < tArray.length) {
            if (tArray[k] == pArray[l]) {
                k++;
                l++;
                if (l == pArray.length) {
                    System.out.print((k - l) + " ");
                    l = lpc[l - 1];
                }
            } else {
                if (l != 0) {
                    l = lpc[l - 1];
                } else {
                    k++;        
                }   
            }
        }  
    }
}


/*import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String pattern = sc.nextLine();
        String text = sc.nextLine();

        int pLength = pattern.length();
        int tLength = text.length();

        // Build prefix function
        int[] pi = new int[pLength];
        for (int i = 1, j = 0; i < pLength; i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j))
                j = pi[j - 1];
            if (pattern.charAt(i) == pattern.charAt(j))
                j++;
            pi[i] = j;
        }

        // Search for pattern in text
        for (int i = 0, j = 0; i < tLength; i++) {
            while (j > 0 && text.charAt(i) != pattern.charAt(j))
                j = pi[j - 1];
            if (text.charAt(i) == pattern.charAt(j))
                j++;
            if (j == pLength) {
                System.out.print((i - pLen + 1) + " ");
                j = pi[j - 1];
            }
        }
    }
}*/