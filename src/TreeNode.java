public class TreeNode {
    Integer val;
    String key;
    boolean color;

    TreeNode left;
    TreeNode right;

    TreeNode(String key, Integer val) {
        this.key = key;
        this.val = val;
    }

    TreeNode(String key, Integer val, boolean color) {
        this.key = key;
        this.val = val;
        this.color = color;
    }
}
