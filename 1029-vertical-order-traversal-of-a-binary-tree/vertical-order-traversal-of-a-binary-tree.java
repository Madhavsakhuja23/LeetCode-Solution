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
class Pair{
    TreeNode node;
    int indx;
    Pair(TreeNode n, int i){
        node = n;
        indx = i;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        TreeMap<Integer,List<Integer>> mp = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        while (!q.isEmpty()) {
            int size = q.size();
            Map<Integer, List<Integer>> levelMap = new HashMap<>();
            for (int i = 0; i < size; i++) {
                Pair p = q.poll();
                levelMap.computeIfAbsent(p.indx, k -> new ArrayList<>()).add(p.node.val);

                if (p.node.left != null) {
                    q.add(new Pair(p.node.left, p.indx - 1));
                }
                if (p.node.right != null) {
                    q.add(new Pair(p.node.right, p.indx + 1));
                }
            }
            for (int col : levelMap.keySet()) {
                List<Integer> samePosNodes = levelMap.get(col);
                Collections.sort(samePosNodes);
                mp.computeIfAbsent(col, k -> new ArrayList<>()).addAll(samePosNodes);
            }
        }
        res.addAll(mp.values());
        return res;
    }
}