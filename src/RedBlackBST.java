public class RedBlackBST extends BST {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private boolean isRed(TreeNode treeNode) {
        if (treeNode == null)
            return false;
        return treeNode.color;
    }

    private TreeNode rotateLeft(TreeNode treeNode) {
        TreeNode x = treeNode.right;
        treeNode.right = x.left;
        x.left = treeNode;
        x.color = treeNode.color;
        treeNode.color = RED;

        return x;
    }

    private TreeNode rotateRight(TreeNode treeNode) {
        TreeNode x = treeNode.left;
        treeNode.left = x.right;
        x.right = treeNode;
        x.color = treeNode.color;
        treeNode.color = RED;

        return x;
    }

    private void flipColors(TreeNode treeNode) {
        treeNode.color = RED;
        treeNode.left.color = BLACK;
        treeNode.right.color = BLACK;
    }

    @Override
    void put(String key, Integer val) {
        root = put(root, key, val);
        root.color = BLACK;
    }

    @Override
    TreeNode put(TreeNode treeNode, String key, Integer val) {
        if (treeNode == null) return new TreeNode(key, val, RED);

        int cmp = key.compareTo(treeNode.key);
        if (cmp < 0) treeNode.left = put(treeNode.left, key, val);
        else if(cmp > 0) treeNode.right = put(treeNode.right, key, val);
        else treeNode.val = val;

        if (isRed(treeNode.right) && !isRed(treeNode.left)) treeNode = rotateLeft(treeNode);
        if (isRed(treeNode.left) && isRed(treeNode.left.left)) treeNode = rotateRight(treeNode);
        if (isRed(treeNode.left) && isRed(treeNode.right)) flipColors(treeNode);

        return treeNode;
    }
}
