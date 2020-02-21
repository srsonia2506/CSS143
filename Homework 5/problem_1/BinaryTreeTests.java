import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import static org.junit.Assert.*;

public class BinaryTreeTests {
    @Test
    public void inorderTraversal() {
        List<BinaryTree> trees = getRegularTreeTestCases();
        int[][] expected = {
                {},
                {1},
                {2, 1},
                {4, 2, 5, 1, 3, 6},
                {3, 2, 1},
                {1, 2, 3},
                {9, 7, 4, 2, 8, 5, 1, 3, 6}
        };

        for (int i = 0; i < expected.length; i++) {
            List<Integer> actual = trees.get(i).inorderRecursive();
            assertEquals(getListFromArray(expected[i]), actual);

            actual = trees.get(i).inorderIterative();
            assertEquals(getListFromArray(expected[i]), actual);
        }
    }

    @Test
    public void LCA() {
        List<BinaryTree> trees = getRegularTreeTestCases();
        int[][] inputs = {
                {5, 4},
                {1, 1},
                {1, 2},
                {4, 5},
                {3, 1},
                {3, 1},
                {8, 9}
        };
        int[] expected = {0, 1, 1, 2, 1, 1, 2};

        // Skip the first test because it is empty
        for (int i = 1; i < expected.length; i++) {
            int actual = trees.get(i).LCA(inputs[i][0], inputs[i][1]);
            assertEquals(expected[i], actual);
        }
    }

    @Test
    public void levelOrderTraversal() {
        List<BinaryTree> trees = getRegularTreeTestCases();
        int[][][] expected = {
                                {},
                                {       {1}
                                },
                                {
                                        {1},
                                        {2},
                                },
                                {
                                        {1},
                                        {2, 3},
                                        {4, 5, 6}
                                },
                                {
                                        {1},
                                        {2},
                                        {3},
                                },
                                {
                                        {1},
                                        {2},
                                        {3},
                                },
                                {
                                        {1},
                                        {2, 3},
                                        {4, 5, 6},
                                        {7, 8},
                                        {9},
                                }
                        };

        for (int i = 0; i < trees.size(); i++) {
            int[][] expectedAnswer = expected[i];
            List<List<Integer>> actual = trees.get(i).levelOrderTraversal();
            for (int j = 0; j < expectedAnswer.length; j++) {
                int[] expectedList = expectedAnswer[j];
                List<Integer> actualList = actual.get(j);
                assertEquals(expectedList.length, actualList.size());
                for (int k = 0; k < expectedList.length; k++) {
                    int expectedInt = expectedList[k];
                    int actualInt = actualList.get(k);
                    assertEquals(expectedInt, actualInt);
                }
            }
        }

    }

    @Test
    public void nthSmallestInBST() {
        List<BinaryTree> trees = getBSTTestCases();
        int[] inputs    = {420, 1, 2, 6, 1, 3, 9};
        int[] expected  = {420, 1, 2, 9, 1, 3, 12};

        // Skip the first test because it is empty
        for (int i = 1; i < trees.size(); i++) {
            int actual = trees.get(i).nthSmallestInBST(inputs[i]);
            assertEquals(expected[i], actual);
        }
    }

    @Test
    public void preorderTraversal() {
        List<BinaryTree> trees = getRegularTreeTestCases();
        int[][] expected = {
                {},
                {1},
                {1, 2},
                {1, 2, 4, 5, 3, 6},
                {1, 2, 3},
                {1, 2, 3},
                {1, 2, 4, 7, 9, 5, 8, 3, 6}
        };

        for (int i = 0; i < expected.length; i++) {
            List<Integer> actual = trees.get(i).preorderRecursive();
            assertEquals(getListFromArray(expected[i]), actual);

            actual = trees.get(i).preorderIterative();
            assertEquals(getListFromArray(expected[i]), actual);
        }
    }

    @Test
    public void postOrderTraversal() {
        List<BinaryTree> trees = getRegularTreeTestCases();
        int[][] expected = {
                {},
                {1},
                {2, 1},
                {4, 5, 2, 6, 3, 1},
                {3, 2, 1},
                {3, 2, 1},
                {9, 7, 4, 8, 5, 2, 6, 3, 1}
        };

        for (int i = 0; i < expected.length; i++) {
            List<Integer> actual = trees.get(i).postorderRecursive();
            assertEquals(getListFromArray(expected[i]), actual);
        }
    }

    @Test
    public void height() {
        List<BinaryTree> trees = getRegularTreeTestCases();
        int[] expected = {0, 1, 2, 3, 3, 3, 5};

        for (int i = 0; i < expected.length; i++) {
            int actual = trees.get(i).height();
            assertEquals(expected[i], actual);
        }
    }

    @Test
    public void LCA_BST() {
        List<BinaryTree> trees = getBSTTestCases();
        int[][] expects = {
                {5, 7, 7},
                {7, 5, 7},
                {7, 8, 7},
                {8, 7, 7},
                {4, 6, 5},
                {6, 4, 5},
                {4, 8, 7},
                {8, 4, 7},
                {5, 9, 7},
                {9, 5, 7},
        };

        for (int i = 0; i < expects.length; i++) {
            BinaryTree tree = trees.get(3);
            assertEquals(expects[i][2],
                    tree.LCA_BST(expects[i][0],
                            expects[i][1]));
        }
    }

    private List<BinaryTree> getRegularTreeTestCases() {
        List<BinaryTree> trees = new ArrayList<>();

        // empty (root==null) tree
        trees.add(new BinaryTree());

        //      1
        //     / \
        //    N   N
        TreeNode root = new TreeNode(1);
        trees.add(new BinaryTree(root));

        //      1
        //     / \
        //    2   N
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        trees.add(new BinaryTree(root));

        //      1
        //     /  \
        //    2    3
        //   / \    \
        //  4   5    6
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(6);
        trees.add(new BinaryTree(root));

        //          1
        //         /
        //        2
        //       /
        //      3
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        trees.add(new BinaryTree(root));

        //          1
        //           \
        //            2
        //             \
        //              3
        root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        trees.add(new BinaryTree(root));

        //             1
        //            /  \
        //           2    3
        //          /  \    \
        //         4    5    6
        //        /    /
        //       7    8
        //      /
        //     9
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.left.left = new TreeNode(9);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(8);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(6);
        trees.add(new BinaryTree(root));

        return trees;
    }

    private List<BinaryTree> getBSTTestCases() {
        List<BinaryTree> trees = new ArrayList<>();

        // empty (root==null) tree
        trees.add(new BinaryTree());

        //      1
        //     / \
        //    N   N
        TreeNode root = new TreeNode(1);
        trees.add(new BinaryTree(root));

        //      2
        //     / \
        //    1   N
        root = new TreeNode(2);
        root.left = new TreeNode(2);
        trees.add(new BinaryTree(root));

        //      7
        //     /  \
        //    5    8
        //   / \    \
        //  4   6    9
        root = new TreeNode(7);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(6);
        root.right = new TreeNode(8);
        root.right.right = new TreeNode(9);
        trees.add(new BinaryTree(root));

        //          3
        //         /
        //        2
        //       /
        //      1
        root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        trees.add(new BinaryTree(root));

        //          1
        //           \
        //            2
        //             \
        //              3
        root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        trees.add(new BinaryTree(root));

        //             9
        //            /  \
        //           5    11
        //          /  \    \
        //         4    8    13
        //        /    /    /  \
        //       3    6    12   18
        //      /
        //     2
        root = new TreeNode(9);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(3);
        root.left.left.left.left = new TreeNode(2);
        root.left.right = new TreeNode(8);
        root.left.right.left = new TreeNode(6);
        root.right = new TreeNode(11);
        root.right.right = new TreeNode(13);
        root.right.right.left = new TreeNode(12);
        root.right.right.right = new TreeNode(18);
        trees.add(new BinaryTree(root));
        return trees;
    }

    private List<Integer> getListFromArray(int[] data) {
        return Arrays.stream(data).boxed().collect(Collectors.toList());
    }
}