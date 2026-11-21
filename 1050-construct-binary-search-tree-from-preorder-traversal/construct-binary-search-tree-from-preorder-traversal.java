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
    public TreeNode bstFromPreorder(int[] preorder) {
        int[] preOrder = Arrays.copyOf(preorder, preorder.length);
        Arrays.sort(preorder);
        int inOrder[] = preorder;
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int i=0;i<inOrder.length;i++){
            mp.put(inOrder[i], i);
        }
        TreeNode root = build(preOrder,0,preOrder.length-1,inOrder,0,inOrder.length-1,mp);
        return root;
    }
    public TreeNode build(int preOrder[], int preOrderStart, int preOrderEnd, int inOrder[], int inOrderStart, int inOrderEnd,HashMap<Integer,Integer> mp){
        if(preOrderStart>preOrderEnd || inOrderStart > inOrderEnd){
            return null;
        }
        TreeNode root = new TreeNode(preOrder[preOrderStart]);
        int inroot = mp.get(root.val);
        int numsLeft = inroot - inOrderStart;

        root.left = build(preOrder,preOrderStart+1, preOrderStart+numsLeft,inOrder,inOrderStart,inroot-1, mp);
        root.right = build(preOrder, preOrderStart+numsLeft+1,preOrderEnd, inOrder, inroot+1,inOrderEnd,mp);
        return root;
    }
}