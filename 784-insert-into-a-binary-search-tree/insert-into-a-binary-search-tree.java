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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode n = new TreeNode(val);
        if(root==null){
            return n;
        }
        TreeNode temp = null;
        TreeNode rr = root;
        while(root!=null){
            if(root.val<=val){
                temp=root;
                root = root.right;
            }else{
                temp = root;
                root=root.left;
            }
        }
        if(temp.val<val){
            temp.right = n;
        }else{
            temp.left = n;
        }
        return rr;
    }
}