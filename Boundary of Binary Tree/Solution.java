/*
 * 按照root->左子树->右子树叶结点->右子树边界的顺序。
 */
public class Solution {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        boolean[] judge = new boolean[1];
        judge[0] = true;
        if(root == null) return list;
        list.add(root.val);
        leftHelper(list, root.left, judge);
        rightHelper(list, root.right);
        rightBound(list, root.right);
        return list;
    }
    
    private void leftHelper(List<Integer> list, TreeNode root, boolean[] judge) {
        if(root == null) return;
        if(judge[0] || isLeaf(root)) list.add(root.val);
        if(isLeaf(root)) judge[0] = false;
        leftHelper(list, root.left, judge);
        leftHelper(list, root.right, judge);
    }
    
    private void rightHelper(List<Integer> list, TreeNode root) {
        if(root == null) return;
        rightHelper(list, root.left);
        rightHelper(list, root.right);
        if(isLeaf(root)) list.add(root.val);
    }
    
    private void rightBound(List<Integer> list, TreeNode root) {
        if(root == null || isLeaf(root)) return;
        if(root.right == null) rightBound(list, root.left);
        else rightBound(list, root.right);
        list.add(root.val);
    }
    
    private boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }
}