import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class TreeTraversal {

    static void recursivePreorderTraversal(TreeNode treeNode) {
        if(treeNode == null) return;
        System.out.println(treeNode.val);
        recursivePreorderTraversal(treeNode.left);
        recursivePreorderTraversal(treeNode.right);
    }

    static void recursiveInorderTraversal(TreeNode treeNode) {
        if(treeNode == null) return;
        recursiveInorderTraversal(treeNode.left);
        System.out.println(treeNode.val);
        recursiveInorderTraversal(treeNode.right);
    }

    static void recursivePostorderTraversal(TreeNode treeNode) {
        if(treeNode == null) return;
        recursivePostorderTraversal(treeNode.left);
        recursivePostorderTraversal(treeNode.right);
        System.out.println(treeNode.val);
    }

    static void preorderTraversal(TreeNode treeNode) {
        if(treeNode == null)
            return;

        Stack<TreeNode> treeNodeStack = new Stack<>();

        List<Integer> treeNodeList = new ArrayList<>();

        treeNodeStack.push(treeNode);
        TreeNode currNode;
        while (!treeNodeStack.empty()) {
            currNode = treeNodeStack.pop();

            treeNodeList.add(currNode.val);

            if(currNode.right != null)
                treeNodeStack.push(currNode.right);
            if(currNode.left != null)
                treeNodeStack.push(currNode.left);
        }

        System.out.println(treeNodeList);
    }

    static void inorderTraversal(TreeNode treeNode) {
        if(treeNode == null)
            return;

        Stack<TreeNode> treeNodeStack = new Stack<>();

        List<Integer> treeNodeList = new ArrayList<>();

        TreeNode currNode = treeNode;
        do {
            while (currNode != null) {
                treeNodeStack.push(currNode);
                currNode = currNode.left;
            }

            if(!treeNodeStack.empty()) {
                currNode = treeNodeStack.pop();
                treeNodeList.add(currNode.val);
                currNode = currNode.right;
            }

        } while (!treeNodeStack.empty() || currNode != null);
        System.out.println(treeNodeList);
    }

    static void postorderTraversal(TreeNode treeNode) {
        if(treeNode == null)
            return;

        Stack<TreeNode> treeNodeStack = new Stack<>();

        List<Integer> treeNodeList = new ArrayList<>();

        treeNodeStack.push(treeNode);
        TreeNode currNode;
        while (!treeNodeStack.empty()) {
            currNode = treeNodeStack.pop();

            treeNodeList.add(0, currNode.val);
            if(currNode.left != null)
                treeNodeStack.push(currNode.left);

            if(currNode.right != null)
                treeNodeStack.push(currNode.right);
        }

        System.out.println(treeNodeList);
    }

    static int levelorderTraverse(TreeNode treeNode) {
        if (treeNode == null)
            return 0;

        LinkedList<TreeNode> treeNodeQueue = new LinkedList<>();
        List<Integer> treeNodeList = new ArrayList<>();

        treeNodeQueue.add(treeNode);
        TreeNode currNode;
        int depth = 0;
        while (!treeNodeQueue.isEmpty()) {
            int len = treeNodeQueue.size();
            depth++;

            while (len-- != 0) {
                currNode = treeNodeQueue.remove();

                treeNodeList.add(currNode.val);
                if (currNode.left != null)
                    treeNodeQueue.add(currNode.left);
                if (currNode.right != null)
                    treeNodeQueue.add(currNode.right);
            }
        }
        System.out.println(treeNodeList);
        return depth;
    }
}
