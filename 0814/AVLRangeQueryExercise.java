import java.util.*;

class AVLRangeQueryExercise {
    class Node {
        int key, height;
        Node left, right;
        Node(int d) { key = d; height = 1; }
    }

    Node root;

    int height(Node N) {
        return (N == null) ? 0 : N.height;
    }

    Node insert(Node node, int key) {
        if (node == null) return new Node(key);
        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);
        else return node;

        node.height = Math.max(height(node.left), height(node.right)) + 1;

        int balance = getBalance(node);
        if (balance > 1 && key < node.left.key)
            return rightRotate(node);
        if (balance < -1 && key > node.right.key)
            return leftRotate(node);
        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    int getBalance(Node N) {
        return (N == null) ? 0 : height(N.left) - height(N.right);
    }

    Node rightRotate(Node y) {
        Node x = y.left, T2 = x.right;
        x.right = y; y.left = T2;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        return x;
    }

    Node leftRotate(Node x) {
        Node y = x.right, T2 = y.left;
        y.left = x; x.right = T2;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        return y;
    }

    public List<Integer> rangeQuery(Node node, int min, int max) {
        List<Integer> result = new ArrayList<>();
        rangeQueryHelper(node, min, max, result);
        return result;
    }

    void rangeQueryHelper(Node node, int min, int max, List<Integer> result) {
        if (node == null) return;
        if (min < node.key) rangeQueryHelper(node.left, min, max, result);
        if (min <= node.key && node.key <= max) result.add(node.key);
        if (max > node.key) rangeQueryHelper(node.right, min, max, result);
    }

    public static void main(String[] args) {
        AVLRangeQueryExercise tree = new AVLRangeQueryExercise();
        int[] vals = {20, 8, 22, 4, 12, 10, 14};
        for (int v : vals) tree.root = tree.insert(tree.root, v);

        List<Integer> result = tree.rangeQuery(tree.root, 10, 20);
        System.out.println("範圍查詢 [10, 20]: " + result);
    }
}
