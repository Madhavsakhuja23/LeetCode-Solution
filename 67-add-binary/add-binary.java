
class Solution {
    public String addBinary(String a, String b) {
        int carry = 0;
        StringBuilder str = new StringBuilder();

        int n1 = a.length() - 1;
        int n2 = b.length() - 1;

        while (n1 >= 0 || n2 >= 0 || carry > 0) {
            int val1 = (n1 < 0) ? 0 : a.charAt(n1) - '0';
            int val2 = (n2 < 0) ? 0 : b.charAt(n2) - '0';

            int total = val1 + val2 + carry;

            str.append(total % 2);
            carry = total / 2;

            n1--;
            n2--;
        }

        return str.reverse().toString();
    }
}
