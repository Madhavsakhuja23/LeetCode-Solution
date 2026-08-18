class Solution {
    public boolean isAnagram(String s, String t) {
        TreeMap<Character,Integer> mp1 = new TreeMap<>();
        TreeMap<Character,Integer> mp2 = new TreeMap<>();

        for(int i=0;i<s.length();i++){
            mp1.put(s.charAt(i), mp1.getOrDefault(s.charAt(i), 0)+1);
        }

        for(int i=0;i<t.length();i++){
            mp2.put(t.charAt(i), mp2.getOrDefault(t.charAt(i), 0)+1);
        }

        return mp1.equals(mp2);
    }
}