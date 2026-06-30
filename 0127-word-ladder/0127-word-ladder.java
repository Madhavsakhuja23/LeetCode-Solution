class Pair{
    String wrd;
    int tm;
    Pair(String w, int t){
        wrd=w;
        tm=t;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        HashSet<String> st = new HashSet<>(wordList);
        st.remove(beginWord);
        q.add(new Pair(beginWord, 1));
        while(!q.isEmpty()){
            String word = q.peek().wrd;
            int stps = q.poll().tm;
            if(word.equals(endWord)){
                return stps;
            }
            for(int i=0;i<word.length();i++){
                for(char c='a';c<='z';c++){
                    char replacedArray[] = word.toCharArray();
                    replacedArray[i]=c;
                    String replacedWord = new String(replacedArray);
                    if(st.contains(replacedWord)){
                        st.remove(replacedWord);
                        q.add(new Pair(replacedWord, stps+1));
                    }
                }
            }
        }
        return 0;
    }
}