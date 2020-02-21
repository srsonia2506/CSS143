import java.util.*;

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
        if (root == null)
            return result;
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode leftMost = root;
        while (!stack.isEmpty() || leftMost != null) {
            while (leftMost != null) {
                stack.push(leftMost);
                leftMost = leftMost.left;
            }
            leftMost = stack.pop();
            result.add(leftMost.val);

            leftMost = leftMost.right;
        }
        return result;
    }

    public int LCA(int v1, int v2) {
        return LCA(root, v1, v2).val;
    }

    private TreeNode LCA(TreeNode node, int v1, int v2) {
        if (node == null)
            return null;
        
        if (node.val == v1 || node.val == v2)
            return node;
        
        TreeNode left = LCA(node.left, v1, v2);
        TreeNode right = LCA(node.right, v1, v2);
        
        if (left != null && right != null)
            return node;
        
        if (right == null)
            return left;
        else
            return right;
    }

    public List<List<Integer>> levelOrderTraversal() {
        if (root == null)
            return new ArrayList<>();

        List<List<Integer>> levels = new ArrayList<>(); 
        Deque<TreeNode> stack = new ArrayDeque<>(); 
        stack.push(root);
        
        while (!stack.isEmpty()) {
            Deque<TreeNode> nextStack = new ArrayDeque<>();
            List<Integer> level = new ArrayList<>();
            
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                level.add(node.val);
                
                if (node.left != null)
                    nextStack.add(node.left);

                if (node.right != null)
                    nextStack.add(node.right);
            }
            
            levels.add(level);
            stack = nextStack;
        }

        return levels;
    }

    public int nthSmallestInBST(int n) {
        return nthSmallestInBST(root, n).val;
    }

    private TreeNode nthSmallestInBST(TreeNode node, int n){
        if(node == null)
            return null;
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode leftMost = root;
        while (!stack.isEmpty() || leftMost != null) {
            while (leftMost != null) {
                stack.push(leftMost);
                leftMost = leftMost.left;
            }
            leftMost = stack.pop();
            n -= 1;
            if(n == 0)
                return leftMost;
            leftMost = leftMost.right;
        }
        return null;
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