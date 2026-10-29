class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> mp1 = new HashMap<>();
        HashMap<Character, Integer> mp2 = new HashMap<>();
        int n1 = s.length();
        int n2 = t.length();
        if(n1!=n2){
            return false;
        }
        for(int i=0;i<n1;i++){
            mp1.put(s.charAt(i), mp1.getOrDefault(s.charAt(i), 0)+1);
        }
        for(int i=0;i<n2;i++){
            mp2.put(t.charAt(i), mp2.getOrDefault(t.charAt(i), 0)+1);
        }
        return mp1.equals(mp2);
    }
}