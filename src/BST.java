public class BST {
    TreeNode root;
    TreeNode left;
    TreeNode right;

    Integer get(String key) {
        return get(root, key);
    }

    Integer get(TreeNode treeNode, String key) {
        if (treeNode == null) return null;
        if (key.compareTo(treeNode.key) < 0) return get(treeNode.left, key);
        else if (key.compareTo(treeNode.key) > 0) return get(treeNode.right, key);
        else return treeNode.val;
    }

    void put(String key, Integer val) {
        if (root == null) {
            root = put(null, key, val);
        }
        put(root, key, val);
    }

    TreeNode put(TreeNode treeNode, String key, Integer val) {
        if (treeNode == null) return new TreeNode(key, val);
        int cmp = key.compareTo(treeNode.key);
        if (cmp < 0) treeNode.left = put(treeNode.left, key, val);
        else if (cmp > 0) treeNode.right = put(treeNode.right, key, val);
        else treeNode.val = val;
        return treeNode;
    }

    int getHeight() {
        return TreeTraversal.levelorderTraverse(root);
    }

//    TreeNode convert2LinkedList() {
//
//    }
}
