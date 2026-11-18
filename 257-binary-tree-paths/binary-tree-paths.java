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
    public List<String> binaryTreePaths(TreeNode root) {
        List<ArrayList<Integer>> arr = new ArrayList<>();
        solve(root,arr, new ArrayList<>());
        List<String> res = new ArrayList<>();
        for(int i=0;i<arr.size();i++){
           List<Integer> str = arr.get(i);
            StringBuilder sb = new StringBuilder("");
            for(int j=0;j<str.size();j++){
                if(j == str.size()-1){
                    sb.append(str.get(j));
                }else{
                     sb.append(str.get(j));
                     sb.append("->");
                }
            }
            res.add(sb.toString());
        }
        return res;
    }
    public void solve(TreeNode root, List<ArrayList<Integer>> arr, ArrayList<Integer> sb){
        if(root==null){
            return;
        }
        sb.add(root.val);
        if(root.left==null && root.right==null){
            arr.add(new ArrayList<>(sb));
            return;
        }
        if(root.left!=null){
            solve(root.left,arr,sb);
            sb.remove((sb.size()-1));
        }
        if(root.right!=null){
            solve(root.right,arr,sb);
            sb.remove((sb.size()-1));
        }
    }

}