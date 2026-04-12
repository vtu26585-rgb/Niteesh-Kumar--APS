import java.util.*;

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        
        dfs(root, targetSum, currentPath, result);
        return result;
    }
    
    private void dfs(TreeNode node, int targetSum, List<Integer> currentPath, List<List<Integer>> result) {
        if (node == null) return;
        
        // Add current node
        currentPath.add(node.val);
        
        // Check if it's a leaf and matches sum
        if (node.left == null && node.right == null && targetSum == node.val) {
            result.add(new ArrayList<>(currentPath)); // copy path
        } else {
            // Recur left and right
            dfs(node.left, targetSum - node.val, currentPath, result);
            dfs(node.right, targetSum - node.val, currentPath, result);
        }
        
        // Backtrack
        currentPath.remove(currentPath.size() - 1);
    }
}