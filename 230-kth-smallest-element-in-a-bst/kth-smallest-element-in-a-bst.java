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
    public int kthSmallest(TreeNode root, int k) {
        // Brute force
        // ArrayList<Integer> arr = new ArrayList<>();
        // inorder(root, arr);
        // return arr.get(k-1);
        
        int res[] = {-1}; 
        findKsmallest(root,k,new int[]{0},res);
        return res[0];
    }
    public void findKsmallest(TreeNode root, int k, int curr[], int ans[]){
        if(root==null || curr[0] >= k){
            return;
        }
        findKsmallest(root.left,k,curr,ans);
        curr[0]++;
        if(curr[0] == k){
            ans[0] =  root.val;
            return;
        }
        findKsmallest(root.right,k,curr,ans);
    }
    // public void inorder(TreeNode root, ArrayList<Integer> arr){
    //     if(root==null){
    //         return;
    //     }
    //     inorder(root.left, arr);
    //     arr.add(root.val);
    //     inorder(root.right,arr);
    // }
}
