class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        int level = Levels(root);
        for(int i = 0 ; i < level ; i++){
            ans.add(0);
        }
        preOrder(root,0,ans);
        return ans;
    }
    private void preOrder(TreeNode root , int level , ArrayList<Integer> ans){
        if(root == null) return ;
        ans.set(level,root.val);
        preOrder(root.left , level+1 , ans);
        preOrder(root.right , level+1 , ans);
    }
    private int Levels(TreeNode root){
        if(root == null) return 0;
        return 1 + Math.max(Levels(root.left),Levels(root.right));
    }
}