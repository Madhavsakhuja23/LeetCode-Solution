class Solution {
    public int longestBeautifulSubstring(String word) {

        int max = 0;
        int len = 1;
        int vowels = 1;

        for (int i = 1; i < word.length(); i++) {

            if (word.charAt(i) == word.charAt(i - 1)) {
                // Same vowel, continue
                len++;
            }
            else if (word.charAt(i) > word.charAt(i - 1)) {
                // Next vowel in correct order
                len++;
                vowels++;
            }
            else {
                // Order broke
                len = 1;
                vowels = 1;
            }

            if (vowels == 5) {
                max = Math.max(max, len);
            }
        }

        return max;
    }
}