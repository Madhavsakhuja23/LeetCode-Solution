class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        ArrayList<HashMap<Character, Integer>> arr = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            HashMap<Character, Integer> mp = new HashMap<>();
            String s = strs[i];
            for (int j = 0; j < s.length(); j++) {
                mp.put(s.charAt(j), mp.getOrDefault(s.charAt(j), 0) + 1);
            }
            arr.add(mp);
        }
        List<List<String>> ans = new ArrayList<>();
        boolean[] visited = new boolean[strs.length];
        // this for doing that the any string doesnt repeat inn two 
        for (int i = 0; i < strs.length; i++) {
            if (visited[i])
                continue;
            List<String> temp = new ArrayList<>();
            temp.add(strs[i]);
            visited[i] = true;
            for (int j = i + 1; j < strs.length; j++) {
                if (!visited[j] && arr.get(i).equals(arr.get(j))) {
                    temp.add(strs[j]);
                    visited[j] = true;
                }
            }
            ans.add(temp);
        }
        return ans;
    }
}