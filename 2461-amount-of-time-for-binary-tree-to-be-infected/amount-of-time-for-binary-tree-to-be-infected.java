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
    public int amountOfTime(TreeNode root, int start) {
        int res =0;
        if(root==null){
            return res;
        }
        HashMap<TreeNode, TreeNode> mp = new HashMap<>();
        markParents(root,mp);
        HashMap<TreeNode, Boolean> visited = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(find(root, start));
        visited.put(find(root, start), true);
        while(!q.isEmpty()){
            int ls = q.size();
            boolean burnedAny = false;
            for(int i=0;i<ls;i++){
                TreeNode node = q.poll();
                if(node.left!=null && visited.get(node.left)==null){
                    q.add(node.left);
                    visited.put(node.left, true);
                    burnedAny=true;
                }
                if(node.right!=null && visited.get(node.right)==null){
                    q.add(node.right);
                    visited.put(node.right, true);
                    burnedAny=true;
                }
                if(mp.get(node)!=null && visited.get(mp.get(node))==null){
                    q.add(mp.get(node));
                    visited.put(mp.get(node), true);
                    burnedAny=true;
                }
            }
            if(burnedAny){
                res++;
            }
        }
        return res;
    }
    public void markParents(TreeNode root, HashMap<TreeNode,TreeNode> mp){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int ls = q.size();
            for(int i=0;i<ls;i++){
                TreeNode node = q.poll();
                if(node.left!=null){
                    q.add(node.left);
                    mp.put(node.left,node);
                }
                if(node.right!=null){
                    q.add(node.right);
                    mp.put(node.right, node);
                }
            }
        }
    }
    public TreeNode find(TreeNode root, int start){
        if(root.val==start){
            return root;
        }
        Queue<TreeNode> q =new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node.val==start){
                return node;
            }
            if(node.left!=null){
                q.add(node.left);
            }
            if(node.right!=null){
                q.add(node.right);
            }
        }
        return root;
    }
}