import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main {
    static class Stack {
        private int[] data;
        private int[] maxData;
        private int size;

        public Stack(int capacity) {
            data = new int[capacity];
            maxData = new int[capacity];
            size = 0;
        }

        public void push(int value) {
            data[size] = value;
            if (size == 0) {
                maxData[size] = value;
            } else {
                maxData[size] = Math.max(value, maxData[size - 1]);
            }
            size++;
        }

        public void pop() {
            if (size > 0) {
                size--;
            }
        }

        public int max() {
            if (size > 0) {
                return maxData[size - 1];
            }
            return 0; 
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(br.readLine());
        Stack stack = new Stack(q);

        for (int i = 0; i < q; i++) {
            String line = br.readLine();
            if (line.startsWith("push")) {
                int v = Integer.parseInt(line.split(" ")[1]);
                stack.push(v);
            } else if (line.equals("pop")) {
                stack.pop();
            } else if (line.equals("max")) {
                System.out.println(stack.max());
            }
        }
    }
}