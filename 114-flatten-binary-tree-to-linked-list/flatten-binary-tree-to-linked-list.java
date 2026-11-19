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
    public void flatten(TreeNode root) {
        if(root==null){
            return;
        }
        ArrayList<Integer> arr = new ArrayList<>();
        preOrder(root, arr);
        TreeNode curr = root;
        curr.left=null;
        for(int i=1;i<arr.size();i++){
            curr.right = new TreeNode(arr.get(i));
            curr.left=null;
            curr=curr.right;
        }
    }
    public void preOrder(TreeNode root, ArrayList<Integer> arr){
        if(root==null){
            return;
        }

        arr.add(root.val);
        preOrder(root.left, arr);
        preOrder(root.right, arr);
    }
}