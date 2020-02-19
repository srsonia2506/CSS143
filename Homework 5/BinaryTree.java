import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class BinaryTree {
    TreeNode root;

    public BinaryTree() {
        root = null;
    }

    public BinaryTree(TreeNode root) {
        this.root = root;
    }

    public List<Integer> inorderIterative() {
        List<Integer> result = new ArrayList<>();
        TreeNode curr = root;

        while (result.size() > 0 || curr != null)	{
          if (curr != null){
            result.add(curr);
            curr = curr.left;
          } else {
            curr = curr.right;
          }
        }
        return result;
        //return Arrays.asList(0); // place holder
    }


    public int LCA(int v1, int v2) {
        Map<Node, Boolean> ancestors = new HashMap<Node, Boolean>(); 
  
        while (v1 != null){ 
            ancestors.put(v1, Boolean.TRUE); 
            v1 = v1.parent; 
        } 
  
        while (v2 != null){ 
            if (ancestors.containsKey(v2) != ancestors.isEmpty()) 
                return v2; 
            v2 = v2.parent; 
        } 
  
        return null; 
    }

    public List<List<Integer>> levelOrderTraversal() {
        // homework
        // to be done iteratively
        return null; // place holder
    }

    public int nthSmallestInBST(int n) {
        // homework
        return -1;  // place holder
    }

    private void preorderRecursive(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        result.add(node.val);
        preorderRecursive(node.left, result);
        preorderRecursive(node.right, result);
    }

    public List<Integer> preorderRecursive() {
        List<Integer> result = new ArrayList<>();
        preorderRecursive(root, result);
        return result;
    }

    public List<Integer> preorderIterative() {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return result;
    }

    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }

    public int height() {
        return height(root);
    }

    private Integer LCA_BST(TreeNode node, int v1, int v2) {
        if (node == null) {
            return null;
        }

        int min = Math.min(v1, v2);
        int max = Math.max(v1, v2);

        if (node.val >= min && node.val <= max) {
            return node.val;
        }

        if (node.val < min) {
            return LCA_BST(node.right, v1, v2);
        }

        return LCA_BST(node.left, v1, v2);
    }

    public int LCA_BST(int v1, int v2) {
        return LCA_BST(root, v1, v2);
    }

    private void postorderRecursive(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }

        postorderRecursive(node.left, result);
        postorderRecursive(node.right, result);
        result.add(node.val);
    }

    List<Integer> postorderRecursive() {
        List<Integer> result = new ArrayList<>();
        postorderRecursive(root, result);
        return result;
    }

    private void inorderRecursive(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        inorderRecursive(node.left, result);
        result.add(node.val);
        inorderRecursive(node.right, result);
    }

    public List<Integer> inorderRecursive() {
        List<Integer> result = new ArrayList<>();
        inorderRecursive(root, result);
        return result;
    }
}
