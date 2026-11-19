/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res = new ArrayList<>();
        HashMap<TreeNode,TreeNode> mp = new HashMap<>();
        markParents(root,mp);
        HashMap<TreeNode,Boolean> visited = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);
        visited.put(target, true);
        int dis =0;
        while(!q.isEmpty()){
            int ls = q.size();
            if(dis==k){
                break;
            }
            dis++;
            for(int i=0;i<ls;i++){
                TreeNode node = q.poll();
                if(node.left!=null && visited.get(node.left)==null){
                    q.add(node.left);
                    visited.put(node.left, true);
                }
                if(node.right!=null && visited.get(node.right)==null){
                    q.add(node.right);
                    visited.put(node.right, true);
                }
                if(mp.get(node)!=null && visited.get(mp.get(node))==null){
                    q.add(mp.get(node));
                    visited.put(mp.get(node), true);
                }
            }
        }
        while(!q.isEmpty()){
            res.add(q.poll().val);
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
                    mp.put(node.left, node);
                    q.add(node.left);
                }
                if(node.right!=null){
                    mp.put(node.right, node);
                    q.add(node.right);
                }
            }
        }
    }
}