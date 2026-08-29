class Solution {
    public int countOfSubstrings(String word, int k) {
        int cnt = 0;

        for (int i = 0; i < word.length(); i++) {

            for (int j = i; j < word.length(); j++) {

                String str = word.substring(i, j + 1);

                if (str.contains("a") &&
                    str.contains("e") &&
                    str.contains("i") &&
                    str.contains("o") &&
                    str.contains("u")) {

                    boolean valid = true;
                    int c = 0;
                    for (char ch : str.toCharArray()) {
                        if ("aeiou".indexOf(ch) == -1) {
                            c++;
                        }
                    }

                    if (c==k) {
                        cnt++;
                    }
                }
            }
        }

        return cnt;
    }
}
