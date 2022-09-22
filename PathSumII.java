import java.util.ArrayList;
import java.util.List;

public class PathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<List<Integer>> results = new ArrayList<List<Integer>>();
        pathSum(root, targetSum, new ArrayList<Integer>(), results);
        return results;
    }

    private void pathSum(TreeNode root, int targetSum, ArrayList<Integer> result, List<List<Integer>> results) {
        // check if current node is null or not
        if (root == null) {
            return;
        }
        // change targetSum number
        targetSum -= root.val;
        // if targetSum is zero and current node is leaf node
        if (targetSum == 0 && root.left == null && root.right == null) {
            // add current node into result
            result.add(root.val);
            // add result array into results array
            results.add(new ArrayList<>(result));
            // remove value of the leaf node
            // to avoid another path includes this leaf node
            result.remove(result.size() - 1);
            return;
        }
        // add current node into result
        result.add(root.val);
        // find if left side has a path of the targetSum
        pathSum(root.left, targetSum, result, results);
        // find if right side has a path of the targetSum
        pathSum(root.right, targetSum, result, results);
        // remove the value of the path node(not leaf node)
        // to avoid another path includes unsatisifed path nodes
        result.remove(result.size() - 1);

    }

    public static void main(String[] args) {
        PathSumII sum = new PathSumII();
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
        System.out.println(sum.pathSum(root, 22));
    }
}
