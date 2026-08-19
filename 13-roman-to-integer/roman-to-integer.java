class Solution {
    public int romanToInt(String s) {
        int ans = 0;
        HashMap<Character, Integer> mp = new HashMap<>();
        mp.put('I',1);
        mp.put('V',5);
        mp.put('X',10);
        mp.put('L',50);
        mp.put('C',100);
        mp.put('D',500);
        mp.put('M',1000);

        for(int i=0;i<s.length()-1;i++){
            int n1 = mp.get(s.charAt(i));
            int n2 = mp.get(s.charAt(i+1));
            if(n1>=n2){
                ans+=n1;
            }else{
                ans-=n1;
            }
        }
        ans+=mp.get(s.charAt(s.length()-1));
        return ans;
    }
}