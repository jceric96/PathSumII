import java.util.*;

public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> results = new ArrayList<>();
        pathSum(root, targetSum, results, new ArrayList<Integer>());
        return results;
    }

    public void pathSum(TreeNode root, int targetSum, List<List<Integer>> results, ArrayList<Integer> path) {
        if (root == null) {
            return;
        }
        targetSum -= root.val;
        if (targetSum == 0 && root.left == null && root.right == null) {
            path.add(root.val);
            results.add(new ArrayList<Integer>(path));
            path.remove(path.size() - 1);
            return;
        }
        path.add(root.val);
        pathSum(root.left, targetSum, results, path);
        pathSum(root.right, targetSum, results, path);
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) throws Exception {
        PathSumII tree = new PathSumII();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.right = null;
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.left.left = null;
        root.right.left.right = null;
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        int targetSum = 22;
        System.out.println(tree.pathSum(root, targetSum));
    }
}
