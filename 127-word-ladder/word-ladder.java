class Pair {
    String w;
    int tm;

    Pair(String s, int d) {
        w = s;
        tm = d;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        HashSet<String> st = new HashSet<>();

        for (String word : wordList) {
            st.add(word);
        }
        st.remove(beginWord);
        q.add(new Pair(beginWord, 1));
        while (!q.isEmpty()) {
            String word = q.peek().w;
            int d = q.poll().tm;
            if (word.equals(endWord)) {
                return d;
            }
            for (int i = 0; i < word.length(); i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    char replacedArray[] = word.toCharArray();
                    replacedArray[i] = c;
                    String replacedWord = new String(replacedArray);
                    if (st.contains(replacedWord)) {
                        st.remove(replacedWord);
                        q.add(new Pair(replacedWord, d + 1));
                    }
                }
            }
        }
        return 0;
    }
}