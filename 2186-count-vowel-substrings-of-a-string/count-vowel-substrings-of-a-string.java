class Solution {
    public int countVowelSubstrings(String word) {

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

                    for (char ch : str.toCharArray()) {
                        if ("aeiou".indexOf(ch) == -1) {
                            valid = false;
                            break;
                        }
                    }

                    if (valid) {
                        cnt++;
                    }
                }
            }
        }

        return cnt;
    }
}