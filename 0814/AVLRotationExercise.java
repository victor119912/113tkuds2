// 檔案：AVLRotationExercise.java
class RotationNode {
    int data, height;
    RotationNode left, right;
    RotationNode(int data) { this.data = data; this.height = 1; }
    void updateHeight() {
        int lh = (left != null) ? left.height : 0;
        int rh = (right != null) ? right.height : 0;
        height = Math.max(lh, rh) + 1;
    }
}

public class AVLRotationExercise {
    private int height(RotationNode n) { return n == null ? 0 : n.height; }

    public RotationNode rightRotate(RotationNode y) {
        RotationNode x = y.left;
        RotationNode T2 = x.right;
        x.right = y;
        y.left = T2;
        y.updateHeight();
        x.updateHeight();
        return x;
    }

    public RotationNode leftRotate(RotationNode x) {
        RotationNode y = x.right;
        RotationNode T2 = y.left;
        y.left = x;
        x.right = T2;
        x.updateHeight();
        y.updateHeight();
        return y;
    }

    public RotationNode leftRightRotate(RotationNode z) {
        z.left = leftRotate(z.left);
        return rightRotate(z);
    }

    public RotationNode rightLeftRotate(RotationNode z) {
        z.right = rightRotate(z.right);
        return leftRotate(z);
    }

    public static void main(String[] args) {
        AVLRotationExercise r = new AVLRotationExercise();

        RotationNode root = new RotationNode(30);
        root.left = new RotationNode(20);
        root.left.left = new RotationNode(10);

        System.out.println("LL -> 右旋");
        root = r.rightRotate(root);
        System.out.println("新根: " + root.data);

        root = new RotationNode(10);
        root.right = new RotationNode(20);
        root.right.right = new RotationNode(30);

        System.out.println("RR -> 左旋");
        root = r.leftRotate(root);
        System.out.println("新根: " + root.data);
    }
}
