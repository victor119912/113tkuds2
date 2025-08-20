// 檔案：AVLBasicExercise.java
class AVLNode {
    int data, height;
    AVLNode left, right;

    AVLNode(int data) {
        this.data = data;
        this.height = 1;
    }

    void updateHeight() {
        int leftHeight = (left != null) ? left.height : 0;
        int rightHeight = (right != null) ? right.height : 0;
        this.height = Math.max(leftHeight, rightHeight) + 1;
    }

    int getBalance() {
        int leftHeight = (left != null) ? left.height : 0;
        int rightHeight = (right != null) ? right.height : 0;
        return leftHeight - rightHeight;
    }
}

public class AVLBasicExercise {
    private AVLNode root;

    // 插入節點
    public void insert(int data) {
        root = insertNode(root, data);
    }

    private AVLNode insertNode(AVLNode node, int data) {
        if (node == null) return new AVLNode(data);

        if (data < node.data) node.left = insertNode(node.left, data);
        else if (data > node.data) node.right = insertNode(node.right, data);
        else return node; // 重複值不插入

        node.updateHeight();

        int balance = node.getBalance();

        // LL
        if (balance > 1 && data < node.left.data)
            return rightRotate(node);

        // RR
        if (balance < -1 && data > node.right.data)
            return leftRotate(node);

        // LR
        if (balance > 1 && data > node.left.data) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // RL
        if (balance < -1 && data < node.right.data) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    // 搜尋節點
    public boolean search(int data) {
        return searchNode(root, data);
    }

    private boolean searchNode(AVLNode node, int data) {
        if (node == null) return false;
        if (data == node.data) return true;
        if (data < node.data) return searchNode(node.left, data);
        return searchNode(node.right, data);
    }

    // 計算高度
    public int height() {
        return (root != null) ? root.height : 0;
    }

    // 檢查是否為有效 AVL
    public boolean isValidAVL() {
        return checkAVL(root) != -1;
    }

    private int checkAVL(AVLNode node) {
        if (node == null) return 0;
        int lh = checkAVL(node.left);
        int rh = checkAVL(node.right);
        if (lh == -1 || rh == -1) return -1;
        if (Math.abs(lh - rh) > 1) return -1;
        return Math.max(lh, rh) + 1;
    }

    // 旋轉操作
    private AVLNode rightRotate(AVLNode y) {
        AVLNode x = y.left;
        AVLNode T2 = x.right;
        x.right = y;
        y.left = T2;
        y.updateHeight();
        x.updateHeight();
        return x;
    }

    private AVLNode leftRotate(AVLNode x) {
        AVLNode y = x.right;
        AVLNode T2 = y.left;
        y.left = x;
        x.right = T2;
        x.updateHeight();
        y.updateHeight();
        return y;
    }

    // 中序列印
    public void printTree() {
        inorder(root);
        System.out.println();
    }

    private void inorder(AVLNode node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.data + "(" + node.getBalance() + ") ");
            inorder(node.right);
        }
    }

    public static void main(String[] args) {
        AVLBasicExercise tree = new AVLBasicExercise();
        int[] arr = {10, 20, 30, 40, 50, 25};
        for (int v : arr) tree.insert(v);

        tree.printTree();
        System.out.println("搜尋 25: " + tree.search(25));
        System.out.println("樹高: " + tree.height());
        System.out.println("是否有效 AVL: " + tree.isValidAVL());
    }
}
