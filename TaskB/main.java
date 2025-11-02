import java.util.*;

public class main {
    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node root = null;

        while (sc.hasNextInt()) {
            int x = sc.nextInt();
            if (x == 0) {
                break;
            }
            root = insert(root, x);
        }

        List<Integer> leaves = new ArrayList<>();
        collectLeavesInOrder(root, leaves);

        for (int leaf : leaves) {
            System.out.print(leaf + " ");
        }
    }

    static Node insert(Node node, int val) {
        if (node == null) {
            return new Node(val);
        }
        if (val < node.val) {
            node.left = insert(node.left, val);
        } else if (val > node.val) {
            node.right = insert(node.right, val);
        }
        return node;
    }

    static void collectLeavesInOrder(Node node, List<Integer> leaves) {
        if (node == null) {
            return;
        }
        collectLeavesInOrder(node.left, leaves);
        if (node.left == null && node.right == null) {
            leaves.add(node.val);
        }
        collectLeavesInOrder(node.right, leaves);
    }
}
