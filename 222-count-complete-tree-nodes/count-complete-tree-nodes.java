/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        int lh = getLeftHeight(root);
        int rh = getRightHeight(root);
        if(lh==rh){
            return (2<<lh)-1;
        }
        return 1+countNodes(root.left)+countNodes(root.right);
    }
    public int getLeftHeight(TreeNode root){
        int cnt =0;
        while(root.left!=null){
            root=root.left;
            cnt++;
        }
        return cnt;
    }
    public int getRightHeight(TreeNode root){
        int cnt =0;
        while(root.right!=null){
            root=root.right;
            cnt++;
        }
        return cnt;
    }
}