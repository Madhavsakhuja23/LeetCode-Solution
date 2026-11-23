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
    public void recoverTree(TreeNode root) {
      ArrayList<Integer> val = new ArrayList<>();
      CollectValues(root, val);
      Collections.sort(val);
      RestoreValues(root,val, new int[]{0});  
    }
    public void CollectValues(TreeNode root, ArrayList<Integer> arr){
        if(root==null){
            return;
        }
        CollectValues(root.left, arr);
        arr.add(root.val);
        CollectValues(root.right,arr);
    }
    public void RestoreValues(TreeNode root, ArrayList<Integer> arr, int indx[]){
        if(root==null){
            return;
        }
        RestoreValues(root.left,arr, indx);
        root.val = (arr.get(indx[0]++));
        RestoreValues(root.right,arr,indx);
    }
}