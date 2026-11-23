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
        private TreeNode first;
    private TreeNode middle;
    private TreeNode last;
    private TreeNode prev;
    public void recoverTree(TreeNode root) {
        first=middle=last = null;
        prev = new TreeNode(Integer.MIN_VALUE);
        inorder(root);
        if(first!=null && last!=null){
            int t = first.val;
            first.val = last.val;
            last.val = t;
        }else if(first!=null && middle!=null){
            int t = first.val;
            first.val = middle.val;
            middle.val = t;
        }

    }
    // public void CollectValues(TreeNode root, ArrayList<Integer> arr){
        // Brute Force
        // if(root==null){
        //     return;
        // }
        // CollectValues(root.left, arr);
        // arr.add(root.val);
        // CollectValues(root.right,arr);

        // optimal
    // }
    public void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        if(prev!=null && root.val < prev.val){
            if(first==null){
                first = prev;
                middle = root;
            }else{
                last = root;
            }
        }
        prev = root;
        inorder(root.right);
    }
    // public void RestoreValues(TreeNode root, ArrayList<Integer> arr, int indx[]){
    //     if(root==null){
    //         return;
    //     }
    //     RestoreValues(root.left,arr, indx);
    //     root.val = (arr.get(indx[0]++));
    //     RestoreValues(root.right,arr,indx);
    // }
}