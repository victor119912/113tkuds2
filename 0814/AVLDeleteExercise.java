class AVLDeleteExercise {
    class Node {
        int key, height;
        Node left, right;

        Node(int d) {
            key = d;
            height = 1;
        }
    }

    Node root;

    int height(Node N) {
        return (N == null) ? 0 : N.height;
    }

    int getBalance(Node N) {
        return (N == null) ? 0 : height(N.left) - height(N.right);
    }

    Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    Node insert(Node node, int key) {
        if (node == null) return new Node(key);

        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);
        else
            return node; // 不允許重複

        node.height = Math.max(height(node.left), height(node.right)) + 1;

        int balance = getBalance(node);

        // 左左
        if (balance > 1 && key < node.left.key)
            return rightRotate(node);
        // 右右
        if (balance < -1 && key > node.right.key)
            return leftRotate(node);
        // 左右
        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        // 右左
        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    Node minValueNode(Node node) {
        Node current = node;
        while (current.left != null)
            current = current.left;
        return current;
    }

    Node deleteNode(Node root, int key) {
        if (root == null) return root;

        if (key < root.key)
            root.left = deleteNode(root.left, key);
        else if (key > root.key)
            root.right = deleteNode(root.right, key);
        else {
            // 找到要刪除的節點
            if ((root.left == null) || (root.right == null)) {
                Node temp = (root.left != null) ? root.left : root.right;
                root = (temp == null) ? null : temp;
            } else {
                Node temp = minValueNode(root.right);
                root.key = temp.key;
                root.right = deleteNode(root.right, temp.key);
            }
        }

        if (root == null) return root;

        root.height = Math.max(height(root.left), height(root.right)) + 1;

        int balance = getBalance(root);

        // 左左
        if (balance > 1 && getBalance(root.left) >= 0)
            return rightRotate(root);
        // 左右
        if (balance > 1 && getBalance(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        // 右右
        if (balance < -1 && getBalance(root.right) <= 0)
            return leftRotate(root);
        // 右左
        if (balance < -1 && getBalance(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public static void main(String[] args) {
        AVLDeleteExercise tree = new AVLDeleteExercise();

        tree.root = tree.insert(tree.root, 9);
        tree.root = tree.insert(tree.root, 5);
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 0);
        tree.root = tree.insert(tree.root, 6);
        tree.root = tree.insert(tree.root, 11);
        tree.root = tree.insert(tree.root, -1);
        tree.root = tree.insert(tree.root, 1);
        tree.root = tree.insert(tree.root, 2);

        System.out.println("刪除前 Preorder: ");
        tree.preOrder(tree.root);

        tree.root = tree.deleteNode(tree.root, 10);

        System.out.println("\n刪除 10 後 Preorder: ");
        tree.preOrder(tree.root);
    }
}
