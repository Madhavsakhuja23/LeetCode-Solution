class Solution {
    public int calculate(String s) {
        Stack<Integer> st = new Stack();
        char sign = '+';
        int num = 0;
        int n = s.length();
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                num = num*10 + (ch-'0');
            }
            if((!Character.isDigit(ch) && ch != ' ') || i==n-1){
                switch(sign){
                    case '+':st.push(num);break;
                    case '-':st.push(-num);break;
                    case '*': st.push(st.pop()*num);break;
                    case '/':st.push(st.pop()/num);break;
                }
                sign = ch;
                num = 0;
            }
        }
        int res = 0;
        while(!st.isEmpty()){
            res+=st.pop();
        }
        return res;
    }
}