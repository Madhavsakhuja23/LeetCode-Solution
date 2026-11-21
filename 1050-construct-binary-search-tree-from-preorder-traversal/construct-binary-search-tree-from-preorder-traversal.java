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
    public TreeNode bstFromPreorder(int[] preOrder) {
        int i[] ={0};
        return build(preOrder, Integer.MAX_VALUE, i);
    }
    public TreeNode build(int preOrder[], int UpperBound, int i[]){
        if(i[0] == preOrder.length || preOrder[i[0]]>UpperBound){
            return null;
        }
        TreeNode root = new TreeNode(preOrder[i[0]++]);
        root.left = build(preOrder,root.val,i);
        root.right = build(preOrder,UpperBound,i);
        return root;
    }
}