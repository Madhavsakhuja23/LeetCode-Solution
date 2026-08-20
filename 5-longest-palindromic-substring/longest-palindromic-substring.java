class Solution {
    public String longestPalindrome(String s) {
        //  brute force is a make every substring an heck whetehr it is a substring or not so its time complexity is ncube 

        // optimal solution we start fom the middle and expland outwards

        String str = "";
        int resLen=0;
        for(int i=0;i<s.length();i++){
            // odd-Length
            int l=i, r=i;
            while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
                if(r-l+1>resLen){
                    resLen=r-l+1;
                    str = s.substring(l,r+1);
                }
                l--;
                r++;
            }

            // even-Length
            l=i;
            r=i+1;
            while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
                if(r-l+1>resLen){
                    resLen=r-l+1;
                    str = s.substring(l,r+1);
                }
                l--;
                r++;
            }
        }
        return str;
    }
}